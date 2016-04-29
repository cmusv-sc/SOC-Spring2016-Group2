Template.userprofile.helpers({
    getData: function() {
        //var person = Session.get("namesession");
        //console.log(person);
        var url = "http://localhost:9000/userprofile/refresh/sssss";
        fetchData(url);
    },
});

var fetchData = function(url){
    var contentholder = $("#content");
    //contentholder.remove();

    $(".loading").append($("<div class='sk-spinner sk-spinner-cube-grid'><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div></div>"));
    Meteor.call('fetchFromService', url, function (err, res){
        var obj = JSON.stringify(res.data);
        console.log("Result: " + obj);
        $(".loading").empty();
      //  $(".table").append("<tbody id='content'></tbody>");
      //  contentholder = $("#content");
        var collaboratorNumbers = res.data[0].collaboratornumber;
        var subscriberNumbers = res.data[1].subscribenumbers;
        var titles = res.data[2].titles;
        var tags = res.data[3].tags;

        //console.log("AAAAAAAAAAA"+tags.split("$&"));
        console.log("TTTTTTTTTTTTTTT"+collaboratorNumbers+""+subscriberNumbers+""+titles+tags);

        $(".collaboratorNumber").text(collaboratorNumbers);
        $(".subscriberNumber").text(subscriberNumbers);
        $(".titles").text(titles.split("$&"));
        $(".tags").text(tags.split("$&"));
    });
}


Template.userprofile.events({
    'click .Refresh': function (event) {
        var input = $("#inputvalue").val();
        if (input == "") { console.log("No input"); return;};
        console.log("refresh userprofile: " + $("#inputvalue").val());
        var url = "http://localhost:9000/userprofile/refresh/" + input;
        fetchData(url);
    },
    'click .Search': function (event) {
        var input = $("#inputvalue").val();
        if (input == "") { console.log("No input"); return;};
        console.log("refresh userprofile: " + $("#inputvalue").val());
        var url = "http://localhost:9000/userprofile/" + input;
        fetchData(url);
    }
});

