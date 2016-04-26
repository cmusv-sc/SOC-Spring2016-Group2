Template.forumlist.helpers({
  getData: function() {
  	var url = "http://localhost:9000/comment?rootid=1&categoryid=1";
  	//url = "http://localhost:9000/year/2012";
	Meteor.call('fetchFromService', url, function (err, res){
		var obj = JSON.stringify(res.data);
		console.log("Result: " + res.data.length);
		//$("#title").text(res.data.length);
	});
  }
});
