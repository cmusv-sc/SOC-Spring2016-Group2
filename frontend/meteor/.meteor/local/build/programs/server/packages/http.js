(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var _ = Package.underscore._;
var URL = Package.url.URL;
var ECMAScript = Package.ecmascript.ECMAScript;
var meteorInstall = Package.modules.meteorInstall;
var Buffer = Package.modules.Buffer;
var process = Package.modules.process;
var Symbol = Package['ecmascript-runtime'].Symbol;
var Map = Package['ecmascript-runtime'].Map;
var Set = Package['ecmascript-runtime'].Set;
var meteorBabelHelpers = Package['babel-runtime'].meteorBabelHelpers;
var Promise = Package.promise.Promise;

/* Package-scope variables */
var makeErrorByStatus, populateData, HTTP, HTTPInternals;

var require = meteorInstall({"node_modules":{"meteor":{"http":{"httpcall_common.js":function(){

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                  //
// packages/http/httpcall_common.js                                                                                 //
//                                                                                                                  //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                    //
var MAX_LENGTH = 500; // if you change this, also change the appropriate test                                       // 1
                                                                                                                    //
makeErrorByStatus = function makeErrorByStatus(statusCode, content) {                                               // 3
  var message = 'failed [' + statusCode + ']';                                                                      // 4
                                                                                                                    //
  if (content) {                                                                                                    // 6
    var stringContent = typeof content == "string" ? content : content.toString();                                  // 7
                                                                                                                    //
    message += ' ' + truncate(stringContent.replace(/\n/g, ' '), MAX_LENGTH);                                       // 10
  }                                                                                                                 //
                                                                                                                    //
  return new Error(message);                                                                                        // 13
};                                                                                                                  //
                                                                                                                    //
function truncate(str, length) {                                                                                    // 16
  return str.length > length ? str.slice(0, length) + '...' : str;                                                  // 17
}                                                                                                                   //
                                                                                                                    //
// Fill in `response.data` if the content-type is JSON.                                                             //
populateData = function populateData(response) {                                                                    // 21
  // Read Content-Type header, up to a ';' if there is one.                                                         //
  // A typical header might be "application/json; charset=utf-8"                                                    //
  // or just "application/json".                                                                                    //
  var contentType = (response.headers['content-type'] || ';').split(';')[0];                                        // 25
                                                                                                                    //
  // Only try to parse data as JSON if server sets correct content type.                                            //
  if (_.include(['application/json', 'text/javascript', 'application/javascript', 'application/x-javascript'], contentType)) {
    try {                                                                                                           // 30
      response.data = JSON.parse(response.content);                                                                 // 31
    } catch (err) {                                                                                                 //
      response.data = null;                                                                                         // 33
    }                                                                                                               //
  } else {                                                                                                          //
    response.data = null;                                                                                           // 36
  }                                                                                                                 //
};                                                                                                                  //
                                                                                                                    //
HTTP = {};                                                                                                          // 40
                                                                                                                    //
/**                                                                                                                 //
 * @summary Send an HTTP `GET` request. Equivalent to calling [`HTTP.call`](#http_call) with "GET" as the first argument.
 * @param {String} url The URL to which the request should be sent.                                                 //
 * @param {Object} [callOptions] Options passed on to [`HTTP.call`](#http_call).                                    //
 * @param {Function} [asyncCallback] Callback that is called when the request is completed. Required on the client.
 * @locus Anywhere                                                                                                  //
 */                                                                                                                 //
HTTP.get = function () /* varargs */{                                                                               // 49
  return HTTP.call.apply(this, ["GET"].concat(_.toArray(arguments)));                                               // 50
};                                                                                                                  //
                                                                                                                    //
/**                                                                                                                 //
 * @summary Send an HTTP `POST` request. Equivalent to calling [`HTTP.call`](#http_call) with "POST" as the first argument.
 * @param {String} url The URL to which the request should be sent.                                                 //
 * @param {Object} [callOptions] Options passed on to [`HTTP.call`](#http_call).                                    //
 * @param {Function} [asyncCallback] Callback that is called when the request is completed. Required on the client.
 * @locus Anywhere                                                                                                  //
 */                                                                                                                 //
HTTP.post = function () /* varargs */{                                                                              // 60
  return HTTP.call.apply(this, ["POST"].concat(_.toArray(arguments)));                                              // 61
};                                                                                                                  //
                                                                                                                    //
/**                                                                                                                 //
 * @summary Send an HTTP `PUT` request. Equivalent to calling [`HTTP.call`](#http_call) with "PUT" as the first argument.
 * @param {String} url The URL to which the request should be sent.                                                 //
 * @param {Object} [callOptions] Options passed on to [`HTTP.call`](#http_call).                                    //
 * @param {Function} [asyncCallback] Callback that is called when the request is completed. Required on the client.
 * @locus Anywhere                                                                                                  //
 */                                                                                                                 //
HTTP.put = function () /* varargs */{                                                                               // 71
  return HTTP.call.apply(this, ["PUT"].concat(_.toArray(arguments)));                                               // 72
};                                                                                                                  //
                                                                                                                    //
/**                                                                                                                 //
 * @summary Send an HTTP `DELETE` request. Equivalent to calling [`HTTP.call`](#http_call) with "DELETE" as the first argument. (Named `del` to avoid conflict with the Javascript keyword `delete`)
 * @param {String} url The URL to which the request should be sent.                                                 //
 * @param {Object} [callOptions] Options passed on to [`HTTP.call`](#http_call).                                    //
 * @param {Function} [asyncCallback] Callback that is called when the request is completed. Required on the client.
 * @locus Anywhere                                                                                                  //
 */                                                                                                                 //
HTTP.del = function () /* varargs */{                                                                               // 82
  return HTTP.call.apply(this, ["DELETE"].concat(_.toArray(arguments)));                                            // 83
};                                                                                                                  //
                                                                                                                    //
/**                                                                                                                 //
 * @summary Send an HTTP `PATCH` request. Equivalent to calling [`HTTP.call`](#http_call) with "PATCH" as the first argument.
 * @param {String} url The URL to which the request should be sent.                                                 //
 * @param {Object} [callOptions] Options passed on to [`HTTP.call`](#http_call).                                    //
 * @param {Function} [asyncCallback] Callback that is called when the request is completed. Required on the client.
 * @locus Anywhere                                                                                                  //
 */                                                                                                                 //
HTTP.patch = function () /* varargs */{                                                                             // 93
  return HTTP.call.apply(this, ["PATCH"].concat(_.toArray(arguments)));                                             // 94
};                                                                                                                  //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"httpcall_server.js":function(require,exports,module){

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                  //
// packages/http/httpcall_server.js                                                                                 //
//                                                                                                                  //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                    //
var path = Npm.require('path');                                                                                     // 1
var request = Npm.require('request');                                                                               // 2
var url_util = Npm.require('url');                                                                                  // 3
                                                                                                                    //
HTTPInternals = {                                                                                                   // 5
  NpmModules: {                                                                                                     // 6
    request: {                                                                                                      // 7
      version: Npm.require('request/package.json').version,                                                         // 8
      module: request                                                                                               // 9
    }                                                                                                               //
  }                                                                                                                 //
};                                                                                                                  //
                                                                                                                    //
// _call always runs asynchronously; HTTP.call, defined below,                                                      //
// wraps _call and runs synchronously when no callback is provided.                                                 //
var _call = function _call(method, url, options, callback) {                                                        // 16
                                                                                                                    //
  ////////// Process arguments //////////                                                                           //
                                                                                                                    //
  if (!callback && typeof options === "function") {                                                                 // 20
    // support (method, url, callback) argument list                                                                //
    callback = options;                                                                                             // 22
    options = null;                                                                                                 // 23
  }                                                                                                                 //
                                                                                                                    //
  options = options || {};                                                                                          // 26
                                                                                                                    //
  if (_.has(options, 'beforeSend')) {                                                                               // 28
    throw new Error("Option beforeSend not supported on server.");                                                  // 29
  }                                                                                                                 //
                                                                                                                    //
  method = (method || "").toUpperCase();                                                                            // 32
                                                                                                                    //
  if (!/^https?:\/\//.test(url)) throw new Error("url must be absolute and start with http:// or https://");        // 34
                                                                                                                    //
  var headers = {};                                                                                                 // 37
                                                                                                                    //
  var content = options.content;                                                                                    // 39
  if (options.data) {                                                                                               // 40
    content = JSON.stringify(options.data);                                                                         // 41
    headers['Content-Type'] = 'application/json';                                                                   // 42
  }                                                                                                                 //
                                                                                                                    //
  var paramsForUrl, paramsForBody;                                                                                  // 46
  if (content || method === "GET" || method === "HEAD") paramsForUrl = options.params;else paramsForBody = options.params;
                                                                                                                    //
  var newUrl = URL._constructUrl(url, options.query, paramsForUrl);                                                 // 52
                                                                                                                    //
  if (options.auth) {                                                                                               // 54
    if (options.auth.indexOf(':') < 0) throw new Error('auth option should be of the form "username:password"');    // 55
    headers['Authorization'] = "Basic " + new Buffer(options.auth, "ascii").toString("base64");                     // 57
  }                                                                                                                 //
                                                                                                                    //
  if (paramsForBody) {                                                                                              // 61
    content = URL._encodeParams(paramsForBody);                                                                     // 62
    headers['Content-Type'] = "application/x-www-form-urlencoded";                                                  // 63
  }                                                                                                                 //
                                                                                                                    //
  _.extend(headers, options.headers || {});                                                                         // 66
                                                                                                                    //
  // wrap callback to add a 'response' property on an error, in case                                                //
  // we have both (http 4xx/5xx error, which has a response payload)                                                //
  callback = function (callback) {                                                                                  // 16
    return function (error, response) {                                                                             // 71
      if (error && response) error.response = response;                                                             // 72
      callback(error, response);                                                                                    // 74
    };                                                                                                              //
  }(callback);                                                                                                      //
                                                                                                                    //
  // safety belt: only call the callback once.                                                                      //
  callback = _.once(callback);                                                                                      // 16
                                                                                                                    //
  ////////// Kickoff! //////////                                                                                    //
                                                                                                                    //
  // Allow users to override any request option with the npmRequestOptions                                          //
  // option.                                                                                                        //
  var reqOptions = _.extend({                                                                                       // 16
    url: newUrl,                                                                                                    // 87
    method: method,                                                                                                 // 88
    encoding: "utf8",                                                                                               // 89
    jar: false,                                                                                                     // 90
    timeout: options.timeout,                                                                                       // 91
    body: content,                                                                                                  // 92
    followRedirect: options.followRedirects,                                                                        // 93
    // Follow redirects on non-GET requests                                                                         //
    // also. (https://github.com/meteor/meteor/issues/2808)                                                         //
    followAllRedirects: options.followRedirects,                                                                    // 96
    headers: headers                                                                                                // 97
  }, options.npmRequestOptions || {});                                                                              //
                                                                                                                    //
  request(reqOptions, function (error, res, body) {                                                                 // 100
    var response = null;                                                                                            // 101
                                                                                                                    //
    if (!error) {                                                                                                   // 103
                                                                                                                    //
      response = {};                                                                                                // 105
      response.statusCode = res.statusCode;                                                                         // 106
      response.content = body;                                                                                      // 107
      response.headers = res.headers;                                                                               // 108
                                                                                                                    //
      populateData(response);                                                                                       // 110
                                                                                                                    //
      if (response.statusCode >= 400) error = makeErrorByStatus(response.statusCode, response.content);             // 112
    }                                                                                                               //
                                                                                                                    //
    callback(error, response);                                                                                      // 116
  });                                                                                                               //
};                                                                                                                  //
                                                                                                                    //
HTTP.call = Meteor.wrapAsync(_call);                                                                                // 121
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"deprecated.js":function(){

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                  //
// packages/http/deprecated.js                                                                                      //
//                                                                                                                  //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                    //
// The HTTP object used to be called Meteor.http.                                                                   //
// XXX COMPAT WITH 0.6.4                                                                                            //
Meteor.http = HTTP;                                                                                                 // 3
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}}}}},{"extensions":[".js",".json"]});
require("./node_modules/meteor/http/httpcall_common.js");
require("./node_modules/meteor/http/httpcall_server.js");
require("./node_modules/meteor/http/deprecated.js");

/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package.http = {}, {
  HTTP: HTTP,
  HTTPInternals: HTTPInternals
});

})();

//# sourceMappingURL=http.js.map
