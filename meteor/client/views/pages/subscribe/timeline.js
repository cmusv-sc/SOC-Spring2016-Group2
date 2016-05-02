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
			var content="";
			var content2="";
			if(res.data[i].category=='paper'){	
				console.log("content="+res.data[i].content);
				console.log("content length="+res.data[i].content.length);
				for(var j=0;j<res.data[i].content.length;j++){
					content2+="<h4>" + res.data[i].content[j].username + "</h4><p><span class=\"glyphicon glyphicon-time\"></span>" + res.data[i].content[j].timestamp + " from comment" + "</p><p style=\"font-size:14px\">" + res.data[i].content[j].content +"</p>";
				}
				content2+="<hr>";
			}
			else{
				content=res.data[i].content;
			}
			var row = "<h3>" + res.data[i].username + "</h3><p><span class=\"glyphicon glyphicon-time\"></span>" + res.data[i].timestamp + " from " + res.data[i].category + "</p><p style=\"font-size:18px\">" + content +"</p><hr>";
			document.getElementById("content").innerHTML+=row;
			document.getElementById("content").innerHTML+=content2;
		};
	});
}