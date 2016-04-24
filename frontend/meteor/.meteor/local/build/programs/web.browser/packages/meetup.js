(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var OAuth = Package.oauth.OAuth;
var Oauth = Package.oauth.Oauth;
var Template = Package.templating.Template;
var _ = Package.underscore._;
var Random = Package.random.Random;
var ServiceConfiguration = Package['service-configuration'].ServiceConfiguration;
var Blaze = Package.blaze.Blaze;
var UI = Package.blaze.UI;
var Handlebars = Package.blaze.Handlebars;
var Spacebars = Package.spacebars.Spacebars;
var HTML = Package.htmljs.HTML;

/* Package-scope variables */
var Meetup;

(function(){

//////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                  //
// packages/meetup/template.meetup_configure.js                                                     //
//                                                                                                  //
//////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                    //
                                                                                                    // 1
Template.__checkName("configureLoginServiceDialogForMeetup");                                       // 2
Template["configureLoginServiceDialogForMeetup"] = new Template("Template.configureLoginServiceDialogForMeetup", (function() {
  var view = this;                                                                                  // 4
  return [ HTML.Raw("<p>\n    First, you'll need to get a Meetup Client ID. Follow these steps:\n  </p>\n  "), HTML.OL("\n    ", HTML.Raw('<li>\n      Visit <a href="http://www.meetup.com/meetup_api/oauth_consumers/create/" target="blank">http://www.meetup.com/meetup_api/oauth_consumers/create/</a>\n    </li>'), "\n    ", HTML.Raw("<li>\n      Set the Consumer name to the name of your application.\n    </li>"), "\n    ", HTML.Raw("<li>\n      Optionally set the Application Website to the URL of your\n      website.  You can leave this blank.\n    </li>"), "\n    ", HTML.LI("\n      Set the ", HTML.Raw("<b>Redirect URI</b>"), " to: ", HTML.SPAN({
    "class": "url"                                                                                  // 6
  }, Blaze.View("lookup:siteUrl", function() {                                                      // 7
    return Spacebars.mustache(view.lookup("siteUrl"));                                              // 8
  })), "  (Do not append a path to this URL.)\n    "), "\n  ") ];                                   // 9
}));                                                                                                // 10
                                                                                                    // 11
//////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

//////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                  //
// packages/meetup/meetup_configure.js                                                              //
//                                                                                                  //
//////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                    //
Template.configureLoginServiceDialogForMeetup.helpers({                                             // 1
  siteUrl: function () {                                                                            // 2
    return Meteor.absoluteUrl();                                                                    // 3
  }                                                                                                 // 4
});                                                                                                 // 5
                                                                                                    // 6
Template.configureLoginServiceDialogForMeetup.fields = function () {                                // 7
  return [                                                                                          // 8
    {property: 'clientId', label: 'Key'},                                                           // 9
    {property: 'secret', label: 'Secret'}                                                           // 10
  ];                                                                                                // 11
};                                                                                                  // 12
                                                                                                    // 13
//////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

//////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                  //
// packages/meetup/meetup_client.js                                                                 //
//                                                                                                  //
//////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                    //
Meetup = {};                                                                                        // 1
// Request Meetup credentials for the user                                                          // 2
// @param options {optional}                                                                        // 3
// @param credentialRequestCompleteCallback {Function} Callback function to call on                 // 4
//   completion. Takes one argument, credentialToken on success, or Error on                        // 5
//   error.                                                                                         // 6
Meetup.requestCredential = function (options, credentialRequestCompleteCallback) {                  // 7
  // support both (options, callback) and (callback).                                               // 8
  if (!credentialRequestCompleteCallback && typeof options === 'function') {                        // 9
    credentialRequestCompleteCallback = options;                                                    // 10
    options = {};                                                                                   // 11
  }                                                                                                 // 12
                                                                                                    // 13
  var config = ServiceConfiguration.configurations.findOne({service: 'meetup'});                    // 14
  if (!config) {                                                                                    // 15
    credentialRequestCompleteCallback && credentialRequestCompleteCallback(                         // 16
      new ServiceConfiguration.ConfigError());                                                      // 17
    return;                                                                                         // 18
  }                                                                                                 // 19
                                                                                                    // 20
  // For some reason, meetup converts underscores to spaces in the state                            // 21
  // parameter when redirecting back to the client, so we use                                       // 22
  // `Random.id()` here (alphanumerics) instead of `Random.secret()`                                // 23
  // (base 64 characters).                                                                          // 24
  var credentialToken = Random.id();                                                                // 25
                                                                                                    // 26
  var scope = (options && options.requestPermissions) || [];                                        // 27
  var flatScope = _.map(scope, encodeURIComponent).join('+');                                       // 28
                                                                                                    // 29
  var loginStyle = OAuth._loginStyle('meetup', config, options);                                    // 30
                                                                                                    // 31
  var loginUrl =                                                                                    // 32
        'https://secure.meetup.com/oauth2/authorize' +                                              // 33
        '?client_id=' + config.clientId +                                                           // 34
        '&response_type=code' +                                                                     // 35
        '&scope=' + flatScope +                                                                     // 36
        '&redirect_uri=' + OAuth._redirectUri('meetup', config) +                                   // 37
        '&state=' + OAuth._stateParam(loginStyle, credentialToken, options && options.redirectUrl);
                                                                                                    // 39
  // meetup box gets taller when permissions requested.                                             // 40
  var height = 620;                                                                                 // 41
  if (_.without(scope, 'basic').length)                                                             // 42
    height += 130;                                                                                  // 43
                                                                                                    // 44
  OAuth.launchLogin({                                                                               // 45
    loginService: "meetup",                                                                         // 46
    loginStyle: loginStyle,                                                                         // 47
    loginUrl: loginUrl,                                                                             // 48
    credentialRequestCompleteCallback: credentialRequestCompleteCallback,                           // 49
    credentialToken: credentialToken,                                                               // 50
    popupOptions: {width: 900, height: height}                                                      // 51
  });                                                                                               // 52
};                                                                                                  // 53
                                                                                                    // 54
//////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package.meetup = {}, {
  Meetup: Meetup
});

})();
