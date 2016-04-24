(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var HTTP = Package.http.HTTP;
var Template = Package.templating.Template;
var OAuth = Package.oauth.OAuth;
var Oauth = Package.oauth.Oauth;
var Random = Package.random.Random;
var ServiceConfiguration = Package['service-configuration'].ServiceConfiguration;
var Blaze = Package.blaze.Blaze;
var UI = Package.blaze.UI;
var Handlebars = Package.blaze.Handlebars;
var Spacebars = Package.spacebars.Spacebars;
var HTML = Package.htmljs.HTML;

/* Package-scope variables */
var Twitter;

(function(){

////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                    //
// packages/twitter/template.twitter_configure.js                                                     //
//                                                                                                    //
////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                      //
                                                                                                      // 1
Template.__checkName("configureLoginServiceDialogForTwitter");                                        // 2
Template["configureLoginServiceDialogForTwitter"] = new Template("Template.configureLoginServiceDialogForTwitter", (function() {
  var view = this;                                                                                    // 4
  return [ HTML.Raw("<p>\n    First, you'll need to register your app on Twitter. Follow these steps:\n  </p>\n  "), HTML.OL("\n    ", HTML.Raw('<li>\n      Visit <a href="https://dev.twitter.com/apps/new" target="_blank">https://dev.twitter.com/apps/new</a>\n    </li>'), "\n    ", HTML.LI("\n      Set Website to: ", HTML.SPAN({
    "class": "url"                                                                                    // 6
  }, Blaze.View("lookup:siteUrl", function() {                                                        // 7
    return Spacebars.mustache(view.lookup("siteUrl"));                                                // 8
  })), "\n    "), "\n    ", HTML.LI("\n      Set Callback URL to: ", HTML.SPAN({                      // 9
    "class": "url"                                                                                    // 10
  }, Blaze.View("lookup:siteUrl", function() {                                                        // 11
    return Spacebars.mustache(view.lookup("siteUrl"));                                                // 12
  }), "_oauth/twitter"), "\n    "), "\n    ", HTML.Raw('<li>\n      Select "Create your Twitter application".\n    </li>'), "\n    ", HTML.Raw('<li>\n      On the Settings tab, enable "Allow this application to be used to Sign in with Twitter" and click\n      "Update settings".\n    </li>'), "\n    ", HTML.Raw('<li>\n      Switch to the "Keys and Access Tokens" tab.\n    </li>'), "\n  ") ];
}));                                                                                                  // 14
                                                                                                      // 15
////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                    //
// packages/twitter/twitter_configure.js                                                              //
//                                                                                                    //
////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                      //
Template.configureLoginServiceDialogForTwitter.helpers({                                              // 1
  siteUrl: function () {                                                                              // 2
  // Twitter doesn't recognize localhost as a domain name                                             // 3
    return Meteor.absoluteUrl({replaceLocalhost: true});                                              // 4
  }                                                                                                   // 5
});                                                                                                   // 6
                                                                                                      // 7
Template.configureLoginServiceDialogForTwitter.fields = function () {                                 // 8
  return [                                                                                            // 9
    {property: 'consumerKey', label: 'API key'},                                                      // 10
    {property: 'secret', label: 'API secret'}                                                         // 11
  ];                                                                                                  // 12
};                                                                                                    // 13
                                                                                                      // 14
////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                    //
// packages/twitter/twitter_client.js                                                                 //
//                                                                                                    //
////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                      //
Twitter = {};                                                                                         // 1
                                                                                                      // 2
// Request Twitter credentials for the user                                                           // 3
// @param options {optional}  XXX support options.requestPermissions                                  // 4
// @param credentialRequestCompleteCallback {Function} Callback function to call on                   // 5
//   completion. Takes one argument, credentialToken on success, or Error on                          // 6
//   error.                                                                                           // 7
Twitter.requestCredential = function (options, credentialRequestCompleteCallback) {                   // 8
  // support both (options, callback) and (callback).                                                 // 9
  if (!credentialRequestCompleteCallback && typeof options === 'function') {                          // 10
    credentialRequestCompleteCallback = options;                                                      // 11
    options = {};                                                                                     // 12
  }                                                                                                   // 13
                                                                                                      // 14
  var config = ServiceConfiguration.configurations.findOne({service: 'twitter'});                     // 15
  if (!config) {                                                                                      // 16
    credentialRequestCompleteCallback && credentialRequestCompleteCallback(                           // 17
      new ServiceConfiguration.ConfigError());                                                        // 18
    return;                                                                                           // 19
  }                                                                                                   // 20
                                                                                                      // 21
  var credentialToken = Random.secret();                                                              // 22
  // We need to keep credentialToken across the next two 'steps' so we're adding                      // 23
  // a credentialToken parameter to the url and the callback url that we'll be returned               // 24
  // to by oauth provider                                                                             // 25
                                                                                                      // 26
  var loginStyle = OAuth._loginStyle('twitter', config, options);                                     // 27
                                                                                                      // 28
  // url to app, enters "step 1" as described in                                                      // 29
  // packages/accounts-oauth1-helper/oauth1_server.js                                                 // 30
  var loginPath = '_oauth/twitter/?requestTokenAndRedirect=true'                                      // 31
        + '&state=' + OAuth._stateParam(loginStyle, credentialToken, options && options.redirectUrl);
                                                                                                      // 33
  if (Meteor.isCordova) {                                                                             // 34
    loginPath = loginPath + "&cordova=true";                                                          // 35
    if (/Android/i.test(navigator.userAgent)) {                                                       // 36
      loginPath = loginPath + "&android=true";                                                        // 37
    }                                                                                                 // 38
  }                                                                                                   // 39
                                                                                                      // 40
  var loginUrl = Meteor.absoluteUrl(loginPath);                                                       // 41
                                                                                                      // 42
  OAuth.launchLogin({                                                                                 // 43
    loginService: "twitter",                                                                          // 44
    loginStyle: loginStyle,                                                                           // 45
    loginUrl: loginUrl,                                                                               // 46
    credentialRequestCompleteCallback: credentialRequestCompleteCallback,                             // 47
    credentialToken: credentialToken                                                                  // 48
  });                                                                                                 // 49
};                                                                                                    // 50
                                                                                                      // 51
////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package.twitter = {}, {
  Twitter: Twitter
});

})();
