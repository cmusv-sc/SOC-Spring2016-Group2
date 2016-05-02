Template.postPage.events({

	'click .findPost': function(event) {
		event.preventDefault();
		Session.set('showSearchPost', true);
	},

	'click .newPost': function(event) {
		event.preventDefault();
		Session.set('showSearchPost', false);
	},
	'click .searchPost': function (event) {
		event.preventDefault();
		var input = $("#keyword").val();
		$("#keyword").val("");
		if (input == "") { console.log("No input"); return;};
		console.log("year: " + $("#inputvalue").val());
		var url = "http://localhost:9000/post/search/" + input;
		fetchData(url);
	},
	'click .addNewPost': function (event) {
		event.preventDefault();
		var title = $("#newPostTitle").val();
		if(title == "") {
			console.log("no post title");
			return;
		}
		var content = $("#newPostContent").val();
		if(content == "") {
			console.log("post content is empty");
			return;
		}
		var isQuestion = $("#setAsQuestion").prop('checked');
		$("#newPostTitle").val("");
		$("#newPostContent").val("");
		$("#setAsQuestion").checked = false;
		var args = {};
		args["title"] = title;
		args["authorid"] = Session.get("userSessionId");
		args["content"] = content;
		args["postAt"] = new Date().toLocaleString();
		args["isQuestion"] = isQuestion;
		var url = "http://localhost:9000/post/addPost";
		Meteor.call('postToBackend', url, args, function (err, res){
			location.reload();
			if(err) {
				console.log("Failed to add new post");
			} else {
				var url = "http://localhost:9000/post/getAllPosts";
				fetchData(url);
			}
		});
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
		if(res.data != null) {
			$("#resultcount").text("Found " + res.data.length + " results.");
			contentholder = $("#content");
			for (var i = 0; i < res.data.length; i++) {
				var row = "<tr><td><span class='label label-primary'>" + (i+1) + "</span> </td><td><a href='/postdetail?id=" + res.data[i].id + "'>" + res.data[i].title + "</a>" + "<br><small>";
				row += res.data[i].authorId;
				//row += User2.findOne(res.data[i].authorId).name;
				row += "</small></td></tr>";
				contentholder.append($(row));
			};
		} else {
			$("#resultcount").text("There is no posts right now");
		}
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