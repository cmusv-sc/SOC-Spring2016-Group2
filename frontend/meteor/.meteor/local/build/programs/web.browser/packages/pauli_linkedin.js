(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var OAuth = Package.oauth.OAuth;
var Oauth = Package.oauth.Oauth;
var Template = Package.templating.Template;
var Random = Package.random.Random;
var ServiceConfiguration = Package['service-configuration'].ServiceConfiguration;
var Blaze = Package.blaze.Blaze;
var UI = Package.blaze.UI;
var Handlebars = Package.blaze.Handlebars;
var Spacebars = Package.spacebars.Spacebars;
var HTML = Package.htmljs.HTML;

/* Package-scope variables */
var LinkedIn;

(function(){

///////////////////////////////////////////////////////////////////////////////////////
//                                                                                   //
// packages/pauli_linkedin/template.linkedin_configure.js                            //
//                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////
                                                                                     //
                                                                                     // 1
Template.__checkName("configureLoginServiceDialogForLinkedin");                      // 2
Template["configureLoginServiceDialogForLinkedin"] = new Template("Template.configureLoginServiceDialogForLinkedin", (function() {
  var view = this;                                                                   // 4
  return HTML.Raw('<p>\n    First, you\'ll need to register your app on Linkedin. Follow these steps:\n  </p>\n  <ol>\n    <li>\n      Visit <a href="https://www.linkedin.com/secure/developer?newapp=" target="_blank">https://www.linkedin.com/secure/developer?newapp=</a>\n    </li>\n  </ol>');
}));                                                                                 // 6
                                                                                     // 7
///////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////
//                                                                                   //
// packages/pauli_linkedin/linkedin_configure.js                                     //
//                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////
                                                                                     //
Template.configureLoginServiceDialogForLinkedin.siteUrl = function () {              // 1
  return Meteor.absoluteUrl();                                                       // 2
};                                                                                   // 3
                                                                                     // 4
Template.configureLoginServiceDialogForLinkedin.fields = function () {               // 5
  return [                                                                           // 6
    {property: 'clientId', label: 'API Key'},                                        // 7
    {property: 'secret', label: 'Secret Key'}                                        // 8
  ];                                                                                 // 9
};                                                                                   // 10
                                                                                     // 11
///////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////
//                                                                                   //
// packages/pauli_linkedin/linkedin_common.js                                        //
//                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////
                                                                                     //
if (typeof LinkedIn === 'undefined') {                                               // 1
  LinkedIn = {};                                                                     // 2
}                                                                                    // 3
                                                                                     // 4
///////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////
//                                                                                   //
// packages/pauli_linkedin/linkedin_client.js                                        //
//                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////
                                                                                     //
// Request LinkedIn credentials for the user                                         // 1
// @param options {optional}                                                         // 2
// @param credentialRequestCompleteCallback {Function} Callback function to call on  // 3
//   completion. Takes one argument, credentialToken on success, or Error on         // 4
//   error.                                                                          // 5
LinkedIn.requestCredential = function (options, credentialRequestCompleteCallback) {
  // support both (options, callback) and (callback).                                // 7
  if (!credentialRequestCompleteCallback && typeof options === 'function') {         // 8
    credentialRequestCompleteCallback = options;                                     // 9
    options = {};                                                                    // 10
  }                                                                                  // 11
                                                                                     // 12
  var config = ServiceConfiguration.configurations.findOne({service: 'linkedin'});   // 13
  if (!config) {                                                                     // 14
    credentialRequestCompleteCallback && credentialRequestCompleteCallback(new ServiceConfiguration.ConfigError("Service not configured"));
    return;                                                                          // 16
  }                                                                                  // 17
                                                                                     // 18
  var credentialToken = Random.secret();                                             // 19
  var loginStyle = OAuth._loginStyle('linkedin', config, options);                   // 20
                                                                                     // 21
  var scope = [];                                                                    // 22
  if (options && options.requestPermissions) {                                       // 23
      scope = options.requestPermissions.join('+');                                  // 24
  }                                                                                  // 25
                                                                                     // 26
  var loginStyle = OAuth._loginStyle('linkedin', config, options);                   // 27
                                                                                     // 28
  var loginUrl =                                                                     // 29
        'https://www.linkedin.com/uas/oauth2/authorization' +                        // 30
        '?response_type=code' + '&client_id=' + config.clientId +                    // 31
        '&redirect_uri=' + OAuth._redirectUri('linkedin', config) +                  // 32
        '&scope=' + scope +                                                          // 33
        '&state=' + OAuth._stateParam(loginStyle, credentialToken);                  // 34
                                                                                     // 35
  OAuth.launchLogin({                                                                // 36
    loginService: "linkedin",                                                        // 37
    loginStyle: loginStyle,                                                          // 38
    loginUrl: loginUrl,                                                              // 39
    credentialRequestCompleteCallback: credentialRequestCompleteCallback,            // 40
    credentialToken: credentialToken                                                 // 41
  });                                                                                // 42
};                                                                                   // 43
                                                                                     // 44
///////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package['pauli:linkedin'] = {}, {
  LinkedIn: LinkedIn
});

})();
