Template.myTemplate.events({
      'submit #searchPost': function(event){
          event.preventDefault();
          var textValue = event.target.searchContent.value;
          console.log(textValue);
          event.target.searchContent.value = "";
      }
   });
