(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var OAuth = Package.oauth.OAuth;
var Oauth = Package.oauth.Oauth;
var _ = Package.underscore._;
var Template = Package.templating.Template;
var Random = Package.random.Random;
var ServiceConfiguration = Package['service-configuration'].ServiceConfiguration;
var Blaze = Package.blaze.Blaze;
var UI = Package.blaze.UI;
var Handlebars = Package.blaze.Handlebars;
var Spacebars = Package.spacebars.Spacebars;
var HTML = Package.htmljs.HTML;

/* Package-scope variables */
var Github;

(function(){

//////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                              //
// packages/github/template.github_configure.js                                                 //
//                                                                                              //
//////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                //
                                                                                                // 1
Template.__checkName("configureLoginServiceDialogForGithub");                                   // 2
Template["configureLoginServiceDialogForGithub"] = new Template("Template.configureLoginServiceDialogForGithub", (function() {
  var view = this;                                                                              // 4
  return [ HTML.Raw("<p>\n    First, you'll need to get a Github Client ID. Follow these steps:\n  </p>\n  "), HTML.OL("\n    ", HTML.Raw('<li>\n      Visit <a href="https://github.com/settings/applications/new" target="blank">https://github.com/settings/applications/new</a>\n    </li>'), "\n    ", HTML.LI("\n      Set Homepage URL to: ", HTML.SPAN({
    "class": "url"                                                                              // 6
  }, Blaze.View("lookup:siteUrl", function() {                                                  // 7
    return Spacebars.mustache(view.lookup("siteUrl"));                                          // 8
  })), "\n    "), "\n    ", HTML.LI("\n      Set Authorization callback URL to: ", HTML.SPAN({  // 9
    "class": "url"                                                                              // 10
  }, Blaze.View("lookup:siteUrl", function() {                                                  // 11
    return Spacebars.mustache(view.lookup("siteUrl"));                                          // 12
  }), "_oauth/github"), "\n    "), "\n  ") ];                                                   // 13
}));                                                                                            // 14
                                                                                                // 15
//////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

//////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                              //
// packages/github/github_configure.js                                                          //
//                                                                                              //
//////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                //
Template.configureLoginServiceDialogForGithub.helpers({                                         // 1
  siteUrl: function () {                                                                        // 2
    return Meteor.absoluteUrl();                                                                // 3
  }                                                                                             // 4
});                                                                                             // 5
                                                                                                // 6
Template.configureLoginServiceDialogForGithub.fields = function () {                            // 7
  return [                                                                                      // 8
    {property: 'clientId', label: 'Client ID'},                                                 // 9
    {property: 'secret', label: 'Client Secret'}                                                // 10
  ];                                                                                            // 11
};                                                                                              // 12
                                                                                                // 13
//////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

//////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                              //
// packages/github/github_client.js                                                             //
//                                                                                              //
//////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                //
Github = {};                                                                                    // 1
                                                                                                // 2
// Request Github credentials for the user                                                      // 3
// @param options {optional}                                                                    // 4
// @param credentialRequestCompleteCallback {Function} Callback function to call on             // 5
//   completion. Takes one argument, credentialToken on success, or Error on                    // 6
//   error.                                                                                     // 7
Github.requestCredential = function (options, credentialRequestCompleteCallback) {              // 8
  // support both (options, callback) and (callback).                                           // 9
  if (!credentialRequestCompleteCallback && typeof options === 'function') {                    // 10
    credentialRequestCompleteCallback = options;                                                // 11
    options = {};                                                                               // 12
  }                                                                                             // 13
                                                                                                // 14
  var config = ServiceConfiguration.configurations.findOne({service: 'github'});                // 15
  if (!config) {                                                                                // 16
    credentialRequestCompleteCallback && credentialRequestCompleteCallback(                     // 17
      new ServiceConfiguration.ConfigError());                                                  // 18
    return;                                                                                     // 19
  }                                                                                             // 20
  var credentialToken = Random.secret();                                                        // 21
                                                                                                // 22
  var scope = (options && options.requestPermissions) || ['user:email'];                        // 23
  var flatScope = _.map(scope, encodeURIComponent).join('+');                                   // 24
                                                                                                // 25
  var loginStyle = OAuth._loginStyle('github', config, options);                                // 26
                                                                                                // 27
  var loginUrl =                                                                                // 28
    'https://github.com/login/oauth/authorize' +                                                // 29
    '?client_id=' + config.clientId +                                                           // 30
    '&scope=' + flatScope +                                                                     // 31
    '&redirect_uri=' + OAuth._redirectUri('github', config) +                                   // 32
    '&state=' + OAuth._stateParam(loginStyle, credentialToken, options && options.redirectUrl);
                                                                                                // 34
  OAuth.launchLogin({                                                                           // 35
    loginService: "github",                                                                     // 36
    loginStyle: loginStyle,                                                                     // 37
    loginUrl: loginUrl,                                                                         // 38
    credentialRequestCompleteCallback: credentialRequestCompleteCallback,                       // 39
    credentialToken: credentialToken,                                                           // 40
    popupOptions: {width: 900, height: 450}                                                     // 41
  });                                                                                           // 42
};                                                                                              // 43
                                                                                                // 44
//////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package.github = {}, {
  Github: Github
});

})();
