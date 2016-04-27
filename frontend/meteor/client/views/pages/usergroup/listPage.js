Template.groupPage.helpers({
   getData: function() {
    //console.log("ID: " + Router.current().params.query.id);
    //var url = "http://localhost:9000/group/"+ this._id+"/message ";legal2
    var url = "http://localhost:9000/group/legal2/message ";
    console.log(this._id);
    fetchData(url);
  },

  
});

var fetchData = function(url){
	console.log(url);
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
    item += "<h2>member: " + c.member_id + "</h2>";
    item += "<p>title:  " + c.title + " </p>";
    item += "<p>message:  " + c.message + " </p>";
    item += "<hr></li>";
    s += item;
  };
  
  s += "</ol>";
  return s;
}
