
Template.friendlisthome.helpers({

    settings: function () {

        return {
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

Template.friendlisthome.helpers({
    myCollection: function () {
        var myid = Session.get("myid")
        return Friends.find({myid : myid}).fetch();
    }
});

Template.friendlisthome.onCreated(function () {
    var myid = Session.get("userSessionId");
    var current = User2.findOne(myid);
    var myname
    if (current == null) {
        myname = "NoName"
    } else {
        myname = current.name
    }
    Template.friendlisthome.currentuser = myname
    Session.setPersistent("myid", myid);
});

Template.request.helpers({

    settings: function () {

        return {
            rowsPerPage: 1,
            showFilter: false,
            showNavigation: "never",
            showNavigationRowsPerPage: false,
            id: "allrequests",
            fields: [
                {
                    fieldId: 'sendername',
                    key: 'sendername',
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

Template.request.helpers({
    requestCollection: function () {
        var myid = Session.get("myid")
        return Requests.find({receiverid : myid}).fetch();
    }
});

Template.friendlisthome.events({
  'click #allfriends tbody tr': function (event) {
    event.preventDefault();
    var post = this;
    // checks if the actual clicked element has the class `delete`
    if (event.target.className == "name") {
        Session.setPersistent("idsession", this.friendid);
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
    if (event.target.className == "sendername") {
        Session.setPersistent("idsession", this.senderid);
        Session.setPersistent("namesession", this.sendername);
        Session.setPersistent("summarysession", this.sendersummary);
        window.location.href='/viewRequestInfo'

    }
  }
});

Template.viewFriendInfo.helpers({
  context: function() {
    var result = _.clone(this);
    var myid = Session.get("myid")
    var id = Session.get("idsession")
    var person = Session.get("namesession")
    var summary = Session.get("summarysession")
    var mutual = "";
    Friends.find(
      {
        myid: id
      }
    ).forEach(function(obj){
        var friendid = obj.friendid
        if (myid != friendid) {
            var count = Friends.find({myid: myid, friendid: friendid}).count();
            if (count > 0) {
                mutual = mutual + obj.name + "|";
            }
        }
    })
    if (mutual == "") {
        mutual = "None"
    }
    result.name = person;
    result.summary = summary;
    result.mutual = mutual;
    return result;
  }
});

Template.viewRequestInfo.helpers({
  context: function() {
    var result = _.clone(this);
    var myid = Session.get("myid")
    var id = Session.get("idsession")
    var person = Session.get("namesession")
    var summary = Session.get("summarysession")
    var mutual = "";
    Friends.find(
      {
        myid: id
      }
    ).forEach(function(obj){
        var friendid = obj.friendid
        if (myid != friendid) {
            var count = Friends.find({myid: myid, friendid: friendid}).count();
            if (count > 0) {
                mutual = mutual + obj.name + "|";
            }
        }
    })
    if (mutual == "") {
        mutual = "None"
    }
    result.name = person;
    result.summary = summary;
    result.mutual = mutual;
    return result;
  }
});

Template.viewFriendInfo.events({
  'click .button2': function (event) {
    event.preventDefault();
    var friendid = Session.get("idsession")
    var myid = Session.get("myid")
    var id1 = Friends.findOne({"myid": myid, "friendid": friendid})._id;
    var id2 = Friends.findOne({"myid": friendid, "friendid": myid})._id;
    Session.setPersistent("namesession", "");
    Session.setPersistent("summarysession", "Deleted Successfully");
    Friends.remove(id1)
    Friends.remove(id2)
  }
});

Template.registerHelper('formatDate', function(date) {
  return moment(date).format('MM-DD-YYYY');
});

Template.friendlisthome.events({
  'click #update'(event, template) {
    event.preventDefault();
    var myid = Session.get("myid")
    // increment the counter when button is clicked
    var name = User2.findOne({_id : myid}).name;
    var summary = template.find(".update_summary").value;
    var createdAt = User2.findOne({_id : myid}).createdAt;
    var services = User2.findOne({_id : myid}).services;
    var emails = User2.findOne({_id : myid}).emails;
    var profile = User2.findOne({_id : myid}).profile;
    template.find(".update_summary").value = "Updated Successfully!"
    User2.remove({_id : myid});
    User2.insert({_id : myid, name: name, summary: summary, createdAt: createdAt, services: services, emails: emails, profile: profile});
    //window.location.href='/add'
  },
});

Template.request.events({
  'click #decline'(event, template) {
    event.preventDefault();
    var myid = Session.get("myid")
    // increment the counter when button is clicked
    var id = Requests.findOne({receiverid : myid})._id;
    Requests.remove(id);
    //window.location.href='/add'
  },
});

Template.request.events({
  'click #accept'(event, template) {
    event.preventDefault();
    // increment the counter when button is clicked
    var myid = Session.get("myid")
    var id = Requests.findOne({receiverid : myid})._id;
    var friendid = Requests.findOne({receiverid : myid}).senderid;
    var friendname = Requests.findOne({receiverid : myid}).sendername;
    var friendsummary = Requests.findOne({receiverid : myid}).sendersummary;
    var date = new Date()
    var myname = User2.findOne(myid).name;
    var mysummary = User2.findOne(myid).summary;
    Friends.insert({myid: myid, friendid: friendid, name: friendname,
                    createdAt: date, summary: friendsummary});
    Friends.insert({myid: friendid, friendid: myid, name: myname,
                    createdAt: date, summary: mysummary});
    Requests.remove(id);
    //window.location.href='/add'
  },
});

Template.request.events({
  'click #ignore'(event, template) {
    event.preventDefault();
    var myid = Session.get("myid")
    // increment the counter when button is clicked
    var id = Requests.findOne({receiverid : myid})._id;
    var receiverid = myid;
    var senderid = Requests.findOne({receiverid : myid}).senderid;
    var sendername = Requests.findOne({receiverid : myid}).sendername;
    var sendersummary = Requests.findOne({receiverid : myid}).sendersummary;
    var createdAt = Requests.findOne({receiverid : myid}).createdAt;

    Requests.insert({receiverid: receiverid, senderid: senderid, sendername: sendername,
                createdAt: createdAt, sendersummary: sendersummary});
    
    Requests.remove(id);
    //window.location.href='/add'
  },
});