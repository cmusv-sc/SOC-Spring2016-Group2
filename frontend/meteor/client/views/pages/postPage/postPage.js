const Posts = new Mongo.Collection('posts');

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
                    	if(response.length <= 0) {
                    		alert("No record found");
                    	} else {
                    		Posts.remove({});
                    		for(var i = 0; i < response.length; i++) {
                    			Posts.insert({
                    				title: response[i].title,
                    				author: response[i].authorId,
                    				postAt: new Date(response[i].postAt),
                    				content: response[i].content
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
		Posts.remove({});
		var post = {
				title: title,
				author: Meteor.userId(),
				content: content,
				postAt: new Date()
			};
		Posts.insert(post);
		HTTP.call(
				'POST',
				'http://localhost:9000/post/addPost',
				post,
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
		return Posts.find({}, {sort: {postAt: 1}}).fetch();
	},
});

