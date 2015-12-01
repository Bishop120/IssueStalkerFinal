/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import org.jboss.resteasy.client.*;
//import org.json.simple.parser.*;
import org.json.*;
import java.net.URLEncoder;

/**
 *
 * @author Michael Hedges and Thomas Coolidge
 */
class Service 
{
    final String baseURl = "https://api.parse.com/1";
    private final String parseAppId = "fVkE0wvEaWTIxPMW5wE3QDOgkQ0vM7UhfSPUBDEh";
    private final String restApiKey = "0JJSBTESRk0Q1JNs0nwCpBGGLFZxQxkibOeoYe49";
    ClientRequest request;
    ClientResponse response;
    public static String sessionToken;
    //private JSONParser parser;
    
    /**
     * Attach Given Headers with Session Token
     */
    void prepareRequest() 
    {
        this.request.header("X-Parse-Application-Id", this.parseAppId);
        this.request.header("X-Parse-REST-API-Key", this.restApiKey);
        this.request.header("X-Parse-Session-Token", this.sessionToken);
    }
    
    /**
     * Attach Given Headers for Login
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
     * GET all Milestones with a given projectID
     * @param className
     * @param objectId
     * @return 
     * @throws java.lang.Exception 
     */
    public String getFeatureId(String objectId) throws Exception
    {
        String query = "{\"milestone\":{\"__type\":\"Pointer\",\"className\":\"Milestone\",\"objectId\":\"" + objectId + "\"}}";
        String url = this.baseURl + "/classes/Issue/?where=" + URLEncoder.encode(query, "UTF-8");
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
     * @return String
     * @throws java.lang.Exception 
     */
    public String post(String className, String post) throws Exception
    {
        JSONObject json = new JSONObject(post);
        String url = this.baseURl + "/classes/" + className;
        System.out.println("post: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.request.body("*/*",json);
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
     * Post an update to a given class
     * @param className
     * @param obejctID
     * @return 
     * @throws java.lang.Exception 
     */
    public String update(String className, String objectID, String update) throws Exception
    {
        JSONObject json = new JSONObject(update);
        String url = this.baseURl + "/classes/" + className + "/" + objectID;
        System.out.println("update: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.request.body("*/*",json);
        this.response = request.put(String.class);
        return (String) this.response.getEntity();
    }
    
    /**
     * Sets the sessionToken
     * @param String token
     * @return void 
     */
    public void setToken(String token)
    {
        this.sessionToken = token;
    }
    
    /**
     * Sets the sessionToken to null
     * @param null
     * @return void 
     */
    public void clearToken()
    {
        this.sessionToken=null;
    }
    
    /**
     * Returns the sessionToken
     * @param null
     * @return String sessionToken 
     */
    public String getToken()
    {
        return this.sessionToken;
    }
}
