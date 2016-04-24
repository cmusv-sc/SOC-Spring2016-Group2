(function(){
Template.friendlisthome.helpers({

    settings: function () {

        return {
            collection: Friends,
            rowsPerPage: 10,
            showFilter: true,
            id: "allfriends",
            fields: [
                {
                    fieldId: 'name',
                    key: 'name',
                    label: 'Name',
                },
                {
                    fieldId: 'createdAt',
                    key: 'createdAt',
                    label: 'Add Time',
                    fn: function (value) { return moment(value).format('MM-DD-YYYY'); }
                }
            ]
        };
    }
});


Template.request.helpers({

    settings: function () {

        return {
            collection: Requests,
            rowsPerPage: 1,
            showFilter: false,
            showNavigation: "never",
            showNavigationRowsPerPage: false,
            id: "allrequests",
            fields: [
                {
                    fieldId: 'name',
                    key: 'name',
                    label: 'Friend Request',
                },
                {
                    fieldId: 'createdAt',
                    key: 'createdAt',
                    label: 'Request Time',
                    sortOrder: 0,
                    fn: function (value) { return moment(value).format('MM-DD-YYYY'); }
                }
            ]
        };
    }
});

Template.friendlisthome.events({
  'click #allfriends tbody tr': function (event) {
    event.preventDefault();
    var post = this;
    // checks if the actual clicked element has the class `delete`
    if (event.target.className == "name") {
        Session.setPersistent("idsession", this._id);
        Session.setPersistent("namesession", this.name);
        Session.setPersistent("summarysession", this.summary);
        window.location.href='/viewFriendInfo'

    }
  }
});

Template.request.events({
  'click #allrequests tbody tr': function (event) {
    event.preventDefault();
    var post = this;
    // checks if the actual clicked element has the class `delete`
    if (event.target.className == "name") {
        Session.setPersistent("idsession", this._id);
        Session.setPersistent("namesession", this.name);
        Session.setPersistent("summarysession", this.summary);
        window.location.href='/viewRequestInfo'

    }
  }
});

Template.viewFriendInfo.helpers({
  context: function() {
    var result = _.clone(this);
    var person = Session.get("namesession")
    var summary = Session.get("summarysession")
    result.name = person;
    result.summary = summary;
    return result;
  }
});

Template.viewRequestInfo.helpers({
  context: function() {
    var result = _.clone(this);
    var person = Session.get("namesession")
    var summary = Session.get("summarysession")
    result.name = person;
    result.summary = summary;
    return result;
  }
});

Template.viewFriendInfo.events({
  'click .button2': function (event) {
    event.preventDefault();
    var id = Session.get("idsession")
    Friends.remove(id);
    window.location.href='/friendlisthome'
  }
});

Template.registerHelper('formatDate', function(date) {
  return moment(date).format('MM-DD-YYYY');
});

Template.request.events({
  'click #decline'(event, template) {
    event.preventDefault();
    // increment the counter when button is clicked
    var id = Requests.findOne()._id;
    Requests.remove(id);
    //window.location.href='/add'
  },
});

Template.request.events({
  'click #accept'(event, template) {
    event.preventDefault();
    // increment the counter when button is clicked
    var id = Requests.findOne()._id;
    var name = Requests.findOne().name;
    var summary = Requests.findOne().summary;
    Friends.insert({name: name, createdAt: new Date(),
                    summary: summary});
    Requests.remove(id);
    //window.location.href='/add'
  },
});

Template.request.events({
  'click #ignore'(event, template) {
    event.preventDefault();
    // increment the counter when button is clicked
    var id = Requests.findOne()._id;
    var name = Requests.findOne().name;
    var summary = Requests.findOne().summary;
    Requests.insert({name: name, createdAt: new Date(),
                    summary: summary});
    Requests.remove(id);
    //window.location.href='/add'
  },
});
}).call(this);
