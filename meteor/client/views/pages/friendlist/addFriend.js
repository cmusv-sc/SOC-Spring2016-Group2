
Template.addFriend.helpers({
    settings: function () {
        return {
            rowsPerPage: 10,
            showFilter: true,
            fields: [
                {
                    fieldId: 'name',
                    key: 'name',
                    label: 'Name',
                },
            ]
        };
    }
});

var searchName;
var weatherDep = new Tracker.Dependency;

Template.addFriend.helpers({
    myCollection: function () {
        weatherDep.depend()
        return User2.find({name : {$regex : ".*" + searchName + ".*"}}).fetch();
    }
});

Template.addFriend.events({
  'click .reactive-table tbody tr': function (event) {
    event.preventDefault();
    var post = this;
    // checks if the actual clicked element has the class `delete`
    if (event.target.className == "name") {
        Session.setPersistent("findid", this._id);
        Session.setPersistent("namesession", this.name);
        Session.setPersistent("summarysession", this.summary);
        window.location.href='/addFriendInfo'
    }
  }
});

Template.addFriendInfo.helpers({
  context: function() {
    var result = _.clone(this);
    var person = Session.get("namesession")
    var summary = Session.get("summarysession")
    result.name = person;
    result.summary = summary;
    return result;
  }
});

Template.addFriendInfo.events({
  'click .button2': function (event) {
    event.preventDefault();
    var myid = Session.get("myid")
    var friendid = Session.get("findid")
    var myname = User2.findOne(myid).name;
    var mysummary = User2.findOne(myid).summary;
    Requests.insert({receiverid: friendid, senderid: myid, sendername: myname,
                createdAt: new Date(), sendersummary: mysummary});

    window.location.href='/addFriend'
  }
});


Template.registerHelper('formatDate', function(date) {
  return moment(date).format('MM-DD-YYYY');
});

Template.searchFriend.events({
  'click button'(event, template) {
    event.preventDefault();
    // increment the counter when button is clicked
    searchName = template.find(".search_box").value;
    weatherDep.changed();
    //window.location.href='/add'
  },
});
