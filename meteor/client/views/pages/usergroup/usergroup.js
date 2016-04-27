Template.usergroup.onCreated( function() {
  this.currentTab = new ReactiveVar( "publicgroup" );
});

Template.usergroup.helpers({
  tab: function() {
    return Template.instance().currentTab.get();
  },
  tabData: function() {
    var tab = Template.instance().currentTab.get();

    var data = {
      "publicgroup": [
        { "name": "Seeking Wisdom: From Darwin to Munger", "creator": "Peter Bevelin" },
        { "name": "Seeking Wisdom: From Darwin to Munger", "creator": "Peter Bevelin" },
        { "name": "Seeking Wisdom: From Darwin to Munger", "creator": "Peter Bevelin" },
      ],
      "privategroup": [
        { "name": "Seeking Wisdom: From Darwin to Munger", "creator": "Peter Bevelin" },
        { "name": "Seeking Wisdom: From Darwin to Munger", "creator": "Peter Bevelin" },
        { "name": "Seeking Wisdom: From Darwin to Munger", "creator": "Peter Bevelin" },
      ]

    };

    return data[ tab ];
  },
  getData: function() {
    //console.log("ID: " + Router.current().params.query.id);
    var url = "http://localhost:9000/groups/publicgroup";
    fetchData(url);
  },
});

var fetchData = function(url){
  Meteor.call('fetchFromService', url, function (err, res){
    var obj = JSON.stringify(res.data);
    var nestable = $('#nestable');
    // console.log(renderComments(res.data));
    nestable.append($(renderComments(res.data)));
  });
}
var renderComments = function(obj){
  if (obj.length == 0) {
    return "";
  }
  var s = "<ol class='dd-list'>";
  
  for (var i = 0; i < obj.length; i++) {
    var c = obj[i];
    var item = "<li class='dd-item'><div class='social-feed-box'>";
    item += "<div class='social-avatar'><div class='media-body'><span class='text-success'>User: " + c.groupname + "</span><small class='pull-right'> " + "DATE" + "</small></div></div>";
    item += "<div class='social-body'><p>" + c.createrid + "</p>";
    item += "<a href='# class='small' style='color: #676a6c;'><i class='fa fa-thumbs-up'></i></a> " + c.intro + " <a href='#'' class='small' style='color: #676a6c;''><i class='fa fa-thumbs-down'></i></a> " + c.type + "<p></p>";
    item += "<div class='input-group'><input type='text' class='form-control input-sm' id='input-" + c.intro + "'><div class='input-group-btn'><button class='btn btn-sm btn-success btn-reply' id='reply-" + c.types + "'>Reply</button></div></div></div></div>";
    item += renderComments(c.children);
    item += "</li>";
    s += item;
  };
  
  s += "</ol>";
  return s;
}
Template.usergroup.events({
  'click .nav-pills li': function( event, template ) {
    var currentTab = $( event.target ).closest( "li" );

    currentTab.addClass( "active" );
    $( ".nav-pills li" ).not( currentTab ).removeClass( "active" );

    template.currentTab.set( currentTab.data( "template" ) );
  }
});