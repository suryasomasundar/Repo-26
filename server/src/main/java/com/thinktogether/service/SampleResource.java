package com.thinktogether.service;

import java.io.IOException;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Sample interface that shows how a service can be implemented with a separate
 * interface. This interface can be used as programmatic contract.
 *
 * Note : Please delete SampleResource interface before going to live.
 */
@Path("/sampleresource")
public interface SampleResource {

    @GET
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/hello")
    public String sayHello();
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/helloJson")
    public Map<String, String> sayHelloJson();
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/create")
    public String createHello(Map<String, String> input);
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/login")
    public LoginResponse login(Login request);
    
    @GET
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/getResource/{resource_id}")
    public String getResource(@PathParam("resource_id") final String resourceId) throws IOException;

}
