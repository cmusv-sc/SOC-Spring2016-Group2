Template.myTemplate.events({
      'submit form': function(event){
 event.preventDefault();
 var textValue = event.target.myForm.value;
 console.log(textValue);
 event.target.myForm.value = "";
      }
   });