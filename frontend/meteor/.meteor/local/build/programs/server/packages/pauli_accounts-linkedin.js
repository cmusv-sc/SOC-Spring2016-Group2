(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var Accounts = Package['accounts-base'].Accounts;
var LinkedIn = Package['pauli:linkedin'].LinkedIn;

(function(){

/////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                         //
// packages/pauli_accounts-linkedin/linkedin_common.js                                     //
//                                                                                         //
/////////////////////////////////////////////////////////////////////////////////////////////
                                                                                           //
// v0.6.5
Accounts.oauth.registerService('linkedin');

if (!Accounts.linkedin) {
  Accounts.linkedin = {};
}

/////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                         //
// packages/pauli_accounts-linkedin/linkedin_server.js                                     //
//                                                                                         //
/////////////////////////////////////////////////////////////////////////////////////////////
                                                                                           //
// v0.6.5
// Accounts.oauth.registerService('linkedin');

Accounts.addAutopublishFields({
  // publish all fields including access token, which can legitimately
  // be used from the client (if transmitted over ssl or on
  // localhost). https://developer.linkedin.com/documents/authentication
  forLoggedInUser: ['services.linkedin'],
  // forOtherUsers: [
  //   'services.linkedin.id', 'services.linkedin.firstName', 'services.linkedin.lastName'
  // ]
});

/////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
Package['pauli:accounts-linkedin'] = {};

})();
