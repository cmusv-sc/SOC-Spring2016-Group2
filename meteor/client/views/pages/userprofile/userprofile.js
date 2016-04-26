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
        console.log("Result: " + res.data.length);
        $(".loading").empty();
        $(".table").append("<tbody id='content'></tbody>");
        contentholder = $("#content");


        for (var i = 0; i < res.data.length; i++) {
            var row = "<tr><td><span class='label label-primary'>" + (i+1) + "</span> </td>";
            row += res.data[i];
            for (var j = 1; j < res.data[i].length; j++) {
                row += ", " + res.data[i];
            };
            row += "</small></td></tr>";
            contentholder.append($(row));
        };
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

