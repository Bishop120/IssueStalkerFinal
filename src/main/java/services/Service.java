/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
//import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.client.*;
import org.json.simple.parser.*;
//import org.json.*;
import java.net.URLEncoder;

/**
 *
 * @author danger
 */
class Service 
{
    final String baseURl = "https://api.parse.com/1";
    private final String parseAppId = "fVkE0wvEaWTIxPMW5wE3QDOgkQ0vM7UhfSPUBDEh";
    private final String restApiKey = "0JJSBTESRk0Q1JNs0nwCpBGGLFZxQxkibOeoYe49";
    ClientRequest request;
    ClientResponse response;
    private static String sessionToken;
    private JSONParser parser;
    
    /**
     * Attach Given Headers
     */
    void prepareRequest() 
    {
        this.request.header("X-Parse-Application-Id", this.parseAppId);
        this.request.header("X-Parse-REST-API-Key", this.restApiKey);
        this.request.header("X-Parse-Session-Token", this.sessionToken);
    }
    
    /**
     * Attach Given Headers
     */
    void prepareLogin() 
    {
        this.request.header("X-Parse-Application-Id", this.parseAppId);
        this.request.header("X-Parse-REST-API-Key", this.restApiKey);
    }
    
    /**
     * List a given class
     * @param className
     * @return 
     * @throws java.lang.Exception 
     */
    public String list(String className) throws Exception
    {
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
     * @param objectId
     * @return 
     * @throws java.lang.Exception 
     */
    public String get(String className, String objectId) throws Exception
    {
        String url = this.baseURl + "/classes/" + className + "/" + objectId;
        System.out.println("get: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }
    
    /**
     * GET all Milestones with a given projectID
     * @param className
     * @param objectId
     * @return 
     * @throws java.lang.Exception 
     */
    public String getProjectId(String objectId) throws Exception
    {
        String query = "{\"project\":{\"__type\":\"Pointer\",\"className\":\"Project\",\"objectId\":\"" + objectId + "\"}}";
        String url = this.baseURl + "/classes/Milestone/?where=" + URLEncoder.encode(query, "UTF-8");
        System.out.println("get: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }
    
     /**
     * Post to a given class
     * @param className
     * @param post
     * @return 
     * @throws java.lang.Exception 
     */
    public String post(String className, String post) throws Exception
    {
        String url = this.baseURl + "/classes/" + className;
        System.out.println("post: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.request.body("application/x-www-form-urlencoded",URLEncoder.encode(post, "UTF-8"));
        this.response = request.post(String.class);
        return (String) this.response.getEntity();
    }
    
    /**
     * Post to a given class
     * @param className
     * @param obejctID
     * @return 
     * @throws java.lang.Exception 
     */
    public String delete(String className, String objectID) throws Exception
    {
        String url = this.baseURl + "/classes/" + className + "/" + objectID;
        System.out.println("delete: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.response = request.delete(String.class);
        return (String) this.response.getEntity();
    }
    
    /**
     * Post to a given class
     * @param className
     * @param obejctID
     * @return 
     * @throws java.lang.Exception 
     */
    public String update(String className, String objectID, String update) throws Exception
    {
        String url = this.baseURl + "/classes/" + className + "/" + objectID;
        System.out.println("update: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.response = request.put(String.class);
        return (String) this.response.getEntity();
    }
    
    public void setToken(String token)
    {
        this.sessionToken = token;
    }
    
    public void clearToken()
    {
        this.sessionToken=null;
    }
    
    public String getToken()
    {
        return this.sessionToken;
    }
}
