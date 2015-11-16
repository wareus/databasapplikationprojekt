package dbap.custom.annotation;

import org.glassfish.jersey.server.ResourceConfig;

public class CustomResourceConfig extends ResourceConfig {
    public CustomResourceConfig() {
    	
        packages("dbap.custom.annotation");
        register(LoginFilter.class);
    }
}
