(function(){
Template.__checkName("addFriend");
Template["addFriend"] = new Template("Template.addFriend", (function() {
  var view = this;
  return HTML.DIV({
    "class": "wrapper wrapper-content animated fadeInRight"
  }, "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "container"
  }, "\n              ", HTML.Raw('<header>\n\n              <h1>Add Friends\n              <button class="btn-xs btn-xs button" onclick="window.location.href=\'/friendlisthome\'">Back\n              </button>\n              </h1>\n              </header>'), "\n                  ", Spacebars.include(view.lookupTemplate("searchFriend")), "\n              ", HTML.UL("\n                ", Blaze._TemplateWith(function() {
    return {
      collection: Spacebars.call(view.lookup("myCollection")),
      settings: Spacebars.call(view.lookup("settings"))
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("reactiveTable"));
  }), "\n              "), "\n            "), "\n        "), "\n    ");
}));

Template.__checkName("searchFriend");
Template["searchFriend"] = new Template("Template.searchFriend", (function() {
  var view = this;
  return HTML.Raw('<input type="text" class="search_box">\n        <button id="search_botton" class="btn-primary btn-xs"> Search\n        </button>');
}));

Template.__checkName("addFriendInfo");
Template["addFriendInfo"] = new Template("Template.addFriendInfo", (function() {
  var view = this;
  return HTML.DIV({
    "class": "wrapper wrapper-content animated fadeInRight"
  }, "\n    ", HTML.DIV({
    "class": "row"
  }, "\n      ", HTML.DIV({
    "class": "container"
  }, "\n        ", HTML.Raw('<header>\n\n          <h1>User Info\n        <button class="btn-xs btn-xs button" onclick="window.location.href=\'/addFriend\'">Back\n        </button>\n        </h1>\n        </header>'), "\n\n        ", HTML.UL("\n              ", Blaze._TemplateWith(function() {
    return Spacebars.call(view.lookup("context"));
  }, function() {
    return Spacebars.include(view.lookupTemplate("person"));
  }), "\n        "), " \n        ", HTML.Raw('<button class="button2">Send Request</button>'), "\n      "), "\n    "), "\n  ");
}));

Template.__checkName("person");
Template["person"] = new Template("Template.person", (function() {
  var view = this;
  return [ HTML.H2("Name: ", Blaze.View("lookup:name", function() {
    return Spacebars.mustache(view.lookup("name"));
  })), HTML.Raw("\n  <h2>Summary:</h2>\n  "), HTML.TEXTAREA({
    "class": "textarea",
    value: function() {
      return Spacebars.mustache(view.lookup("summary"));
    }
  }) ];
}));

}).call(this);
