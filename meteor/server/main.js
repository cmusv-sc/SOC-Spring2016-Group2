//Friends = new Mongo.Collection('friends');
//User2 = new Mongo.Collection('usersdatabase');

// mongodb://user:pass@host:port/dbname

var database = new MongoInternals.RemoteCollectionDriver("mongodb://root:root@ec2-54-200-79-239.us-west-2.compute.amazonaws.com:27017/test");
Friends = new Mongo.Collection("friends", { _driver: database });
User2 = new Mongo.Collection('usersdatabase', { _driver: database });
Requests = new Mongo.Collection('requests', { _driver: database });

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