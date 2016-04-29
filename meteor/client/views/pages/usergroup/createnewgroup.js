Template.createnewgroup.events({
	'click .postgroup': function (event) {
		//console.log("test click");
		var groupname = $("#groupname").val();
		var intro = $("#intro").val();
		var type = $('input[name=optionsRadios]:checked').val()

		var url = "http://localhost:9000/groups";
		var args = {};
		var myid = Session.get("userSessionId");
		args["createrid"] = myid;
		args["groupname"] = groupname;
		args["intro"] = intro;
		args["type"] = type;
		

		console.log(myid);
		
		Meteor.call('postToBackend', url, args, function (err, res){
			location.reload();
		});
	}

});
