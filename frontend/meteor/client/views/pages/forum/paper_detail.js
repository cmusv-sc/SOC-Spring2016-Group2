Template.paperdetail.helpers({
  getData: function() {
  	console.log("ID: " + Router.current().params.query.id);
  	var url = "http://localhost:9000/id/" + Router.current().params.query.id;
  	fetchData(url);
	url = "http://localhost:9000/getTag/6";
	fetchTag(url);
  },
});

var fetchData = function(url){
	
	Meteor.call('fetchFromService', url, function (err, res){
		var obj = JSON.stringify(res.data);
		
		var publication = res.data[0].publication;
		var authors = res.data[0].authors;
		console.log("Result: " + publication.title);
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


var fetchTag = function(url){
	console.log("in fetchTag " + url);
	Meteor.call('fetchFromService', url, function(err, res){
		// console.log("res is " + JSON.stringify(res));
		var tags = res.content.split(",");
		console.log("tags is " + tags);
		for (i=0; i<tags.length; i++)
			$(".tags").append("<button class=\"btn btn-white btn-xs\" type=\"button\">"+tags[i]+"</button>");
	});
}
