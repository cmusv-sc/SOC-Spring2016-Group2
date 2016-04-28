Template.subscriptionlist.helpers({
  getData: function() {
  	var url = "http://localhost:9000/subscribe/list/all";
	fetchData(url);
  },
});
 
var fetchData = function(url){
	var contentholder = $("#content");
	contentholder.remove();
	$(".loading").append($("<div class='sk-spinner sk-spinner-cube-grid'><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div></div>"));
	Meteor.call('fetchFromService', url, function (err, res){
		console.log("subscribe res="+ JSON.stringify(res));
		//console.log("Result: " + res.data.length);
		$(".loading").empty();
		$(".table").append("<tbody id='content'></tbody>");
		$("#resultcount").text("Found " + res.data.length + " results.");
		contentholder = $("#content");
		var thead="<tr><th width=\"100\">Number</th><th width=\"100\">Name</th><th width=\"100\">Category</th></tr>";
		contentholder.append($(thead));
		for (var i = 0; i < res.data.length; i++) {
			var row = "<tr><td><span class='label label-primary'>" + (i+1) + "</span></td><td>" + res.data[i].username + "</td><td>" + res.data[i].category + "</td></tbody>";
			contentholder.append($(row));
		};
	});
}


Template.subscriptionlist.events({
	'click .all': function (event) {		
		var url = "http://localhost:9000/subscribe/list/all";
		fetchData(url);
	},
	'click .user': function (event) {
		var url = "http://localhost:9000/subscribe/list/user";
		fetchData(url);
	},
	'click .group': function (event) {		
		var url = "http://localhost:9000/subscribe/list/group";
		fetchData(url);
	},
	'click .paper': function (event) {
		var url = "http://localhost:9000/subscribe/list/paper";
		fetchData(url);
	}

});


