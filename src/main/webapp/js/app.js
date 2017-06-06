(function(){
	var api = {
			collections:{},
			models:{},
			views:{loginView:LoginView},
			init: function(){this.content = $("#main");
			}
	};
	Backbone.history.start();
	api.init();
	
	var login = new LoginView();
	login.init();
	return api;
})();