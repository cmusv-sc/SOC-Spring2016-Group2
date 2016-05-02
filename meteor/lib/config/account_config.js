var SubmitFunc = function(error, state){
  
  if (!error) {

    if (state === "signIn") {
        
        // Successfully logged in
        console.log("[INFO] User Signed In");
        
        // Redirect to home page
        Router.go('/dashboard1');

        // Debug: Console
        var currentUserID = Meteor.userId();
        var currentUserName = Meteor.user().username;
        console.log("[INFO] Current User ID: " + currentUserID);

        // Set user session
        Session.setPersistent("userSessionId", currentUserID);
        Session.setPersistent("userSessionName", currentUserName);
    }

    if (state === "signUp") {
        // Successfully registered
        console.log("[INFO] User registered");
        // Redirect to home page
        Router.go('/dashboard1');
    }
  }
};


var PostSubmitFunc = function(error, state){

    if (!error) {
        if (state === "signUp") {
      
            // Successfully registered
            console.log("[SUCCESS] User registered into database");

            // Redirect to dashboard
            Router.go('/dashboard1');
        }
    }
};

AccountsTemplates.configure({
    // Behavior
    confirmPassword: true,
    enablePasswordChange: true,
    forbidClientAccountCreation: false,
    overrideLoginErrors: true,
    sendVerificationEmail: true,
    lowercaseUsername: false,
    focusFirstInput: true,

    // Appearance
    showAddRemoveServices: false,
    showForgotPasswordLink: true,
    showLabels: true,
    showPlaceholders: true,
    showResendVerificationEmailLink: true,

    // Client-side Validation
    continuousValidation: true,
    negativeFeedback: false,
    negativeValidation: true,
    positiveValidation: true,
    positiveFeedback: true,
    showValidating: true,

    // Privacy Policy and Terms of Use
    // privacyUrl: 'privacy',
    // termsUrl: 'terms-of-use',

    // Redirects
    homeRoutePath: '/dashboard1',
    redirectTimeout: 4000,

    // Hooks
    
    //onLogoutHook: myLogoutFunc,
    onSubmitHook: SubmitFunc,
    //preSignUpHook: myPreSubmitFunc,
    postSignUpHook: PostSubmitFunc,

    // Texts
    
});


