
Template.friendlisthome.helpers({

    settings: function () {

        return {
            collection: Friends,
            rowsPerPage: 10,
            showFilter: true,
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


Template.friendlisthome.events({
  'click .reactive-table tbody tr': function (event) {
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

Template.viewFriendInfo.events({
  'click .button2': function (event) {
    event.preventDefault();
    var id = Session.get("idsession")
    Friends.remove(id);
    window.location.href='/friendlisthome'
  }
});


