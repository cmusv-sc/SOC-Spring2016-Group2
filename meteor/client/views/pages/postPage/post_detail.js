Template.postDetail.helpers({
  getData: function() {
  	var url = "http://localhost:9000/post/getPostById/" + Router.current().params.query.id;
  	fetchData(url);
	url = "http://localhost:9000/getTagpost/" + Router.current().params.query.id;
	fetchTag(url);
  	url = "http://localhost:9000/comment?rootid=" + Router.current().params.query.id + "&categoryid=2&userid=1";
  	fetchComment(url);
  }
});

var fetchComment = function(url){
	Meteor.call('fetchFromService', url, function (err, res){
		var obj = JSON.stringify(res.data);
		var nestable = $('#nestable');
		// console.log(renderComments(res.data));
		nestable.append($(renderComments(res.data)));
	});
}

var renderComments = function(obj){
	if (obj.length == 0) {
		return "";
	}
	var s = "<ol class='dd-list'>";

	for (var i = 0; i < obj.length; i++) {
		var c = obj[i];
		var item = "<li class='dd-item'><div class='social-feed-box'>";
		var d = new Date(c.comment.time*1000);
		item += "<div class='social-avatar'><div class='media-body'><span class='text-success'>User: " + c.comment.authorid + "</span><small class='pull-right'> " + d.toLocaleString() + "</small></div></div>";
		item += "<div class='social-body'><div class='input-group'><input type='text' class='form-control input-sm input-edit hide' value='" + c.comment.content + "' id='edit-" + c.comment.id + "'><span id='commentcontent-" + c.comment.id + "'>" + c.comment.content + "</span><p></p></div>";
		item += "<div><a class='small thumbup'" + "style='color: #676a6c;' id='thumbupa-" + c.comment.id + "'" + "><i class='fa fa-thumbs-up ";
		if (c.thumbuped == true) { item += "ed"; };
		item += "' id='thumbup-" + c.comment.id + "'></i> <span>" + c.thumbup + " </span></a> <a class='small thumbdown'";
		item += " style='color: #676a6c;' id='thumbdowna-" + c.comment.id + "'" + "><i class='fa fa-thumbs-down ";
		if (c.thumbdowned == true) { item += "ed"; };
		item += "' id='thumbdown-" + c.comment.id + "'></i> <span>" + c.thumbdown + "</span></a><span class='pull-right'>";
		if (c.comment.authorid == 1) {
			//User
			item += "<a class='small edit'><i class='fa fa-paste' id='edita-" + c.comment.id + "'></i></a>";
		}
		if(isQuestion) {
			item += "<button class='btn btn-sm btn-success setAsAnswer' id='postcomment-" + c.comment.id + "'>Set As Answer</button>"
		}
		item += "</span></div><p></p>";
		item += "<div class='input-group'><input type='text' class='form-control input-sm' id='input-" + c.comment.id + "'><div class='input-group-btn'><button class='btn btn-sm btn-primary btn-upload ladda-button' data-style='zoom-out' id='upload-" + c.comment.id + "'>upload</button><button class='btn btn-sm btn-success btn-reply' id='reply-" + c.comment.id + "'>Reply</button></div></div></div></div>";
		item += renderComments(c.children);
		item += "</li>";
		s += item;
	};

	s += "</ol>";
	return s;
}

var isQuestion = false;

var fetchData = function(url){

	Meteor.call('fetchFromService', url, function (err, res){
		var obj = JSON.stringify(res.data);
		var post = res.data;
		$("#title").text(post.title);
		$(".author").text(post.authorId);
		//$(".author").text(User2.findOne(post.authorId).name);
		$(".id").text(post.id);
		$(".content").text(post.content);
		$(".postAt").text(post.postAt);
		isQuestion = post.isQuestion;
		if(post.isQuestion) {
			$(".isQuestion").text("Yes");
			if(post.answer == "") {
				$(".answer").text("No answer selected yet");
			} else {
				$(".answer").text(post.answer);
			}
		} else {
			$(".isQuestion").text("No");
			$(".answer").text("This is not a question, there is no answer");
		}
	});
}

Template.postDetail.rendered = function(){
	$("#addTag").keyup(function(e){
		if (e.keyCode==13)
		{
			console.log("Press Enter");
			$(".tags").append("<button class=\"btn btn-white btn-xs\" type=\"button\">"+$("#addTag").val()+"</button>&nbsp");
			var url = "http://localhost:9000/addtagpost/" + Router.current().params.query.id + "/" + $("#addTag").val();
			fetchTagAdded(url);
			$("#addTag").val("");
		}
	});
	$("#file1").change(function(e){
		console.log($("#file1").val());
		var formData = new FormData();
    	formData.append('file', $('#file1').get(0).files[0]);
    	console.log(up);
    	var id = up.split("-")[1];
    	var ans = "#inputcomment";
    	if (id > 0) {
    		ans = "#input-" + id;
    	}
    	var b = "#" + up;
    	console.log(b);
    	b = $(b).ladda();
    	b.ladda('start');
    	var request = $.ajax({
    	      url: "http://localhost:9000/upload",
    	      method: "POST",
    	      data: formData,
    	      contentType: false,
    	      processData: false,
    	      cache: false
    	    }).done(function(data){
    	      console.log(data);
    	      var file = data.split("/")[3];
    	      var link = '<a href="localhost:9000' + data + '">' + file + "</a>";
    	      var t = $(ans).val();
    	      $(ans).val(t + link);
    	      b.ladda('stop');
    	    });
	});
};

var up = "";

var fetchTag = function(url){
	//console.log("in fetchTag " + url);
	Meteor.call('fetchFromService', url, function(err, res){
		// console.log("res is " + JSON.stringify(res));
		if (res.content.length == 0)
			return;
		var tags = res.content.split(",");
		console.log("tags is " + tags);
		for (i=0; i<tags.length; i++)
			$(".tags").append("<button class=\"btn btn-white btn-xs\" type=\"button\">"+tags[i]+"</button>&nbsp");
	});
}

var fetchTagAdded = function(url){
	console.log("add tag into db table with url " + url);
	Meteor.call('fetchFromService', url, function(err, res){
		// YoLo
	});
}

Template.postDetail.events({
	'click #postcomment': function (event) {
		var input = $("#inputcomment").val();
		if (input == "") {
			$("#inputcomment").parent(".input-group").addClass("has-error");
			console.log("No input");
			return;
		};
		//console.log("Comment: " + input);
		var url = "http://localhost:9000/comment";
		var args = {};
		args["parentid"] = 0;
		args["authorid"] = 1;
		args["content"] = input;
		args["rootid"] = Router.current().params.query.id;
		args["categoryid"] = 2;
		//console.log(args);
		Meteor.call('postToBackend', url, args, function (err, res){
			//console.log(JSON.stringify(res));
			location.reload();
			// var redirect = "/paperdetail?id=" + Router.current().params.query.id;
			// Router.go(redirect);
		});
	},
	'click .btn-reply': function(event){
		var btnid = event.target.id;
		var id = btnid.split("-")[1];
		var inputid = "#input-" + id;
		var content = $(inputid).val();
		//console.log(content);
		if (content == "") {
			$(inputid).parent(".input-group").addClass("has-error");
			console.log("No input");
			return;
		};
		var args = {};
		args["parentid"] = id;
		args["authorid"] = 1;
		args["content"] = content;
		args["rootid"] = Router.current().params.query.id;
		args["categoryid"] = 2;
		//console.log(args);
		var url = "http://localhost:9000/comment";
		Meteor.call('postToBackend', url, args, function (err, res){
			//console.log(JSON.stringify(res));
			location.reload();
			// var redirect = "/paperdetail?id=" + Router.current().params.query.id;
			// Router.go(redirect);
		});
	},
	'click .thumbup': function(event){
		var btnid = event.target.id;
		var id = btnid.split("-")[1];
		console.log("THUMBUP: " + id + " " + event.target.getAttribute('class'));
		var aid = "#thumbupa-" + id;
		var count = parseInt($(aid).children("span").text());
		if ($(event.target).hasClass('ed')) {
			$(event.target).removeClass('ed');
			var user = 1;
			var url = "http://localhost:9000/deleteThumb/1/" + user + "/" + id;
			Meteor.call('deleteInBackend', url, function (err, res){
				console.log("Deleted");
			});
			count --;
		}else{
			$(event.target).addClass('ed');
			count ++;
			var url = "http://localhost:9000/addThumb";
			var args = {};
			args["sender"] = 1;
			args["receiver"] = id;
			args["thumb_type"] = 1;
			Meteor.call('postToBackend', url, args, function (err, res){
				console.log("Up Done");

			});
		}
		$(aid).children("span").text(count);
	},
	'click .thumbdown': function(event){
		var btnid = event.target.id;
		var id = btnid.split("-")[1];
		var aid = "#thumbdowna-" + id;
		console.log("THUMBDOWN: " + id);
		var count = parseInt($(aid).children("span").text());
		//console.log(count);
		if ($(event.target).hasClass('ed')) {
			$(event.target).removeClass('ed');
			var user = 1;
			var url = "http://localhost:9000/deleteThumb/0/" + user + "/" + id;
			Meteor.call('deleteInBackend', url, function (err, res){
				console.log("Deleted");
			});
			count --;
		}else{
			$(event.target).addClass('ed');
			count ++;
			var url = "http://localhost:9000/addThumb";
			var args = {};
			args["sender"] = 1;
			args["receiver"] = id;
			args["thumb_type"] = 0;
			Meteor.call('postToBackend', url, args, function (err, res){
				console.log("Down Done");
			});
		}
		$(aid).children("span").text(count);
	},
	'click .setAsAnswer': function(event) {
		var btnid = event.target.id;
		var id = btnid.split("-")[1];
		var commentcontentid = "#edit-" + id;
		var commentcontent = $(commentcontentid).val();
		$(".answer").text(commentcontent);
		var url = "http://localhost:9000/post/setAnswer";
		var args = {};
		args["postId"] = Router.current().params.query.id;
		args["answer"] = commentcontent;
		Meteor.call("postToBackend", url, args, function(err, res) {
			if(err) {
				console.log(err);
			} else {
				console.log(res);
			}
		});
	},
	'click .input-sm': function(event){
		console.log("FOCUS");
		$(event.target).parent(".input-group").removeClass("has-error");
	},
	'click .edit': function(event){
		//console.log("Edit: " + event.target.id);
		var id = event.target.id.split("-")[1];
		var inputid = "#edit-" + id;
		var commentcontentid = "#commentcontent-" + id;
		if ($(inputid).hasClass('hide')) {
			$(inputid).removeClass('hide');
			$(commentcontentid).addClass('hide');
		}else{
			$(inputid).addClass('hide');
			$(commentcontentid).removeClass('hide');
		}
	},
	'keyup .input-edit': function(event){
		if (event.keyCode == 13){
			var input_val = $(event.target).val();
			console.log(event.target.id);
			var id = event.target.id.split("-")[1];
			if (input_val == "") {
				$(event.target).parents(".input-group").addClass("has-error");
				return;
			}
			$(event.target).addClass('hide');
			var sib = $(event.target).siblings('span');
			$(sib).removeClass('hide');
			$(sib).text(input_val);
			var url = "http://localhost:9000/updateComment";
			var args = {};
			args["id"] = id;
			args["content"] = input_val;
			Meteor.call('postToBackend', url, args, function (err, res){
				console.log("Updated!");
			});
		}
	},
	'click .btn-upload': function(event){
		$("#file1").click();
		console.log(event.target.id);
		up = event.target.id;
	},
	'click #closecomment': function(event){
		console.log("Close");
    var myid = Session.get("userSessionId");
    var current = User2.findOne(myid);
    var myname
    if (current != null) {
      myname=current.name
    } else {
      myname = "NoName"
    }
    console.log(myname);
    if(myname=="Michael Stonebraker")
    {

      		if ($(".input-group").hasClass("hide")) {
      			$(".input-group").removeClass("hide");
      			$(".dd").removeClass("hide");
      			$("#commentnote").addClass("hide");
      			$(event.target).text("Close Comment");
      		}else{
      			$(".input-group").addClass("hide");
      			$("#commentnote").removeClass("hide");
      			$(".dd").addClass("hide");
      			$(event.target).text("Open Comment");
      		}
    }
    else if (myname!="Michael Stonebraker") {
        swal("you can't edit it!")

    }

	}
});
