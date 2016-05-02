Template.timeline.helpers({
  getData: function() {
  	var url = "http://localhost:9000/subscribe/timeline";
	fetchData(url);
  },
});

var fetchData = function(url){
	var contentholder = $("#content");
	contentholder.remove();
	// $(".loading").append($("<div class='sk-spinner sk-spinner-cube-grid'><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div></div>"));
	Meteor.call('fetchFromService', url, function (err, res){
		console.log("timeline res="+ JSON.stringify(res));
		console.log("length= "+ res.data.length);
		for (var i = 0; i < res.data.length; i++) {
			var row = "<h3>" + res.data[i].username + "</h3><p><span class=\"glyphicon glyphicon-time\"></span>" + res.data[i].timestamp + " from " + res.data[i].category + "</p><p style=\"font-size:18px\">" + res.data[i].content +"</p><hr>";
			document.getElementById("content").innerHTML+=row;
		};
	});
}