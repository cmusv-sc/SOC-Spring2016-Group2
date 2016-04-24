(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var Blaze = Package.blaze.Blaze;
var UI = Package.blaze.UI;
var Handlebars = Package.blaze.Handlebars;
var ReactiveVar = Package['reactive-var'].ReactiveVar;
var HTML = Package.htmljs.HTML;

/* Package-scope variables */
var MeteorCamera;

(function(){

///////////////////////////////////////////////////////////////////////
//                                                                   //
// packages/mdg_camera/photo.js                                      //
//                                                                   //
///////////////////////////////////////////////////////////////////////
                                                                     //
MeteorCamera = {};
///////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package['mdg:camera'] = {}, {
  MeteorCamera: MeteorCamera
});

})();
