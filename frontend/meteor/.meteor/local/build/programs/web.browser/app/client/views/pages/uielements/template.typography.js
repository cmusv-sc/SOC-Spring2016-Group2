(function(){
Template.__checkName("typography");
Template["typography"] = new Template("Template.typography", (function() {
  var view = this;
  return [ HTML.Raw("<!-- Page heading -->\n    "), Blaze._TemplateWith(function() {
    return {
      title: Spacebars.call("Typography"),
      category: Spacebars.call("UI Elements")
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("pageHeading"));
  }), "\n\n    ", HTML.DIV({
    "class": "wrapper wrapper-content animated fadeInRight"
  }, "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "col-lg-6"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Headings</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <h1>Heading 1\n                            <small>Sub-heading</small>\n                        </h1>\n                        <h2>Heading 2\n                            <small>Sub-heading</small>\n                        </h2>\n                        <h3>Heading 3\n                            <small>Sub-heading</small>\n                        </h3>\n                        <h4>Heading 4\n                            <small>Sub-heading</small>\n                        </h4>\n                        <h5>Heading 5\n                            <small>Sub-heading</small>\n                        </h5>\n                        <h6>Heading 6\n                            <small>Sub-heading</small>\n                        </h6>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-6"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Paragraph text</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <p>Lorem ipsum <strong>eget urna mollis</strong> ornare vel eu leo. <em>Cum sociisnatoque penatibus</em> et magnis dis parturient montes, <code>code</code> nascetur\n                            ridiculus mus. Nullam id dolor id nibh ultricies vehicula ut id elit. Sed euismod aliquet sapien consequat tincidunt.</p>\n\n                        <p>Vivamus sagittis lacus vel augue laoreet <abbr title="" data-original-title="Sample abbreviation">rutrum faucibus dolor auctor</abbr>. Duis mollis, est non commodo\n                            luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec sed odio dui. Sed euismod aliquet sapien consequat tincidunt.</p>\n\n                        <p>\n                            But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual.\n                        </p>\n                    </div>'), "\n                "), "\n            "), "\n        "), "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Unstyled list</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <ul class="unstyled">\n                            <li>But I must explain </li>\n                            <li>To you how all this mistaken</li>\n                            <li>Idea of denouncing pleasure </li>\n                            <li>Great explorer of the truth</li>\n                            <li>To take a trivial example\n                                <ul>\n                                    <li>Or one who avoids a pain</li>\n                                    <li>Indignation and dislike men</li>\n                                    <li>Nor again is there anyone </li>\n                                    <li>But who has any right</li>\n                                </ul>\n                            </li>\n                            <li>That they cannot foresee</li>\n                            <li>Who avoids a pain that produceg</li>\n                            <li>Consequences that are extremely </li>\n                        </ul>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Unordered list</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <ul>\n                            <li>But I must explain </li>\n                            <li>To you how all this mistaken</li>\n                            <li>Idea of denouncing pleasure </li>\n                            <li>Great explorer of the truth</li>\n                            <li>To take a trivial example\n                                <ul>\n                                    <li>Or one who avoids a pain</li>\n                                    <li>Indignation and dislike men</li>\n                                    <li>Nor again is there anyone </li>\n                                    <li>But who has any right</li>\n                                </ul>\n                            </li>\n                            <li>That they cannot foresee</li>\n                            <li>Who avoids a pain that produceg</li>\n                            <li>Consequences that are extremely </li>\n                        </ul>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Ordered list</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <ol>\n                            <li>But I must explain </li>\n                            <li>To you how all this mistaken</li>\n                            <li>Idea of denouncing pleasure </li>\n                            <li>Great explorer of the truth</li>\n                            <li>To take a trivial example\n                                <ol>\n                                    <li>Or one who avoids a pain</li>\n                                    <li>Indignation and dislike men</li>\n                                    <li>Nor again is there anyone </li>\n                                    <li>But who has any right</li>\n                                </ol>\n                            </li>\n                            <li>That they cannot foresee</li>\n                            <li>Who avoids a pain that produceg</li>\n                            <li>Consequences that are extremely </li>\n                        </ol>\n                    </div>'), "\n                "), "\n            "), "\n        "), "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "col-lg-6"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Emphasis Classes</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <p class="text-muted">This is an example of muted text.</p>\n                        <p class="text-primary">This is an example of primary text.</p>\n                        <p class="text-success">This is an example of success text.</p>\n                        <p class="text-info">This is an example of info text.</p>\n                        <p class="text-warning">This is an example of warning text.</p>\n                        <p class="text-danger">This is an example of danger text.</p>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-6"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Blockquotes</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <blockquote>\n                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>\n                            <small><strong>Author name</strong> in <cite title="" data-original-title="">Book name</cite></small>\n                        </blockquote>\n\n                    </div>'), "\n                "), "\n            "), "\n\n        "), "\n        ", HTML.DIV({
    "class": "row"
  }, "\n\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Alignment</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <p class="text-left">Left aligned text.</p>\n                        <p class="text-center">Center aligned text.</p>\n                        <p class="text-right">Right aligned text.</p>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Address</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <address>\n                            <strong>Twitter, Inc.</strong><br>\n                            795 Folsom Ave, Suite 600<br>\n                            San Francisco, CA 94107<br>\n                            <abbr title="Phone">P:</abbr> (123) 456-7890\n                        </address>\n\n                        <address>\n                            <strong>Full Name</strong><br>\n                            <a href="mailto:#">first.last@example.com</a>\n                        </address>\n\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Grouped Lists</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content no-padding">\n                        <ul class="list-group">\n                            <li class="list-group-item">\n                                <span class="badge badge-primary">16</span>\n                                But I must explain to\n                            </li>\n                            <li class="list-group-item ">\n                                <span class="badge badge-info">12</span>\n                                How all this mistaken\n                            </li>\n                            <li class="list-group-item">\n                                <span class="badge badge-danger">10</span>\n                                But because occasionally\n                            </li>\n                            <li class="list-group-item">\n                                <span class="badge badge-success">10</span>\n                                But who has any right\n                            </li>\n                            <li class="list-group-item">\n                                <span class="badge badge-warning">7</span>\n                                On the other hand\n                            </li>\n                        </ul>\n                    </div>'), "\n                "), "\n            "), "\n\n        "), "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "col-lg-6"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Grouped Lists</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <div class="list-group">\n                            <a class="list-group-item active" href="#">\n                                <h3 class="list-group-item-heading">A wonderful serenity has taken</h3>\n\n                                <p class="list-group-item-text">I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. </p>\n                            </a>\n\n                            <a class="list-group-item" href="#">\n                                <h3 class="list-group-item-heading">Why painful the sixteen how minuter</h3>\n\n                                <p class="list-group-item-text">I throw myself down among the tall grass by the trickling stream; and, as I lie close to the earth, a thousand unknown plants are noticed by me: when I hear the buzz of the little world among the stalks, and grow familiar with the countless indescribable forms of the insects and flies, then I feel the presence of the Almighty, who formed us in his own image, and the breath </p>\n                            </a>\n\n                            <a class="list-group-item" href="#">\n                                <h3 class="list-group-item-heading">Barton waited twenty always repair</h3>\n\n                                <p class="list-group-item-text">I never was a greater artist than now. When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary</p>\n                            </a>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-6"
  }, "\n                ", HTML.DIV({
    "class": "ibox float-e-margins"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-title"
  }, "\n                        ", HTML.Raw("<h5>Wells</h5>"), "\n                        ", Spacebars.include(view.lookupTemplate("iboxTools")), "\n                    "), "\n                    ", HTML.Raw('<div class="ibox-content">\n                        <div class="well">\n                            <h3>\n                                The quick, brown fox jumps over a lazy dog.\n                            </h3>\n                            I feel the presence of the Almighty, who formed us in his own image, and the breath\n                        </div>\n                        <div class="well well-lg">\n                            <h3>\n                                Quick zephyrs blow, vexing daft Jim.\n                            </h3>\n                            I feel that I never was a greater artist than now. When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees\n                        </div>\n                        <div class="well well-sm">\n                            <h3>\n                                Joaquin Phoenix was gazed by MTV for luck\n                            </h3>\n                            A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n        "), "\n\n\n    ") ];
}));

}).call(this);
