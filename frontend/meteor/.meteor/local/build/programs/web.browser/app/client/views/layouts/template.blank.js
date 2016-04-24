(function(){
Template.__checkName("blankLayout");
Template["blankLayout"] = new Template("Template.blankLayout", (function() {
  var view = this;
  return HTML.DIV({
    id: "content"
  }, "\n    ", Spacebars.include(view.lookupTemplate("yield")), "\n  ");
}));

}).call(this);
