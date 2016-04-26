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
		console.log(keyword);
        HTTP.call(
                'GET',
                'http://localhost:9000/post/search/' + keyword,
                {},
                function(error, response) {
                    if(error) {
                    	alert(error);
                        console.log(error);
                    } else {
                        console.log(response);
                        var results = response.data;
                    	if(results.length <= 0) {
                    		alert("No record found");
                    	} else {
                    		Meteor.call('removeAllPosts');
                    		for(var i = 0; i < results.length; i++) {
                    			console.log(results[i].title);
                    			console.log(results[i].authorId);
                    			console.log(results[i].postAt);
                    			console.log(results[i].content);
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
				"authorId": Meteor.userId(),
				"content": content,
				"postAt": new Date()
			};
		Posts.insert(post);
		var data = {
			params: {
				"title": title,
				"authorId": Meteor.userId(),
				"content": content,
				"postAt": new Date(),
			}
		}
		HTTP.call(
				'POST',
				'http://localhost:9000/post/addPost',
				data,
				function(error, response) {
					if(error) {
						console.log(error);
						alert(error);
					} else {
						console.log(response);
					}
				}
		);
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