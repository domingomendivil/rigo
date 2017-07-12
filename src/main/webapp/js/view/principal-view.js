App.Views.PrincipalView = Backbone.View.extend({
	
	
	el : $("#container"),
	initialize: function(){
		console.log("principalview");
		
	},
	render: function(){
		console.log("rendering principalview");
		var self = this;
		$.get('templates/app.html', function (data) {
			 var template = _.template(data);
		      $(self.el).html(template(self.model.attributes));
		    }, 'html');
		return this;
	}
}
);