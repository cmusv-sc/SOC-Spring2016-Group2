Router.configure({
    layoutTemplate: 'mainLayout',
});

AccountsTemplates.configure({
    defaultLayout: 'blankLayout',
});

Router.plugin('ensureSignedIn', {
  except: ['/', 'login', 'register', 'signIn',
            'signUp', 'changePwd', 'enrollAccount',
            'forgotPwd', 'resetPwd', 'verifyEmail']
});

AccountsTemplates.configureRoute('signIn');
AccountsTemplates.configureRoute('signUp');
AccountsTemplates.configureRoute('changePwd');
AccountsTemplates.configureRoute('enrollAccount');
AccountsTemplates.configureRoute('forgotPwd');
AccountsTemplates.configureRoute('resetPwd');
AccountsTemplates.configureRoute('verifyEmail');

// Router.add('/suggestions.txt', function() {
//     this.response.setHeader('access-control-allow-origin', '*');

//     var fs = Npm.require("fs");
//     return fs.readFileSync("/public/suggestions.txt", "utf8");

// });

// Common pages routes
Router.route('/notFound', function () {
    this.render('notFound');
});

Router.route('/nav', function () {
    this.render('nav');
});

// Default route
Router.route('/', function () {
    this.render('sign-in');
    this.layout('blankLayout')
});

// Account management
Router.route('/register', function () {
    this.render('register');
    this.layout('blankLayout')
});

Router.route('/login', function () {
    this.render('login');
    this.layout('blankLayout')
});

Router.route('/forgotPassword', function () {
    this.render('forgotPassword');
    this.layout('blankLayout')
});

// Friendlist
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

// Suggestion
Router.route('/suggestion', function () {
    this.render('suggestion');
});

// Post
Router.route('/postPage', function() {
	this.render('postPage')
});

//Forum
Router.route('/forumlist', function () {
    this.render('forumlist');
});

Router.route('/findpaper', function () {
    this.render('findpaper');
});

Router.route('/paperdetail', function () {
    this.render('paperdetail');
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

//
// Graphs routes
//

Router.route('/graphFlot', function () {
    this.render('graphFlot');
});

Router.route('/graphRickshaw', function () {
    this.render('graphRickshaw');
});

Router.route('/graphChartJs', function () {
    this.render('graphChartJs');
});

Router.route('/graphChartist', function () {
    this.render('graphChartist');
});

Router.route('/c3charts', function () {
    this.render('c3charts');
});

Router.route('/graphPeity', function () {
    this.render('graphPeity');
});

Router.route('/graphSparkline', function () {
    this.render('graphSparkline');
});

//
// Mailbox
//

Router.route('/mailbox', function () {
    this.render('mailbox');
});

Router.route('/emailView', function () {
    this.render('emailView');
});

Router.route('/emailCompose', function () {
    this.render('emailCompose');
});

Router.route('/emailTemplates', function () {
    this.render('emailTemplates');
});

//
// Widgets
//

Router.route('/widgets', function () {
    this.render('widgets');
});

//
// Metrics
//

Router.route('/metrics', function () {
    this.render('metrics');
});

//
// Forms
//

Router.route('/formBasic', function () {
    this.render('formBasic');
});

Router.route('/formAdvanced', function () {
    this.render('formAdvanced');
});

Router.route('/formWizard', function () {
    this.render('formWizard');
});

Router.route('/formUpload', function () {
    this.render('formUpload');
});

Router.route('/textEditor', function () {
    this.render('textEditor');
});

Router.route('/markdown', function () {
    this.render('markdown');
});

//
// App Views
//

Router.route('/contacts', function () {
    this.render('contacts');
});

Router.route('/profile', function () {
    this.render('profile');
});

Router.route('/profile2', function () {
    this.render('profile2');
});

Router.route('/contacts2', function () {
    this.render('contacts2');
});

Router.route('/projects', function () {
    this.render('projects');
});

Router.route('/projectDetail', function () {
    this.render('projectDetail');
});

Router.route('/teamsBoard', function () {
    this.render('teamsBoard');
});

Router.route('/socialFeed', function () {
    this.render('socialFeed');
});

Router.route('/clients', function () {
    this.render('clients');
});

Router.route('/fullHeight', function () {
    this.render('fullHeight');
});

Router.route('/offCanvas', function () {
    this.render('offCanvas');
});

Router.route('/voteList', function () {
    this.render('voteList');
});

Router.route('/fileManager', function () {
    this.render('fileManager');
});

Router.route('/calendar', function () {
    this.render('calendar');
});

Router.route('/issueTracker', function () {
    this.render('issueTracker');
});

Router.route('/blog', function () {
    this.render('blog');
});

Router.route('/article', function () {
    this.render('article');
});

Router.route('/faq', function () {
    this.render('faq');
});

Router.route('/timelineOne', function () {
    this.render('timelineOne');
});

Router.route('/pinBoard', function () {
    this.render('pinBoard');
});

//
// Other pages
//

Router.route('/searchResult', function () {
    this.render('searchResult');
});

Router.route('/lockScreen', function () {
    this.render('lockScreen');
    this.layout('blankLayout')
});

Router.route('/invoice', function () {
    this.render('invoice');
});

Router.route('/invoicePrint', function () {
    this.render('invoicePrint');
    this.layout('blankLayout')
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

//
// Miscellaneous
//

Router.route('/toastrNotification', function () {
    this.render('toastrNotification');
});

Router.route('/nestableList', function () {
    this.render('nestableList');
});

Router.route('/agileBoard', function () {
    this.render('agileBoard');
});

Router.route('/timelineTwo', function () {
    this.render('timelineTwo');
});

Router.route('/diff', function () {
    this.render('diff');
});

Router.route('/i18support', function () {
    this.render('i18support');
});

Router.route('/sweetAlert', function () {
    this.render('sweetAlert');
});

Router.route('/idleTimer', function () {
    this.render('idleTimer');
});

Router.route('/truncate', function () {
    this.render('truncate');
});

Router.route('/spinners', function () {
    this.render('spinners');
});

Router.route('/liveFavicon', function () {
    this.render('liveFavicon');
});

Router.route('/googleMaps', function () {
    this.render('googleMaps');
});

Router.route('/codeEditor', function () {
    this.render('codeEditor');
});

Router.route('/modalWindow', function () {
    this.render('modalWindow');
});

Router.route('/clipboard', function () {
    this.render('clipboard');
});

Router.route('/forumView', function () {
    this.render('forumView');
});

Router.route('/forumDetail', function () {
    this.render('forumDetail');
});

Router.route('/validation', function () {
    this.render('validation');
});

Router.route('/treeView', function () {
    this.render('treeView');
});

Router.route('/loadingButtons', function () {
    this.render('loadingButtons');
});

Router.route('/chatView', function () {
    this.render('chatView');
});

Router.route('/masonry', function () {
    this.render('masonry');
});

Router.route('/tour', function () {
    this.render('tour');
});

//
// UI Elements
//

Router.route('/typography', function () {
    this.render('typography');
});

Router.route('/icons', function () {
    this.render('icons');
});

Router.route('/draggablePanels', function () {
    this.render('draggablePanels');
});

Router.route('/resizeablePanels', function () {
    this.render('resizeablePanels');
});

Router.route('/buttons', function () {
    this.render('buttons');
});

Router.route('/video', function () {
    this.render('video');
});

Router.route('/tabsPanels', function () {
    this.render('tabsPanels');
});

Router.route('/tabs', function () {
    this.render('tabs');
});

Router.route('/notifications', function () {
    this.render('notifications');
});

Router.route('/badgesLabels', function () {
    this.render('badgesLabels');
});

//
// Grid Options
//

Router.route('/gridOptions', function () {
    this.render('gridOptions');
});

//
// Tables
//

Router.route('/tableStatic', function () {
    this.render('tableStatic');
});

Router.route('/dataTables', function () {
    this.render('dataTables');
});

Router.route('/fooTables', function () {
    this.render('fooTables');
});

//
// E-commerce
//

Router.route('/productsGrid', function () {
    this.render('productsGrid');
});

Router.route('/productsList', function () {
    this.render('productsList');
});

Router.route('/productEdit', function () {
    this.render('productEdit');
});

Router.route('/shopingCart', function () {
    this.render('shopingCart');
});

Router.route('/orders', function () {
    this.render('orders');
});

Router.route('/productDetail', function () {
    this.render('productDetail');
});

Router.route('/payments', function () {
    this.render('payments');
});

//
// Gallery
//

Router.route('/gallery', function () {
    this.render('gallery');
});

Router.route('/carusela', function () {
    this.render('carusela');
});

Router.route('/slick', function () {
    this.render('slick');
});


//
// CSS Animations
//

Router.route('/cssAnimations', function () {
    this.render('cssAnimations');
});

//
// Landing page
//

Router.route('/landing', function () {
    this.render('landing');
    this.layout('blankLayout')
});
