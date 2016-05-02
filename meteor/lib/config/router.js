
// Default Layout and routing
Router.configure({
    layoutTemplate: 'mainLayout',
});

AccountsTemplates.configure({
    defaultLayout: 'blankLayout',
});

Router.route('/', function () {
    Router.go('/dashboard1');
});

Router.route('/paperedit', function () {
    this.render('paperedit');
});
// Authentication required
Router.plugin('ensureSignedIn', {
  except: ['/', 'login', 'register', 'signIn',
            'signUp', 'changePwd', 'enrollAccount',
            'forgotPwd', 'resetPwd', 'verifyEmail']
});

// Authentication: user accounts management
AccountsTemplates.configureRoute('signIn');
AccountsTemplates.configureRoute('signUp');
AccountsTemplates.configureRoute('changePwd');
AccountsTemplates.configureRoute('enrollAccount');
AccountsTemplates.configureRoute('forgotPwd');
AccountsTemplates.configureRoute('resetPwd');
AccountsTemplates.configureRoute('verifyEmail');


// Common pages routes
Router.route('/nav', function () {
    this.render('nav');
});

//userprofile
Router.route('/userprofile', function () {
    this.render('userprofile');
});

// Features: Friendlist
Router.route('/friendlisthome', function () {
    this.render('friendlisthome');
});

Router.route('/addFriend', function () {
    this.render('addFriend');
});

Router.route('/addFriendInfo', function () {
    this.render('addFriendInfo');
});

Router.route('/viewFriendInfo', function () {
    this.render('viewFriendInfo');
});

Router.route('/viewRequestInfo', function () {
    this.render('viewRequestInfo');
});

// Features: Suggestion
Router.route('/suggestion', function () {
    this.render('suggestion');
});

// Features: Post
Router.route('/postPage', function() {
	this.render('postPage')
});
Router.route('/postDetail', function () {
    this.render('postDetail');
});

// Features: Forum
Router.route('/forumlist', function () {
    this.render('forumlist');
});

Router.route('/popularity', function () {
    this.render('popularity');
});

Router.route('/findpaper', function () {
    this.render('findpaper');
});

Router.route('/paperdetail', function () {
    this.render('paperdetail');
});

// Subscribe
Router.route('/subscriptionlist', function () {
    this.render('subscriptionlist');
});

Router.route('/timeline', function () {
    this.render('timeline');
});

//
// Dashboards routes
//

Router.route('/dashboard1', function () {
    this.render('dashboard1');
});
Router.route('/dashboard2', function () {
    this.render('dashboard2');
});
Router.route('/dashboard3', function () {
    this.render('dashboard3');
});
Router.route('/dashboard4', function () {
    this.render('dashboard4');
    this.layout('layout2');
});
Router.route('/dashboard4l', function () {
    this.render('dashboard4l');
});
Router.route('/dashboard5', function () {
    this.render('dashboard5');
});


//
// Layouts route
//

Router.route('/layouts', function () {
    this.render('layouts');
});


Router.route('/profile', function () {
    this.render('profile');
});


//
// Other pages
//

Router.route('/searchResult', function () {
    this.render('searchResult');
});


Router.route('/errorOne', function () {
    this.render('errorOne');
    this.layout('blankLayout')
});

Router.route('/errorTwo', function () {
    this.render('errorTwo');
    this.layout('blankLayout')
});

Router.route('/emptyPage', function () {
    this.render('emptyPage');
});

Router.route('/notFound', function () {
    this.render('notFound');
});
//user group
Router.route('/publicgroup',function(){
    this.render('publicgroup');
});
Router.route('/privategroup',function(){
    this.render('privategroup');
});
Router.route('/owngroup',function(){
    this.render('yourown');
});
Router.route('/notice',function(){
    this.render('notificaction');
});

Router.route('/group/:_id', {
    template: 'groupPage',
    data: function(){
        return {_id: this.params._id};
    }

});

Router.route('/newgroup',function(){
    this.render('createnewgroup');
});
