Template.login.events({

  'submit form' ( event, template ) {
    event.preventDefault();
    
    email    = event.target.email.value,
    password = event.target.password.value;
    
    Meteor.logininWithPassword(email, password);

  }

});

Template.photo.events({
    'click .takePhoto': function(event, template) {

    var cameraOptions = {
        width: 400,
        height: 400
    };

    MeteorCamera.getPicture(cameraOptions, function (error, data) {
        
        if (!error) {
            template.$('.photo').attr('src', data); 
        }
        
        Session.set("identificationPhoto", data);

        var formData = new FormData();
        var backupData = open("/demo/evans.jpg", mode='r');

        formData.append("files", backupData);
        formData.append("album", "Stuart");
        formData.append("albumkey", "e0fae4596dcd26cab7f43424fd21732440c3a8fec421e52fa27676008f74799d");
        
        var request = request.postSync("https://lambda-face-recognition.p.mashape.com/detect");

        var headers = {
            'X-Mashape-Key': 'K9cjqFoiMvmshaynIi8ohEKnbCgcp1H0dpTjsnZFoWTu6X2JvV'
        };

        var options = {
            url: 'https://lambda-face-recognition.p.mashape.com/detect',
            method: 'POST',
            body: formData,
            headers: headers
        };

        function callback(error, response, body) {
            if (!error && response.statusCode == 200) {
                console.log(body);
            }
        }

        request(options, callback);
        console.log("[INFO] xmlhttp Sent");

    });
    event.preventDefault();
}});

