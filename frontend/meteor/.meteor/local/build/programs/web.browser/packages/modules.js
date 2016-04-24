(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var _ = Package.underscore._;
var meteorInstall = Package['modules-runtime'].meteorInstall;

/* Package-scope variables */
var Buffer, process;

var require = meteorInstall({"node_modules":{"meteor":{"modules":{"client.js":["./stubs.js","./buffer.js","./process.js","./css",function(require,exports){

////////////////////////////////////////////////////////////////////////////
//                                                                        //
// packages/modules/client.js                                             //
//                                                                        //
////////////////////////////////////////////////////////////////////////////
                                                                          //
require("./stubs.js");                                                    // 1
require("./buffer.js");                                                   // 2
require("./process.js");                                                  // 3
                                                                          // 4
exports.addStyles = require("./css").addStyles;                           // 5
                                                                          // 6
////////////////////////////////////////////////////////////////////////////

}],"buffer.js":["buffer",function(require){

////////////////////////////////////////////////////////////////////////////
//                                                                        //
// packages/modules/buffer.js                                             //
//                                                                        //
////////////////////////////////////////////////////////////////////////////
                                                                          //
try {                                                                     // 1
  Buffer = global.Buffer || require("buffer").Buffer;                     // 2
} catch (noBuffer) {}                                                     // 3
                                                                          // 4
////////////////////////////////////////////////////////////////////////////

}],"css.js":function(require,exports){

////////////////////////////////////////////////////////////////////////////
//                                                                        //
// packages/modules/css.js                                                //
//                                                                        //
////////////////////////////////////////////////////////////////////////////
                                                                          //
var doc = document;                                                       // 1
var head = doc.getElementsByTagName("head").item(0);                      // 2
                                                                          // 3
exports.addStyles = function (css) {                                      // 4
  var style = doc.createElement("style");                                 // 5
                                                                          // 6
  style.setAttribute("type", "text/css");                                 // 7
                                                                          // 8
  // https://msdn.microsoft.com/en-us/library/ms535871(v=vs.85).aspx      // 9
  var internetExplorerSheetObject =                                       // 10
    style.sheet || // Edge/IE11.                                          // 11
    style.styleSheet; // Older IEs.                                       // 12
                                                                          // 13
  if (internetExplorerSheetObject) {                                      // 14
    internetExplorerSheetObject.cssText = css;                            // 15
  } else {                                                                // 16
    style.appendChild(doc.createTextNode(css));                           // 17
  }                                                                       // 18
                                                                          // 19
  return head.appendChild(style);                                         // 20
};                                                                        // 21
                                                                          // 22
////////////////////////////////////////////////////////////////////////////

},"process.js":["process",function(require,exports,module){

////////////////////////////////////////////////////////////////////////////
//                                                                        //
// packages/modules/process.js                                            //
//                                                                        //
////////////////////////////////////////////////////////////////////////////
                                                                          //
try {                                                                     // 1
  // The application can run `npm install process` to provide its own     // 2
  // process stub; otherwise this module will provide a partial stub.     // 3
  process = global.process || require("process");                         // 4
} catch (noProcess) {                                                     // 5
  process = {};                                                           // 6
}                                                                         // 7
                                                                          // 8
if (Meteor.isServer) {                                                    // 9
  // Make require("process") work on the server in all versions of Node.  // 10
  meteorInstall({                                                         // 11
    node_modules: {                                                       // 12
      "process.js": function (r, e, module) {                             // 13
        module.exports = process;                                         // 14
      }                                                                   // 15
    }                                                                     // 16
  });                                                                     // 17
} else {                                                                  // 18
  process.platform = "browser";                                           // 19
  process.nextTick = process.nextTick || Meteor._setImmediate;            // 20
}                                                                         // 21
                                                                          // 22
if (typeof process.env !== "object") {                                    // 23
  process.env = {};                                                       // 24
}                                                                         // 25
                                                                          // 26
_.extend(process.env, meteorEnv);                                         // 27
                                                                          // 28
////////////////////////////////////////////////////////////////////////////

}],"stubs.js":["meteor-node-stubs",function(require){

////////////////////////////////////////////////////////////////////////////
//                                                                        //
// packages/modules/stubs.js                                              //
//                                                                        //
////////////////////////////////////////////////////////////////////////////
                                                                          //
try {                                                                     // 1
  // When meteor-node-stubs is installed in the application's root        // 2
  // node_modules directory, requiring it here installs aliases for stubs
  // for all Node built-in modules, such as fs, util, and http.           // 4
  require("meteor-node-stubs");                                           // 5
} catch (noStubs) {}                                                      // 6
                                                                          // 7
////////////////////////////////////////////////////////////////////////////

}]}}}},{"extensions":[".js",".json"]});
var exports = require("./node_modules/meteor/modules/client.js");

/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package.modules = exports, {
  meteorInstall: meteorInstall,
  Buffer: Buffer,
  process: process
});

})();
