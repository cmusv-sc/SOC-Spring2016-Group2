(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var Promise = Package.promise.Promise;
var ReactiveDict = Package['reactive-dict'].ReactiveDict;
var Reload = Package.reload.Reload;

/* Package-scope variables */
var hcp, HotCodePush, RouterAutoscroll;

(function(){

//////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                              //
// packages/okgrow_router-autoscroll/client/hot-code-push.js                                    //
//                                                                                              //
//////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                //
//named reactive-dict are persisted across hot code push                                        // 1
hcp = new ReactiveDict("okgrow-hot-code-push");                                                 // 2
                                                                                                // 3
var fakeStartPromise = {                                                                        // 4
  'then': function (actionFn) {                                                                 // 5
    //debug("scheduled begin and end hook")                                                     // 6
    hcp.set("has-hcp-hook", true);                                                              // 7
    Reload._onMigrate(function () {                                                             // 8
      try {                                                                                     // 9
        actionFn()                                                                              // 10
      } catch(ex) {;}                                                                           // 11
      return [true];                                                                            // 12
    });                                                                                         // 13
    return fakeStartPromise;                                                                    // 14
  }                                                                                             // 15
};                                                                                              // 16
                                                                                                // 17
HotCodePush = {                                                                                 // 18
  start: fakeStartPromise,                                                                      // 19
  end: new Promise(function (resolve) {                                                         // 20
    hcp.set("has-hcp-hook", true);                                                              // 21
    window.addEventListener("load", function () {                                               // 22
      //debug("detected window load")                                                           // 23
      if( hcp.get("has-hcp-hook") ){                                                            // 24
        //debug("HotCodePush.end promise resolving");                                           // 25
        hcp.set("has-hcp-hook", undefined);                                                     // 26
        resolve(true);                                                                          // 27
      }                                                                                         // 28
    });                                                                                         // 29
  })                                                                                            // 30
};                                                                                              // 31
                                                                                                // 32
function debug(msg) {                                                                           // 33
  console.info(msg);                                                                            // 34
}                                                                                               // 35
                                                                                                // 36
//////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

//////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                              //
// packages/okgrow_router-autoscroll/client/router-autoscroll.js                                //
//                                                                                              //
//////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                //
RouterAutoscroll = {                                                                            // 1
  animationDuration: 200,                                                                       // 2
  marginTop: 0                                                                                  // 3
};                                                                                              // 4
                                                                                                // 5
var backToPosition;                                                                             // 6
// Saved positions will survive a hot code push                                                 // 7
var scrollPositions = new ReactiveDict("okgrow-router-autoscroll");                             // 8
                                                                                                // 9
// local variable for accessing jquery, if available                                            // 10
var _jQuery = false;                                                                            // 11
                                                                                                // 12
if (Package["jquery"]) {                                                                        // 13
  _jQuery = Package["jquery"].jQuery;                                                           // 14
}                                                                                               // 15
                                                                                                // 16
function saveScrollPosition () {                                                                // 17
  scrollPositions.set(window.location.href, scrollTop());                                       // 18
};                                                                                              // 19
                                                                                                // 20
//TODO use history state so we don't litter                                                     // 21
window.onpopstate = function () {                                                               // 22
  backToPosition = scrollPositions.get(window.location.href);                                   // 23
};                                                                                              // 24
                                                                                                // 25
// Scroll to the right place after changing routes. "The right place" is:                       // 26
// 1. The previous position if we're returning via the back button                              // 27
// 2. The element whose id is specified in the URL hash                                         // 28
// 3. The top of page otherwise                                                                 // 29
function getScrollToPosition () {                                                               // 30
  if (backToPosition) {                                                                         // 31
    var oldPosition = backToPosition;                                                           // 32
    backToPosition = undefined;                                                                 // 33
    return oldPosition;                                                                         // 34
  }                                                                                             // 35
                                                                                                // 36
  var id = window.location.hash.replace("#", '');                                               // 37
  var element;                                                                                  // 38
                                                                                                // 39
  // check if maintainScroll=1 exists                                                           // 40
  if (id.indexOf('maintainScroll=1') > -1) {                                                    // 41
    return undefined;                                                                           // 42
  }                                                                                             // 43
                                                                                                // 44
  //HTML5 allows all kinds of ids, so we can't whitelist characters, only                       // 45
  //decide the hash doesn't represent a DOM id if we fail                                       // 46
  try {                                                                                         // 47
    element = document.getElementById(id);                                                      // 48
  } catch (ex) {                                                                                // 49
    element = false;                                                                            // 50
  }                                                                                             // 51
  if (element) {                                                                                // 52
    return element.getBoundingClientRect().top + scrollTop();                                   // 53
  }                                                                                             // 54
                                                                                                // 55
  return 0;                                                                                     // 56
}                                                                                               // 57
                                                                                                // 58
//Do the scroll, after the DOM update so that the position can be correct                       // 59
var scheduleScroll = function () {                                                              // 60
  Tracker.afterFlush(function () {                                                              // 61
    Meteor.defer(function () {                                                                  // 62
      var position = getScrollToPosition();                                                     // 63
      scrollTo(position);                                                                       // 64
    });                                                                                         // 65
  });                                                                                           // 66
};                                                                                              // 67
                                                                                                // 68
var flowScroll = function (newRoute) {                                                          // 69
  var path = (newRoute.context && newRoute.context.pathname) || newRoute.path;                  // 70
  if (path.indexOf("#") == -1)                                                                  // 71
    scrollTo(0);                                                                                // 72
  else                                                                                          // 73
    scheduleScroll();                                                                           // 74
};                                                                                              // 75
                                                                                                // 76
function ironWhenReady (callFn) {                                                               // 77
  return function () {                                                                          // 78
    var self = this;                                                                            // 79
    self.next();                                                                                // 80
    // XXX in iron, why do we abort if not ready, shouldn't we try once ready?                  // 81
    if (self.ready()) callFn();                                                                 // 82
  }                                                                                             // 83
}                                                                                               // 84
                                                                                                // 85
// use _jQuery if available, otherwise support IE9+                                             // 86
var scrollTop = function () {                                                                   // 87
  if (_jQuery) {                                                                                // 88
    return _jQuery(window).scrollTop();                                                         // 89
  } else {                                                                                      // 90
    // uses solution from http://stackoverflow.com/questions/871399/cross-browser-method-for-detecting-the-scrolltop-of-the-browser-window
    return document.body.scrollTop || document.documentElement.scrollTop || window.pageYOffset;
  }                                                                                             // 93
}                                                                                               // 94
                                                                                                // 95
var scrollTo = function (position) {                                                            // 96
  if (_jQuery) {                                                                                // 97
    _jQuery('body,html').animate({                                                              // 98
      scrollTop: position - RouterAutoscroll.marginTop                                          // 99
    }, RouterAutoscroll.animationDuration);                                                     // 100
  } else {                                                                                      // 101
    window.scroll(0, position - RouterAutoscroll.marginTop);                                    // 102
  }                                                                                             // 103
}                                                                                               // 104
                                                                                                // 105
if (Package['iron:router']) {                                                                   // 106
  Package['iron:router'].Router.onRun(ironWhenReady(scheduleScroll));                           // 107
  Package['iron:router'].Router.onStop(saveScrollPosition);                                     // 108
}                                                                                               // 109
                                                                                                // 110
if (Package["kadira:flow-router"]) {                                                            // 111
  Package["kadira:flow-router"].FlowRouter.triggers.enter([flowScroll]);                        // 112
  Package["kadira:flow-router"].FlowRouter.triggers.exit([saveScrollPosition]);                 // 113
}                                                                                               // 114
                                                                                                // 115
if (Package["kadira:flow-router-ssr"]) {                                                        // 116
  Package["kadira:flow-router-ssr"].FlowRouter.triggers.enter([flowScroll]);                    // 117
  Package["kadira:flow-router-ssr"].FlowRouter.triggers.exit([saveScrollPosition]);             // 118
}                                                                                               // 119
                                                                                                // 120
if (Package["meteorhacks:flow-router"]) {                                                       // 121
  Package["meteorhacks:flow-router"].FlowRouter.triggers.enter([flowScroll]);                   // 122
  Package["meteorhacks:flow-router"].FlowRouter.triggers.exit([saveScrollPosition]);            // 123
}                                                                                               // 124
                                                                                                // 125
if (Package["meteorhacks:flow-router-ssr"]) {                                                   // 126
  Package["meteorhacks:flow-router-ssr"].FlowRouter.triggers.enter([flowScroll]);               // 127
  Package["meteorhacks:flow-router-ssr"].FlowRouter.triggers.exit([saveScrollPosition]);        // 128
}                                                                                               // 129
                                                                                                // 130
HotCodePush.start.then(function () {                                                            // 131
  var currentScroll = scrollTop();                                                              // 132
  scrollPositions.set("HotCodePushScrollPosition", currentScroll);                              // 133
});                                                                                             // 134
                                                                                                // 135
HotCodePush.end.then(function () {                                                              // 136
  backToPosition = scrollPositions.get("HotCodePushScrollPosition");                            // 137
  if (backToPosition) {                                                                         // 138
    scheduleScroll();                                                                           // 139
  }                                                                                             // 140
});                                                                                             // 141
                                                                                                // 142
RouterAutoscroll.scrollPositions = scrollPositions;                                             // 143
                                                                                                // 144
//////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package['okgrow:router-autoscroll'] = {}, {
  RouterAutoscroll: RouterAutoscroll
});

})();
