
App.Models.Person = Backbone.Model.extend({
    defaults: { name: ""  },
    urlRoot: 'http://localhost:8083/users',
    validate: function () { },
    sync: function(method,model,options){
    	options.success({
            id: 178,
            name:'Pepe'
        });
    	options.xhr = { status: 200 };
    }
});