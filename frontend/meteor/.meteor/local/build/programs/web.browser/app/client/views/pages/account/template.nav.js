(function(){
Template.__checkName("nav");
Template["nav"] = new Template("Template.nav", (function() {
  var view = this;
  return HTML.DIV({
    "class": "fixed"
  }, "\n    ", HTML.NAV({
    "class": "top-bar",
    "data-topbar": ""
  }, "\n      ", HTML.SECTION({
    "class": "top-bar-section"
  }, "\n        ", HTML.Raw("<!-- Right Nav Section -->"), "\n        ", HTML.UL({
    "class": "right"
  }, "\n            ", Spacebars.include(view.lookupTemplate("atNavButton")), "\n        "), "\n      "), "\n    "), "\n  ");
}));

}).call(this);
