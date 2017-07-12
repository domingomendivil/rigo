App.Views.CancelBookingView = Backbone.View.extend({
	events:{
		'click #cancelBooking':'cancelBooking',
		'click #searchBooking':'searchBooking'
	},
	
	el: $('#section'),
	render: function(){
		var self=this;
		$.get('templates/cancel-booking.html', function (data) {
	  	      self.$el.html(_.template(data));
	  	    }, 'html');
		return this;
	},
	cancelBooking: function(){
		console.log("cancel booking");
	},
	searchBooking: function(){
		var booking = new App.Models.Booking();
		booking.set("id",$("#bookingNro").val());
		var self = this;
        booking.fetch({
            success: function(data,response,options){
                var booking = new App.Views.BookingView({model:data});
                booking.render();
                console.log("luego del render");
            },
            error: function (collection, response, options){
            	
            	console.log("error");
            }
        }    );
	}
});
