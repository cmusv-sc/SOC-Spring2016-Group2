Template.paperdetail.helpers({
  getData: function() {
  	//console.log("ID: " + Router.current().params.query.id);
  	var url = "http://localhost:9000/id/" + Router.current().params.query.id;
  	fetchData(url);
	url = "http://localhost:9000/getTag/" + Router.current().params.query.id;
	fetchTag(url);
  	url = "http://localhost:9000/comment?rootid=" + Router.current().params.query.id + "&categoryid=1";
  	fetchComment(url);
  },
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
		item += "<div class='social-body'><p>" + c.comment.content + "</p>";
		item += "<a href='# class='small' style='color: #676a6c;'><i class='fa fa-thumbs-up'></i></a> " + c.thumbup + " <a href='#'' class='small' style='color: #676a6c;''><i class='fa fa-thumbs-down'></i></a> " + c.thumbdown + "<p></p>";
		item += "<div class='input-group'><input type='text' class='form-control input-sm' id='input-" + c.comment.id + "'><div class='input-group-btn'><button class='btn btn-sm btn-success btn-reply' id='reply-" + c.comment.id + "'>Reply</button></div></div></div></div>";
		item += renderComments(c.children);
		item += "</li>";
		s += item;
	};
	
	s += "</ol>";
	return s;
}

var fetchData = function(url){
	
	Meteor.call('fetchFromService', url, function (err, res){
		var obj = JSON.stringify(res.data);
		
		var publication = res.data[0].publication;
		var authors = res.data[0].authors;
		//console.log("Result: " + publication.title);
		$("#title").text(publication.title);
		$(".title").text(publication.title);
		$(".id").text(publication.id);
		$(".pubkey").text(publication.pubkey);
		$(".editor").text(publication.editor);
		$(".year").text(publication.year);
		$(".isbn").text(publication.isbn);
		$(".url").text(publication.url);
		$(".volume").text(publication.volume);
		$(".pages").text(publication.pages);
		$(".mdate").text(publication.mdate);
		$(".series").text(publication.series);
		$(".publisher").text(publication.publisher);
		$(".booktitle").text(publication.booktitle);
		$(".crossref").text(publication.crossref);
		$(".ee").text(publication.ee);
		$(".ee").attr("href", publication.ee);
		var author = authors[0].name;
		for (var i = 1; i < authors.length; i++) {
			author += ", " + authors[i].name;
		};
		$(".author").text(author);
	});
}

Template.paperdetail.rendered = function(){
	$("#addTag").keyup(function(e){
		if (e.keyCode==13)
		{
			console.log("Press Enter");
			$(".tags").append("<button class=\"btn btn-white btn-xs\" type=\"button\">"+$("#addTag").val()+"</button>&nbsp");
			var url = "http://localhost:9000/addtagpub/" + Router.current().params.query.id + "/" + $("#addTag").val(); 
			fetchTagAdded(url);
			$("#addTag").val("");
		}
	});
};

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

Template.paperdetail.events({
	'click #postcomment': function (event) {
		var input = $("#inputcomment").val();
		if (input == "") { console.log("No input"); return;};
		//console.log("Comment: " + input);
		var url = "http://localhost:9000/comment";
		var args = {};
		args["parentid"] = 0;
		args["authorid"] = 1;
		args["content"] = input;
		args["rootid"] = Router.current().params.query.id;
		args["categoryid"] = 1;
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
		if (console == "") {console.log("No input"); return;};
		var args = {};
		args["parentid"] = id;
		args["authorid"] = 1;
		args["content"] = content;
		args["rootid"] = Router.current().params.query.id;
		args["categoryid"] = 1;
		//console.log(args);
		var url = "http://localhost:9000/comment";
		Meteor.call('postToBackend', url, args, function (err, res){
			//console.log(JSON.stringify(res));
			location.reload();
			// var redirect = "/paperdetail?id=" + Router.current().params.query.id;
			// Router.go(redirect);
		});
	}
});
