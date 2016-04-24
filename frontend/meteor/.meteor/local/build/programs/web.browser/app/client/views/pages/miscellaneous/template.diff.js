(function(){
Template.__checkName("diff");
Template["diff"] = new Template("Template.diff", (function() {
  var view = this;
  return [ HTML.Raw("<!-- Page heading -->\n    "), Blaze._TemplateWith(function() {
    return {
      title: Spacebars.call("Diff"),
      category: Spacebars.call("Miscellaneous")
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("pageHeading"));
  }), "\n\n    ", HTML.DIV({
    "class": "wrapper wrapper-content  animated fadeInRight"
  }, "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "col-lg-12"
  }, "\n                ", HTML.DIV({
    "class": "ibox "
  }, "\n                    ", HTML.Raw('<div class="ibox-title">\n                        <h5>Diff plugin</h5>\n                    </div>'), "\n\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n\n                        ", HTML.Raw("<strong>jQuery.PrettyTextDiff</strong>"), "\n                        ", HTML.Raw("<p>\n                            A wrapper around Google's diff_match_patch library.\n                            <br>\n                            You can run diff on existing text by adding class <code>original</code> and <code>changed</code> and add element that compares text. Or you can pass text as a param of function. See example below.\n                        </p>"), "\n\n                        ", HTML.Raw('<div class="well">\n                            <h3 class="m-t-lg">Standard example</h3>\n\n                            <div class="row diff-wrapper">\n                                <div class="col-md-4">\n                                    <h4>Oryginal text</h4>\n\n                                    <div class="original">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only centuries, but also the leap into electronic typesetting.</div>\n                                </div>\n                                <div class="col-md-4">\n                                    <h4>Changed text</h4>\n\n                                    <div class="changed">Lorem Ipsum is simply typesetting dummy text of the printing and has been the industry\'s typesetting. Lorem Ipsum has been the industry\'s standard dummy text ever the 1500s, when an printer took a galley of type and simply it to make a type. It has survived not only five centuries, but survived not also the leap into electronic typesetting.</div>\n                                </div>\n                                <div class="col-md-4">\n                                    <h4>Diff results</h4>\n\n                                    <div class="diff1"></div>\n                                </div>\n                            </div>\n                        </div>'), "\n\n                        ", HTML.Raw('<h3 class="m-t-lg">As a function param</h3>'), "\n                        ", HTML.Raw("<p>\n                            Diff will run after textarea will change. So feel free to play with it to see Diff results.\n                        </p>"), "\n                        ", HTML.DIV({
    "class": "row diff-wrapper2"
  }, "\n                            ", HTML.DIV({
    "class": "col-md-4"
  }, "\n                                ", HTML.Raw("<h4>Oryginal text</h4>"), "\n                                    ", HTML.TEXTAREA({
    "class": "form-control diff-textarea",
    id: "original",
    rows: "6",
    value: "Lorem Ipsum is simply printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text eve\n                                    "
  }), "\n                            "), "\n                            ", HTML.Raw('<div class="col-md-4">\n                                <h4>Diff results</h4>\n                                <div class="diff2"></div>\n                            </div>'), "\n                            ", HTML.DIV({
    "class": "col-md-4"
  }, "\n                                ", HTML.Raw("<h4>New text</h4>"), "\n                                    ", HTML.TEXTAREA({
    "class": "form-control diff-textarea",
    id: "changed",
    rows: "6",
    value: "Ting dummy text of the printing and has been the industry's typesetting. Lorem Ipsum has been the industry's\n                                    "
  }), "\n                            "), "\n                        "), "\n                    "), "\n                "), "\n            "), "\n        "), "\n    ") ];
}));

}).call(this);
