App.Views.LoginView = Backbone.View.extend({
	events:
    {
        "click #btnLogin": "submitLogin",
        "click #btnCancel": "cancel"	
    },
    render: function () {
    	var self = this;
        $.get('templates/login2.html', function (data) {
	      $(self.el).html(_.template(data)());
	    }, 'html');
        return this;
    },
    
    submitLogin: function () {
        var person = new App.Models.Person({name: $("#user").val()});
        person.set("id",$("#user").val());
        console.log("antes de fetch");
        person.fetch({
            success: function(){
                console.log("success");
                principalView = new App.Views.PrincipalView({model:person});
                principalView.render();
                localStorage.setItem("token", person.get("token"));
            },
            error: function (collection, response, options){
            	console.log("res "+JSON.stringify(response));
            	console.log("error");
            }
        }    );
        console.log("ds de fetch");
        this.model.add(person);
    },
    
    cancel: function(){
    	window.alert("cancel");
    }
});







