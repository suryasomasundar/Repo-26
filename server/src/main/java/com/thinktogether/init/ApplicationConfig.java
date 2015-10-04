package com.thinktogether.init;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This is a JAX-RS compliant way to map your JAX-RS root context for your
 * application. The resources will be mapped to the ApplicationPath defined 
 * in this annotation and the @PATH annotation will be appended to it.
 * ApplicationPath that serves as the base URI is structured based on PPaaS standards.
 * @see <a href="http://ppaas/api-standards-md/">http://ppaas/api-standards-md/</a>
 * If it is a PPaaS application, please change the value "fpmmsb" based on PPaaS namespace standards.
 */
@ApplicationPath("/thinktogether/")
public class  ApplicationConfig extends Application {
}

