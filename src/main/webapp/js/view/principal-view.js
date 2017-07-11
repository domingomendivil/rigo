App.Views.PrincipalView = Backbone.View.extend({
	el : $("#container"),
	initialize: function(){
		console.log("principalview");
	},
	render: function(){
		console.log("rendering principalview");
		var self = this;
		$.get('templates/app.html', function (data) {
		      $(self.el).html(_.template(data)());
		    }, 'html');
		return this;
	}
}
);