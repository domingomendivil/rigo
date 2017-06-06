package com.mag.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class MyApplication extends ResourceConfig {
	public MyApplication() {
        register(new MyApplicationBinder());
        packages(true, "uy.gub.dgi.rest").register(RolesAllowedDynamicFeature.class);
    }
}