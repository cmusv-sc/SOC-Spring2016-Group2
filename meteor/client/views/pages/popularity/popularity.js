Template.popularity.helpers({
  getData1: function() {
  	var url = "http://localhost:9000/paper/year/2012";
	fetchData1(url);
  },
});

var fetchData1 = function(url){
	var contentholder = $("#content");
	contentholder.remove();
	$(".loading").append($("<div class='sk-spinner sk-spinner-cube-grid'><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div></div>"));
	Meteor.call('fetchFromService', url, function (err, res){
		var obj = JSON.stringify(res.data);
		//console.log("Result: " + res.data.length);
		$(".loading").empty();
		$(".table").append("<tbody id='content'></tbody>");
		$("#resultcount").text("Found " + res.data.length + " results.");
		contentholder = $("#content");
		for (var i = 0; i < res.data.length; i++) {
			var row = "<tr><td><span class='label label-primary'>" + (i+1) + "</span> </td><td><a href='/paperdetail?id=" + res.data[i].publication.id + "'>" + res.data[i].publication.title + "</span> </td><td>" + "<small>";
			row += res.data[i].authors[0].name;
			for (var j = 1; j < res.data[i].authors.length; j++) {
				row += ", " + res.data[i].authors[j].name;
			};
			row += "</small></td><td>"+res.data[i].publication.year+"</td></tr>";
			contentholder.append($(row));
		};
	});
}

Template.popularity.events({
	'click .year': function (event) {
		var input = $("#inputvalue").val();
		if (input == "") { console.log("No input"); return;};
		console.log("ByYear: " + $("#inputvalue").val());
		var url = "http://localhost:9000/getPopularityByYear/" + input;
		fetchData1(url);
	},
	'click .author': function (event) {
		var input = $("#inputvalue").val();
		if (input == "") { console.log("No input"); return;};
		console.log("title: " + $("#inputvalue").val());
		var url = "http://localhost:9000/getAuthorPopularity/" + input;
		fetchData1(url);
	},
	'click .popularity': function (event) {
		
		var url = "http://localhost:9000/getMostPopularity";
		fetchData1(url);

	},
});

