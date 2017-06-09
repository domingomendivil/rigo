
var LoginView = Backbone.View.extend({
	el: $('#main'),
	
	init: function(){this.render()},
	
	events:{'click':'procesLogin'},
	
	processLogin: function(){
		console.log("processlogin");
			window.alert("login");
	},
	render: function(){
		var self= this;
		console.log("consola ....."+ $("#personTemplate"));
		$.get('templates/login.html', function (data) {
				console.log("rendering login");
		       self.$el.html(_.template(data)());
		    }, 'html');
	}
});	

