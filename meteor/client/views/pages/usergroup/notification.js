Template.notificaction.helpers({
   getData: function() {
    //console.log("ID: " + Router.current().params.query.id);
    //var url = "http://localhost:9000/group/"+ this._id+"/message ";legal2
    //change 111
    var url = "http://localhost:9000/group/notification/111";
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
    item += "<h2>member: " + c.sender + "</h2>";
    item += "<p>title:  " + c.group_id + " </p>";
    item += "<a class='btn btn-primary sendpermit' id=\""+ c.id +"\" > OK <span class='glyphicon glyphicon-chevron-right'></span></a>";
    item += "<a class='btn btn-primary senddelete' id=\""+ c.id +"\" > Delete <span class='glyphicon glyphicon-chevron-right'></span></a>";
    item += "<hr></li>";
    s += item;
  };
  
  s += "</ol>";
  return s;
}
Template.notificaction.events({
  'click .sendpermit': function (event) {
    alert("request sent");
   var url = "http://localhost:9000/group/resnotification";
   var args = {};
   args["requestid"] = event.target.id;
   args["response"] = "OK";
   console.log(event.target.id);
   postNotice(url,args);
  
  },

  'click .senddelete': function (event) {
    alert("request sent");
   var url = "http://localhost:9000/group/resnotification";
   var args = {};
   args["requestid"] = event.target.id;
   args["response"] = "Delete";
   console.log(event.target.id);
   postNotice(url,args);
  
  }

});
var postNotice = function(url,args){
   Meteor.call('postToBackend', url, args, function (err, res){
      location.reload();
   });
}