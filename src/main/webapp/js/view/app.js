window.app = {};




var AppRouter = Backbone.Router.extend({
    routes: {
        "cancelBooking": "cancel"
    },
    cancel: function(){
    	console.log("router cancel");
    	var cancel = new App.Views.CancelBookingView();
    	cancel.render();
    }
});
// Initiate the router
var app_router = new AppRouter;


// Start Backbone history a necessary step for bookmarkable URL's
Backbone.history.start();





$(document).ready(function () {
    var people2 = new App.Collections.People();
    var loginView = new App.Views.LoginView({model: people2});
    $("#container").html(loginView.render().el);
    
});




var App = {

	    Views: {},
	    Models: {},
	    Collections: {},
	    Router: {}
	}



