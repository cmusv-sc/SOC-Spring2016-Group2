Friends = new Mongo.Collection('friends');
User2 = new Mongo.Collection('usersdatabase');

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
