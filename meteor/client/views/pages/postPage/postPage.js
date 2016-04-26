Template.postPage.events({

	'click #findPost': function(event) {
		event.preventDefault();
		Session.set('showAddNewPost', false);
	},

	'click #addPost': function(event) {
		Session.set('showAddNewPost', true);
	},

	'submit #searchPostForm': function(event) {
		event.preventDefault();
		var keyword = event.target.keyword.value;
        HTTP.call(
                'GET',
                'http://localhost:9000/post/search/' + keyword,
                {},
                function(error, response) {
                    if(error) {
                    	alert(error);
                    } else {
                        var results = response.data;
                    	if(results.length <= 0) {
                    		alert("No record found");
                    	} else {
                    		Meteor.call('removeAllPosts');
                    		for(var i = 0; i < results.length; i++) {
                    			Posts.insert({
                    				title: results[i].title,
                    				author: results[i].authorId,
                    				postAt: new Date(results[i].postAt),
                    				content: results[i].content
                    			});
                    		}
                    	}
                    }
                }
            );
	},

	'submit #addPostForm': function(event) {
		event.preventDefault();
		var title = event.target.postTitle.value;
		var content = event.target.postContent.value;
		console.log(title);
		console.log(content);
		Meteor.call('removeAllPosts');
		var post = {
				"title": title,
				"authorId": 3232,
				"content": content,
				"postAt": new Date()
			};
		Posts.insert(post);
		var url = "http://localhost:9000/post/addPost";
		var args = {};
		args["title"] = title;
		args["authorId"] = 232;
		args["content"] = content;
		args["postAt"] = new Date();
		Meteor.call('postToBackend', url, args, function (err, res){
			if(err) {
				console.log(err);
			} else {
				console.log(res);
			}
		});
	}
});

Template.postPage.helpers({
	ifShowAddNewPost: function() {
		return Session.get('showAddNewPost');
	},
	posts: function() {
		console.log("getting posts");
		console.log(Posts.find({}, {sort: {postAt: 1}}).fetch());
		return Posts.find({}, {sort: {postAt: 1}}).fetch();
	},
});