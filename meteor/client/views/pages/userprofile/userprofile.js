Template.userprofile.helpers({
    getData: function() {
        var url = "http://localhost:9000/userprofile/refresh/Wei%20Song";
        fetchData(url);
    },
});

var fetchData = function(url){
    var contentholder = $("#content");
    contentholder.remove();

    $(".loading").append($("<div class='sk-spinner sk-spinner-cube-grid'><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div><div class='sk-cube'></div></div>"));
    Meteor.call('fetchFromService', url, function (err, res){
        var obj = JSON.stringify(res.data);
        //console.log("Result: " + res.data.length);
        $(".loading").empty();
        $(".table").append("<tbody id='content'></tbody>");
        contentholder = $("#content");
        var collaboratorNumbers = res.data[0].collaboratornumber;
        var subscriberNumbers = res.data[1].subscribenumbers;
        var titles = res.data[2].titles;
        var tags = res.data[3].tags;
        //console.log("TTTTTTTTTTTTTTT"+collaboratorNumbers+""+subscriberNumbers+""+titles+tags);

        $(".collaboratorNumber").text(collaboratorNumbers);
        $(".subscriberNumber").text(subscriberNumbers);
        $(".titles").text(titles);
        $(".tags").text(tags);
    });
}


Template.userprofile.events({
    'click .userprofile': function (event) {
        var input = $("#inputvalue").val();
        if (input == "") { console.log("No input"); return;};
        console.log("year: " + $("#inputvalue").val());
        var url = "http://localhost:9000/userprofile/" + input;
        fetchData(url);
    },
    'click .refresh': function (event) {
        var input = $("#inputvalue").val();
        if (input == "") { console.log("No input"); return;};
        console.log("refresh userprofile: " + $("#inputvalue").val());
        var url = "http://localhost:9000/userprofile/refresh/" + input;
        fetchData(url);
    }
});

