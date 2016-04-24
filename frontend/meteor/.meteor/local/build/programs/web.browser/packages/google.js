(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var OAuth = Package.oauth.OAuth;
var Oauth = Package.oauth.Oauth;
var _ = Package.underscore._;
var ServiceConfiguration = Package['service-configuration'].ServiceConfiguration;
var Random = Package.random.Random;
var Template = Package.templating.Template;
var Blaze = Package.blaze.Blaze;
var UI = Package.blaze.UI;
var Handlebars = Package.blaze.Handlebars;
var Spacebars = Package.spacebars.Spacebars;
var HTML = Package.htmljs.HTML;

/* Package-scope variables */
var Google;

(function(){

///////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                           //
// packages/google/template.google_configure.js                                              //
//                                                                                           //
///////////////////////////////////////////////////////////////////////////////////////////////
                                                                                             //
                                                                                             // 1
Template.__checkName("configureLoginServiceDialogForGoogle");                                // 2
Template["configureLoginServiceDialogForGoogle"] = new Template("Template.configureLoginServiceDialogForGoogle", (function() {
  var view = this;                                                                           // 4
  return [ HTML.Raw("<p>\n    First, you'll need to get a Google Client ID. Follow these steps:\n  </p>\n  "), HTML.OL("\n    ", HTML.Raw('<li>\n      Visit <a href="https://console.developers.google.com/" target="blank">https://console.developers.google.com/</a>\n    </li>'), "\n    ", HTML.Raw('<li>\n      "Create Project", if needed. Wait for Google to finish provisioning.\n    </li>'), "\n    ", HTML.Raw('<li>\n      On the left sidebar, go to "APIs &amp; auth" and, underneath, "Consent Screen". Make sure to enter an email address and a product name, and save.\n    </li>'), "\n    ", HTML.Raw('<li>\n      On the left sidebar, go to "APIs &amp; auth" and then, "Credentials". "Create New Client ID", then select "Web application" as the type.\n    </li>'), "\n    ", HTML.LI("\n     Set Authorized Javascript Origins to: ", HTML.SPAN({
    "class": "url"                                                                           // 6
  }, Blaze.View("lookup:siteUrl", function() {                                               // 7
    return Spacebars.mustache(view.lookup("siteUrl"));                                       // 8
  })), "\n    "), "\n    ", HTML.LI("\n      Set Authorized Redirect URI to: ", HTML.SPAN({  // 9
    "class": "url"                                                                           // 10
  }, Blaze.View("lookup:siteUrl", function() {                                               // 11
    return Spacebars.mustache(view.lookup("siteUrl"));                                       // 12
  }), "_oauth/google"), "\n    "), "\n    ", HTML.Raw('<li>\n      Finish by clicking "Create Client ID".\n    </li>'), "\n  ") ];
}));                                                                                         // 14
                                                                                             // 15
///////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                           //
// packages/google/google_configure.js                                                       //
//                                                                                           //
///////////////////////////////////////////////////////////////////////////////////////////////
                                                                                             //
Template.configureLoginServiceDialogForGoogle.helpers({                                      // 1
  siteUrl: function () {                                                                     // 2
    return Meteor.absoluteUrl();                                                             // 3
  }                                                                                          // 4
});                                                                                          // 5
                                                                                             // 6
Template.configureLoginServiceDialogForGoogle.fields = function () {                         // 7
  return [                                                                                   // 8
    {property: 'clientId', label: 'Client ID'},                                              // 9
    {property: 'secret', label: 'Client secret'}                                             // 10
  ];                                                                                         // 11
};                                                                                           // 12
                                                                                             // 13
///////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                           //
// packages/google/google_client.js                                                          //
//                                                                                           //
///////////////////////////////////////////////////////////////////////////////////////////////
                                                                                             //
Google = {};                                                                                 // 1
                                                                                             // 2
// Request Google credentials for the user                                                   // 3
// @param options {optional}                                                                 // 4
// @param credentialRequestCompleteCallback {Function} Callback function to call on          // 5
//   completion. Takes one argument, credentialToken on success, or Error on                 // 6
//   error.                                                                                  // 7
Google.requestCredential = function (options, credentialRequestCompleteCallback) {           // 8
  // support both (options, callback) and (callback).                                        // 9
  if (!credentialRequestCompleteCallback && typeof options === 'function') {                 // 10
    credentialRequestCompleteCallback = options;                                             // 11
    options = {};                                                                            // 12
  } else if (!options) {                                                                     // 13
    options = {};                                                                            // 14
  }                                                                                          // 15
                                                                                             // 16
  var config = ServiceConfiguration.configurations.findOne({service: 'google'});             // 17
  if (!config) {                                                                             // 18
    credentialRequestCompleteCallback && credentialRequestCompleteCallback(                  // 19
      new ServiceConfiguration.ConfigError());                                               // 20
    return;                                                                                  // 21
  }                                                                                          // 22
                                                                                             // 23
  var credentialToken = Random.secret();                                                     // 24
                                                                                             // 25
  // always need this to get user id from google.                                            // 26
  var requiredScope = ['profile'];                                                           // 27
  var scope = ['email'];                                                                     // 28
  if (options.requestPermissions)                                                            // 29
    scope = options.requestPermissions;                                                      // 30
  scope = _.union(scope, requiredScope);                                                     // 31
                                                                                             // 32
  var loginUrlParameters = {};                                                               // 33
  if (config.loginUrlParameters){                                                            // 34
    _.extend(loginUrlParameters, config.loginUrlParameters)                                  // 35
  }                                                                                          // 36
  if (options.loginUrlParameters){                                                           // 37
    _.extend(loginUrlParameters, options.loginUrlParameters)                                 // 38
  }                                                                                          // 39
  var ILLEGAL_PARAMETERS = ['response_type', 'client_id', 'scope', 'redirect_uri', 'state'];
    // validate options keys                                                                 // 41
  _.each(_.keys(loginUrlParameters), function (key) {                                        // 42
    if (_.contains(ILLEGAL_PARAMETERS, key))                                                 // 43
      throw new Error("Google.requestCredential: Invalid loginUrlParameter: " + key);        // 44
  });                                                                                        // 45
                                                                                             // 46
  // backwards compatible options                                                            // 47
  if (options.requestOfflineToken != null){                                                  // 48
    loginUrlParameters.access_type = options.requestOfflineToken ? 'offline' : 'online'      // 49
  }                                                                                          // 50
  if (options.prompt != null) {                                                              // 51
    loginUrlParameters.prompt = options.prompt;                                              // 52
  } else if (options.forceApprovalPrompt) {                                                  // 53
    loginUrlParameters.prompt = 'consent'                                                    // 54
  }                                                                                          // 55
                                                                                             // 56
  if (options.loginHint) {                                                                   // 57
    loginUrlParameters.login_hint = options.loginHint;                                       // 58
  }                                                                                          // 59
                                                                                             // 60
  var loginStyle = OAuth._loginStyle('google', config, options);                             // 61
  // https://developers.google.com/accounts/docs/OAuth2WebServer#formingtheurl               // 62
  _.extend(loginUrlParameters, {                                                             // 63
    "response_type": "code",                                                                 // 64
    "client_id":  config.clientId,                                                           // 65
    "scope": scope.join(' '), // space delimited                                             // 66
    "redirect_uri": OAuth._redirectUri('google', config),                                    // 67
    "state": OAuth._stateParam(loginStyle, credentialToken, options.redirectUrl)             // 68
  });                                                                                        // 69
  var loginUrl = 'https://accounts.google.com/o/oauth2/auth?' +                              // 70
    _.map(loginUrlParameters, function(value, param){                                        // 71
      return encodeURIComponent(param) + '=' + encodeURIComponent(value);                    // 72
    }).join("&");                                                                            // 73
                                                                                             // 74
  OAuth.launchLogin({                                                                        // 75
    loginService: "google",                                                                  // 76
    loginStyle: loginStyle,                                                                  // 77
    loginUrl: loginUrl,                                                                      // 78
    credentialRequestCompleteCallback: credentialRequestCompleteCallback,                    // 79
    credentialToken: credentialToken,                                                        // 80
    popupOptions: { height: 600 }                                                            // 81
  });                                                                                        // 82
};                                                                                           // 83
                                                                                             // 84
///////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package.google = {}, {
  Google: Google
});

})();
