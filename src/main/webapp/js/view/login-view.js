
var LoginView = Backbone.View.extend({
	el: $('#main'),
	init: function(){this.render()},
	events:{'click':'procesLogin'},
	processLogin: function(){
			
	},
	render: function(){
		var self= this;
		$.get('templates/login.html', function (data) {
		       self.$el.html(_.template(data)());
		    }, 'html');
	}
});	

