Meteor.startup(function () {

	smtp = {
	    username: 'serviceorientedcomputinggroup2',   // eg: server@gentlenode.com
	    password: 'servicepassword',   // eg: 3eeP1gtizk5eziohfervU
	    server:   'smtp.gmail.com',  // eg: mail.gandi.net
	    port: 25,
  	}
	process.env.MAIL_URL = 'smtp://' + encodeURIComponent(smtp.username) + ':' + encodeURIComponent(smtp.password) + '@' + encodeURIComponent(smtp.server) + ':' + smtp.port;
  
	Accounts.emailTemplates.from = 'Email Support <support@serviceorientedcomputinggroup2.com>';
	Accounts.emailTemplates.siteName = 'Scientific Social Network';

	Accounts.emailTemplates.verifyEmail.subject = function(user) {
		return 'Confirm Your Email Address';
	};
	/** Note: if you need to return HTML instead, use .html instead of .text **/
	Accounts.emailTemplates.verifyEmail.text = function(user, url) {
		return 'click on the following link to verify your email address: ' + url;
	};

	Accounts.emailTemplates.resetPassword.subject = function (user) {
		return "Message for " + user.profile.displayName;
	};

	Accounts.emailTemplates.resetPassword.text = function (user, url) {
	    var signature = "MySite Bot";
	    
	    url = "http://54.187.53.141";

	    return "Dear " + user.profile.displayName + ",\n\n" +
	        "Click the following link to set your new password:\n" +
	        url + "\n\n" +
	        "Please never forget it again!!!\n\n\n" +
	        "Cheers,\n" +
	        signature;
	};
});