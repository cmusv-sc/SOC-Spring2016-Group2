//Friends = new Mongo.Collection('friends');
//User2 = new Mongo.Collection('usersdatabase');

// mongodb://user:pass@host:port/dbname


Friends = new Mongo.Collection("friends");
User2 = new Mongo.Collection('usersdatabase');
Requests = new Mongo.Collection('requests');

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