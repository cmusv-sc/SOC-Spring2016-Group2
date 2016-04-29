Template.privategroup.helpers({
   getData: function() {
    //console.log("ID: " + Router.current().params.query.id);
    var url = "http://localhost:9000/groups/privategroup";
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
    item += "<h2 >" + c.groupname + "</h2>";
    item += "<p>intro:  " + c.intro + " </p>";
    item += "<a class='btn btn-primary sendrequest' id=\""+ c.groupname +"\" > I want to join in <span class='glyphicon glyphicon-chevron-right'></span></a><hr>";
    item += "</li>";
    s += item;
  };
  
  s += "</ol>";
  return s;
}
//change sender name
Template.privategroup.events({
  'click .sendrequest': function (event) {
    alert("request sent");
   var url = "http://localhost:9000/group/notification";
   var args = {};
   var myid = Session.get("userSessionId");
   args["sender"] = myid;
   args["groupname"] = event.target.id;
   console.log(event.target.id);
   postNotice(url,args);
  
  }

});
var postNotice = function(url,args){
   Meteor.call('postToBackend', url, args, function (err, res){
      location.reload();
   });
}