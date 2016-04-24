(function(){
Template.__checkName("blog");
Template["blog"] = new Template("Template.blog", (function() {
  var view = this;
  return [ HTML.Raw("<!-- Page heading -->\n    "), Blaze._TemplateWith(function() {
    return {
      title: Spacebars.call("Blog"),
      category: Spacebars.call("App views")
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("pageHeading"));
  }), "\n\n    ", HTML.DIV({
    "class": "wrapper wrapper-content animated fadeInRight blog"
  }, "\n        ", HTML.DIV({
    "class": "row"
  }, "\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                One morning, when Gregor Samsa\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>Adam Novak</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 28th Oct 2015</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-primary btn-xs" type="button">Model</button>\n                                <button class="btn btn-white btn-xs" type="button">Publishing</button>\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 56 comments </div>\n                                    <i class="fa fa-eye"> </i> 144 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                It showed a lady fitted out with\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>Mike Smith</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 11th May 2015</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of.\n                        </p>"), "\n                        ", HTML.Raw("<p>\n                            No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-primary btn-xs" type="button">New</button>\n                                <button class="btn btn-white btn-xs" type="button">Model</button>\n                                <button class="btn btn-white btn-xs" type="button">Publishing</button>\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 36 comments </div>\n                                    <i class="fa fa-eye"> </i> 100 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                The bedding was hardly able to cover\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>Anthony Dvorak</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 11th Dec 2014</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            A collection of textile samples lay spread out on the table - Samsa was a travelling salesman.\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-white btn-xs" type="button">Publishing</button>\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 11 comments </div>\n                                    <i class="fa fa-eye"> </i> 46 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                Junk MTV quiz graced by fox whelps.\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>alex Trebek</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 07 Apr 2015</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            Alex Trebek's fun TV quiz game. Woven silk pyjamas exchanged for blue quartz. Brawny gods just zebra, and my wolves quack! Blowzy red vixens fight for a quick.\n                        </p>"), "\n                        ", HTML.Raw("<p>\n                            On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the.\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-white btn-xs" type="button">Model</button>\n                                <button class="btn btn-white btn-xs" type="button">Publishing</button>\n                                <button class="btn btn-white btn-xs" type="button">Modern</button>\n                                <button class="btn btn-white btn-xs" type="button">Premium</button>\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 23 comments </div>\n                                    <i class="fa fa-eye"> </i> 34 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                Two driven jocks help fax my big\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>Monica Jackson</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 14th Oct 2015</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            Flummoxed by job, kvetching W. zaps Iraq. Cozy sphinx waves quart jug of bad milk. A very bad quack might jinx zippy fowls. Few quips galvanized\n                        </p>"), "\n                        ", HTML.Raw("<p>\n                            It wasn't a dream. His room, a proper human room although a little too small, lay peacefully between its four familiar walls.\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-white btn-xs" type="button">Modern</button>\n                                <button class="btn btn-white btn-xs" type="button">Model</button>\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 32 comments </div>\n                                    <i class="fa fa-eye"> </i> 10 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                I feel the presence of the Almighty\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>John Smith</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 04 Dec 2015</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            I hear the buzz of the little world among the stalks, and grow familiar with the countless indescribable forms of the insects and flies, then I feel the presence of the Almighty, who formed us in his own image, and the breath\n                            Gregor then turned to look out the window at the dull weather.\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-white btn-xs" type="button">Publishing</button>\n                                <button class="btn btn-white btn-xs" type="button">Premium</button>\n\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 22 comments </div>\n                                    <i class="fa fa-eye"> </i> 17 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                The European languages are members\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>Anthony Pits</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 04 Jan 2015</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators.\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-primary btn-xs" type="button">Publishing</button>\n                                <button class="btn btn-white btn-xs" type="button">Model</button>\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 54 comments </div>\n                                    <i class="fa fa-eye"> </i> 52 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                The new common language\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>Adam Novak</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 14th Oct 2015</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web\n                        </p>"), "\n                        ", HTML.Raw("<p>\n                            The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-white btn-xs" type="button">Publishing</button>\n                                <button class="btn btn-white btn-xs" type="button">Model</button>\n                                <button class="btn btn-white btn-xs" type="button">Premium</button>\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 47 comments </div>\n                                    <i class="fa fa-eye"> </i> 138 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n                ", HTML.DIV({
    "class": "ibox"
  }, "\n                    ", HTML.DIV({
    "class": "ibox-content"
  }, "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "article"
      }));
    },
    "class": "btn-link"
  }, "\n                            ", HTML.Raw("<h2>\n                                Their pronunciation and their most\n                            </h2>"), "\n                        "), "\n                        ", HTML.Raw('<div class="small m-b-xs">\n                            <strong>Mike Johnson</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 11th Oct 2015</span>\n                        </div>'), "\n                        ", HTML.Raw("<p>\n                            To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses\n                        </p>"), "\n                        ", HTML.Raw('<div class="row">\n                            <div class="col-md-6">\n                                <h5>Tags:</h5>\n                                <button class="btn btn-primary btn-xs" type="button">Publishing</button>\n                                <button class="btn btn-white btn-xs" type="button">Model</button>\n                            </div>\n                            <div class="col-md-6">\n                                <div class="small text-right">\n                                    <h5>Stats:</h5>\n                                    <div> <i class="fa fa-comments-o"> </i> 54 comments </div>\n                                    <i class="fa fa-eye"> </i> 52 views\n                                </div>\n                            </div>\n                        </div>'), "\n                    "), "\n                "), "\n            "), "\n        "), "\n\n\n    ") ];
}));

}).call(this);
