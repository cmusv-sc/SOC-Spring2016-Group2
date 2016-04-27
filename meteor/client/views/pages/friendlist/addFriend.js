
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
    var myid = Session.get("myid")
    var id = Session.get("findid")
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

Template.addFriendInfo.events({
  'click .button2': function (event) {
    event.preventDefault();
    var myid = Session.get("myid")
    var friendid = Session.get("findid")
    var myname = User2.findOne(myid).name;
    var mysummary = User2.findOne(myid).summary;
    var count = Friends.find({myid: myid, friendid: friendid}).count();
    var count2 = Requests.find({senderid: myid, receiverid: friendid}).count();

    if (friendid == myid) {
        Session.setPersistent("summarysession", "This is yourself. What are you doing?");
    } else if (count == 0){
        if (count2 == 0) {
            Requests.insert({receiverid: friendid, senderid: myid, sendername: myname,
                        createdAt: new Date(), sendersummary: mysummary});
            window.location.href='/addFriend'
        } else {
            Session.setPersistent("summarysession", "You already sent a request");
        }
    } else {
        Session.setPersistent("summarysession", "This Persion is already your friend");
    }
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

Template.recommend.onCreated(function () {
    var name1 = ""
    var name2 = ""
    var name3 = ""
    var count1 = -1
    var count2 = -1
    var count3 = -1

    var myid = Session.get("myid")

    Friends.find(
      {
        myid: myid
      }
    ).forEach(function(obj){
        var friendid = obj.friendid
        Friends.find(
          {
            myid: friendid
          }
        ).forEach(function(ob){
            var second = ob.friendid
            var secondname = ob.name
            if (second != myid && Friends.find({myid: myid, friendid: second}).count() == 0) {
            	var count = 0
            	Friends.find(
		          {
		            myid: second
		          }
        		).forEach(function(ob2){
        			var thirdid = ob2.friendid
        			count += Friends.find({myid: myid, friendid: thirdid}).count()
        		})
                if (count > count1) {
                	name3 = name2
                	name2 = name1
                    name1 = secondname

                    var summary1 = Session.get("recommendsum1")
                    var summary2 = Session.get("recommendsum2")
                    var id1 = Session.get("recommendid1")
                    var id2 = Session.get("recommendid2")
                    Session.setPersistent("recommendid3", id2);
                    Session.setPersistent("recommendsum3", summary2);
                    Session.setPersistent("recommendid2", id1);
                    Session.setPersistent("recommendsum2", summary1);
                    Session.setPersistent("recommendid1", second);
                    Session.setPersistent("recommendsum1", ob.summary);
                    count3 = count2
                    count2 = count1
                    count1 = count
                } else if (count > count2 && secondname != name1) {
                	name3 = name2
                    name2 = secondname
                    var summary2 = Session.get("recommendsum2")
                    var id2 = Session.get("recommendid2")
                    Session.setPersistent("recommendid3", id2);
                    Session.setPersistent("recommendsum3", summary2);
                    Session.setPersistent("recommendid2", second);
                    Session.setPersistent("recommendsum2", ob.summary);
                    count3 = count2
                    count2 = count
                } else if (count > count3 && secondname != name1 && secondname != name2) {
                    name3 = secondname
                    Session.setPersistent("recommendid3", second);
                    Session.setPersistent("recommendsum3", ob.summary);
                    count3 = count
                }
            }
        })
    })

    Template.recommend.name1 = name1
    Template.recommend.name2 = name2
    Template.recommend.name3 = name3

});

Template.recommend.events({
  'click .recommend1'(event, template) {
    event.preventDefault();
    var id = Session.get("recommendid1")
    var summary = Session.get("recommendsum1")
    Session.setPersistent("findid", id);
    Session.setPersistent("namesession", Template.recommend.name1);
    Session.setPersistent("summarysession", summary);
    window.location.href='/addFriendInfo'
  },
});

Template.recommend.events({
  'click .recommend2'(event, template) {
    event.preventDefault();
    var id = Session.get("recommendid2")
    var summary = Session.get("recommendsum2")
    Session.setPersistent("findid", id);
    Session.setPersistent("namesession", Template.recommend.name2);
    Session.setPersistent("summarysession", summary);
    window.location.href='/addFriendInfo'
  },
});

Template.recommend.events({
  'click .recommend3'(event, template) {
    event.preventDefault();
    var id = Session.get("recommendid3")
    var summary = Session.get("recommendsum3")
    Session.setPersistent("findid", id);
    Session.setPersistent("namesession", Template.recommend.name3);
    Session.setPersistent("summarysession", summary);
    window.location.href='/addFriendInfo'
  },
});