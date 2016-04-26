//Friends = new Mongo.Collection('friends');
//User2 = new Mongo.Collection('usersdatabase');

// mongodb://user:pass@host:port/dbname


Friends = new Mongo.Collection("friends");
User2 = new Mongo.Collection('usersdatabase');
Requests = new Mongo.Collection('requests');

Posts = new Mongo.Collection('posts');

  Friends.allow({
    'insert': function (userId,doc) {
      /* user and doc checks ,
      return true to allow insert */
      return true; 
    }
  });


  Friends.allow({
    'remove': function (userId,doc) {
      /* user and doc checks ,
      return true to allow insert */
      return true; 
    }
  });

  User2.allow({
    'insert': function (userId,doc) {
      /* user and doc checks ,
      return true to allow insert */
      return true; 
    }
  });


  User2.allow({
    'remove': function (userId,doc) {
      /* user and doc checks ,
      return true to allow insert */
      return true; 
    }
  });
  
  Requests.allow({
    'insert': function (userId,doc) {
      /* user and doc checks ,
      return true to allow insert */
      return true; 
    }
  });


  Requests.allow({
    'remove': function (userId,doc) {
      /* user and doc checks ,
      return true to allow insert */
      return true; 
    }
  });

  Posts.allow({
    'insert': function(userId, doc) {
      return true;
    }
  });

  Meteor.methods({
    fetchFromService: function(url) {

      var convertAsyncToSync  = Meteor.wrapAsync( HTTP.get );
      var resultOfAsyncToSync = convertAsyncToSync(url, {} );

      return resultOfAsyncToSync;
    },
    postToBackend: function(url, args) {
      var convertAsyncToSync  = Meteor.wrapAsync( HTTP.post );
      var resultOfAsyncToSync = convertAsyncToSync(url, {data: args} );

      return resultOfAsyncToSync;
    },
    deleteInBackend: function(url) {
      var convertAsyncToSync  = Meteor.wrapAsync( HTTP.call );
      var resultOfAsyncToSync = convertAsyncToSync("DELETE", url, {} );

      return resultOfAsyncToSync;
    },
    removeAllPosts: function() {
      Posts.remove({});
    }
  });
