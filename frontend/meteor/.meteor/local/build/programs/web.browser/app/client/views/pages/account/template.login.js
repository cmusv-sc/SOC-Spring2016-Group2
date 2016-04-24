(function(){
Template.__checkName("login");
Template["login"] = new Template("Template.login", (function() {
  var view = this;
  return HTML.DIV({
    "class": "wrapper wrapper-content text-center loginscreen animated fadeInDown"
  }, HTML.Raw('\n        <div>\n            <h1 class="logo-name">IN+</h1>\n        </div>\n        <h3>Register to Publication Group Management System</h3>\n\n        <p>Create account to see it in action.</p>\n        '), HTML.DIV({
    "class": "row"
  }, " \n            ", HTML.Raw('<div class="col-lg-3" align="center">\n            </div>'), "\n            ", HTML.DIV({
    "class": "col-lg-6",
    align: "center"
  }, "\n                ", HTML.DIV({
    "class": "tabs-container"
  }, "\n                    ", HTML.Raw('<ul class="nav nav-tabs">\n                        <li class="active"><a data-toggle="tab" href="#tab-1"> Sign In with Social Account </a></li>\n                        <li class=""><a data-toggle="tab" href="#tab-2">Sign In with Face Recongition</a></li>\n                    </ul>'), "\n                    ", HTML.DIV({
    "class": "tab-content"
  }, "\n                        ", HTML.DIV({
    id: "tab-1",
    "class": "tab-pane active"
  }, "\n                            ", HTML.DIV({
    "class": "panel-body"
  }, "\n                                ", HTML.DIV({
    "class": "m-t",
    role: "form"
  }, "\n                                    ", Blaze._TemplateWith(function() {
    return {
      state: Spacebars.call("signIn")
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("atForm"));
  }), "\n                                "), "\n                            "), "\n                        "), "\n                        ", HTML.DIV({
    id: "tab-2",
    "class": "tab-pane"
  }, "\n                            ", HTML.DIV({
    "class": "panel-body"
  }, "\n                                ", HTML.DIV({
    "class": "m-t",
    role: "form"
  }, "\n                                    ", Spacebars.include(view.lookupTemplate("photo")), "\n                                "), "\n                            "), "\n                        "), "\n                    "), "\n                "), "\n            "), "\n        "), HTML.Raw('\n\n        <p class="m-t">\n            <small>Service Oriented Computing &copy; 2016</small>\n        </p>\n    '));
}));

Template.__checkName("photo");
Template["photo"] = new Template("Template.photo", (function() {
  var view = this;
  return HTML.Raw('<a href="#" class="takePhoto">take photo</a>\n\n    <img class="photo">');
}));

}).call(this);
