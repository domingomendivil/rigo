App.Views.CancelBookingView = Backbone.View.extend({
	el: $('#section'),
	render: function(){
		console.log("rendering cancel");
		var self=this;
		 $.get('templates/cancel-booking.html', function (data) {
	  	      self.$el.html(_.template(data));
	  	    }, 'html');
		return this;
	}
});
