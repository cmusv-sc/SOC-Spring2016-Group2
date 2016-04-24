(function(){
Template.__checkName("navigation");
Template["navigation"] = new Template("Template.navigation", (function() {
  var view = this;
  return HTML.NAV({
    "class": "navbar-default navbar-static-side",
    role: "navigation"
  }, "\n        ", HTML.DIV({
    "class": "sidebar-collapse"
  }, "\n\n            ", HTML.Raw("<!-- Close canvas menu used only on OffCanvas page -->"), "\n            ", HTML.Raw("<!-- You can remove this tag if you dont use offCanvas menu -->"), "\n            ", HTML.Raw('<a class="close-canvas-menu"><i class="fa fa-times"></i></a>'), "\n            ", HTML.Raw("<!-- End offCanvas menu toggle -->"), "\n\n            ", HTML.UL({
    "class": "nav metismenu",
    id: "side-menu"
  }, "\n                ", HTML.LI({
    "class": "nav-header"
  }, "\n                    ", HTML.DIV({
    "class": "dropdown profile-element"
  }, " ", HTML.Raw("<span>\n                             </span>"), "\n                        ", HTML.Raw('<a data-toggle="dropdown" class="dropdown-toggle" href="#">\n                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">Jia</strong>\n                             </span> <span class="text-muted text-xs block">Professor <b class="caret"></b></span> </span> </a>'), "\n                        ", HTML.UL({
    "class": "dropdown-menu animated fadeInRight m-t-xs"
  }, "\n                            ", HTML.LI(HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "profile"
      }));
    }
  }, "Profile")), "\n                            ", HTML.LI(HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "contacts"
      }));
    }
  }, "Contacts")), "\n                            ", HTML.LI(HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "mailbox"
      }));
    }
  }, "Mailbox")), "\n                            ", HTML.Raw('<li class="divider"></li>'), "\n                            ", HTML.LI(HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "login"
      }));
    }
  }, "Logout")), "\n                        "), "\n                    "), "\n                    ", HTML.Raw('<div class="logo-element">\n                        IN+\n                    </div>'), "\n                "), "\n                ", HTML.LI({
    "class": function() {
      return Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "dashboard1|dashboard2|dashboard3|dashboard4l|dashboard5|friendlisthome|suggestion"
      }));
    }
  }, "\n                    ", HTML.Raw('<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label" data-i18n="nav.dashboard">Dashboards</span> <span class="fa arrow"></span></a>'), "\n                    ", HTML.UL({
    "class": function() {
      return [ "nav nav-second-level collapse ", Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "dashboard1|dashboard2|dashboard3|dashboard4l|dashboard5|friendlisthome|suggestion",
        className: "in"
      })) ];
    }
  }, "\n                        ", HTML.LI({
    "class": function() {
      return Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "dashboard1"
      }));
    }
  }, HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "dashboard1"
      }));
    }
  }, "Paper ")), "\n                        ", HTML.LI({
    "class": function() {
      return Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "friendlisthome"
      }));
    }
  }, HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "friendlisthome"
      }));
    }
  }, "FriendList ", HTML.Raw('<span class="label label-primary pull-right">NEW</span>'))), "\n                        ", HTML.LI({
    "class": function() {
      return Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "usergroup"
      }));
    }
  }, HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "usergroup"
      }));
    }
  }, "User Group ", HTML.Raw('<span class="label label-primary pull-right">NEW</span>'))), "\n                        ", HTML.LI({
    "class": function() {
      return Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "suggestion"
      }));
    }
  }, HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "suggestion"
      }));
    }
  }, "Suggestion ", HTML.Raw('<span class="label label-primary pull-right">NEW</span>'))), "\n                        ", HTML.LI({
    "class": function() {
      return Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "academicforum"
      }));
    }
  }, HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "academicforum"
      }));
    }
  }, "Academic Forum ", HTML.Raw('<span class="label label-primary pull-right">NEW</span>'))), "\n                        ", HTML.LI({
    "class": function() {
      return Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "accesscontrol"
      }));
    }
  }, HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "accesscontrol"
      }));
    }
  }, "Access Control ", HTML.Raw('<span class="label label-primary pull-right">NEW</span>'))), "\n                        ", HTML.LI({
    "class": function() {
      return Spacebars.mustache(view.lookup("isActiveRoute"), Spacebars.kw({
        regex: "postPage"
      }));
    }
  }, HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "postPage"
      }));
    }
  }, "post Page ", HTML.Raw('<span class="label label-primary pull-right">NEW</span>'))), "\n                    "), "\n                "), "\n            "), "\n\n        "), "\n    ");
}));

}).call(this);
