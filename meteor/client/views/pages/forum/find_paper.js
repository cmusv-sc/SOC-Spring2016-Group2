Template.findpaper.helpers({
  getData: function() {
  	var url = "http://localhost:9000/paper/year/2012";
	fetchData(url);
  },
});

var fetchData = function(url){
	var contentholder = $("#content");
	contentholder.remove();
	$(".loading").append($("<div class='sk-spinner sk-spinner-cube-grid'><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div></div>"));
	Meteor.call('fetchFromService', url, function (err, res){
		var obj = JSON.stringify(res.data);
		console.log("Result: " + JSON.stringify(res));
		$(".loading").empty();
		$(".table").append("<tbody id='content'></tbody>");
		$("#resultcount").text("Found " + res.data.length + " results.");
		contentholder = $("#content");
		for (var i = 0; i < res.data.length; i++) {
			var row = "<tr><td><span class='label label-primary'>" + (i+1) + "</span> </td><td><a href='/paperdetail?id=" + res.data[i].publication.id + "'>" + res.data[i].publication.title + "</a>" + "<br><small>";
			row += res.data[i].authors[0].name;
			for (var j = 1; j < res.data[i].authors.length; j++) {
				row += ", " + res.data[i].authors[j].name;
			};
			row += "</small></td></tr>";
			contentholder.append($(row));
		};
	});
}

Template.findpaper.events({
	'click .year': function (event) {
		console.log("click year");
		var input = $("#inputvalue").val();
		if (input == "") { console.log("No input"); return;};
		console.log("year: " + $("#inputvalue").val());
		var url = "http://localhost:9000/paper/year/" + input;
		fetchData(url);
	},
	'click .title': function (event) {
		console.log("click title");
		var input = $("#inputvalue").val();
		if (input == "") { console.log("No input"); return;};
		console.log("title: " + $("#inputvalue").val());
		var url = "http://localhost:9000/paper/title/" + input;
		fetchData(url);
	},
	'click .tagpub': function (event) {
		var input = $("#inputvalue").val();
		if (input == "") { console.log("No input"); return;};
		console.log("tagpub: " + $("#inputvalue").val());
		var url = "http://localhost:9000/getpublications/" + input;
		fetchData(url);
	}
});

