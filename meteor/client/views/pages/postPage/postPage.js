const Posts = new Mongo.Collection('posts');

Template.postPage.events({
	'click #findPost': function() {
		  Session.set('showFindPost', true);
	},
	'click #addPost': function() {
		Session.set('showFindPost', false);
	},
	'submit #searchPostForm': function(event) {
		event.preventDefault();
		var keyword = event.keyword.text.value;
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
		var title = event.postTitle.text.value;
		var content = event.postContent.text.value;
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
	ifShowFindPost: function() {
		return Session.get('showFindPost');
	},
	posts: function() {
		return Posts.find({}, {sort: {postAt: 1}}).fetch();
	},
});

