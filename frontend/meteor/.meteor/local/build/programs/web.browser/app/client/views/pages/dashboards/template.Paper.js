(function(){
Template.__checkName("dashboard1");
Template["dashboard1"] = new Template("Template.dashboard1", (function() {
  var view = this;
  return HTML.DIV({
    "class": "wrapper wrapper-content"
  }, "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "col-lg-12"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Paper table </h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-sm-5 m-b-xs"><select class="input-sm form-control input-s-sm inline">\n                                <option value="0">Articles</option>\n                                <option value="1">Journal</option>\n                                <option value="2">Thesis</option>\n                            </select>\n                            </div>\n                            <div class="col-sm-4 m-b-xs">\n                                <div data-toggle="buttons" class="btn-group">\n                                    <label class="btn btn-sm btn-white"> <input type="radio" id="option1" name="options"> Day </label>\n                                    <label class="btn btn-sm btn-white active"> <input type="radio" id="option2" name="options"> Week </label>\n                                    <label class="btn btn-sm btn-white"> <input type="radio" id="option3" name="options"> Month </label>\n                                </div>\n                            </div>\n                            <div class="col-sm-3">\n                                <div class="input-group"><input type="text" placeholder="Search" class="input-sm form-control"> <span class="input-group-btn">\n                                        <button type="button" class="btn btn-sm btn-primary"> Go!</button> </span></div>\n                            </div>\n                        </div>'), "\n                        ", HTML.DIV({
    "class": "table-responsive"
  }, "\n                            ", HTML.TABLE({
    "class": "table table-striped"
  }, "\n                                ", HTML.THEAD("\n                                ", HTML.TR("\n\n                                    ", HTML.TH(), "\n                                    ", HTML.TH("Author "), "\n                                    ", HTML.TH("Title "), "\n                                    ", HTML.TH("Year"), "\n                                "), "\n                                "), "\n                                ", HTML.TBODY("\n                                ", HTML.TR("\n                                    ", HTML.TD(HTML.INPUT({
    type: "checkbox",
    checked: "",
    "class": "i-checks",
    name: "input[]"
  })), "\n                                    ", HTML.TD("Jia Zhang ", Blaze.View("lookup:AuthorTop1", function() {
    return Spacebars.mustache(view.lookup("AuthorTop1"));
  }), " "), "\n                                    ", HTML.TD(HTML.SPAN({
    "class": "pie"
  }, "Supporting CSCW and CSCL with Intelligent Social Grouping Services.")), "\n                                    ", HTML.TD("2012"), "\n                                "), "\n                                ", HTML.TR("\n                                    ", HTML.TD(HTML.INPUT({
    type: "checkbox",
    "class": "i-checks",
    name: "input[]"
  })), "\n                                    ", HTML.TD("Jinhui Yao ", Blaze.View("lookup:AuthorTop2", function() {
    return Spacebars.mustache(view.lookup("AuthorTop2"));
  })), "\n                                    ", HTML.TD("ReputationNet: Reputation-Based Service Recommendation for e-Science"), "\n                                    ", HTML.TD("2015"), "\n                                "), "\n                                ", HTML.TR("\n                                    ", HTML.TD(HTML.INPUT({
    type: "checkbox",
    "class": "i-checks",
    name: "input[]"
  })), "\n                                    ", HTML.TD("Stephen J. H. Yang ", Blaze.View("lookup:AuthorTop3", function() {
    return Spacebars.mustache(view.lookup("AuthorTop3"));
  })), "\n                                    ", HTML.TD("Using Description Logics for the Provision of Context-Driven Content Adaptation Services."), "\n                                    ", HTML.TD("2011"), "\n                                "), "\n                                "), "\n                            "), "\n                        "), "\n\n                    "), "\n                "), "\n            "), "\n\n        "), "\n    ");
}));

}).call(this);
