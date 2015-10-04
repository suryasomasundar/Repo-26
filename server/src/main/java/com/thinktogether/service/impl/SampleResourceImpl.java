package com.thinktogether.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thinktogether.service.Login;
import com.thinktogether.service.LoginResponse;
import com.thinktogether.service.SampleResource;

/**
 * This resource shows how to use JAX-RS injection and how to use
 * a spring bean as a JAX-RS resource class.
 *
 * Notice that the scope for this bean is request which means that a new
 * instance of this class will be created per request.
 * 
 * Note : Please delete SampleResourceImpl before going to live.
 */

@Component
@Scope("request")
public class SampleResourceImpl implements com.thinktogether.service.SampleResource {
    @Inject
    private Environment env;
    
    static private Map<String, String> loginMap = init();
    static private Map<String, String> roleMap = initRole();
    
    static Map<String, String> init(){
        HashMap<String, String> lmap = new HashMap<String, String>();
        lmap.put("john", "john123");
        lmap.put("jane", "jane123");
        lmap.put("admin", "admin123");
        return lmap;
    }
    
    static Map<String, String> initRole(){
        HashMap<String, String> rmap = new HashMap<String, String>();
        rmap.put("john", "SC");
        rmap.put("jane", "PL");
        rmap.put("admin", "admin");
        return rmap;
    }

    public String sayHello() {  
        return "Hello, World!";
    }
    
    public Map<String, String> sayHelloJson(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("word ", "Hello");
        map.put("name",  "Minjun");
        return map;
        
    }
    
    public String createHello(Map<String, String> input){
        
        
        System.out.println(input);
        return "Success";
    }
    
   
   
    public String getResource(String resourceId) throws IOException{
        
        /*Properties prop = new Properties();
        InputStream input = null;
            
        String filename = "config.properties";
        input = getClass().getClassLoader().getResourceAsStream(filename);
        if (input == null) {
            System.out.println("Sorry, unable to find " + filename);
            
        }

        prop.load(input);
        return prop.getProperty(resourceId);*/
        return env.getProperty(resourceId);
               
    }

    public LoginResponse login(Login request){
        String usrname = request.getUsername();
        String pw = request.getPassword();
        LoginResponse response = new LoginResponse();
        
        if (loginMap.containsKey(usrname)){
            if (loginMap.get(usrname).equals(pw)){
                response.setStatus("Success");
                response.setRole(roleMap.get(usrname));
            }else {
                response.setStatus("Failed");
            }
        }else{
            response.setStatus("Failed");
        }       
        return response;
    }
}
