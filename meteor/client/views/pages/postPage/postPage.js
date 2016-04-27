Template.postPage.events({

	'click .findPost': function(event) {
		event.preventDefault();
		Session.set('showSearchPost', true);
	},

	'click .newPost': function(event) {
		Session.set('showSearchPost', false);
	},
});

var fetchData = function(url){
	var contentholder = $("#content");
	contentholder.remove();
	$(".loading").append($("<div class='sk-spinner sk-spinner-cube-grid'><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div></div>"));
	Meteor.call('fetchFromService', url, function (err, res){
		var obj = JSON.stringify(res.data);
		$(".loading").empty();
		$(".table").append("<tbody id='content'></tbody>");
		$("#resultcount").text("Found " + res.data.length + " results.");
		contentholder = $("#content");
		for (var i = 0; i < res.data.length; i++) {
			var row = "<tr><td><span class='label label-primary'>" + (i+1) + "</span> </td><td><a href='/paperdetail?id=" + res.data[i].post.id + "'>" + res.data[i].post.title + "</a>" + "<br><small>";
			row += res.data[i].authorId;
			row += "</small></td></tr>";
			contentholder.append($(row));
		};
	});
}

Template.postPage.helpers({
	ifShowAddNewPost: function() {
		return Session.get('showSearchPost');
	},
	getData: function() {
		var url = "http://localhost:9000/post/getAllPosts";
		fetchData(url);
	},
});