(function(){
Template.__checkName("forgotPassword");
Template["forgotPassword"] = new Template("Template.forgotPassword", (function() {
  var view = this;
  return HTML.DIV({
    "class": "middle-box text-center loginscreen animated fadeInDown"
  }, HTML.Raw('\n        <div>\n            <h1 class="logo-name">IN+</h1>\n        </div>\n        <h3>Register to Service Oriented Computing</h3>\n\n        <p>Create account to see it in action.</p>\n\n        '), HTML.DIV({
    "class": "m-t",
    role: "form"
  }, "\n            ", Blaze._TemplateWith(function() {
    return {
      state: Spacebars.call("forgotPwd")
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("atForm"));
  }), "\n        "), HTML.Raw('\n        <p class="m-t">\n            <small>Service Oriented Computing &copy; 2016</small>\n        </p>\n    '));
}));

}).call(this);
