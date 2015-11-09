/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author danger
 */
public class Service {
    private final String baseURl = "https://api.parse.com/1";
    private final String parseAppId = "ejdm9iw3ff8CG2JVWX33CiLkpzwngMYTMyQ4CNE0";
    private final String restApiKey = "ZokE5oRI2ibLXmaPcsxLoXx4eCvnYHHZcc4cAnuu";
    private ClientRequest request;
    private ClientResponse response;
    private JSONParser parser;
    

    
    /**
     * Attach Given Headers
     */
    private void prepareRequest() {
        this.request.header("X-Parse-Application-Id", this.parseAppId);
        this.request.header("X-Parse-REST-API-Key", this.restApiKey);
    }
    
    /**
     * List a given class
     * @param className
     * @return 
     * @throws java.lang.Exception 
     */
    public String list(String className) throws Exception{
        String url = this.baseURl + "/classes/" + className;
        System.out.println("list: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }
    
    
    /**
     * GET a given class
     * @param className
     * @return 
     * @throws java.lang.Exception 
     */
    public String get(String className, String objectId) throws Exception{
        String url = this.baseURl + "/classes/" + className + "/" + objectId;
        System.out.println("get: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }
}
