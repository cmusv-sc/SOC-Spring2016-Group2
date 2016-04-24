(function(){
Template.__checkName("invoice");
Template["invoice"] = new Template("Template.invoice", (function() {
  var view = this;
  return [ HTML.DIV({
    "class": "row wrapper border-bottom white-bg page-heading"
  }, "\n        ", HTML.DIV({
    "class": "col-lg-8"
  }, "\n            ", HTML.Raw("<h2>Invoice</h2>"), "\n            ", HTML.OL({
    "class": "breadcrumb"
  }, "\n                ", HTML.LI("\n                    ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "dashboard1"
      }));
    }
  }, "Home"), "\n                "), "\n                ", HTML.Raw("<li>\n                    Other Pages\n                </li>"), "\n                ", HTML.Raw('<li class="active">\n                    <strong>Invoice</strong>\n                </li>'), "\n            "), "\n        "), "\n        ", HTML.DIV({
    "class": "col-lg-4"
  }, "\n            ", HTML.DIV({
    "class": "title-action"
  }, "\n                ", HTML.Raw('<a href="#" class="btn btn-white"><i class="fa fa-pencil"></i> Edit </a>'), "\n                ", HTML.Raw('<a href="#" class="btn btn-white"><i class="fa fa-check "></i> Save </a>'), "\n                ", HTML.A({
    href: function() {
      return Spacebars.mustache(view.lookup("pathFor"), Spacebars.kw({
        route: "invoicePrint"
      }));
    },
    target: "_blank",
    "class": "btn btn-primary"
  }, HTML.Raw('<i class="fa fa-print"></i>'), " Print Invoice "), "\n            "), "\n        "), "\n    "), "\n    ", HTML.DIV({
    "class": "wrapper wrapper-content animated fadeInRight"
  }, "\n        ", HTML.DIV({
    "class": "ibox-content p-xl"
  }, "\n            ", HTML.Raw('<div class="row">\n                <div class="col-sm-6">\n                    <h5>From:</h5>\n                    <address>\n                        <strong>Inspinia, Inc.</strong><br>\n                        106 Jorg Avenu, 600/10<br>\n                        Chicago, VT 32456<br>\n                        <abbr title="Phone">P:</abbr> (123) 601-4590\n                    </address>\n                </div>\n\n                <div class="col-sm-6 text-right">\n                    <h4>Invoice No.</h4>\n                    <h4 class="text-navy">INV-000567F7-00</h4>\n                    <span>To:</span>\n                    <address>\n                        <strong>Corporate, Inc.</strong><br>\n                        112 Street Avenu, 1080<br>\n                        Miami, CT 445611<br>\n                        <abbr title="Phone">P:</abbr> (120) 9000-4321\n                    </address>\n                    <p>\n                        <span><strong>Invoice Date:</strong> Marh 18, 2014</span><br>\n                        <span><strong>Due Date:</strong> March 24, 2014</span>\n                    </p>\n                </div>\n            </div>'), "\n\n            ", HTML.DIV({
    "class": "table-responsive m-t"
  }, "\n                ", HTML.TABLE({
    "class": "table invoice-table"
  }, "\n                    ", HTML.THEAD("\n                    ", HTML.TR("\n                        ", HTML.TH("Item List"), "\n                        ", HTML.TH("Quantity"), "\n                        ", HTML.TH("Unit Price"), "\n                        ", HTML.TH("Tax"), "\n                        ", HTML.TH("Total Price"), "\n                    "), "\n                    "), "\n                    ", HTML.TBODY("\n                    ", HTML.TR("\n                        ", HTML.TD(HTML.DIV(HTML.STRONG("Admin Theme with psd project layouts")), "\n                            ", HTML.SMALL("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")), "\n                        ", HTML.TD("1"), "\n                        ", HTML.TD("$26.00"), "\n                        ", HTML.TD("$5.98"), "\n                        ", HTML.TD("$31,98"), "\n                    "), "\n                    ", HTML.TR("\n                        ", HTML.TD(HTML.DIV(HTML.STRONG("Wodpress Them customization")), "\n                            ", HTML.SMALL("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n                                Eiusmod tempor incididunt ut labore et dolore magna aliqua.\n                            ")), "\n                        ", HTML.TD("2"), "\n                        ", HTML.TD("$80.00"), "\n                        ", HTML.TD("$36.80"), "\n                        ", HTML.TD("$196.80"), "\n                    "), "\n                    ", HTML.TR("\n                        ", HTML.TD(HTML.DIV(HTML.STRONG("Angular JS & Node JS Application")), "\n                            ", HTML.SMALL("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")), "\n                        ", HTML.TD("3"), "\n                        ", HTML.TD("$420.00"), "\n                        ", HTML.TD("$193.20"), "\n                        ", HTML.TD("$1033.20"), "\n                    "), "\n\n                    "), "\n                "), "\n            "), HTML.Raw("<!-- /table-responsive -->"), "\n\n            ", HTML.TABLE({
    "class": "table invoice-total"
  }, "\n                ", HTML.TBODY("\n                ", HTML.TR("\n                    ", HTML.TD(HTML.STRONG("Sub Total :")), "\n                    ", HTML.TD("$1026.00"), "\n                "), "\n                ", HTML.TR("\n                    ", HTML.TD(HTML.STRONG("TAX :")), "\n                    ", HTML.TD("$235.98"), "\n                "), "\n                ", HTML.TR("\n                    ", HTML.TD(HTML.STRONG("TOTAL :")), "\n                    ", HTML.TD("$1261.98"), "\n                "), "\n                "), "\n            "), "\n            ", HTML.Raw('<div class="text-right">\n                <button class="btn btn-primary"><i class="fa fa-dollar"></i> Make A Payment</button>\n            </div>'), "\n\n            ", HTML.Raw('<div class="well m-t"><strong>Comments</strong>\n                It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less\n            </div>'), "\n        "), "\n    ") ];
}));

}).call(this);
