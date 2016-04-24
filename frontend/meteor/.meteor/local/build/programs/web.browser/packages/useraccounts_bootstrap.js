(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var Template = Package.templating.Template;
var _ = Package.underscore._;
var AccountsTemplates = Package['useraccounts:core'].AccountsTemplates;
var Blaze = Package.blaze.Blaze;
var UI = Package.blaze.UI;
var Handlebars = Package.blaze.Handlebars;
var Spacebars = Package.spacebars.Spacebars;
var Accounts = Package['accounts-base'].Accounts;
var T9n = Package['softwarerero:accounts-t9n'].T9n;
var HTML = Package.htmljs.HTML;

(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_error.js                                                            //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atError");                                                                                       // 2
Template["atError"] = new Template("Template.atError", (function() {                                                   // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-error alert alert-danger"                                                                             // 6
  }, "\n    ", Blaze.Each(function() {                                                                                 // 7
    return Spacebars.call(view.lookup("error"));                                                                       // 8
  }, function() {                                                                                                      // 9
    return [ "\n      ", HTML.P(Blaze.View("lookup:errorText", function() {                                            // 10
      return Spacebars.mustache(view.lookup("errorText"));                                                             // 11
    })), "\n    " ];                                                                                                   // 12
  }), "\n  ");                                                                                                         // 13
}));                                                                                                                   // 14
                                                                                                                       // 15
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_error.js                                                                     //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atError.helpers(AccountsTemplates.atErrorHelpers);                                                            // 2
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_form.js                                                             //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atForm");                                                                                        // 2
Template["atForm"] = new Template("Template.atForm", (function() {                                                     // 3
  var view = this;                                                                                                     // 4
  return Blaze.Unless(function() {                                                                                     // 5
    return Spacebars.call(view.lookup("hide"));                                                                        // 6
  }, function() {                                                                                                      // 7
    return [ "\n    ", HTML.DIV({                                                                                      // 8
      "class": "at-form"                                                                                               // 9
    }, "\n      ", Blaze.If(function() {                                                                               // 10
      return Spacebars.call(view.lookup("showTitle"));                                                                 // 11
    }, function() {                                                                                                    // 12
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atTitle")), "\n      " ];                          // 13
    }), "\n      ", Blaze.If(function() {                                                                              // 14
      return Spacebars.call(view.lookup("showOauthServices"));                                                         // 15
    }, function() {                                                                                                    // 16
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atOauth")), "\n      " ];                          // 17
    }), "\n      ", Blaze.If(function() {                                                                              // 18
      return Spacebars.call(view.lookup("showServicesSeparator"));                                                     // 19
    }, function() {                                                                                                    // 20
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atSep")), "\n      " ];                            // 21
    }), "\n      ", Blaze.If(function() {                                                                              // 22
      return Spacebars.call(view.lookup("showError"));                                                                 // 23
    }, function() {                                                                                                    // 24
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atError")), "\n      " ];                          // 25
    }), "\n      ", Blaze.If(function() {                                                                              // 26
      return Spacebars.call(view.lookup("showResult"));                                                                // 27
    }, function() {                                                                                                    // 28
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atResult")), "\n      " ];                         // 29
    }), "\n      ", Blaze.If(function() {                                                                              // 30
      return Spacebars.call(view.lookup("showMessage"));                                                               // 31
    }, function() {                                                                                                    // 32
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atMessage")), "\n      " ];                        // 33
    }), "\n      ", Blaze.If(function() {                                                                              // 34
      return Spacebars.call(view.lookup("showPwdForm"));                                                               // 35
    }, function() {                                                                                                    // 36
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atPwdForm")), "\n      " ];                        // 37
    }), "\n      ", Blaze.If(function() {                                                                              // 38
      return Spacebars.call(view.lookup("showTermsLink"));                                                             // 39
    }, function() {                                                                                                    // 40
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atTermsLink")), "\n      " ];                      // 41
    }), "\n      ", Blaze.If(function() {                                                                              // 42
      return Spacebars.call(view.lookup("showSignInLink"));                                                            // 43
    }, function() {                                                                                                    // 44
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atSigninLink")), "\n      " ];                     // 45
    }), "\n      ", Blaze.If(function() {                                                                              // 46
      return Spacebars.call(view.lookup("showSignUpLink"));                                                            // 47
    }, function() {                                                                                                    // 48
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atSignupLink")), "\n      " ];                     // 49
    }), "\n      ", Blaze.If(function() {                                                                              // 50
      return Spacebars.call(view.lookup("showResendVerificationEmailLink"));                                           // 51
    }, function() {                                                                                                    // 52
      return [ "\n        ", Spacebars.include(view.lookupTemplate("atResendVerificationEmailLink")), "\n      " ];    // 53
    }), "\n    "), "\n  " ];                                                                                           // 54
  });                                                                                                                  // 55
}));                                                                                                                   // 56
                                                                                                                       // 57
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_form.js                                                                      //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atForm.helpers(AccountsTemplates.atFormHelpers);                                                              // 2
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_input.js                                                            //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atInput");                                                                                       // 2
Template["atInput"] = new Template("Template.atInput", (function() {                                                   // 3
  var view = this;                                                                                                     // 4
  return Blaze._TemplateWith(function() {                                                                              // 5
    return {                                                                                                           // 6
      template: Spacebars.call(view.lookup("templateName"))                                                            // 7
    };                                                                                                                 // 8
  }, function() {                                                                                                      // 9
    return Spacebars.include(function() {                                                                              // 10
      return Spacebars.call(Template.__dynamic);                                                                       // 11
    });                                                                                                                // 12
  });                                                                                                                  // 13
}));                                                                                                                   // 14
                                                                                                                       // 15
Template.__checkName("atTextInput");                                                                                   // 16
Template["atTextInput"] = new Template("Template.atTextInput", (function() {                                           // 17
  var view = this;                                                                                                     // 18
  return HTML.DIV({                                                                                                    // 19
    "class": function() {                                                                                              // 20
      return [ "at-input form-group ", Blaze.If(function() {                                                           // 21
        return Spacebars.call(view.lookup("isValidating"));                                                            // 22
      }, function() {                                                                                                  // 23
        return "validating";                                                                                           // 24
      }), " ", Blaze.If(function() {                                                                                   // 25
        return Spacebars.call(view.lookup("hasError"));                                                                // 26
      }, function() {                                                                                                  // 27
        return "has-error";                                                                                            // 28
      }), " ", Blaze.If(function() {                                                                                   // 29
        return Spacebars.call(view.lookup("hasSuccess"));                                                              // 30
      }, function() {                                                                                                  // 31
        return "has-success";                                                                                          // 32
      }), " ", Blaze.If(function() {                                                                                   // 33
        return Spacebars.call(view.lookup("feedback"));                                                                // 34
      }, function() {                                                                                                  // 35
        return "has-feedback";                                                                                         // 36
      }) ];                                                                                                            // 37
    }                                                                                                                  // 38
  }, "\n    ", HTML.LABEL({                                                                                            // 39
    "class": function() {                                                                                              // 40
      return [ "control-label ", Blaze.Unless(function() {                                                             // 41
        return Spacebars.call(view.lookup("showLabels"));                                                              // 42
      }, function() {                                                                                                  // 43
        return "sr-only";                                                                                              // 44
      }) ];                                                                                                            // 45
    },                                                                                                                 // 46
    "for": function() {                                                                                                // 47
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 48
    }                                                                                                                  // 49
  }, "\n      ", Blaze.View("lookup:displayName", function() {                                                         // 50
    return Spacebars.mustache(view.lookup("displayName"));                                                             // 51
  }), " ", Blaze.Unless(function() {                                                                                   // 52
    return Spacebars.call(view.lookup("required"));                                                                    // 53
  }, function() {                                                                                                      // 54
    return Blaze.View("lookup:optionalText", function() {                                                              // 55
      return Spacebars.mustache(view.lookup("optionalText"));                                                          // 56
    });                                                                                                                // 57
  }), "\n    "), "\n    ", HTML.INPUT({                                                                                // 58
    type: function() {                                                                                                 // 59
      return Spacebars.mustache(view.lookup("type"));                                                                  // 60
    },                                                                                                                 // 61
    "class": "form-control",                                                                                           // 62
    id: function() {                                                                                                   // 63
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 64
    },                                                                                                                 // 65
    name: function() {                                                                                                 // 66
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 67
    },                                                                                                                 // 68
    placeholder: function() {                                                                                          // 69
      return Spacebars.mustache(view.lookup("placeholder"));                                                           // 70
    },                                                                                                                 // 71
    autocapitalize: "none",                                                                                            // 72
    autocorrect: "off"                                                                                                 // 73
  }), "\n    ", Blaze.If(function() {                                                                                  // 74
    return Spacebars.call(view.lookup("hasIcon"));                                                                     // 75
  }, function() {                                                                                                      // 76
    return [ "\n      ", HTML.SPAN({                                                                                   // 77
      "class": function() {                                                                                            // 78
        return [ Spacebars.mustache(view.lookup("iconClass")), " form-control-feedback" ];                             // 79
      }                                                                                                                // 80
    }), "\n    " ];                                                                                                    // 81
  }), "\n    ", HTML.SPAN({                                                                                            // 82
    "class": function() {                                                                                              // 83
      return [ "help-block ", Blaze.Unless(function() {                                                                // 84
        return Spacebars.call(view.lookup("hasError"));                                                                // 85
      }, function() {                                                                                                  // 86
        return "hide";                                                                                                 // 87
      }) ];                                                                                                            // 88
    }                                                                                                                  // 89
  }, Blaze.View("lookup:errorText", function() {                                                                       // 90
    return Spacebars.mustache(view.lookup("errorText"));                                                               // 91
  })), "\n  ");                                                                                                        // 92
}));                                                                                                                   // 93
                                                                                                                       // 94
Template.__checkName("atCheckboxInput");                                                                               // 95
Template["atCheckboxInput"] = new Template("Template.atCheckboxInput", (function() {                                   // 96
  var view = this;                                                                                                     // 97
  return HTML.DIV({                                                                                                    // 98
    "class": "at-input checkbox"                                                                                       // 99
  }, "\n    ", HTML.LABEL({                                                                                            // 100
    "for": function() {                                                                                                // 101
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 102
    }                                                                                                                  // 103
  }, "\n      ", HTML.INPUT(HTML.Attrs({                                                                               // 104
    type: function() {                                                                                                 // 105
      return Spacebars.mustache(view.lookup("type"));                                                                  // 106
    },                                                                                                                 // 107
    id: function() {                                                                                                   // 108
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 109
    },                                                                                                                 // 110
    name: function() {                                                                                                 // 111
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 112
    }                                                                                                                  // 113
  }, function() {                                                                                                      // 114
    return Spacebars.attrMustache(view.lookup("disabled"));                                                            // 115
  })), "\n      ", Blaze.View("lookup:displayName", function() {                                                       // 116
    return Spacebars.mustache(view.lookup("displayName"));                                                             // 117
  }), "\n    "), "\n  ");                                                                                              // 118
}));                                                                                                                   // 119
                                                                                                                       // 120
Template.__checkName("atSelectInput");                                                                                 // 121
Template["atSelectInput"] = new Template("Template.atSelectInput", (function() {                                       // 122
  var view = this;                                                                                                     // 123
  return HTML.DIV({                                                                                                    // 124
    "class": "at-input field"                                                                                          // 125
  }, "\n    ", HTML.LABEL(Blaze.View("lookup:displayName", function() {                                                // 126
    return Spacebars.mustache(view.lookup("displayName"));                                                             // 127
  })), "\n    ", HTML.SELECT({                                                                                         // 128
    "class": "form-control",                                                                                           // 129
    id: function() {                                                                                                   // 130
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 131
    },                                                                                                                 // 132
    name: function() {                                                                                                 // 133
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 134
    }                                                                                                                  // 135
  }, "\n      ", Blaze.Each(function() {                                                                               // 136
    return Spacebars.call(view.lookup("values"));                                                                      // 137
  }, function() {                                                                                                      // 138
    return [ "\n        ", HTML.OPTION({                                                                               // 139
      value: function() {                                                                                              // 140
        return Spacebars.mustache(view.lookup("value"));                                                               // 141
      }                                                                                                                // 142
    }, Blaze.View("lookup:text", function() {                                                                          // 143
      return Spacebars.mustache(view.lookup("text"));                                                                  // 144
    })), "\n      " ];                                                                                                 // 145
  }), "\n    "), "\n  ");                                                                                              // 146
}));                                                                                                                   // 147
                                                                                                                       // 148
Template.__checkName("atRadioInput");                                                                                  // 149
Template["atRadioInput"] = new Template("Template.atRadioInput", (function() {                                         // 150
  var view = this;                                                                                                     // 151
  return HTML.DIV({                                                                                                    // 152
    "class": "at-input form-group"                                                                                     // 153
  }, "\n    ", HTML.LABEL(Blaze.View("lookup:displayName", function() {                                                // 154
    return Spacebars.mustache(view.lookup("displayName"));                                                             // 155
  })), "\n    ", Blaze.Each(function() {                                                                               // 156
    return Spacebars.call(view.lookup("values"));                                                                      // 157
  }, function() {                                                                                                      // 158
    return [ "\n      ", HTML.DIV({                                                                                    // 159
      "class": "at-input radio"                                                                                        // 160
    }, "\n        ", HTML.LABEL({                                                                                      // 161
      "for": function() {                                                                                              // 162
        return [ "at-field-", Spacebars.mustache(view.lookup("id")), "-choice-", Spacebars.mustache(view.lookup("value")) ];
      }                                                                                                                // 164
    }, "\n          ", HTML.INPUT({                                                                                    // 165
      id: function() {                                                                                                 // 166
        return [ "at-field-", Spacebars.mustache(view.lookup("id")), "-choice-", Spacebars.mustache(view.lookup("value")) ];
      },                                                                                                               // 168
      type: "radio",                                                                                                   // 169
      name: function() {                                                                                               // 170
        return [ "at-field-", Spacebars.mustache(view.lookup("id")) ];                                                 // 171
      },                                                                                                               // 172
      value: function() {                                                                                              // 173
        return Spacebars.mustache(view.lookup("value"));                                                               // 174
      }                                                                                                                // 175
    }), "\n          ", Blaze.View("lookup:text", function() {                                                         // 176
      return Spacebars.mustache(view.lookup("text"));                                                                  // 177
    }), "\n        "), "\n      "), "\n    " ];                                                                        // 178
  }), "\n  ");                                                                                                         // 179
}));                                                                                                                   // 180
                                                                                                                       // 181
Template.__checkName("atHiddenInput");                                                                                 // 182
Template["atHiddenInput"] = new Template("Template.atHiddenInput", (function() {                                       // 183
  var view = this;                                                                                                     // 184
  return HTML.INPUT({                                                                                                  // 185
    type: "hidden",                                                                                                    // 186
    id: function() {                                                                                                   // 187
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 188
    },                                                                                                                 // 189
    name: function() {                                                                                                 // 190
      return [ "at-field-", Spacebars.mustache(view.lookup("_id")) ];                                                  // 191
    }                                                                                                                  // 192
  });                                                                                                                  // 193
}));                                                                                                                   // 194
                                                                                                                       // 195
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_input.js                                                                     //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
_.each(AccountsTemplates.atInputRendered, function(callback){                                                          // 1
  Template.atInput.onRendered(callback);                                                                               // 2
  Template.atHiddenInput.onRendered(callback);                                                                         // 3
});                                                                                                                    // 4
                                                                                                                       // 5
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 6
Template.atInput.helpers(AccountsTemplates.atInputHelpers);                                                            // 7
                                                                                                                       // 8
// Simply 'inherites' events from AccountsTemplates                                                                    // 9
Template.atInput.events(AccountsTemplates.atInputEvents);                                                              // 10
                                                                                                                       // 11
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 12
Template.atTextInput.helpers(AccountsTemplates.atInputHelpers);                                                        // 13
                                                                                                                       // 14
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 15
Template.atCheckboxInput.helpers(AccountsTemplates.atInputHelpers);                                                    // 16
                                                                                                                       // 17
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 18
Template.atSelectInput.helpers(AccountsTemplates.atInputHelpers);                                                      // 19
                                                                                                                       // 20
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 21
Template.atRadioInput.helpers(AccountsTemplates.atInputHelpers);                                                       // 22
                                                                                                                       // 23
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 24
Template.atHiddenInput.helpers(AccountsTemplates.atInputHelpers);                                                      // 25
                                                                                                                       // 26
                                                                                                                       // 27
// Sets up default Bootstrap icon classes for social button icons                                                      // 28
AccountsTemplates.configure({                                                                                          // 29
    texts: {                                                                                                           // 30
        inputIcons: {                                                                                                  // 31
            isValidating: "glyphicon glyphicon-refresh",                                                               // 32
            hasError: "glyphicon glyphicon-remove",                                                                    // 33
            hasSuccess: "glyphicon glyphicon-ok",                                                                      // 34
        }                                                                                                              // 35
    },                                                                                                                 // 36
});                                                                                                                    // 37
                                                                                                                       // 38
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_message.js                                                          //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atMessage");                                                                                     // 2
Template["atMessage"] = new Template("Template.atMessage", (function() {                                               // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-message alert alert-info"                                                                             // 6
  }, "\n    ", Blaze.View("lookup:message", function() {                                                               // 7
    return Spacebars.mustache(view.lookup("message"));                                                                 // 8
  }), "\n  ");                                                                                                         // 9
}));                                                                                                                   // 10
                                                                                                                       // 11
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_message.js                                                                   //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atMessage.helpers(AccountsTemplates.atMessageHelpers);                                                        // 2
                                                                                                                       // 3
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_nav_button.js                                                       //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atNavButton");                                                                                   // 2
Template["atNavButton"] = new Template("Template.atNavButton", (function() {                                           // 3
  var view = this;                                                                                                     // 4
  return HTML.BUTTON({                                                                                                 // 5
    type: "button",                                                                                                    // 6
    id: "at-nav-button",                                                                                               // 7
    "class": "btn btn-default navbar-btn"                                                                              // 8
  }, Blaze.View("lookup:text", function() {                                                                            // 9
    return Spacebars.mustache(view.lookup("text"));                                                                    // 10
  }));                                                                                                                 // 11
}));                                                                                                                   // 12
                                                                                                                       // 13
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_nav_button.js                                                                //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atNavButton.helpers(AccountsTemplates.atNavButtonHelpers);                                                    // 2
                                                                                                                       // 3
// Simply 'inherites' events from AccountsTemplates                                                                    // 4
Template.atNavButton.events(AccountsTemplates.atNavButtonEvents);                                                      // 5
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_oauth.js                                                            //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atOauth");                                                                                       // 2
Template["atOauth"] = new Template("Template.atOauth", (function() {                                                   // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-oauth"                                                                                                // 6
  }, "\n    ", Blaze.Each(function() {                                                                                 // 7
    return Spacebars.call(view.lookup("oauthService"));                                                                // 8
  }, function() {                                                                                                      // 9
    return [ "\n      ", Spacebars.include(view.lookupTemplate("atSocial")), "\n    " ];                               // 10
  }), "\n  ");                                                                                                         // 11
}));                                                                                                                   // 12
                                                                                                                       // 13
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_oauth.js                                                                     //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atOauth.helpers(AccountsTemplates.atOauthHelpers);                                                            // 2
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_pwd_form.js                                                         //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atPwdForm");                                                                                     // 2
Template["atPwdForm"] = new Template("Template.atPwdForm", (function() {                                               // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-pwd-form"                                                                                             // 6
  }, "\n    ", HTML.FORM({                                                                                             // 7
    role: "form",                                                                                                      // 8
    id: "at-pwd-form",                                                                                                 // 9
    novalidate: "",                                                                                                    // 10
    action: "#",                                                                                                       // 11
    method: "POST"                                                                                                     // 12
  }, "\n      ", HTML.FIELDSET(HTML.Attrs(function() {                                                                 // 13
    return Spacebars.attrMustache(view.lookup("disabled"));                                                            // 14
  }), "\n        ", Blaze.Each(function() {                                                                            // 15
    return Spacebars.call(view.lookup("fields"));                                                                      // 16
  }, function() {                                                                                                      // 17
    return [ "\n          ", Spacebars.include(view.lookupTemplate("atInput")), "\n        " ];                        // 18
  }), "\n        ", Blaze.If(function() {                                                                              // 19
    return Spacebars.call(view.lookup("showReCaptcha"));                                                               // 20
  }, function() {                                                                                                      // 21
    return [ "\n          ", Spacebars.include(view.lookupTemplate("atReCaptcha")), "\n        " ];                    // 22
  }), "\n        ", Blaze.If(function() {                                                                              // 23
    return Spacebars.call(view.lookup("showForgotPasswordLink"));                                                      // 24
  }, function() {                                                                                                      // 25
    return [ "\n          ", Spacebars.include(view.lookupTemplate("atPwdLink")), "\n        " ];                      // 26
  }), "\n        ", Spacebars.include(view.lookupTemplate("atPwdFormBtn")), "\n      "), "\n    "), "\n  ");           // 27
}));                                                                                                                   // 28
                                                                                                                       // 29
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_pwd_form.js                                                                  //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherits' helpers from AccountsTemplates                                                                    // 1
Template.atPwdForm.helpers(AccountsTemplates.atPwdFormHelpers);                                                        // 2
                                                                                                                       // 3
// Simply 'inherits' events from AccountsTemplates                                                                     // 4
Template.atPwdForm.events(AccountsTemplates.atPwdFormEvents);                                                          // 5
                                                                                                                       // 6
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_pwd_form_btn.js                                                     //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atPwdFormBtn");                                                                                  // 2
Template["atPwdFormBtn"] = new Template("Template.atPwdFormBtn", (function() {                                         // 3
  var view = this;                                                                                                     // 4
  return HTML.BUTTON({                                                                                                 // 5
    type: "submit",                                                                                                    // 6
    "class": function() {                                                                                              // 7
      return [ "at-btn submit btn btn-lg btn-block btn-default ", Spacebars.mustache(view.lookup("submitDisabled")) ];
    },                                                                                                                 // 9
    id: "at-btn"                                                                                                       // 10
  }, "\n    ", Blaze.View("lookup:buttonText", function() {                                                            // 11
    return Spacebars.mustache(view.lookup("buttonText"));                                                              // 12
  }), "\n  ");                                                                                                         // 13
}));                                                                                                                   // 14
                                                                                                                       // 15
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_pwd_form_btn.js                                                              //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atPwdFormBtn.helpers(AccountsTemplates.atPwdFormBtnHelpers);                                                  // 2
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_pwd_link.js                                                         //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atPwdLink");                                                                                     // 2
Template["atPwdLink"] = new Template("Template.atPwdLink", (function() {                                               // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-pwd-link"                                                                                             // 6
  }, "\n    ", HTML.P("\n      ", Blaze.View("lookup:preText", function() {                                            // 7
    return Spacebars.mustache(view.lookup("preText"));                                                                 // 8
  }), "\n      ", HTML.A({                                                                                             // 9
    href: function() {                                                                                                 // 10
      return Spacebars.mustache(view.lookup("forgotPwdLink"));                                                         // 11
    },                                                                                                                 // 12
    id: "at-forgotPwd",                                                                                                // 13
    "class": function() {                                                                                              // 14
      return [ "at-link at-pwd ", Spacebars.mustache(view.lookup("disabled")) ];                                       // 15
    }                                                                                                                  // 16
  }, Blaze.View("lookup:linkText", function() {                                                                        // 17
    return Spacebars.mustache(view.lookup("linkText"));                                                                // 18
  })), "\n      ", Blaze.View("lookup:suffText", function() {                                                          // 19
    return Spacebars.mustache(view.lookup("suffText"));                                                                // 20
  }), "\n    "), "\n  ");                                                                                              // 21
}));                                                                                                                   // 22
                                                                                                                       // 23
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_pwd_link.js                                                                  //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atPwdLink.helpers(AccountsTemplates.atPwdLinkHelpers);                                                        // 2
                                                                                                                       // 3
// Simply 'inherites' events from AccountsTemplates                                                                    // 4
Template.atPwdLink.events(AccountsTemplates.atPwdLinkEvents);                                                          // 5
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_reCaptcha.js                                                        //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atReCaptcha");                                                                                   // 2
Template["atReCaptcha"] = new Template("Template.atReCaptcha", (function() {                                           // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "g-recaptcha",                                                                                            // 6
    "data-sitekey": function() {                                                                                       // 7
      return Spacebars.mustache(view.lookup("key"));                                                                   // 8
    },                                                                                                                 // 9
    "data-theme": function() {                                                                                         // 10
      return Spacebars.mustache(view.lookup("theme"));                                                                 // 11
    },                                                                                                                 // 12
    "data-type": function() {                                                                                          // 13
      return Spacebars.mustache(view.lookup("data_type"));                                                             // 14
    }                                                                                                                  // 15
  });                                                                                                                  // 16
}));                                                                                                                   // 17
                                                                                                                       // 18
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_reCaptcha.js                                                                 //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' rendered callback from AccountsTemplates                                                         // 1
Template.atReCaptcha.rendered = AccountsTemplates.atReCaptchaRendered;                                                 // 2
                                                                                                                       // 3
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 4
Template.atReCaptcha.helpers(AccountsTemplates.atReCaptchaHelpers);                                                    // 5
                                                                                                                       // 6
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_result.js                                                           //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atResult");                                                                                      // 2
Template["atResult"] = new Template("Template.atResult", (function() {                                                 // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-result alert alert-success"                                                                           // 6
  }, "\n    ", Blaze.View("lookup:result", function() {                                                                // 7
    return Spacebars.mustache(view.lookup("result"));                                                                  // 8
  }), "\n  ");                                                                                                         // 9
}));                                                                                                                   // 10
                                                                                                                       // 11
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_result.js                                                                    //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atResult.helpers(AccountsTemplates.atResultHelpers);                                                          // 2
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_sep.js                                                              //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atSep");                                                                                         // 2
Template["atSep"] = new Template("Template.atSep", (function() {                                                       // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-sep"                                                                                                  // 6
  }, "\n    ", HTML.STRONG(Blaze.View("lookup:sepText", function() {                                                   // 7
    return Spacebars.mustache(view.lookup("sepText"));                                                                 // 8
  })), "\n  ");                                                                                                        // 9
}));                                                                                                                   // 10
                                                                                                                       // 11
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_sep.js                                                                       //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atSep.helpers(AccountsTemplates.atSepHelpers);                                                                // 2
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_signin_link.js                                                      //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atSigninLink");                                                                                  // 2
Template["atSigninLink"] = new Template("Template.atSigninLink", (function() {                                         // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-signin-link"                                                                                          // 6
  }, "\n    ", HTML.P("\n      ", Blaze.View("lookup:preText", function() {                                            // 7
    return Spacebars.mustache(view.lookup("preText"));                                                                 // 8
  }), "\n      ", HTML.A({                                                                                             // 9
    href: function() {                                                                                                 // 10
      return Spacebars.mustache(view.lookup("signInLink"));                                                            // 11
    },                                                                                                                 // 12
    id: "at-signIn",                                                                                                   // 13
    "class": function() {                                                                                              // 14
      return [ "at-link at-signin ", Spacebars.mustache(view.lookup("disabled")) ];                                    // 15
    }                                                                                                                  // 16
  }, Blaze.View("lookup:linkText", function() {                                                                        // 17
    return Spacebars.mustache(view.lookup("linkText"));                                                                // 18
  })), "\n      ", Blaze.View("lookup:suffText", function() {                                                          // 19
    return Spacebars.mustache(view.lookup("suffText"));                                                                // 20
  }), "\n    "), "\n  ");                                                                                              // 21
}));                                                                                                                   // 22
                                                                                                                       // 23
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_signin_link.js                                                               //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atSigninLink.helpers(AccountsTemplates.atSigninLinkHelpers);                                                  // 2
                                                                                                                       // 3
// Simply 'inherites' events from AccountsTemplates                                                                    // 4
Template.atSigninLink.events(AccountsTemplates.atSigninLinkEvents);                                                    // 5
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_signup_link.js                                                      //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atSignupLink");                                                                                  // 2
Template["atSignupLink"] = new Template("Template.atSignupLink", (function() {                                         // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-signup-link"                                                                                          // 6
  }, "\n    ", HTML.P("\n      ", Blaze.View("lookup:preText", function() {                                            // 7
    return Spacebars.mustache(view.lookup("preText"));                                                                 // 8
  }), "\n      ", HTML.A({                                                                                             // 9
    href: function() {                                                                                                 // 10
      return Spacebars.mustache(view.lookup("signUpLink"));                                                            // 11
    },                                                                                                                 // 12
    id: "at-signUp",                                                                                                   // 13
    "class": function() {                                                                                              // 14
      return [ "at-link at-signup ", Spacebars.mustache(view.lookup("disabled")) ];                                    // 15
    }                                                                                                                  // 16
  }, Blaze.View("lookup:linkText", function() {                                                                        // 17
    return Spacebars.mustache(view.lookup("linkText"));                                                                // 18
  })), "\n      ", Blaze.View("lookup:suffText", function() {                                                          // 19
    return Spacebars.mustache(view.lookup("suffText"));                                                                // 20
  }), "\n    "), "\n  ");                                                                                              // 21
}));                                                                                                                   // 22
                                                                                                                       // 23
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_signup_link.js                                                               //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atSignupLink.helpers(AccountsTemplates.atSignupLinkHelpers);                                                  // 2
                                                                                                                       // 3
// Simply 'inherites' events from AccountsTemplates                                                                    // 4
Template.atSignupLink.events(AccountsTemplates.atSignupLinkEvents);                                                    // 5
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_social.js                                                           //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atSocial");                                                                                      // 2
Template["atSocial"] = new Template("Template.atSocial", (function() {                                                 // 3
  var view = this;                                                                                                     // 4
  return HTML.BUTTON({                                                                                                 // 5
    "class": function() {                                                                                              // 6
      return [ "btn at-social-btn ", Spacebars.mustache(view.lookup("disabled")) ];                                    // 7
    },                                                                                                                 // 8
    id: function() {                                                                                                   // 9
      return [ "at-", Spacebars.mustache(view.lookup("name")) ];                                                       // 10
    },                                                                                                                 // 11
    name: function() {                                                                                                 // 12
      return Spacebars.mustache(view.lookup("name"));                                                                  // 13
    }                                                                                                                  // 14
  }, "\n    ", HTML.I({                                                                                                // 15
    "class": function() {                                                                                              // 16
      return Spacebars.mustache(view.lookup("iconClass"));                                                             // 17
    }                                                                                                                  // 18
  }), " ", Blaze.View("lookup:buttonText", function() {                                                                // 19
    return Spacebars.mustache(view.lookup("buttonText"));                                                              // 20
  }), "\n  ");                                                                                                         // 21
}));                                                                                                                   // 22
                                                                                                                       // 23
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_social.js                                                                    //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atSocial.helpers(AccountsTemplates.atSocialHelpers);                                                          // 2
                                                                                                                       // 3
// Simply 'inherites' events from AccountsTemplates                                                                    // 4
Template.atSocial.events(AccountsTemplates.atSocialEvents);                                                            // 5
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_terms_link.js                                                       //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atTermsLink");                                                                                   // 2
Template["atTermsLink"] = new Template("Template.atTermsLink", (function() {                                           // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-terms-link at-wrap"                                                                                   // 6
  }, "\n    ", HTML.P("\n      ", Blaze.View("lookup:text", function() {                                               // 7
    return Spacebars.mustache(view.lookup("text"));                                                                    // 8
  }), "\n      ", Blaze.If(function() {                                                                                // 9
    return Spacebars.call(view.lookup("privacyUrl"));                                                                  // 10
  }, function() {                                                                                                      // 11
    return [ "\n        ", HTML.A({                                                                                    // 12
      href: function() {                                                                                               // 13
        return Spacebars.mustache(view.lookup("privacyUrl"));                                                          // 14
      },                                                                                                               // 15
      "class": function() {                                                                                            // 16
        return Spacebars.mustache(view.lookup("disabled"));                                                            // 17
      }                                                                                                                // 18
    }, Blaze.View("lookup:privacyLinkText", function() {                                                               // 19
      return Spacebars.mustache(view.lookup("privacyLinkText"));                                                       // 20
    })), "\n      " ];                                                                                                 // 21
  }), "\n      ", Blaze.If(function() {                                                                                // 22
    return Spacebars.call(view.lookup("showTermsAnd"));                                                                // 23
  }, function() {                                                                                                      // 24
    return [ "\n        ", Blaze.View("lookup:and", function() {                                                       // 25
      return Spacebars.mustache(view.lookup("and"));                                                                   // 26
    }), "\n      " ];                                                                                                  // 27
  }), "\n      ", Blaze.If(function() {                                                                                // 28
    return Spacebars.call(view.lookup("termsUrl"));                                                                    // 29
  }, function() {                                                                                                      // 30
    return [ "\n        ", HTML.A({                                                                                    // 31
      href: function() {                                                                                               // 32
        return Spacebars.mustache(view.lookup("termsUrl"));                                                            // 33
      },                                                                                                               // 34
      "class": function() {                                                                                            // 35
        return Spacebars.mustache(view.lookup("disabled"));                                                            // 36
      }                                                                                                                // 37
    }, Blaze.View("lookup:termsLinkText", function() {                                                                 // 38
      return Spacebars.mustache(view.lookup("termsLinkText"));                                                         // 39
    })), "\n      " ];                                                                                                 // 40
  }), "\n    "), "\n  ");                                                                                              // 41
}));                                                                                                                   // 42
                                                                                                                       // 43
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_terms_link.js                                                                //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atTermsLink.helpers(AccountsTemplates.atTermsLinkHelpers);                                                    // 2
                                                                                                                       // 3
// Simply 'inherites' events from AccountsTemplates                                                                    // 4
Template.atTermsLink.events(AccountsTemplates.atTermsLinkEvents);                                                      // 5
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_resend_verification_email_link.js                                   //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atResendVerificationEmailLink");                                                                 // 2
Template["atResendVerificationEmailLink"] = new Template("Template.atResendVerificationEmailLink", (function() {       // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-resend-verification-email-link at-wrap"                                                               // 6
  }, "\n    ", HTML.P("\n      ", Blaze.View("lookup:preText", function() {                                            // 7
    return Spacebars.mustache(view.lookup("preText"));                                                                 // 8
  }), "\n      ", HTML.A({                                                                                             // 9
    href: function() {                                                                                                 // 10
      return Spacebars.mustache(view.lookup("resendVerificationEmailLink"));                                           // 11
    },                                                                                                                 // 12
    id: "at-resend-verification-email",                                                                                // 13
    "class": function() {                                                                                              // 14
      return [ "at-link at-resend-verification-email ", Spacebars.mustache(view.lookup("disabled")) ];                 // 15
    }                                                                                                                  // 16
  }, Blaze.View("lookup:linkText", function() {                                                                        // 17
    return Spacebars.mustache(view.lookup("linkText"));                                                                // 18
  })), "\n      ", Blaze.View("lookup:suffText", function() {                                                          // 19
    return Spacebars.mustache(view.lookup("suffText"));                                                                // 20
  }), "\n    "), "\n  ");                                                                                              // 21
}));                                                                                                                   // 22
                                                                                                                       // 23
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_resend_verification_email_link.js                                            //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atResendVerificationEmailLink.helpers(AccountsTemplates.atResendVerificationEmailLinkHelpers);                // 2
                                                                                                                       // 3
// Simply 'inherites' events from AccountsTemplates                                                                    // 4
Template.atResendVerificationEmailLink.events(AccountsTemplates.atResendVerificationEmailLinkEvents);                  // 5
                                                                                                                       // 6
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.at_title.js                                                            //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("atTitle");                                                                                       // 2
Template["atTitle"] = new Template("Template.atTitle", (function() {                                                   // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "at-title"                                                                                                // 6
  }, "\n    ", HTML.H3(Blaze.View("lookup:title", function() {                                                         // 7
    return Spacebars.mustache(view.lookup("title"));                                                                   // 8
  })), "\n  ");                                                                                                        // 9
}));                                                                                                                   // 10
                                                                                                                       // 11
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/at_title.js                                                                     //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
// Simply 'inherites' helpers from AccountsTemplates                                                                   // 1
Template.atTitle.helpers(AccountsTemplates.atTitleHelpers);                                                            // 2
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                     //
// packages/useraccounts_bootstrap/lib/template.full_page_at_form.js                                                   //
//                                                                                                                     //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                       //
                                                                                                                       // 1
Template.__checkName("fullPageAtForm");                                                                                // 2
Template["fullPageAtForm"] = new Template("Template.fullPageAtForm", (function() {                                     // 3
  var view = this;                                                                                                     // 4
  return HTML.DIV({                                                                                                    // 5
    "class": "container"                                                                                               // 6
  }, "\n    ", HTML.DIV({                                                                                              // 7
    "class": "row"                                                                                                     // 8
  }, "\n      ", HTML.DIV({                                                                                            // 9
    "class": "col-md-6 col-md-offset-3"                                                                                // 10
  }, "\n        ", Spacebars.include(view.lookupTemplate("atForm")), "\n      "), "\n    "), "\n  ");                  // 11
}));                                                                                                                   // 12
                                                                                                                       // 13
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
Package['useraccounts:bootstrap'] = {};

})();
