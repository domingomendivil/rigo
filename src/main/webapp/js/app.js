(function(){
	var api = {
			collections:{},
			models:{},
			views:{},
			init: function(){this.content = $("#main");
			}
	};
	Backbone.history.start();
	
	api.init();
	
	//var login = new LoginView();
	//login.init();
	console.log("login created")
	return api;
})();