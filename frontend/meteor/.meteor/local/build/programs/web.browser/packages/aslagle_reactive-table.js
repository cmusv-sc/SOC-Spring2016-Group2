(function () {

/* Imports */
var Meteor = Package.meteor.Meteor;
var global = Package.meteor.global;
var meteorEnv = Package.meteor.meteorEnv;
var Template = Package.templating.Template;
var $ = Package.jquery.$;
var jQuery = Package.jquery.jQuery;
var _ = Package.underscore._;
var Tracker = Package.tracker.Tracker;
var Deps = Package.tracker.Deps;
var ReactiveVar = Package['reactive-var'].ReactiveVar;
var i18n = Package['anti:i18n'].i18n;
var Mongo = Package.mongo.Mongo;
var Blaze = Package.blaze.Blaze;
var UI = Package.blaze.UI;
var Handlebars = Package.blaze.Handlebars;
var Spacebars = Package.spacebars.Spacebars;
var HTML = Package.htmljs.HTML;

/* Package-scope variables */
var get, oldField, sortedRows, normalizeSort, getSortedFields, getSortQuery, sortWithFunctions, getPrimarySortField, changePrimarySort, getFilterQuery, ReactiveTable, dependOnFilters, getFilterStrings, getFilterFields;

(function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// packages/aslagle_reactive-table/lib/template.reactive_table.js                                                    //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     // 1
Template.__checkName("reactiveTable");                                                                               // 2
Template["reactiveTable"] = new Template("Template.reactiveTable", (function() {                                     // 3
  var view = this;                                                                                                   // 4
  return Spacebars.With(function() {                                                                                 // 5
    return Spacebars.call(view.lookup("context"));                                                                   // 6
  }, function() {                                                                                                    // 7
    return [ "\n  ", Blaze.If(function() {                                                                           // 8
      return Spacebars.call(view.lookup("ready"));                                                                   // 9
    }, function() {                                                                                                  // 10
      return [ "\n    ", HTML.DIV({                                                                                  // 11
        "class": "clearfix"                                                                                          // 12
      }, "\n      ", HTML.DIV({                                                                                      // 13
        "class": "reactive-table-options col-sm-8 pull-right"                                                        // 14
      }, "\n        ", Blaze.If(function() {                                                                         // 15
        return Spacebars.call(view.lookup("showFilter"));                                                            // 16
      }, function() {                                                                                                // 17
        return [ "\n          ", HTML.DIV({                                                                          // 18
          "class": "reactive-table-filter form-group col-sm-8 pull-right"                                            // 19
        }, "\n            ", Blaze._TemplateWith(function() {                                                        // 20
          return {                                                                                                   // 21
            id: Spacebars.call(view.lookup("getFilterId")),                                                          // 22
            useFontAwesome: Spacebars.call(view.lookup("useFontAwesome"))                                            // 23
          };                                                                                                         // 24
        }, function() {                                                                                              // 25
          return Spacebars.include(view.lookupTemplate("reactiveTableFilter"));                                      // 26
        }), "\n          "), "\n        " ];                                                                         // 27
      }), "\n        ", Blaze.If(function() {                                                                        // 28
        return Spacebars.call(view.lookup("showColumnToggles"));                                                     // 29
      }, function() {                                                                                                // 30
        return [ "\n          ", HTML.DIV({                                                                          // 31
          "class": "reactive-table-columns-dropdown col-sm-4 pull-right"                                             // 32
        }, "\n            ", HTML.BUTTON({                                                                           // 33
          "class": "btn btn-default dropdown-toggle",                                                                // 34
          id: function() {                                                                                           // 35
            return [ "reactive-table-add-column-", Spacebars.mustache(view.lookup("id")) ];                          // 36
          },                                                                                                         // 37
          "data-toggle": "dropdown"                                                                                  // 38
        }, "\n              ", Blaze.View("lookup:i18n", function() {                                                // 39
          return Spacebars.mustache(view.lookup("i18n"), "reactiveTable.columns");                                   // 40
        }), "\n            "), "\n            ", HTML.UL({                                                           // 41
          "class": "dropdown-menu dropdown-menu-right",                                                              // 42
          role: "menu",                                                                                              // 43
          "aria-labelledby": function() {                                                                            // 44
            return [ "reactive-table-add-column-", Spacebars.mustache(view.lookup("id")) ];                          // 45
          }                                                                                                          // 46
        }, "\n              ", Blaze.Each(function() {                                                               // 47
          return Spacebars.call(view.lookup("fields"));                                                              // 48
        }, function() {                                                                                              // 49
          return [ "\n                ", Blaze.Unless(function() {                                                   // 50
            return Spacebars.call(view.lookup("hideToggle"));                                                        // 51
          }, function() {                                                                                            // 52
            return [ "\n                  ", HTML.LI({                                                               // 53
              role: "presentation"                                                                                   // 54
            }, HTML.A({                                                                                              // 55
              role: "menuitem",                                                                                      // 56
              tabindex: "-1",                                                                                        // 57
              "data-target": "#"                                                                                     // 58
            }, "\n                    ", Blaze.If(function() {                                                       // 59
              return Spacebars.call(view.lookup("isVisible"));                                                       // 60
            }, function() {                                                                                          // 61
              return [ "\n                      ", HTML.INPUT({                                                      // 62
                type: "checkbox",                                                                                    // 63
                checked: "",                                                                                         // 64
                "data-fieldid": function() {                                                                         // 65
                  return Spacebars.mustache(view.lookup("fieldId"));                                                 // 66
                }                                                                                                    // 67
              }), "\n                    " ];                                                                        // 68
            }, function() {                                                                                          // 69
              return [ "\n                      ", HTML.INPUT({                                                      // 70
                type: "checkbox",                                                                                    // 71
                "data-fieldid": function() {                                                                         // 72
                  return Spacebars.mustache(view.lookup("fieldId"));                                                 // 73
                }                                                                                                    // 74
              }), "\n                    " ];                                                                        // 75
            }), "\n                    ", HTML.LABEL("\n                      ", Blaze.If(function() {               // 76
              return Spacebars.call(view.lookup("labelIsTemplate"));                                                 // 77
            }, function() {                                                                                          // 78
              return Spacebars.With(function() {                                                                     // 79
                return Spacebars.call(view.lookup("labelData"));                                                     // 80
              }, function() {                                                                                        // 81
                return Spacebars.include(function() {                                                                // 82
                  return Spacebars.call(Spacebars.dot(view.lookup(".."), "label"));                                  // 83
                });                                                                                                  // 84
              }, function() {                                                                                        // 85
                return Spacebars.include(view.lookupTemplate("label"));                                              // 86
              });                                                                                                    // 87
            }, function() {                                                                                          // 88
              return Blaze.View("lookup:getLabel", function() {                                                      // 89
                return Spacebars.mustache(view.lookup("getLabel"));                                                  // 90
              });                                                                                                    // 91
            }), "\n                    "), "\n                  ")), "\n                " ];                         // 92
          }), "\n              " ];                                                                                  // 93
        }), "\n            "), "\n          "), "\n        " ];                                                      // 94
      }), "\n      "), "\n    "), "\n    ", Blaze.Unless(function() {                                                // 95
        return Spacebars.call(view.lookup("noData"));                                                                // 96
      }, function() {                                                                                                // 97
        return [ "\n      ", HTML.TABLE({                                                                            // 98
          id: function() {                                                                                           // 99
            return Spacebars.mustache(view.lookup("id"));                                                            // 100
          },                                                                                                         // 101
          "class": function() {                                                                                      // 102
            return [ Spacebars.mustache(view.lookup("class")), " reactive-table" ];                                  // 103
          }                                                                                                          // 104
        }, "\n        ", HTML.THEAD("\n          ", HTML.TR("\n            ", Blaze.Each(function() {                // 105
          return Spacebars.call(view.lookup("fields"));                                                              // 106
        }, function() {                                                                                              // 107
          return [ "\n              ", Blaze.If(function() {                                                         // 108
            return Spacebars.call(view.lookup("isVisible"));                                                         // 109
          }, function() {                                                                                            // 110
            return [ "\n                ", Blaze.If(function() {                                                     // 111
              return Spacebars.call(view.lookup("isPrimarySortField"));                                              // 112
            }, function() {                                                                                          // 113
              return [ "\n                  ", HTML.TH({                                                             // 114
                "class": function() {                                                                                // 115
                  return [ Blaze.If(function() {                                                                     // 116
                    return Spacebars.call(view.lookup("isSortable"));                                                // 117
                  }, function() {                                                                                    // 118
                    return "sortable ";                                                                              // 119
                  }), Spacebars.mustache(view.lookup("getHeaderClass")) ];                                           // 120
                },                                                                                                   // 121
                fieldid: function() {                                                                                // 122
                  return Spacebars.mustache(view.lookup("getFieldFieldId"));                                         // 123
                }                                                                                                    // 124
              }, "\n                    ", Blaze.If(function() {                                                     // 125
                return Spacebars.call(view.lookup("labelIsTemplate"));                                               // 126
              }, function() {                                                                                        // 127
                return Spacebars.With(function() {                                                                   // 128
                  return Spacebars.call(view.lookup("labelData"));                                                   // 129
                }, function() {                                                                                      // 130
                  return Spacebars.include(function() {                                                              // 131
                    return Spacebars.call(Spacebars.dot(view.lookup(".."), "label"));                                // 132
                  });                                                                                                // 133
                }, function() {                                                                                      // 134
                  return Spacebars.include(view.lookupTemplate("label"));                                            // 135
                });                                                                                                  // 136
              }, function() {                                                                                        // 137
                return Blaze.View("lookup:getLabel", function() {                                                    // 138
                  return Spacebars.mustache(view.lookup("getLabel"));                                                // 139
                });                                                                                                  // 140
              }), HTML.CharRef({                                                                                     // 141
                html: "&nbsp;",                                                                                      // 142
                str: " "                                                                                             // 143
              }), HTML.CharRef({                                                                                     // 144
                html: "&nbsp;",                                                                                      // 145
                str: " "                                                                                             // 146
              }), "\n                    ", Blaze.If(function() {                                                    // 147
                return Spacebars.call(view.lookup("isAscending"));                                                   // 148
              }, function() {                                                                                        // 149
                return [ "\n                      ", Blaze.If(function() {                                           // 150
                  return Spacebars.call(Spacebars.dot(view.lookup(".."), "useFontAwesome"));                         // 151
                }, function() {                                                                                      // 152
                  return [ "\n                        ", HTML.I({                                                    // 153
                    "class": "fa fa-sort-asc"                                                                        // 154
                  }), "\n                      " ];                                                                  // 155
                }, function() {                                                                                      // 156
                  return [ "\n                        ", HTML.CharRef({                                              // 157
                    html: "&#x25B2;",                                                                                // 158
                    str: "▲"                                                                                         // 159
                  }), "\n                      " ];                                                                  // 160
                }), "\n                    " ];                                                                      // 161
              }, function() {                                                                                        // 162
                return [ "\n                      ", Blaze.If(function() {                                           // 163
                  return Spacebars.call(Spacebars.dot(view.lookup(".."), "useFontAwesome"));                         // 164
                }, function() {                                                                                      // 165
                  return [ "\n                        ", HTML.I({                                                    // 166
                    "class": "fa fa-sort-desc"                                                                       // 167
                  }), "\n                      " ];                                                                  // 168
                }, function() {                                                                                      // 169
                  return [ "\n                        ", HTML.CharRef({                                              // 170
                    html: "&#x25BC;",                                                                                // 171
                    str: "▼"                                                                                         // 172
                  }), "\n                      " ];                                                                  // 173
                }), "\n                    " ];                                                                      // 174
              }), "\n                  "), "\n                " ];                                                   // 175
            }, function() {                                                                                          // 176
              return [ "\n                  ", Blaze.If(function() {                                                 // 177
                return Spacebars.call(view.lookup("isSortable"));                                                    // 178
              }, function() {                                                                                        // 179
                return [ "\n                    ", HTML.TH({                                                         // 180
                  "class": function() {                                                                              // 181
                    return [ Spacebars.mustache(view.lookup("getHeaderClass")), " sortable" ];                       // 182
                  },                                                                                                 // 183
                  fieldid: function() {                                                                              // 184
                    return Spacebars.mustache(view.lookup("getFieldFieldId"));                                       // 185
                  }                                                                                                  // 186
                }, Blaze.If(function() {                                                                             // 187
                  return Spacebars.call(view.lookup("labelIsTemplate"));                                             // 188
                }, function() {                                                                                      // 189
                  return Spacebars.With(function() {                                                                 // 190
                    return Spacebars.call(view.lookup("labelData"));                                                 // 191
                  }, function() {                                                                                    // 192
                    return Spacebars.include(function() {                                                            // 193
                      return Spacebars.call(Spacebars.dot(view.lookup(".."), "label"));                              // 194
                    });                                                                                              // 195
                  }, function() {                                                                                    // 196
                    return Spacebars.include(view.lookupTemplate("label"));                                          // 197
                  });                                                                                                // 198
                }, function() {                                                                                      // 199
                  return Blaze.View("lookup:getLabel", function() {                                                  // 200
                    return Spacebars.mustache(view.lookup("getLabel"));                                              // 201
                  });                                                                                                // 202
                })), "\n                  " ];                                                                       // 203
              }, function() {                                                                                        // 204
                return [ "\n                    ", HTML.TH({                                                         // 205
                  "class": function() {                                                                              // 206
                    return Spacebars.mustache(view.lookup("getHeaderClass"));                                        // 207
                  },                                                                                                 // 208
                  fieldid: function() {                                                                              // 209
                    return Spacebars.mustache(view.lookup("getFieldFieldId"));                                       // 210
                  }                                                                                                  // 211
                }, Blaze.If(function() {                                                                             // 212
                  return Spacebars.call(view.lookup("labelIsTemplate"));                                             // 213
                }, function() {                                                                                      // 214
                  return Spacebars.With(function() {                                                                 // 215
                    return Spacebars.call(view.lookup("labelData"));                                                 // 216
                  }, function() {                                                                                    // 217
                    return Spacebars.include(function() {                                                            // 218
                      return Spacebars.call(Spacebars.dot(view.lookup(".."), "label"));                              // 219
                    });                                                                                              // 220
                  }, function() {                                                                                    // 221
                    return Spacebars.include(view.lookupTemplate("label"));                                          // 222
                  });                                                                                                // 223
                }, function() {                                                                                      // 224
                  return Blaze.View("lookup:getLabel", function() {                                                  // 225
                    return Spacebars.mustache(view.lookup("getLabel"));                                              // 226
                  });                                                                                                // 227
                })), "\n                  " ];                                                                       // 228
              }), "\n                " ];                                                                            // 229
            }), "\n              " ];                                                                                // 230
          }), "\n            " ];                                                                                    // 231
        }), "\n          "), "\n        "), "\n        ", HTML.TBODY("\n          ", Blaze.Each(function() {         // 232
          return Spacebars.call(view.lookup("sortedRows"));                                                          // 233
        }, function() {                                                                                              // 234
          return [ "\n            ", HTML.TR({                                                                       // 235
            "class": function() {                                                                                    // 236
              return Spacebars.mustache(Spacebars.dot(view.lookup(".."), "rowClass"), view.lookup("."));             // 237
            }                                                                                                        // 238
          }, "\n              ", Blaze.Each(function() {                                                             // 239
            return Spacebars.call(Spacebars.dot(view.lookup(".."), "fields"));                                       // 240
          }, function() {                                                                                            // 241
            return [ "\n                ", Blaze.If(function() {                                                     // 242
              return Spacebars.call(view.lookup("isVisible"));                                                       // 243
            }, function() {                                                                                          // 244
              return [ "\n                  ", HTML.TD({                                                             // 245
                "class": function() {                                                                                // 246
                  return Spacebars.mustache(view.lookup("getCellClass"), view.lookup(".."));                         // 247
                }                                                                                                    // 248
              }, Blaze.If(function() {                                                                               // 249
                return Spacebars.call(view.lookup("tmpl"));                                                          // 250
              }, function() {                                                                                        // 251
                return Spacebars.With(function() {                                                                   // 252
                  return Spacebars.call(view.lookup(".."));                                                          // 253
                }, function() {                                                                                      // 254
                  return Spacebars.include(function() {                                                              // 255
                    return Spacebars.call(Spacebars.dot(view.lookup(".."), "tmpl"));                                 // 256
                  });                                                                                                // 257
                });                                                                                                  // 258
              }, function() {                                                                                        // 259
                return Blaze.View("lookup:getField", function() {                                                    // 260
                  return Spacebars.mustache(view.lookup("getField"), view.lookup(".."));                             // 261
                });                                                                                                  // 262
              })), "\n                " ];                                                                           // 263
            }), "\n              " ];                                                                                // 264
          }), "\n            "), "\n          " ];                                                                   // 265
        }), "\n        "), "\n      "), "\n      ", Blaze.If(function() {                                            // 266
          return Spacebars.call(view.lookup("showNavigation"));                                                      // 267
        }, function() {                                                                                              // 268
          return [ "\n        ", HTML.DIV({                                                                          // 269
            "class": "reactive-table-navigation"                                                                     // 270
          }, "\n          ", Blaze.If(function() {                                                                   // 271
            return Spacebars.call(view.lookup("showNavigationRowsPerPage"));                                         // 272
          }, function() {                                                                                            // 273
            return [ "\n            ", HTML.DIV({                                                                    // 274
              "class": "form-inline form-group rows-per-page"                                                        // 275
            }, "\n              ", HTML.LABEL("\n                ", HTML.SPAN(Blaze.View("lookup:i18n", function() {
              return Spacebars.mustache(view.lookup("i18n"), "reactiveTable.show");                                  // 277
            })), "\n                ", HTML.INPUT({                                                                  // 278
              "class": "form-control",                                                                               // 279
              type: "text",                                                                                          // 280
              value: function() {                                                                                    // 281
                return Spacebars.mustache(view.lookup("getRowsPerPage"));                                            // 282
              }                                                                                                      // 283
            }), "\n                ", Blaze.If(function() {                                                          // 284
              return Spacebars.call(view.lookup("showRowCount"));                                                    // 285
            }, function() {                                                                                          // 286
              return [ "\n                  ", HTML.SPAN(Blaze.View("lookup:i18n", function() {                      // 287
                return Spacebars.mustache(view.lookup("i18n"), "reactiveTable.of");                                  // 288
              })), "\n                  ", HTML.SPAN({                                                               // 289
                "class": "rows-per-page-count"                                                                       // 290
              }, Blaze.View("lookup:getRowCount", function() {                                                       // 291
                return Spacebars.mustache(view.lookup("getRowCount"));                                               // 292
              })), "\n                " ];                                                                           // 293
            }), "\n                ", HTML.SPAN({                                                                    // 294
              "class": "rows-per-page-label"                                                                         // 295
            }, Blaze.View("lookup:i18n", function() {                                                                // 296
              return Spacebars.mustache(view.lookup("i18n"), "reactiveTable.rowsPerPage");                           // 297
            })), "\n              "), "\n            "), "\n          " ];                                           // 298
          }), "\n          ", HTML.DIV({                                                                             // 299
            "class": "form-inline form-group page-number"                                                            // 300
          }, "\n            ", Blaze.If(function() {                                                                 // 301
            return Spacebars.call(view.lookup("isntFirstPage"));                                                     // 302
          }, function() {                                                                                            // 303
            return [ "\n              ", Blaze.If(function() {                                                       // 304
              return Spacebars.call(view.lookup("useFontAwesome"));                                                  // 305
            }, function() {                                                                                          // 306
              return [ "\n                ", HTML.I({                                                                // 307
                "class": "previous-page fa fa-caret-left"                                                            // 308
              }), "\n              " ];                                                                              // 309
            }, function() {                                                                                          // 310
              return [ "\n                ", HTML.LABEL({                                                            // 311
                "class": "previous-page"                                                                             // 312
              }, HTML.CharRef({                                                                                      // 313
                html: "&lt;",                                                                                        // 314
                str: "<"                                                                                             // 315
              })), "\n              " ];                                                                             // 316
            }), "\n            " ];                                                                                  // 317
          }), "\n            ", HTML.LABEL("\n              ", HTML.SPAN(Blaze.View("lookup:i18n", function() {      // 318
            return Spacebars.mustache(view.lookup("i18n"), "reactiveTable.page");                                    // 319
          })), "\n              ", HTML.INPUT({                                                                      // 320
            "class": "form-control",                                                                                 // 321
            type: "text",                                                                                            // 322
            value: function() {                                                                                      // 323
              return Spacebars.mustache(view.lookup("getCurrentPage"));                                              // 324
            }                                                                                                        // 325
          }), "\n              ", HTML.SPAN(Blaze.View("lookup:i18n", function() {                                   // 326
            return Spacebars.mustache(view.lookup("i18n"), "reactiveTable.of");                                      // 327
          })), "\n              ", HTML.SPAN({                                                                       // 328
            "class": "page-number-count"                                                                             // 329
          }, Blaze.View("lookup:getPageCount", function() {                                                          // 330
            return Spacebars.mustache(view.lookup("getPageCount"));                                                  // 331
          })), "\n            "), "\n            ", Blaze.If(function() {                                            // 332
            return Spacebars.call(view.lookup("isntLastPage"));                                                      // 333
          }, function() {                                                                                            // 334
            return [ "\n              ", Blaze.If(function() {                                                       // 335
              return Spacebars.call(view.lookup("useFontAwesome"));                                                  // 336
            }, function() {                                                                                          // 337
              return [ "\n                ", HTML.I({                                                                // 338
                "class": "next-page fa fa-caret-right"                                                               // 339
              }), "\n              " ];                                                                              // 340
            }, function() {                                                                                          // 341
              return [ "\n                ", HTML.LABEL({                                                            // 342
                "class": "next-page"                                                                                 // 343
              }, HTML.CharRef({                                                                                      // 344
                html: "&gt;",                                                                                        // 345
                str: ">"                                                                                             // 346
              })), "\n              " ];                                                                             // 347
            }), "\n            " ];                                                                                  // 348
          }), "\n          "), "\n        "), "\n      " ];                                                          // 349
        }), "\n    " ];                                                                                              // 350
      }, function() {                                                                                                // 351
        return [ "\n      ", Spacebars.include(view.lookupTemplate("noDataTmpl")), "\n    " ];                       // 352
      }), "\n  " ];                                                                                                  // 353
    }), "\n  " ];                                                                                                    // 354
  });                                                                                                                // 355
}));                                                                                                                 // 356
                                                                                                                     // 357
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// packages/aslagle_reactive-table/lib/template.filter.js                                                            //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     // 1
Template.__checkName("reactiveTableFilter");                                                                         // 2
Template["reactiveTableFilter"] = new Template("Template.reactiveTableFilter", (function() {                         // 3
  var view = this;                                                                                                   // 4
  return HTML.DIV({                                                                                                  // 5
    id: function() {                                                                                                 // 6
      return Spacebars.mustache(view.lookup("id"));                                                                  // 7
    },                                                                                                               // 8
    "class": function() {                                                                                            // 9
      return Spacebars.mustache(view.lookup("class"));                                                               // 10
    }                                                                                                                // 11
  }, "\n    ", HTML.SPAN({                                                                                           // 12
    "class": "input-group-addon"                                                                                     // 13
  }, "\n      ", Blaze.If(function() {                                                                               // 14
    return Spacebars.call(view.lookup("useFontAwesome"));                                                            // 15
  }, function() {                                                                                                    // 16
    return [ "\n        ", HTML.I({                                                                                  // 17
      "class": "fa fa-filter"                                                                                        // 18
    }), "\n      " ];                                                                                                // 19
  }, function() {                                                                                                    // 20
    return [ "\n        ", Blaze.If(function() {                                                                     // 21
      return Spacebars.call(view.lookup("label"));                                                                   // 22
    }, function() {                                                                                                  // 23
      return [ "\n          ", HTML.SPAN(Blaze.View("lookup:label", function() {                                     // 24
        return Spacebars.mustache(view.lookup("label"));                                                             // 25
      })), "\n        " ];                                                                                           // 26
    }, function() {                                                                                                  // 27
      return [ "\n          ", Blaze.View("lookup:i18n", function() {                                                // 28
        return Spacebars.mustache(view.lookup("i18n"), "reactiveTable.filter");                                      // 29
      }), "\n        " ];                                                                                            // 30
    }), "\n      " ];                                                                                                // 31
  }), "\n    "), "\n    ", Blaze.If(function() {                                                                     // 32
    return Spacebars.call(view.lookup("useFontAwesome"));                                                            // 33
  }, function() {                                                                                                    // 34
    return [ "\n      ", Blaze.If(function() {                                                                       // 35
      return Spacebars.call(view.lookup("label"));                                                                   // 36
    }, function() {                                                                                                  // 37
      return [ "\n        ", HTML.INPUT({                                                                            // 38
        "class": "reactive-table-input form-control",                                                                // 39
        type: "text",                                                                                                // 40
        value: function() {                                                                                          // 41
          return Spacebars.mustache(view.lookup("filter"));                                                          // 42
        },                                                                                                           // 43
        placeholder: function() {                                                                                    // 44
          return Spacebars.mustache(view.lookup("label"));                                                           // 45
        }                                                                                                            // 46
      }), "\n      " ];                                                                                              // 47
    }, function() {                                                                                                  // 48
      return [ "\n        ", HTML.INPUT({                                                                            // 49
        "class": "reactive-table-input form-control",                                                                // 50
        type: "text",                                                                                                // 51
        value: function() {                                                                                          // 52
          return Spacebars.mustache(view.lookup("filter"));                                                          // 53
        },                                                                                                           // 54
        placeholder: function() {                                                                                    // 55
          return Spacebars.mustache(view.lookup("i18n"), "reactiveTable.filter");                                    // 56
        }                                                                                                            // 57
      }), "\n      " ];                                                                                              // 58
    }), "\n    " ];                                                                                                  // 59
  }, function() {                                                                                                    // 60
    return [ "\n      ", HTML.INPUT({                                                                                // 61
      "class": "reactive-table-input form-control",                                                                  // 62
      type: "text",                                                                                                  // 63
      value: function() {                                                                                            // 64
        return Spacebars.mustache(view.lookup("filter"));                                                            // 65
      }                                                                                                              // 66
    }), "\n    " ];                                                                                                  // 67
  }), "\n  ");                                                                                                       // 68
}));                                                                                                                 // 69
                                                                                                                     // 70
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// packages/aslagle_reactive-table/lib/reactive_table_i18n.js                                                        //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
i18n.map('en', {                                                                                                     // 1
    reactiveTable: {                                                                                                 // 2
        filter: 'Filter',                                                                                            // 3
        columns: 'Columns',                                                                                          // 4
        show: 'Show',                                                                                                // 5
        rowsPerPage: 'rows per page',                                                                                // 6
        page: 'Page',                                                                                                // 7
        of: 'of'                                                                                                     // 8
    }                                                                                                                // 9
});                                                                                                                  // 10
                                                                                                                     // 11
i18n.map('fr', {                                                                                                     // 12
    reactiveTable: {                                                                                                 // 13
        filter: 'Filtre',                                                                                            // 14
        columns: 'Colonnes',                                                                                         // 15
        show: 'Voir',                                                                                                // 16
        rowsPerPage: 'lignes par page',                                                                              // 17
        page: 'page',                                                                                                // 18
        of: 'sur'                                                                                                    // 19
    }                                                                                                                // 20
});                                                                                                                  // 21
                                                                                                                     // 22
i18n.map('ru', {                                                                                                     // 23
    reactiveTable: {                                                                                                 // 24
        filter: 'Фильтр',                                                                                            // 25
        columns: 'Колонка',                                                                                          // 26
        show: 'Показать',                                                                                            // 27
        rowsPerPage: 'линий на странице',                                                                            // 28
        page: 'Страница',                                                                                            // 29
        of: 'из'                                                                                                     // 30
    }                                                                                                                // 31
});                                                                                                                  // 32
                                                                                                                     // 33
i18n.map('es', {                                                                                                     // 34
    reactiveTable: {                                                                                                 // 35
        filter: 'Filtro',                                                                                            // 36
        columns: 'Columnas',                                                                                         // 37
        show:   'Mostrar',                                                                                           // 38
        rowsPerPage: 'filas por página',                                                                             // 39
        page: 'Página',                                                                                              // 40
        of: 'de'                                                                                                     // 41
    }                                                                                                                // 42
});                                                                                                                  // 43
                                                                                                                     // 44
i18n.map('nl', {                                                                                                     // 45
    reactiveTable: {                                                                                                 // 46
        filter: 'Filter',                                                                                            // 47
        show:   'Toon',                                                                                              // 48
        rowsPerPage: 'regels per pagina',                                                                            // 49
        page: 'Pagina',                                                                                              // 50
        of: 'van'                                                                                                    // 51
    }                                                                                                                // 52
});                                                                                                                  // 53
                                                                                                                     // 54
i18n.map('pt-br', {                                                                                                  // 55
    reactiveTable: {                                                                                                 // 56
        filter: 'Filtro',                                                                                            // 57
        show: 'Mostrar',                                                                                             // 58
        rowsPerPage: 'linhas por página',                                                                            // 59
        page: 'Página',                                                                                              // 60
        of: 'de'                                                                                                     // 61
    }                                                                                                                // 62
});                                                                                                                  // 63
                                                                                                                     // 64
i18n.map('it', {                                                                                                     // 65
    reactiveTable: {                                                                                                 // 66
        filter: 'Filtra',                                                                                            // 67
        show: 'Mostra',                                                                                              // 68
        rowsPerPage: 'righe per pagina',                                                                             // 69
        page: 'Pagina',                                                                                              // 70
        of: 'di'                                                                                                     // 71
    }                                                                                                                // 72
});                                                                                                                  // 73
                                                                                                                     // 74
i18n.map('sv', {                                                                                                     // 75
    reactiveTable: {                                                                                                 // 76
        filter: 'Filter',                                                                                            // 77
        show: 'Visa',                                                                                                // 78
        rowsPerPage: 'rader per sida',                                                                               // 79
        page: 'Sida',                                                                                                // 80
        of: 'av'                                                                                                     // 81
    }                                                                                                                // 82
});                                                                                                                  // 83
                                                                                                                     // 84
i18n.map('ua', {                                                                                                     // 85
    reactiveTable: {                                                                                                 // 86
        filter: 'Фільтр',                                                                                            // 87
        show: 'Показати',                                                                                            // 88
        rowsPerPage: 'рядків на сторінці',                                                                           // 89
        page: 'Сторінка',                                                                                            // 90
        of: 'з'                                                                                                      // 91
    }                                                                                                                // 92
});                                                                                                                  // 93
                                                                                                                     // 94
i18n.map('tr', {                                                                                                     // 95
    reactiveTable: {                                                                                                 // 96
        filter: 'Süz',                                                                                               // 97
        columns: 'Sütunlar',                                                                                         // 98
        show: 'Sayfa başına',                                                                                        // 99
        rowsPerPage: 'satır göster',                                                                                 // 100
        page: 'Sayfa',                                                                                               // 101
        of: ' / '                                                                                                    // 102
    }                                                                                                                // 103
});                                                                                                                  // 104
                                                                                                                     // 105
i18n.map('sk', {                                                                                                     // 106
    reactiveTable: {                                                                                                 // 107
        filter: 'Filter',                                                                                            // 108
        show: 'Zobraz',                                                                                              // 109
        rowsPerPage: 'riadkov na stranu',                                                                            // 110
        page: 'Strana',                                                                                              // 111
        of: 'z'                                                                                                      // 112
    }                                                                                                                // 113
});                                                                                                                  // 114
                                                                                                                     // 115
i18n.map('cs', {                                                                                                     // 116
    reactiveTable: {                                                                                                 // 117
        filter: 'Filter',                                                                                            // 118
        show: 'Zobraz',                                                                                              // 119
        rowsPerPage: 'řádků na stranu',                                                                              // 120
        page: 'Strana',                                                                                              // 121
        of: 'z'                                                                                                      // 122
    }                                                                                                                // 123
});                                                                                                                  // 124
                                                                                                                     // 125
i18n.map('he', {                                                                                                     // 126
    reactiveTable: {                                                                                                 // 127
        filter: 'פילטר',                                                                                             // 128
        show: 'הצג',                                                                                                 // 129
        rowsPerPage: 'שורות לעמוד',                                                                                  // 130
        page: 'עמוד',                                                                                                // 131
        of: 'מתוך'                                                                                                   // 132
    }                                                                                                                // 133
});                                                                                                                  // 134
                                                                                                                     // 135
i18n.map('da', {                                                                                                     // 136
    reactiveTable: {                                                                                                 // 137
        filter: 'Filter',                                                                                            // 138
        columns: 'Kolonner',                                                                                         // 139
        show: 'Vis',                                                                                                 // 140
        rowsPerPage: 'rækker per side',                                                                              // 141
        page: 'Side',                                                                                                // 142
        of: 'af'                                                                                                     // 143
    }                                                                                                                // 144
});                                                                                                                  // 145
                                                                                                                     // 146
i18n.map('de', {                                                                                                     // 147
    reactiveTable: {                                                                                                 // 148
        filter: 'Filter',                                                                                            // 149
        columns: 'Spalten',                                                                                          // 150
        show: 'Zeige',                                                                                               // 151
        rowsPerPage: 'Zeilen pro Seite',                                                                             // 152
        page: 'Seite',                                                                                               // 153
        of: 'von'                                                                                                    // 154
    }                                                                                                                // 155
});                                                                                                                  // 156
                                                                                                                     // 157
i18n.map('fi', {                                                                                                     // 158
    reactiveTable: {                                                                                                 // 159
        filter: 'Suodata',                                                                                           // 160
        show: 'Näytä',                                                                                               // 161
        rowsPerPage: 'riviä sivulla',                                                                                // 162
        page: 'Sivu',                                                                                                // 163
        of: ' / '                                                                                                    // 164
    }                                                                                                                // 165
});                                                                                                                  // 166
                                                                                                                     // 167
i18n.map('no', {                                                                                                     // 168
    reactiveTable: {                                                                                                 // 169
        filter: 'Filter',                                                                                            // 170
        columns: 'Kolonner',                                                                                         // 171
        show: 'Vis',                                                                                                 // 172
        rowsPerPage: 'rader per side',                                                                               // 173
        page: 'Side',                                                                                                // 174
        of: 'av'                                                                                                     // 175
    }                                                                                                                // 176
});                                                                                                                  // 177
                                                                                                                     // 178
i18n.map('pl', {                                                                                                     // 179
    reactiveTable: {                                                                                                 // 180
        filter: 'Szukaj',                                                                                            // 181
        columns: 'Kolumny',                                                                                          // 182
        show: 'Pokaż',                                                                                               // 183
        rowsPerPage: 'pozycji na stronie',                                                                           // 184
        page: 'Strona',                                                                                              // 185
        of: 'z'                                                                                                      // 186
    }                                                                                                                // 187
});                                                                                                                  // 188
                                                                                                                     // 189
i18n.map('hr', {                                                                                                     // 190
    reactiveTable: {                                                                                                 // 191
        filter: 'Filter',                                                                                            // 192
        columns: 'Stupci',                                                                                           // 193
        show: 'Prikaži',                                                                                             // 194
        rowsPerPage: 'redova po stranici',                                                                           // 195
        page: 'Stranica',                                                                                            // 196
        of: 'od'                                                                                                     // 197
    }                                                                                                                // 198
});                                                                                                                  // 199
                                                                                                                     // 200
i18n.map('is', {                                                                                                     // 201
    reactiveTable: {                                                                                                 // 202
        filter: 'Sía',                                                                                               // 203
        columns: 'Dálkar',                                                                                           // 204
        show: 'Sýna',                                                                                                // 205
        rowsPerPage: 'raðir á síðu',                                                                                 // 206
        page: 'Síða',                                                                                                // 207
        of: 'af'                                                                                                     // 208
    }                                                                                                                // 209
});                                                                                                                  // 210
                                                                                                                     // 211
i18n.map('zh', {                                                                                                     // 212
    reactiveTable: {                                                                                                 // 213
        filter: '过滤',                                                                                                // 214
        columns: '列',                                                                                                // 215
        show: '显示',                                                                                                  // 216
        rowsPerPage: '每页行数',                                                                                         // 217
        page: '页数',                                                                                                  // 218
        of: '之'                                                                                                      // 219
    }                                                                                                                // 220
});                                                                                                                  // 221
                                                                                                                     // 222
i18n.map('fa', {                                                                                                     // 223
    reactiveTable: {                                                                                                 // 224
        filter: 'تزکیه',                                                                                             // 225
        columns: 'ستون',                                                                                             // 226
        show: 'ارائه',                                                                                               // 227
        rowsPerPage: 'ردیف در هر صفحه',                                                                              // 228
        page: 'صفحه',                                                                                                // 229
        of: 'از'                                                                                                     // 230
    }                                                                                                                // 231
});                                                                                                                  // 232
                                                                                                                     // 233
i18n.map('gr', {                                                                                                     // 234
    reactiveTable: {                                                                                                 // 235
        filter: 'Φίλτρα',                                                                                            // 236
        columns: 'Στήλες',                                                                                           // 237
        show: 'Προβολή',                                                                                             // 238
        rowsPerPage: 'γραμμές ανά σελίδα',                                                                           // 239
        page: 'Σελίδα',                                                                                              // 240
        of: 'από'                                                                                                    // 241
    }                                                                                                                // 242
});                                                                                                                  // 243
                                                                                                                     // 244
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// packages/aslagle_reactive-table/lib/reactive_table.js                                                             //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
var ReactiveTableCounts = new Mongo.Collection("reactive-table-counts");                                             // 1
                                                                                                                     // 2
get = function(obj, field) {                                                                                         // 3
  var keys = field.split('.');                                                                                       // 4
  var value = obj;                                                                                                   // 5
                                                                                                                     // 6
  _.each(keys, function (key) {                                                                                      // 7
      if (_.isObject(value) && _.isFunction(value[key])) {                                                           // 8
          value = value[key]();                                                                                      // 9
      } else if (_.isObject(value) && !_.isUndefined(value[key])) {                                                  // 10
          value = value[key];                                                                                        // 11
      } else {                                                                                                       // 12
          value = null;                                                                                              // 13
      }                                                                                                              // 14
  });                                                                                                                // 15
                                                                                                                     // 16
  return value;                                                                                                      // 17
};                                                                                                                   // 18
                                                                                                                     // 19
var updateHandle = function (set_context) {                                                                          // 20
    var context = set_context;                                                                                       // 21
    if (context.server) {                                                                                            // 22
        var newHandle;                                                                                               // 23
                                                                                                                     // 24
        // Could use the table id, but this way we can wait to change the                                            // 25
        // page until the new data is ready, so it doesn't move around                                               // 26
        // while rows are added and removed                                                                          // 27
        var publicationId = _.uniqueId();                                                                            // 28
        var newPublishedRows = new Mongo.Collection('reactive-table-rows-' + publicationId);                         // 29
        context.nextPublicationId.set(publicationId);                                                                // 30
                                                                                                                     // 31
        var rowsPerPage = context.rowsPerPage.get();                                                                 // 32
        var currentPage = context.currentPage.get();                                                                 // 33
        var currentIndex = currentPage * rowsPerPage;                                                                // 34
                                                                                                                     // 35
        var options = {                                                                                              // 36
            skip: currentIndex,                                                                                      // 37
            limit: rowsPerPage,                                                                                      // 38
            sort: getSortQuery(context.fields, context.multiColumnSort)                                              // 39
        };                                                                                                           // 40
                                                                                                                     // 41
        var filters = context.filters.get();                                                                         // 42
                                                                                                                     // 43
        var onReady = function () {                                                                                  // 44
            if (publicationId === context.nextPublicationId.get()) {                                                 // 45
                context.ready.set(true);                                                                             // 46
                context.publicationId.set(publicationId);                                                            // 47
                context.publishedRows = newPublishedRows;                                                            // 48
                var oldHandle = context.handle;                                                                      // 49
                context.handle = newHandle;                                                                          // 50
                                                                                                                     // 51
                if (oldHandle) {                                                                                     // 52
                    oldHandle.stop();                                                                                // 53
                }                                                                                                    // 54
            } else {                                                                                                 // 55
                // another handle was created after this one                                                         // 56
                newHandle.stop();                                                                                    // 57
            }                                                                                                        // 58
        };                                                                                                           // 59
        var onError = function (error) {                                                                             // 60
            console.log("ReactiveTable subscription error: " + error);                                               // 61
        };                                                                                                           // 62
        newHandle = Meteor.subscribe(                                                                                // 63
            "reactive-table-" + context.collection,                                                                  // 64
            publicationId,                                                                                           // 65
            getFilterStrings(filters),                                                                               // 66
            getFilterFields(filters, context.fields),                                                                // 67
            options,                                                                                                 // 68
            context.rowsPerPage.get(),                                                                               // 69
            {onReady: onReady, onError: onError}                                                                     // 70
        );                                                                                                           // 71
    }                                                                                                                // 72
};                                                                                                                   // 73
                                                                                                                     // 74
                                                                                                                     // 75
var getDefaultFalseSetting = function (key, templateData) {                                                          // 76
    if (!_.isUndefined(templateData[key]) &&                                                                         // 77
        templateData[key]) {                                                                                         // 78
        return true;                                                                                                 // 79
    }                                                                                                                // 80
    if (!_.isUndefined(templateData.settings) &&                                                                     // 81
        !_.isUndefined(templateData.settings[key]) &&                                                                // 82
        templateData.settings[key]) {                                                                                // 83
        return true;                                                                                                 // 84
    }                                                                                                                // 85
    return false;                                                                                                    // 86
};                                                                                                                   // 87
                                                                                                                     // 88
var getDefaultTrueSetting = function (key, templateData) {                                                           // 89
    if (!_.isUndefined(templateData[key]) &&                                                                         // 90
        !templateData[key]) {                                                                                        // 91
        return false;                                                                                                // 92
    }                                                                                                                // 93
    if (!_.isUndefined(templateData.settings) &&                                                                     // 94
        !_.isUndefined(templateData.settings[key]) &&                                                                // 95
        !templateData.settings[key]) {                                                                               // 96
        return false;                                                                                                // 97
    }                                                                                                                // 98
    return true;                                                                                                     // 99
};                                                                                                                   // 100
                                                                                                                     // 101
                                                                                                                     // 102
                                                                                                                     // 103
var setup = function () {                                                                                            // 104
    var context = {};                                                                                                // 105
    var oldContext = this.context || {};                                                                             // 106
    context.templateData = this.data;                                                                                // 107
    this.data.settings = this.data.settings || {};                                                                   // 108
    var collection = this.data.collection || this.data.settings.collection || this.data;                             // 109
                                                                                                                     // 110
    if (!(collection instanceof Mongo.Collection)) {                                                                 // 111
        if (_.isArray(collection)) {                                                                                 // 112
            // collection is an array                                                                                // 113
            // create a new collection from the data                                                                 // 114
            var data = collection;                                                                                   // 115
            collection = new Mongo.Collection(null);                                                                 // 116
            _.each(data, function (doc) {                                                                            // 117
                collection.insert(doc);                                                                              // 118
            });                                                                                                      // 119
        } else if (_.isFunction(collection.fetch)) {                                                                 // 120
            // collection is a cursor                                                                                // 121
            // create a new collection that will reactively update                                                   // 122
            var cursor = collection;                                                                                 // 123
            collection = new Mongo.Collection(null);                                                                 // 124
                                                                                                                     // 125
            // copy over transforms from collection-helper package                                                   // 126
            collection._transform = cursor._transform;                                                               // 127
            collection._name = cursor.collection._name;                                                              // 128
                                                                                                                     // 129
            var addedCallback = function (doc) {                                                                     // 130
                collection.insert(doc);                                                                              // 131
            };                                                                                                       // 132
            var changedCallback = function (doc, oldDoc) {                                                           // 133
                collection.update(oldDoc._id, doc);                                                                  // 134
            };                                                                                                       // 135
            var removedCallback = function (oldDoc) {                                                                // 136
                collection.remove(oldDoc._id);                                                                       // 137
            };                                                                                                       // 138
            cursor.observe({added: addedCallback, changed: changedCallback, removed: removedCallback});              // 139
        } else if (_.isString(collection)) {                                                                         // 140
            // server side publication                                                                               // 141
            context.server = true;                                                                                   // 142
            context.publicationId = new ReactiveVar();                                                               // 143
            context.nextPublicationId = new ReactiveVar();                                                           // 144
            context.publishedRows = new Mongo.Collection(null);                                                      // 145
        } else {                                                                                                     // 146
            console.error("reactiveTable error: argument is not an instance of Mongo.Collection, a cursor, or an array");
            collection = new Mongo.Collection(null);                                                                 // 148
        }                                                                                                            // 149
    }                                                                                                                // 150
    context.collection = collection;                                                                                 // 151
                                                                                                                     // 152
    context.multiColumnSort = getDefaultTrueSetting('multiColumnSort', this.data);                                   // 153
                                                                                                                     // 154
    var fields = this.data.fields || this.data.settings.fields || {};                                                // 155
    if (_.keys(fields).length < 1 ||                                                                                 // 156
        (_.keys(fields).length === 1 &&                                                                              // 157
         _.keys(fields)[0] === 'hash')) {                                                                            // 158
                                                                                                                     // 159
        if (context.server) {                                                                                        // 160
            console.error("reactiveTable error: fields option is required with server-side publications");           // 161
        } else {                                                                                                     // 162
            fields = _.without(_.keys(collection.findOne() || {}), '_id');                                           // 163
            if (fields.length < 1) {                                                                                 // 164
                console.error("reactiveTable error: Couldn't get fields from an item in the collection on load, so there are no columns to display. Provide the fields option or ensure that the collection has at least one item and the subscription is ready when the table renders.");
            }                                                                                                        // 166
        }                                                                                                            // 167
    }                                                                                                                // 168
                                                                                                                     // 169
    var fieldIdsArePresentAndUnique = function (fields) {                                                            // 170
        var uniqueFieldIds = _.chain(fields)                                                                         // 171
            .filter(function (field) {                                                                               // 172
                return !_.isUndefined(field.fieldId)                                                                 // 173
            })                                                                                                       // 174
            .map(function (field) {                                                                                  // 175
                return field.fieldId;                                                                                // 176
            })                                                                                                       // 177
            .uniq()                                                                                                  // 178
            .value();                                                                                                // 179
        return uniqueFieldIds.length === fields.length;                                                              // 180
    };                                                                                                               // 181
                                                                                                                     // 182
    // If at least one field specifies a fieldId, all fields must specify a                                          // 183
    // fieldId with a unique value                                                                                   // 184
    if (_.find(fields, function (field) {                                                                            // 185
        return !_.isUndefined(field.fieldId)                                                                         // 186
        }) && !fieldIdsArePresentAndUnique(fields)) {                                                                // 187
        console.error("reactiveTable error: all fields must have a unique-valued fieldId if at least one has a fieldId attribute");
        fields = [];                                                                                                 // 189
    }                                                                                                                // 190
                                                                                                                     // 191
    var normalizeField = function (field, i) {                                                                       // 192
        if (typeof field === 'string') {                                                                             // 193
            field = {key: field, label: field};                                                                      // 194
        }                                                                                                            // 195
        if (!_.has(field, 'fieldId')) {                                                                              // 196
            // Default fieldId to index in fields array if not present                                               // 197
            field.fieldId = i.toString();                                                                            // 198
        }                                                                                                            // 199
        if (!_.has(field, 'key')) {                                                                                  // 200
            field.key = '';                                                                                          // 201
        }                                                                                                            // 202
        oldField = _.find(oldContext.fields, function (oldField) {                                                   // 203
            return oldField.fieldId === field.fieldId;                                                               // 204
        });                                                                                                          // 205
        normalizeSort(field, oldField);                                                                              // 206
        return field;                                                                                                // 207
    };                                                                                                               // 208
                                                                                                                     // 209
    fields = _.map(fields, normalizeField);                                                                          // 210
                                                                                                                     // 211
    context.fields = fields;                                                                                         // 212
                                                                                                                     // 213
    var visibleFields = [];                                                                                          // 214
    _.each(fields, function (field, i) {                                                                             // 215
        visibleFields.push({fieldId:field.fieldId, isVisible: getDefaultFieldVisibility(field)});                    // 216
    });                                                                                                              // 217
    context.visibleFields = (!_.isUndefined(oldContext.visibleFields) && !_.isEmpty(oldContext.visibleFields)) ? oldContext.visibleFields : new ReactiveVar(visibleFields);
                                                                                                                     // 219
                                                                                                                     // 220
    var rowClass = this.data.rowClass || this.data.settings.rowClass || function() {return '';};                     // 221
    if (typeof rowClass === 'string') {                                                                              // 222
        var tmp = rowClass;                                                                                          // 223
        rowClass = function(obj) { return tmp; };                                                                    // 224
    }                                                                                                                // 225
    context.rowClass = rowClass;                                                                                     // 226
                                                                                                                     // 227
    context.class = this.data.class || this.data.settings.class || 'table table-striped table-hover col-sm-12';      // 228
    context.id = this.data.id || this.data.settings.id || _.uniqueId('reactive-table-');                             // 229
                                                                                                                     // 230
    context.showNavigation = this.data.showNavigation || this.data.settings.showNavigation || 'always';              // 231
    context.showNavigationRowsPerPage = getDefaultTrueSetting('showNavigationRowsPerPage', this.data);               // 232
    context.showRowCount = getDefaultFalseSetting('showRowCount', this.data)                                         // 233
                                                                                                                     // 234
    var rowsPerPage;                                                                                                 // 235
    if (!_.isUndefined(oldContext.rowsPerPage)) {                                                                    // 236
        rowsPerPage = oldContext.rowsPerPage;                                                                        // 237
    } else if (this.data.rowsPerPage && this.data.rowsPerPage instanceof ReactiveVar) {                              // 238
        rowsPerPage = this.data.rowsPerPage;                                                                         // 239
    } else if (this.data.settings.rowsPerPage && this.data.settings.rowsPerPage instanceof ReactiveVar) {            // 240
        rowsPerPage = this.data.settings.rowsPerPage;                                                                // 241
    } else {                                                                                                         // 242
        rowsPerPage = new ReactiveVar(this.data.rowsPerPage || this.data.settings.rowsPerPage || 10);                // 243
    }                                                                                                                // 244
    context.rowsPerPage = rowsPerPage;                                                                               // 245
                                                                                                                     // 246
    var currentPage;                                                                                                 // 247
    if (!_.isUndefined(oldContext.currentPage)) {                                                                    // 248
        currentPage = oldContext.currentPage;                                                                        // 249
    } else if (this.data.currentPage && this.data.currentPage instanceof ReactiveVar) {                              // 250
        currentPage = this.data.currentPage;                                                                         // 251
    } else if (this.data.settings.currentPage && this.data.settings.currentPage instanceof ReactiveVar) {            // 252
        currentPage = this.data.settings.currentPage;                                                                // 253
    } else {                                                                                                         // 254
        currentPage = new ReactiveVar(0);                                                                            // 255
    }                                                                                                                // 256
    context.currentPage = currentPage;                                                                               // 257
                                                                                                                     // 258
    var filters = this.data.filters || this.data.settings.filters || [];                                             // 259
    if (_.isEmpty(filters)) {                                                                                        // 260
      context.showFilter = getDefaultTrueSetting('showFilter', this.data);                                           // 261
    } else {                                                                                                         // 262
      context.showFilter = getDefaultFalseSetting('showFilter', this.data);                                          // 263
    }                                                                                                                // 264
    if (context.showFilter) {                                                                                        // 265
      filters.push(context.id + '-filter');                                                                          // 266
    }                                                                                                                // 267
    context.filters = new ReactiveVar(filters);                                                                      // 268
                                                                                                                     // 269
    dependOnFilters(context.filters.get(), function () {                                                             // 270
      if (context.reactiveTableSetup) {                                                                              // 271
        context.currentPage.set(0);                                                                                  // 272
        updateHandle(context);                                                                                       // 273
      }                                                                                                              // 274
    });                                                                                                              // 275
                                                                                                                     // 276
    context.showColumnToggles = getDefaultFalseSetting('showColumnToggles', this.data);                              // 277
                                                                                                                     // 278
    if (_.isUndefined(this.data.useFontAwesome)) {                                                                   // 279
        if (!_.isUndefined(this.data.settings.useFontAwesome)) {                                                     // 280
            context.useFontAwesome = this.data.settings.useFontAwesome;                                              // 281
        } else if (!_.isUndefined(Package['fortawesome:fontawesome'])) {                                             // 282
            context.useFontAwesome = true;                                                                           // 283
        } else {                                                                                                     // 284
            context.useFontAwesome = false;                                                                          // 285
        }                                                                                                            // 286
    } else {                                                                                                         // 287
        context.useFontAwesome = this.data.useFontAwesome;                                                           // 288
    }                                                                                                                // 289
    context.noDataTmpl = this.data.noDataTmpl || this.data.settings.noDataTmpl;                                      // 290
    context.enableRegex = getDefaultFalseSetting('enableRegex', this.data);                                          // 291
    context.filterOperator = this.data.filterOperator || this.data.settings.filterOperator || '$and';                // 292
                                                                                                                     // 293
    var ready;                                                                                                       // 294
    if (!_.isUndefined(oldContext.ready)) {                                                                          // 295
        ready = oldContext.ready;                                                                                    // 296
    } else if (this.data.ready && this.data.ready instanceof ReactiveVar) {                                          // 297
        ready = this.data.ready;                                                                                     // 298
    } else if (this.data.settings.ready && this.data.settings.ready instanceof ReactiveVar) {                        // 299
        ready = this.data.settings.ready;                                                                            // 300
    } else {                                                                                                         // 301
        ready = new ReactiveVar(true);                                                                               // 302
    }                                                                                                                // 303
    context.ready = ready;                                                                                           // 304
                                                                                                                     // 305
    if (context.server) {                                                                                            // 306
        context.ready.set(false);                                                                                    // 307
        updateHandle(context);                                                                                       // 308
    }                                                                                                                // 309
                                                                                                                     // 310
    context.reactiveTableSetup = true;                                                                               // 311
                                                                                                                     // 312
    this.context = context;                                                                                          // 313
};                                                                                                                   // 314
                                                                                                                     // 315
var getDefaultFieldVisibility = function (field) {                                                                   // 316
    if (field.isVisible && field.isVisible instanceof ReactiveVar) {                                                 // 317
        return field.isVisible;                                                                                      // 318
    }                                                                                                                // 319
    return new ReactiveVar(!field.hidden || (_.isFunction(field.hidden) && !field.hidden()));                        // 320
}                                                                                                                    // 321
                                                                                                                     // 322
var getRowCount = function () {                                                                                      // 323
    if (this.server) {                                                                                               // 324
        var count = ReactiveTableCounts.findOne(this.publicationId.get());                                           // 325
        return (count ? count.count : 0);                                                                            // 326
    } else {                                                                                                         // 327
        var filterQuery = getFilterQuery(getFilterStrings(this.filters.get()), getFilterFields(this.filters.get(), this.fields), {enableRegex: this.enableRegex, filterOperator: this.filterOperator});
        return this.collection.find(filterQuery).count();                                                            // 329
    }                                                                                                                // 330
};                                                                                                                   // 331
                                                                                                                     // 332
var getPageCount = function () {                                                                                     // 333
    var count = getRowCount.call(this);                                                                              // 334
    var rowsPerPage = this.rowsPerPage.get();                                                                        // 335
    return Math.ceil(count / rowsPerPage);                                                                           // 336
};                                                                                                                   // 337
                                                                                                                     // 338
Template.reactiveTable.onCreated(function() {                                                                        // 339
   this.updateHandle = _.debounce(updateHandle, 200);                                                                // 340
                                                                                                                     // 341
   var rowsPerPage = this.data.rowsPerPage || (this.data.settings && this.data.settings.rowsPerPage);                // 342
   var currentPage = this.data.currentPage || (this.data.settings && this.data.settings.currentPage);                // 343
   var fields = this.data.fields || (this.data.settings && this.data.settings.fields) || [];                         // 344
                                                                                                                     // 345
   var template = this;                                                                                              // 346
   Tracker.autorun(function(c) {                                                                                     // 347
     if (rowsPerPage instanceof ReactiveVar) {                                                                       // 348
       rowsPerPage.dep.depend();                                                                                     // 349
     }                                                                                                               // 350
     if (currentPage instanceof ReactiveVar) {                                                                       // 351
       currentPage.dep.depend();                                                                                     // 352
     }                                                                                                               // 353
     _.each(fields, function (field) {                                                                               // 354
       if (field.sortOrder && field.sortOrder instanceof ReactiveVar) {                                              // 355
         field.sortOrder.dep.depend();                                                                               // 356
       }                                                                                                             // 357
       if (field.sortDirection && field.sortDirection instanceof ReactiveVar) {                                      // 358
         field.sortDirection.dep.depend();                                                                           // 359
       }                                                                                                             // 360
     });                                                                                                             // 361
     if (template.context) {                                                                                         // 362
       template.updateHandle(template.context);                                                                      // 363
     }                                                                                                               // 364
   });                                                                                                               // 365
});                                                                                                                  // 366
                                                                                                                     // 367
Template.reactiveTable.onDestroyed(function() {                                                                      // 368
  if (this.context.server && this.context.handle) {                                                                  // 369
    this.context.handle.stop();                                                                                      // 370
  }                                                                                                                  // 371
});                                                                                                                  // 372
                                                                                                                     // 373
Template.reactiveTable.helpers({                                                                                     // 374
    'context': function () {                                                                                         // 375
        if (!Template.instance().context ||                                                                          // 376
            !_.isEqual(this, Template.instance().context.templateData)) {                                            // 377
            setup.call(Template.instance());                                                                         // 378
        }                                                                                                            // 379
        return Template.instance().context;                                                                          // 380
    },                                                                                                               // 381
                                                                                                                     // 382
    'ready' : function () {                                                                                          // 383
        return this.ready.get();                                                                                     // 384
    },                                                                                                               // 385
                                                                                                                     // 386
    'getFilterId': function () {                                                                                     // 387
        return this.id + '-filter';                                                                                  // 388
    },                                                                                                               // 389
                                                                                                                     // 390
    'getField': function (object) {                                                                                  // 391
        var fn = this.fn || function (value) { return value; };                                                      // 392
        var key = this.key;                                                                                          // 393
        var value = get(object, key);                                                                                // 394
        return fn(value, object, key);                                                                               // 395
    },                                                                                                               // 396
                                                                                                                     // 397
    'getFieldIndex': function () {                                                                                   // 398
        return _.indexOf(Template.parentData(1).fields, this);                                                       // 399
    },                                                                                                               // 400
                                                                                                                     // 401
    'getFieldFieldId': function () {                                                                                 // 402
        return this.fieldId;                                                                                         // 403
    },                                                                                                               // 404
                                                                                                                     // 405
    'getKey': function () {                                                                                          // 406
        return this.key;                                                                                             // 407
    },                                                                                                               // 408
                                                                                                                     // 409
    'getHeaderClass': function () {                                                                                  // 410
        if (_.isUndefined(this.headerClass)) {                                                                       // 411
            return this.key;                                                                                         // 412
        }                                                                                                            // 413
        var css;                                                                                                     // 414
        if (_.isFunction(this.headerClass)) {                                                                        // 415
            css = this.headerClass();                                                                                // 416
        } else {                                                                                                     // 417
            css = this.headerClass;                                                                                  // 418
        }                                                                                                            // 419
        return css;                                                                                                  // 420
    },                                                                                                               // 421
                                                                                                                     // 422
    'getCellClass': function (object) {                                                                              // 423
        if (_.isUndefined(this.cellClass)) {                                                                         // 424
            return this.key;                                                                                         // 425
        }                                                                                                            // 426
        var css;                                                                                                     // 427
        if (_.isFunction(this.cellClass)) {                                                                          // 428
            var value = get(object, this.key);                                                                       // 429
            css = this.cellClass(value, object);                                                                     // 430
        } else {                                                                                                     // 431
            css = this.cellClass;                                                                                    // 432
        }                                                                                                            // 433
        return css;                                                                                                  // 434
    },                                                                                                               // 435
                                                                                                                     // 436
    'labelIsTemplate': function () {                                                                                 // 437
        return this.label && _.isObject(this.label) && this.label instanceof Blaze.Template;                         // 438
    },                                                                                                               // 439
                                                                                                                     // 440
    'getLabel': function () {                                                                                        // 441
        return _.isString(this.label) ? this.label : this.label();                                                   // 442
    },                                                                                                               // 443
                                                                                                                     // 444
    'isPrimarySortField': function () {                                                                              // 445
        var parentData = Template.parentData(1);                                                                     // 446
        var primarySortField = getPrimarySortField(parentData.fields, parentData.multiColumnSort);                   // 447
        return primarySortField && primarySortField.fieldId === this.fieldId;                                        // 448
    },                                                                                                               // 449
                                                                                                                     // 450
    'isSortable': function () {                                                                                      // 451
        return (this.sortable === undefined) ? true : this.sortable;                                                 // 452
    },                                                                                                               // 453
                                                                                                                     // 454
    'isVisible': function () {                                                                                       // 455
        var self = this; // is a field object                                                                        // 456
        var topLevelData;                                                                                            // 457
        if (Template.parentData(2) && Template.parentData(2).reactiveTableSetup) {                                   // 458
          topLevelData = Template.parentData(2);                                                                     // 459
        } else {                                                                                                     // 460
          topLevelData = Template.parentData(1);                                                                     // 461
        }                                                                                                            // 462
        var visibleFields = topLevelData.visibleFields.get();                                                        // 463
        var fields = topLevelData.fields;                                                                            // 464
                                                                                                                     // 465
        var visibleField = _.findWhere(visibleFields, {fieldId: self.fieldId});                                      // 466
        if (visibleField) {                                                                                          // 467
            return visibleField.isVisible.get();                                                                     // 468
        } else {                                                                                                     // 469
            // Add field to visibleFields list                                                                       // 470
            var _isVisible = getDefaultFieldVisibility(self);                                                        // 471
            visibleFields.push({fieldId:self.fieldId, isVisible:_isVisible});                                        // 472
            topLevelData.visibleFields.set(visibleFields);                                                           // 473
            return _isVisible.get();                                                                                 // 474
        }                                                                                                            // 475
    },                                                                                                               // 476
                                                                                                                     // 477
    'isAscending' : function () {                                                                                    // 478
        var sortDirection = this.sortDirection.get();                                                                // 479
        return (sortDirection === 1);                                                                                // 480
    },                                                                                                               // 481
                                                                                                                     // 482
    'sortedRows': function () {                                                                                      // 483
        if (this.server) {                                                                                           // 484
            return this.publishedRows.find({                                                                         // 485
              "reactive-table-id": this.publicationId.get()                                                          // 486
            }, {                                                                                                     // 487
              sort: {                                                                                                // 488
                "reactive-table-sort": 1                                                                             // 489
              }                                                                                                      // 490
            });                                                                                                      // 491
        } else  {                                                                                                    // 492
            var sortByValue = _.all(getSortedFields(this.fields, this.multiColumnSort), function (field) {           // 493
                return field.sortByValue || !field.fn;                                                               // 494
            });                                                                                                      // 495
            var filterQuery = getFilterQuery(getFilterStrings(this.filters.get()), getFilterFields(this.filters.get(), this.fields), {enableRegex: this.enableRegex, filterOperator: this.filterOperator});
                                                                                                                     // 497
            var limit = this.rowsPerPage.get();                                                                      // 498
            var currentPage = this.currentPage.get();                                                                // 499
            var skip = currentPage * limit;                                                                          // 500
                                                                                                                     // 501
            if (sortByValue) {                                                                                       // 502
                                                                                                                     // 503
                var sortQuery = getSortQuery(this.fields, this.multiColumnSort);                                     // 504
                return this.collection.find(filterQuery, {                                                           // 505
                    sort: sortQuery,                                                                                 // 506
                    skip: skip,                                                                                      // 507
                    limit: limit                                                                                     // 508
                });                                                                                                  // 509
                                                                                                                     // 510
            } else {                                                                                                 // 511
                                                                                                                     // 512
                var rows = this.collection.find(filterQuery).fetch();                                                // 513
                sortedRows = sortWithFunctions(rows, this.fields, this.multiColumnSort);                             // 514
                return sortedRows.slice(skip, skip + limit);                                                         // 515
                                                                                                                     // 516
            }                                                                                                        // 517
        }                                                                                                            // 518
    },                                                                                                               // 519
                                                                                                                     // 520
    'noData': function () {                                                                                          // 521
        var pageCount = getPageCount.call(this);                                                                     // 522
        return (pageCount === 0) && this.noDataTmpl;                                                                 // 523
    },                                                                                                               // 524
                                                                                                                     // 525
    'getPageCount' : getPageCount,                                                                                   // 526
                                                                                                                     // 527
    'getRowsPerPage' : function () {                                                                                 // 528
        return this.rowsPerPage.get();                                                                               // 529
    },                                                                                                               // 530
                                                                                                                     // 531
    'getCurrentPage' : function () {                                                                                 // 532
        return 1 + this.currentPage.get();                                                                           // 533
    },                                                                                                               // 534
                                                                                                                     // 535
    'isntFirstPage' : function () {                                                                                  // 536
        return this.currentPage.get() > 0;                                                                           // 537
    },                                                                                                               // 538
                                                                                                                     // 539
    'isntLastPage' : function () {                                                                                   // 540
        var currentPage = 1 + this.currentPage.get();                                                                // 541
        var pageCount = getPageCount.call(this);                                                                     // 542
        return currentPage < pageCount;                                                                              // 543
    },                                                                                                               // 544
                                                                                                                     // 545
    'showNavigation' : function () {                                                                                 // 546
        if (this.showNavigation === 'always') return true;                                                           // 547
        if (this.showNavigation === 'never') return false;                                                           // 548
        return getPageCount.call(this) > 1;                                                                          // 549
    },                                                                                                               // 550
    'getRowCount': getRowCount                                                                                       // 551
});                                                                                                                  // 552
                                                                                                                     // 553
Template.reactiveTable.events({                                                                                      // 554
    'click .reactive-table .sortable': function (event) {                                                            // 555
        var template = Template.instance();                                                                          // 556
        var target = $(event.currentTarget);                                                                         // 557
        var sortFieldId = target.attr('fieldid');                                                                    // 558
        changePrimarySort(sortFieldId, template.context.fields, template.multiColumnSort);                           // 559
        template.updateHandle(template.context);                                                                     // 560
    },                                                                                                               // 561
                                                                                                                     // 562
    'click .reactive-table-columns-dropdown li': function (event) {                                                  // 563
        var template = Template.instance();                                                                          // 564
        var target = $(event.currentTarget);                                                                         // 565
        var fieldId = target.find('input').attr('data-fieldid');                                                     // 566
        var visibleFields = template.context.visibleFields.get();                                                    // 567
        var visibleField = _.findWhere(visibleFields, {fieldId: fieldId});                                           // 568
        if (visibleField) {                                                                                          // 569
            // Toggle visibility                                                                                     // 570
            visibleField.isVisible.set(!visibleField.isVisible.get());                                               // 571
            template.context.visibleFields.set(visibleFields);                                                       // 572
        }                                                                                                            // 573
    },                                                                                                               // 574
                                                                                                                     // 575
    'change .reactive-table-navigation .rows-per-page input': function (event) {                                     // 576
        var rowsPerPage = Math.max(~~$(event.target).val(), 1);                                                      // 577
        var template = Template.instance();                                                                          // 578
        template.context.rowsPerPage.set(rowsPerPage);                                                               // 579
        $(event.target).val(rowsPerPage);                                                                            // 580
                                                                                                                     // 581
        var currentPage = template.context.currentPage.get() + 1;                                                    // 582
        var pageCount = getPageCount.call(this);                                                                     // 583
        if (currentPage > pageCount) {                                                                               // 584
          template.context.currentPage.set(pageCount - 1);                                                           // 585
        }                                                                                                            // 586
        template.updateHandle(template.context);                                                                     // 587
    },                                                                                                               // 588
                                                                                                                     // 589
    'change .reactive-table-navigation .page-number input': function (event) {                                       // 590
        var currentPage = Math.max(~~$(event.target).val(), 1);                                                      // 591
        var pageCount = getPageCount.call(this);                                                                     // 592
        if (currentPage > pageCount) {                                                                               // 593
          currentPage = pageCount;                                                                                   // 594
        }                                                                                                            // 595
        if (currentPage < 0) {                                                                                       // 596
          currentPage = 1;                                                                                           // 597
        }                                                                                                            // 598
        var template = Template.instance();                                                                          // 599
        template.context.currentPage.set(currentPage - 1);                                                           // 600
        $(event.target).val(currentPage);                                                                            // 601
        template.updateHandle(template.context);                                                                     // 602
    },                                                                                                               // 603
                                                                                                                     // 604
    'click .reactive-table-navigation .previous-page': function (event) {                                            // 605
        var template = Template.instance();                                                                          // 606
        var currentPage = template.context.currentPage.get();                                                        // 607
        template.context.currentPage.set(currentPage - 1);                                                           // 608
        template.updateHandle(template.context);                                                                     // 609
    },                                                                                                               // 610
                                                                                                                     // 611
    'click .reactive-table-navigation .next-page': function (event) {                                                // 612
        var template = Template.instance();                                                                          // 613
        var currentPage = template.context.currentPage.get();                                                        // 614
        template.context.currentPage.set(currentPage + 1);                                                           // 615
        template.updateHandle(template.context);                                                                     // 616
    }                                                                                                                // 617
});                                                                                                                  // 618
                                                                                                                     // 619
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// packages/aslagle_reactive-table/lib/sort.js                                                                       //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
normalizeSort = function (field, oldField) {                                                                         // 1
  // preserve user sort settings                                                                                     // 2
  if (oldField && _.has(oldField, 'sortOrder')) {                                                                    // 3
    field.sortOrder = oldField.sortOrder;                                                                            // 4
  }                                                                                                                  // 5
  if (oldField && _.has(oldField, 'sortDirection')) {                                                                // 6
    field.sortDirection = oldField.sortDirection;                                                                    // 7
  }                                                                                                                  // 8
                                                                                                                     // 9
  // backwards-compatibility                                                                                         // 10
  if (!_.has(field, 'sortOrder') && _.has(field, 'sort')) {                                                          // 11
    console.warn('reactiveTable warning: The "sort" option for fields is deprecated');                               // 12
    field.sortOrder = 0;                                                                                             // 13
    field.sortDirection = field.sort;                                                                                // 14
  }                                                                                                                  // 15
                                                                                                                     // 16
                                                                                                                     // 17
  var sortOrder;                                                                                                     // 18
                                                                                                                     // 19
  if (!_.has(field, 'sortOrder')) {                                                                                  // 20
    sortOrder = Infinity;                                                                                            // 21
    field.sortOrder = new ReactiveVar();                                                                             // 22
  } else if (field.sortOrder instanceof ReactiveVar) {                                                               // 23
    sortOrder = field.sortOrder.get()                                                                                // 24
  } else {                                                                                                           // 25
    sortOrder = field.sortOrder;                                                                                     // 26
    field.sortOrder = new ReactiveVar();                                                                             // 27
  }                                                                                                                  // 28
                                                                                                                     // 29
  if (!_.isNumber(sortOrder) || sortOrder < 0) {                                                                     // 30
    console.error('reactiveTable error - sortOrder must be a postive number: ' + sortOrder);                         // 31
    sortOrder = Infinity;                                                                                            // 32
  }                                                                                                                  // 33
  field.sortOrder.set(sortOrder);                                                                                    // 34
                                                                                                                     // 35
  var sortDirection;                                                                                                 // 36
                                                                                                                     // 37
  if (!_.has(field, 'sortDirection')) {                                                                              // 38
    sortDirection = 1;                                                                                               // 39
    field.sortDirection = new ReactiveVar()                                                                          // 40
  } else if (field.sortDirection instanceof ReactiveVar) {                                                           // 41
    sortDirection = field.sortDirection.get();                                                                       // 42
  } else {                                                                                                           // 43
    sortDirection = field.sortDirection;                                                                             // 44
    field.sortDirection = new ReactiveVar();                                                                         // 45
  }                                                                                                                  // 46
                                                                                                                     // 47
  if (sortDirection === 'desc' || sortDirection === 'descending' || sortDirection === -1) {                          // 48
    sortDirection = -1;                                                                                              // 49
  } else if (sortDirection) {                                                                                        // 50
    sortDirection = 1;                                                                                               // 51
  }                                                                                                                  // 52
  field.sortDirection.set(sortDirection);                                                                            // 53
};                                                                                                                   // 54
                                                                                                                     // 55
getSortedFields = function (fields, multiColumnSort) {                                                               // 56
  var filteredFields = _.filter(fields, function (field) {                                                           // 57
    return field.sortOrder.get() < Infinity;                                                                         // 58
  });                                                                                                                // 59
  if (!filteredFields.length) {                                                                                      // 60
    var firstSortableField = _.find(fields, function (field) {                                                       // 61
      return _.isUndefined(field.sortable) || field.sortable !== false;                                              // 62
    });                                                                                                              // 63
    if (firstSortableField) {                                                                                        // 64
      filteredFields = [firstSortableField];                                                                         // 65
    }                                                                                                                // 66
  }                                                                                                                  // 67
  var sortedFields = _.sortBy(filteredFields, function (field) {                                                     // 68
    return field.sortOrder.get();                                                                                    // 69
  });                                                                                                                // 70
  return multiColumnSort ? sortedFields : sortedFields.slice(0, 1);                                                  // 71
}                                                                                                                    // 72
                                                                                                                     // 73
getSortQuery = function (fields, multiColumnSort) {                                                                  // 74
  var sortedFields = getSortedFields(fields, multiColumnSort);                                                       // 75
  var sortQuery = {};                                                                                                // 76
  _.each(sortedFields, function (field) {                                                                            // 77
    sortQuery[field.key] = field.sortDirection.get();                                                                // 78
  });                                                                                                                // 79
  return sortQuery;                                                                                                  // 80
};                                                                                                                   // 81
                                                                                                                     // 82
sortWithFunctions = function (rows, fields, multiColumnSort) {                                                       // 83
  var sortedFields = getSortedFields(fields, multiColumnSort);                                                       // 84
  var sortedRows = rows;                                                                                             // 85
                                                                                                                     // 86
  _.each(sortedFields.reverse(), function (field) {                                                                  // 87
    if (field.sortByValue || !field.fn) {                                                                            // 88
      sortedRows = _.sortBy(sortedRows, field.key);                                                                  // 89
    } else {                                                                                                         // 90
      sortedRows = _.sortBy(sortedRows, function (row) {                                                             // 91
        return field.fn( get( row, field.key ), row );                                                               // 92
      });                                                                                                            // 93
    }                                                                                                                // 94
    if (field.sortDirection.get() === -1) {                                                                          // 95
      sortedRows.reverse();                                                                                          // 96
    }                                                                                                                // 97
  });                                                                                                                // 98
  return sortedRows;                                                                                                 // 99
};                                                                                                                   // 100
                                                                                                                     // 101
getPrimarySortField = function (fields, multiColumnSort) {                                                           // 102
  return getSortedFields(fields, multiColumnSort)[0];                                                                // 103
};                                                                                                                   // 104
                                                                                                                     // 105
changePrimarySort = function(fieldId, fields, multiColumnSort) {                                                     // 106
  var primarySortField = getPrimarySortField(fields, multiColumnSort);                                               // 107
  if (primarySortField && primarySortField.fieldId === fieldId) {                                                    // 108
    var sortDirection = -1 * primarySortField.sortDirection.get();                                                   // 109
    primarySortField.sortDirection.set(sortDirection);                                                               // 110
    primarySortField.sortOrder.set(0);                                                                               // 111
  } else {                                                                                                           // 112
    _.each(fields, function (field) {                                                                                // 113
      if (field.fieldId === fieldId) {                                                                               // 114
        field.sortOrder.set(0);                                                                                      // 115
        if (primarySortField) {                                                                                      // 116
          field.sortDirection.set(primarySortField.sortDirection.get());                                             // 117
        }                                                                                                            // 118
      } else {                                                                                                       // 119
        var sortOrder = 1 + field.sortOrder.get();                                                                   // 120
        field.sortOrder.set(sortOrder);                                                                              // 121
      }                                                                                                              // 122
    });                                                                                                              // 123
  }                                                                                                                  // 124
};                                                                                                                   // 125
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);






(function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// packages/aslagle_reactive-table/lib/filter.js                                                                     //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
var parseFilterString = function (filterString) {                                                                    // 1
  var startQuoteRegExp = /^[\'\"]/;                                                                                  // 2
  var endQuoteRegExp = /[\'\"]$/;                                                                                    // 3
  var filters = [];                                                                                                  // 4
  var words = filterString.split(' ');                                                                               // 5
                                                                                                                     // 6
  var inQuote = false;                                                                                               // 7
  var quotedWord = '';                                                                                               // 8
  _.each(words, function (word) {                                                                                    // 9
    if (inQuote) {                                                                                                   // 10
      if (endQuoteRegExp.test(word)) {                                                                               // 11
        filters.push(quotedWord + ' ' + word.slice(0, word.length - 1));                                             // 12
        inQuote = false;                                                                                             // 13
        quotedWord = '';                                                                                             // 14
      } else {                                                                                                       // 15
        quotedWord = quotedWord + ' ' + word;                                                                        // 16
      }                                                                                                              // 17
    } else if (startQuoteRegExp.test(word)) {                                                                        // 18
      if (endQuoteRegExp.test(word)) {                                                                               // 19
        filters.push(word.slice(1, word.length - 1));                                                                // 20
      } else {                                                                                                       // 21
        inQuote = true;                                                                                              // 22
        quotedWord = word.slice(1, word.length);                                                                     // 23
      }                                                                                                              // 24
    } else {                                                                                                         // 25
      filters.push(word);                                                                                            // 26
    }                                                                                                                // 27
  });                                                                                                                // 28
  return filters;                                                                                                    // 29
};                                                                                                                   // 30
                                                                                                                     // 31
var escapeRegex = function(text) {                                                                                   // 32
  return text.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&");                                                           // 33
};                                                                                                                   // 34
                                                                                                                     // 35
var getFieldMatches = function (field) {                                                                             // 36
  var fieldMatches = [];                                                                                             // 37
  var keys = field.split('.');                                                                                       // 38
  var previousKeys = '';                                                                                             // 39
  _.each(keys, function (key) {                                                                                      // 40
    fieldMatches.push(previousKeys + key);                                                                           // 41
    previousKeys += key + '.';                                                                                       // 42
  });                                                                                                                // 43
  return fieldMatches;                                                                                               // 44
};                                                                                                                   // 45
                                                                                                                     // 46
getFilterQuery = function (filterInputs, filterFields, settings) {                                                   // 47
  settings = settings || {};                                                                                         // 48
  if (settings.enableRegex === undefined) {                                                                          // 49
    settings.enableRegex = false;                                                                                    // 50
  }                                                                                                                  // 51
  if (settings.filterOperator === undefined) {                                                                       // 52
    settings.filterOperator = "$and";                                                                                // 53
  }                                                                                                                  // 54
  if (settings.fields) {                                                                                             // 55
    _.each(filterInputs, function (filter, index) {                                                                  // 56
      if (_.any(settings.fields, function (include) { return include; })) {                                          // 57
        filterFields[index] = _.filter(filterFields[index], function (field) {                                       // 58
          return _.any(getFieldMatches(field), function (fieldMatch) {                                               // 59
            return settings.fields[fieldMatch];                                                                      // 60
          });                                                                                                        // 61
        });                                                                                                          // 62
      } else {                                                                                                       // 63
        filterFields[index] = _.filter(filterFields[index], function (field) {                                       // 64
          return _.all(getFieldMatches(field), function (fieldMatch) {                                               // 65
            return _.isUndefined(settings.fields[fieldMatch]) || settings.fields[fieldMatch];                        // 66
          });                                                                                                        // 67
        });                                                                                                          // 68
      }                                                                                                              // 69
    });                                                                                                              // 70
  }                                                                                                                  // 71
  var numberRegExp = /^\d+$/;                                                                                        // 72
  var queryList = [];                                                                                                // 73
  _.each(filterInputs, function (filter, index) {                                                                    // 74
    if (filter) {                                                                                                    // 75
      if (_.isObject(filter)) {                                                                                      // 76
        var fieldQueries = _.map(filterFields[index], function (field) {                                             // 77
          var query = {};                                                                                            // 78
          query[field] = filter;                                                                                     // 79
          return query;                                                                                              // 80
        });                                                                                                          // 81
        if (fieldQueries.length) {                                                                                   // 82
            queryList.push({'$or': fieldQueries});                                                                   // 83
          }                                                                                                          // 84
      } else {                                                                                                       // 85
        var filters = parseFilterString(filter);                                                                     // 86
        _.each(filters, function (filterWord) {                                                                      // 87
          if (settings.enableRegex === false) {                                                                      // 88
            filterWord = escapeRegex(filterWord);                                                                    // 89
          }                                                                                                          // 90
          var filterQueryList = [];                                                                                  // 91
          _.each(filterFields[index], function (field) {                                                             // 92
            var filterRegExp = new RegExp(filterWord, 'i');                                                          // 93
            var query = {};                                                                                          // 94
            query[field] = filterRegExp;                                                                             // 95
            filterQueryList.push(query);                                                                             // 96
                                                                                                                     // 97
            if (numberRegExp.test(filterWord)) {                                                                     // 98
              var numberQuery = {};                                                                                  // 99
              numberQuery[field] = parseInt(filterWord, 10);                                                         // 100
              filterQueryList.push(numberQuery);                                                                     // 101
            }                                                                                                        // 102
                                                                                                                     // 103
            if (filterWord === "true") {                                                                             // 104
              var boolQuery = {};                                                                                    // 105
              boolQuery[field] = true;                                                                               // 106
              filterQueryList.push(boolQuery);                                                                       // 107
            } else if (filterWord === "false") {                                                                     // 108
              var boolQuery = {};                                                                                    // 109
              boolQuery[field] = false;                                                                              // 110
              filterQueryList.push(boolQuery);                                                                       // 111
            }                                                                                                        // 112
          });                                                                                                        // 113
                                                                                                                     // 114
          if (filterQueryList.length) {                                                                              // 115
            var filterQuery = {'$or': filterQueryList};                                                              // 116
            queryList.push(filterQuery);                                                                             // 117
          }                                                                                                          // 118
        });                                                                                                          // 119
      }                                                                                                              // 120
    }                                                                                                                // 121
  });                                                                                                                // 122
                                                                                                                     // 123
  var query = {};                                                                                                    // 124
                                                                                                                     // 125
  if(queryList.length) {                                                                                             // 126
    query[settings.filterOperator] = queryList;                                                                      // 127
  }                                                                                                                  // 128
                                                                                                                     // 129
  return query;                                                                                                      // 130
};                                                                                                                   // 131
                                                                                                                     // 132
if (Meteor.isClient) {                                                                                               // 133
  ReactiveTable = ReactiveTable || {};                                                                               // 134
                                                                                                                     // 135
  var reactiveTableFilters = {};                                                                                     // 136
  var callbacks = {};                                                                                                // 137
                                                                                                                     // 138
  ReactiveTable.Filter = function (id, fields) {                                                                     // 139
    if (reactiveTableFilters[id]) {                                                                                  // 140
        return reactiveTableFilters[id];                                                                             // 141
    }                                                                                                                // 142
                                                                                                                     // 143
    var filter = new ReactiveVar();                                                                                  // 144
                                                                                                                     // 145
    this.fields = fields;                                                                                            // 146
                                                                                                                     // 147
    this.get = function () {                                                                                         // 148
      return filter.get() || '';                                                                                     // 149
    };                                                                                                               // 150
                                                                                                                     // 151
    this.set = function (filterString) {                                                                             // 152
      filter.set(filterString);                                                                                      // 153
      _.each(callbacks[id], function (callback) {                                                                    // 154
        callback();                                                                                                  // 155
      });                                                                                                            // 156
    };                                                                                                               // 157
                                                                                                                     // 158
    reactiveTableFilters[id] = this;                                                                                 // 159
  };                                                                                                                 // 160
                                                                                                                     // 161
  ReactiveTable.clearFilters = function (filterIds) {                                                                // 162
    _.each(filterIds, function (filterId) {                                                                          // 163
      if (reactiveTableFilters[filterId]) {                                                                          // 164
        reactiveTableFilters[filterId].set('');                                                                      // 165
      }                                                                                                              // 166
    });                                                                                                              // 167
  };                                                                                                                 // 168
                                                                                                                     // 169
  dependOnFilters = function (filterIds, callback) {                                                                 // 170
    _.each(filterIds, function (filterId) {                                                                          // 171
      if (_.isUndefined(callbacks[filterId])) {                                                                      // 172
        callbacks[filterId] = [];                                                                                    // 173
      }                                                                                                              // 174
      callbacks[filterId].push(callback);                                                                            // 175
    });                                                                                                              // 176
  };                                                                                                                 // 177
                                                                                                                     // 178
  getFilterStrings = function (filterIds) {                                                                          // 179
    return _.map(filterIds, function (filterId) {                                                                    // 180
      if (_.isUndefined(reactiveTableFilters[filterId])) {                                                           // 181
        reactiveTableFilters[filterId] = new ReactiveTable.Filter(filterId);                                         // 182
      }                                                                                                              // 183
      return reactiveTableFilters[filterId].get();                                                                   // 184
    });                                                                                                              // 185
  };                                                                                                                 // 186
                                                                                                                     // 187
  getFilterFields = function (filterIds, allFields) {                                                                // 188
    return _.map(filterIds, function (filterId) {                                                                    // 189
      if (_.isUndefined(reactiveTableFilters[filterId])) {                                                           // 190
        return _.map(allFields, function (field) { return field.key; });                                             // 191
      } else if (_.isEmpty(reactiveTableFilters[filterId].fields)) {                                                 // 192
        return _.map(allFields, function (field) { return field.key; });                                             // 193
      } else {                                                                                                       // 194
        return reactiveTableFilters[filterId].fields;                                                                // 195
      }                                                                                                              // 196
    });                                                                                                              // 197
  };                                                                                                                 // 198
                                                                                                                     // 199
  Template.reactiveTableFilter.helpers({                                                                             // 200
    'class': function () {                                                                                           // 201
      return this.class || 'input-group';                                                                            // 202
    },                                                                                                               // 203
                                                                                                                     // 204
    'filter': function () {                                                                                          // 205
      if (_.isUndefined(reactiveTableFilters[this.id])) {                                                            // 206
        new ReactiveTable.Filter(this.id, this.fields);                                                              // 207
      } else if (_.isUndefined(reactiveTableFilters[this.id].fields)) {                                              // 208
        reactiveTableFilters[this.id].fields = this.fields;                                                          // 209
      }                                                                                                              // 210
      return reactiveTableFilters[this.id].get();                                                                    // 211
    }                                                                                                                // 212
  });                                                                                                                // 213
                                                                                                                     // 214
  var updateFilter = _.debounce(function (template, filterText) {                                                    // 215
    reactiveTableFilters[template.data.id].set(filterText);                                                          // 216
  }, 200);                                                                                                           // 217
                                                                                                                     // 218
  Template.reactiveTableFilter.events({                                                                              // 219
    'keyup .reactive-table-input, input .reactive-table-input': function (event) {                                   // 220
      var template = Template.instance();                                                                            // 221
      var filterText = $(event.target).val();                                                                        // 222
      updateFilter(template, filterText);                                                                            // 223
    },                                                                                                               // 224
  });                                                                                                                // 225
}                                                                                                                    // 226
                                                                                                                     // 227
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}).call(this);


/* Exports */
if (typeof Package === 'undefined') Package = {};
(function (pkg, symbols) {
  for (var s in symbols)
    (s in pkg) || (pkg[s] = symbols[s]);
})(Package['aslagle:reactive-table'] = {}, {
  ReactiveTable: ReactiveTable
});

})();
