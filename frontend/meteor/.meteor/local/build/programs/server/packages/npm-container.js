(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;

(function(){

/////////////////////////////////////////////////////////////////////////////////////////
//                                                                                     //
// packages/npm-container/index.js                                                     //
//                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////
                                                                                       //
Meteor.npmRequire = function(moduleName) {
  var module = Npm.require(moduleName);
  return module;
};

Meteor.require = function(moduleName) {
  console.warn('Meteor.require is deprecated. Please use Meteor.npmRequire instead!');
  return Meteor.npmRequire(moduleName);
};
/////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
Package['npm-container'] = {};

})();
