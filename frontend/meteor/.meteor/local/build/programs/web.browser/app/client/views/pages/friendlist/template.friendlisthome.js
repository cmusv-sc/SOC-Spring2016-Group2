(function(){
Template.__checkName("friendlisthome");
Template["friendlisthome"] = new Template("Template.friendlisthome", (function() {
  var view = this;
  return HTML.DIV({
    "class": "wrapper wrapper-content animated fadeInRight"
  }, "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "container"
  }, "\n              ", HTML.HEADER("\n                ", HTML.Raw('<h1>\n                Friend List\n                <button class="btn btn-primary button" onclick="window.location.href=\'/addFriend\'">Find More Friends\n                </button> \n                </h1>'), "\n                ", HTML.Raw('<p>\n                  <b>Summary:</b>\n                  <input type="text" class="update_summary">\n\n                  <button class="button">\n                  Update\n                  </button> \n                </p>'), "\n                ", Spacebars.include(view.lookupTemplate("request")), " \n              "), "\n              ", HTML.UL("\n              ", Blaze._TemplateWith(function() {
    return {
      settings: Spacebars.call(view.lookup("settings"))
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("reactiveTable"));
  }), "\n              "), "\n            "), "\n        "), "\n    ");
}));

Template.__checkName("viewFriendInfo");
Template["viewFriendInfo"] = new Template("Template.viewFriendInfo", (function() {
  var view = this;
  return HTML.BODY("\n    ", HTML.DIV({
    "class": "container"
  }, "\n      ", HTML.Raw('<header>\n        <h1>Friend Info\n      <button class="btn-xs btn-xs button" onclick="window.location.href=\'/friendlisthome\'">Back\n      </button>\n      </h1>\n      </header>'), "\n      ", HTML.UL("\n            ", Blaze._TemplateWith(function() {
    return Spacebars.call(view.lookup("context"));
  }, function() {
    return Spacebars.include(view.lookupTemplate("person"));
  }), "\n\n      "), "\n      ", HTML.Raw('<button class="button2">Unfriend</button>'), "\n    "), "\n  ");
}));

Template.__checkName("request");
Template["request"] = new Template("Template.request", (function() {
  var view = this;
  return [ Blaze._TemplateWith(function() {
    return {
      settings: Spacebars.call(view.lookup("settings"))
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("reactiveTable"));
  }), HTML.Raw('\n        <button id="accept" class="button3">Accept</button>\n        <button id="decline" class="button3">Decline</button>\n        <button id="ignore" class="button3">Ignore</button>') ];
}));

Template.__checkName("viewRequestInfo");
Template["viewRequestInfo"] = new Template("Template.viewRequestInfo", (function() {
  var view = this;
  return HTML.BODY("\n    ", HTML.DIV({
    "class": "container"
  }, "\n      ", HTML.Raw('<header>\n        <h1>Request Info\n      <button class="btn-xs btn-xs button" onclick="window.location.href=\'/friendlisthome\'">Back\n      </button>\n      </h1>\n      </header>'), "\n      ", HTML.UL("\n            ", Blaze._TemplateWith(function() {
    return Spacebars.call(view.lookup("context"));
  }, function() {
    return Spacebars.include(view.lookupTemplate("person"));
  }), "\n      "), "\n    "), "\n  ");
}));

}).call(this);
