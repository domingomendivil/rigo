package com.mag.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.mag.filters.AuthorizationFilter;

public class MyApplication extends ResourceConfig {
	public MyApplication() {
		register(RolesAllowedDynamicFeature.class);
        register(new MyApplicationBinder());
       /** packages(true, "com.mag.rest").register(RolesAllowedDynamicFeature.class);
        register(AuthorizationFilter.class);
        System.out.println("authorizationfilter class added");
        System.out.println("dynamic feature added");**/
    }
}