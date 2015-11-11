/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author danger
 */
public class Service {

    final String baseURl = "https://api.parse.com/1";
    private final String parseAppId = "ejdm9iw3ff8CG2JVWX33CiLkpzwngMYTMyQ4CNE0";
    private final String restApiKey = "ZokE5oRI2ibLXmaPcsxLoXx4eCvnYHHZcc4cAnuu";
    ClientRequest request;
    ClientResponse response;
    private JSONParser parser;

    /**
     * Attach Given Headers
     */
    void prepareRequest() {
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
     * Create a new
     */
    public String create(String className, String body) throws Exception{
        String url = this.baseURl + "/classes/" + className;
        System.out.println("list: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.request.body("application/json", body);
        this.response = request.post(String.class);
        return (String) this.response.getEntity();
    }

    /**
     * GET a given class
     * @param className
     * @param objectId
     * @return
     * @throws java.lang.Exception
     */
    public String get(String className, String objectId) throws Exception{
        String url = this.baseURl + "/classes/" + className + "/" + objectId;
        System.out.println("get: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.response = this.request.get(String.class);
        return (String) this.response.getEntity();
    }
<<<<<<< HEAD
    
    
        /**
     * GET a given class
     * @param className
     * @param objectId
     * @return 
     * @throws java.lang.Exception 
     */
    public String update(String className, String objectId) throws Exception{
        String url = this.baseURl + "/classes/" + className + "/" + objectId;
        System.out.println("get: " + url);
        this.request = new ClientRequest(url);
        this.prepareRequest();
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
=======

    /**
     * Update a given class
     * @param className
     * @param objectId
     * @return
     * @throws java.lang.Exception
     */
    public String update(String className, String objectId, String body) throws Exception{
      String url = this.baseURl + "/classes/" + className + "/" + objectId;
      System.out.println("put: " + url);
      this.request = new ClientRequest(url);
      this.prepareRequest();
      this.request.body("application/json", body);
      this.response = this.request.put(String.class);
      return (String) this.response.getEntity();
    }

    /**
     * Delete a given object
     * @param className
     * @param objectId
     * @return
     * @throws java.lang.Exception
     */
    public String delete(String className, String objectId) throws Exception{
      String url = this.baseURl + "/classes/" + className + "/" + objectId;
      System.out.println("put: " + url);
      this.request = new ClientRequest(url);
      this.prepareRequest();
      this.response = this.request.delete(String.class);
      return (String) this.response.getEntity();
>>>>>>> master
    }
}
