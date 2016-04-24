(function(){
Template.__checkName("forumView");
Template["forumView"] = new Template("Template.forumView", (function() {
  var view = this;
  return [ HTML.Raw("<!-- Page heading -->\n    "), Blaze._TemplateWith(function() {
    return {
      title: Spacebars.call("Forum view"),
      category: Spacebars.call("Miscellaneous")
    };
  }, function() {
    return Spacebars.include(view.lookupTemplate("pageHeading"));
  }), "\n\n    ", HTML.DIV({
    "class": "wrapper wrapper-content animated fadeInRight"
  }, "\n\n        ", HTML.Raw('<div class="ibox-content m-b-sm border-bottom">\n            <div class="p-xs">\n                <div class="pull-left m-r-md">\n                    <i class="fa fa-globe text-navy mid-icon"></i>\n                </div>\n                <h2>Welcome in Inspinia Forum</h2>\n                <span>Feel free to choose topic you\'re interested in.</span>\n            </div>\n        </div>'), "\n\n        ", HTML.DIV({
    "class": "ibox-content forum-container"
  }, "\n\n            ", HTML.DIV({
    "class": "forum-title"
  }, "\n                ", HTML.DIV({
    "class": "pull-right forum-desc"
  }, "\n                    ", HTML.getTag("samll")("Total posts: 320,800"), "\n                "), "\n                ", HTML.Raw("<h3>General subjects</h3>"), "\n            "), "\n\n            ", HTML.DIV({
    "class": "forum-item active"
  }, "\n                ", HTML.DIV({
    "class": "row"
  }, "\n                    ", HTML.DIV({
    "class": "col-md-9"
  }, "\n                        ", HTML.Raw('<div class="forum-icon">\n                            <i class="fa fa-shield"></i>\n                        </div>'), "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "forumDetail"
      }));
    },
    "class": "forum-item-title"
  }, "General Discussion"), "\n                        ", HTML.Raw('<div class="forum-sub-title">Talk about sports, entertainment, music, movies, your favorite color, talk about enything.</div>'), "\n                    "), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            1216\n                                        </span>\n                        <div>\n                            <small>Views</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            368\n                                        </span>\n                        <div>\n                            <small>Topics</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            140\n                                        </span>\n                        <div>\n                            <small>Posts</small>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "forum-item"
  }, "\n                ", HTML.DIV({
    "class": "row"
  }, "\n                    ", HTML.DIV({
    "class": "col-md-9"
  }, "\n                        ", HTML.Raw('<div class="forum-icon">\n                            <i class="fa fa-bolt"></i>\n                        </div>'), "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "forumDetail"
      }));
    },
    "class": "forum-item-title"
  }, "Introductions"), "\n                        ", HTML.Raw('<div class="forum-sub-title">New to the community? Please stop by, say hi and tell us a bit about yourself. </div>'), "\n                    "), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            890\n                                        </span>\n                        <div>\n                            <small>Views</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            120\n                                        </span>\n                        <div>\n                            <small>Topics</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            154\n                                        </span>\n                        <div>\n                            <small>Posts</small>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "forum-item active"
  }, "\n                ", HTML.DIV({
    "class": "row"
  }, "\n                    ", HTML.DIV({
    "class": "col-md-9"
  }, "\n                        ", HTML.Raw('<div class="forum-icon">\n                            <i class="fa fa-calendar"></i>\n                        </div>'), "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "forumDetail"
      }));
    },
    "class": "forum-item-title"
  }, "Announcements"), "\n                        ", HTML.Raw('<div class="forum-sub-title">This forum features announcements from the community staff. If there is a new post in this forum, please check it out. </div>'), "\n                    "), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            680\n                                        </span>\n                        <div>\n                            <small>Views</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            124\n                                        </span>\n                        <div>\n                            <small>Topics</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            61\n                                        </span>\n                        <div>\n                            <small>Posts</small>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "forum-item"
  }, "\n                ", HTML.DIV({
    "class": "row"
  }, "\n                    ", HTML.DIV({
    "class": "col-md-9"
  }, "\n                        ", HTML.Raw('<div class="forum-icon">\n                            <i class="fa fa-star"></i>\n                        </div>'), "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "forumDetail"
      }));
    },
    "class": "forum-item-title"
  }, "Staff Discussion"), "\n                        ", HTML.Raw('<div class="forum-sub-title">This forum is for private, staff member only discussions, usually pertaining to the community itself. </div>'), "\n                    "), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            1450\n                                        </span>\n                        <div>\n                            <small>Views</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            652\n                                        </span>\n                        <div>\n                            <small>Topics</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            572\n                                        </span>\n                        <div>\n                            <small>Posts</small>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n\n            ", HTML.DIV({
    "class": "forum-title"
  }, "\n                ", HTML.DIV({
    "class": "pull-right forum-desc"
  }, "\n                    ", HTML.getTag("samll")("Total posts: 17,800,600"), "\n                "), "\n                ", HTML.Raw("<h3>Other subjects</h3>"), "\n            "), "\n\n            ", HTML.DIV({
    "class": "forum-item"
  }, "\n                ", HTML.DIV({
    "class": "row"
  }, "\n                    ", HTML.DIV({
    "class": "col-md-9"
  }, "\n                        ", HTML.Raw('<div class="forum-icon">\n                            <i class="fa fa-clock-o"></i>\n                        </div>'), "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "forumDetail"
      }));
    },
    "class": "forum-item-title"
  }, "Lorem Ipsum is simply dummy text. "), "\n                        ", HTML.Raw('<div class="forum-sub-title">Various versions have evolved over the years, sometimes by accident, sometimes on purpose passage of Lorem Ipsum (injected humour and the like).</div>'), "\n                    "), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            1516\n                                        </span>\n                        <div>\n                            <small>Views</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            238\n                                        </span>\n                        <div>\n                            <small>Topics</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            180\n                                        </span>\n                        <div>\n                            <small>Posts</small>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "forum-item"
  }, "\n                ", HTML.DIV({
    "class": "row"
  }, "\n                    ", HTML.DIV({
    "class": "col-md-9"
  }, "\n                        ", HTML.Raw('<div class="forum-icon">\n                            <i class="fa fa-bomb"></i>\n                        </div>'), "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "forumDetail"
      }));
    },
    "class": "forum-item-title"
  }, "There are many variations of passages"), "\n                        ", HTML.Raw('<div class="forum-sub-title"> If you are going to use a passage of Lorem Ipsum, you need to be sure there isn\'t anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the . </div>'), "\n                    "), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            1766\n                                        </span>\n                        <div>\n                            <small>Views</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            321\n                                        </span>\n                        <div>\n                            <small>Topics</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            42\n                                        </span>\n                        <div>\n                            <small>Posts</small>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "forum-item"
  }, "\n                ", HTML.DIV({
    "class": "row"
  }, "\n                    ", HTML.DIV({
    "class": "col-md-9"
  }, "\n                        ", HTML.Raw('<div class="forum-icon">\n                            <i class="fa fa-bookmark"></i>\n                        </div>'), "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "forumDetail"
      }));
    },
    "class": "forum-item-title"
  }, "The standard chunk of Lorem Ipsum"), "\n                        ", HTML.Raw('<div class="forum-sub-title">Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet.</div>'), "\n                    "), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            765\n                                        </span>\n                        <div>\n                            <small>Views</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            90\n                                        </span>\n                        <div>\n                            <small>Topics</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            11\n                                        </span>\n                        <div>\n                            <small>Posts</small>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n            ", HTML.DIV({
    "class": "forum-item"
  }, "\n                ", HTML.DIV({
    "class": "row"
  }, "\n                    ", HTML.DIV({
    "class": "col-md-9"
  }, "\n                        ", HTML.Raw('<div class="forum-icon">\n                            <i class="fa fa-ambulance"></i>\n                        </div>'), "\n                        ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "forumDetail"
      }));
    },
    "class": "forum-item-title"
  }, "Lorem Ipsum, you need to be sure there"), "\n                        ", HTML.Raw('<div class="forum-sub-title">Internet tend to repeat predefined chunks as necessary, making this the</div>'), "\n                    "), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            2550\n                                        </span>\n                        <div>\n                            <small>Views</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            122\n                                        </span>\n                        <div>\n                            <small>Topics</small>\n                        </div>\n                    </div>'), "\n                    ", HTML.Raw('<div class="col-md-1 forum-info">\n                                        <span class="views-number">\n                                            92\n                                        </span>\n                        <div>\n                            <small>Posts</small>\n                        </div>\n                    </div>'), "\n                "), "\n            "), "\n\n        "), "\n    ") ];
}));

}).call(this);
