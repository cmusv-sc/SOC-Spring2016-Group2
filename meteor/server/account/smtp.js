Meteor.startup(function () {
  
  Accounts.emailTemplates.from = 'Email Support <support@bookMyTravel.com>';
  Accounts.emailTemplates.siteName = 'Book My Travel';
  Accounts.emailTemplates.verifyEmail.subject = function(user) {
    return 'Confirm Your Email Address';
  };
  /** Note: if you need to return HTML instead, use .html instead of .text **/
  Accounts.emailTemplates.verifyEmail.text = function(user, url) {
    return 'click on the following link to verify your email address: ' + url;
  };
});