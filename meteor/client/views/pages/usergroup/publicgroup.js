Template.publicgroup.helpers({
   getData: function() {
    //console.log("ID: " + Router.current().params.query.id);
    var url = "http://localhost:9000/groups/publicgroup";
    fetchData(url);
  },
});

var fetchData = function(url){
  Meteor.call('fetchFromService', url, function (err, res){
    var obj = JSON.stringify(res.data);
    console.log(obj);
    var nestable = $('#row');
    // console.log(renderComments(res.data));
    nestable.append($(renderGroups(res.data)));
  });
}

var renderGroups = function(obj){
  if (obj.length == 0) {
    return "";
  }
  var s = "<ol class='dd-list'>";
  console.log("type of obj is "+typeof obj);
  console.log(obj.length);
  for (var i = 0; i < obj.length; i++) {
    var c = obj[i];
    console.log("for test "+c);
    var item = "<li class='dd-item'>";
    item += "<h2>" + c.groupname + "</h2>";
    item += "<p>intro:  " + c.intro + " </p>";
    item += "<a class='btn btn-primary' href='/group/" + c.groupname + "'>Enter<span class='glyphicon glyphicon-chevron-right'></span></a><hr>";
    item += "</li>";
    s += item;
  };
  
  s += "</ol>";
  return s;
}