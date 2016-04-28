Template.paperedit.events({
  //var url = "http://localhost:9000/id/" + Router.current().params.query.id;
  //fetchData(url);
  'click #updatepaper': function (event) {
    swal("save success!")
    var newTitle = $("#title").val();
    var newEditor = $("#editor").val();
    var newYear = $("#year").val();
    var newIsbn = $("#isbn").val();
    var newVolume = $("#volume").val();
    var newPages = $("#pages").val();
    var newMdate = $("#mdate").val();
    var newSeries = $("#series").val();
    var newPublisher = $("#publisher").val();
    var newBookTitle = $("#booktitle").val();
    var newCrossRef = $("#crossref").val();
    var newEE = $("#ee").val();
    var newAuthor = $("#author").val();
    var tagedit = $("#tagedit").val();

    var url = "http://localhost:9000/updatepub/?pub_id=" + Router.current().params.query.id + "&title=" +  newTitle +
        "&editor=" + newEditor + "&year=" + newYear + "&isbn=" + newIsbn +
        "&volume=" + newVolume + "&pages=" + newPages + "&mdate=" + newMdate + "&series=" + newSeries +
        "&publisher=" + newPublisher + "&booktitle=" + newBookTitle +
        "&crossref=" + newCrossRef + "&ee=" + newEE + "&author=" + newAuthor;
    modifyData(url);
    //var url= "http://localhost:9000/updatetag/"+ Router.current().params.query.id +;
    //console.log(url);

    $("#title").val(newTitle);
    $("#editor").val(newEditor);
    $("#year").val(newYear);
    $("#isbn").val(newIsbn);
    $("#volume").val(newVolume);
    $("#pages").val(newPages);
    $("#mdate").val(newMdate);
    $("#series").val(newSeries);
    $("#publisher").val(newPublisher);
    $("#booktitle").val(newBookTitle);
    $("#crossref").val(newCrossRef);
    $("#ee").val(newEE);
    $("#author").val(newAuthor);
    $("#tagedit").val(tagedit);

    var url1 = "http://localhost:9000/updateTag/?pubid=" + Router.current().params.query.id  + "&tagpub=" + tagedit;
    modifyData(url1);

  },

  'click #backpub': function (event) {
    var url = "http://localhost:3000/paperdetail?id=" + Router.current().params.query.id;
    Router.go(url);
  }
});



var modifyData = function(url) {
  Meteor.call('fetchFromService', url, function (err, res){
  });
}

Template.paperedit.rendered = function(){

  var url = "http://localhost:9000/paper/id/" + Router.current().params.query.id;
  fetchData(url);
  url = "http://localhost:9000/getTag/" + Router.current().params.query.id;
	fetchTag(url);
  //$("#title").val(publication.title);
};

var fetchData = function(url){
	Meteor.call('fetchFromService', url, function (err, res) {
		var obj = JSON.stringify(res.data);

		var publication = res.data[0].publication;
		var authors = res.data[0].authors;
		$("#title").val(publication.title);
		$("#editor").val(publication.editor);
		$("#year").val(publication.year);
		$("#isbn").val(publication.isbn);
		$(".url").text(publication.url);
		$("#volume").val(publication.volume);
		$("#pages").val(publication.pages);
		$("#mdate").val(publication.mdate);
		$("#series").val(publication.series);
		$("#publisher").val(publication.publisher);
		$("#booktitle").val(publication.booktitle);
		$("#crossref").val(publication.crossref);
		$("#ee").val(publication.ee);
    $(".id").text(publication.id);
    $(".pubkey").text(publication.pubkey);
    console.log(publication.url);
		var author = authors[0].name;
		for (var i = 1; i < authors.length; i++) {
			author += ", " + authors[i].name;
		};
		$("#author").val(author);
	});
}

var fetchTag = function(url){
	//console.log("in fetchTag " + url);
	Meteor.call('fetchFromService', url, function(err, res){
		// console.log("res is " + JSON.stringify(res));
		if (res.content.length == 0)
			return;
		var tags = res.content;
    $("#tagedit").val(tags);
	});
}
