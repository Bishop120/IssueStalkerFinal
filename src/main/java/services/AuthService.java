/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import org.jboss.resteasy.client.*;

/**
 *
 * @author Thomas Coolidge
 */
public class AuthService extends Service
{
    private final String parseAppId = "ejdm9iw3ff8CG2JVWX33CiLkpzwngMYTMyQ4CNE0";
    private final String restApiKey = "ZokE5oRI2ibLXmaPcsxLoXx4eCvnYHHZcc4cAnuu";
    
    public String login(String username, String password) throws Exception
    {
        String url = this.baseURl + "/login/?username=" + username + "&password=" + password;
        //System.out.println("get: " + url);
        super.request = new ClientRequest(url);
        this.request.header("X-Parse-Application-Id", this.parseAppId);
        this.request.header("X-Parse-REST-API-Key", this.restApiKey);
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }
    
    public String logout() throws Exception
    {
        String url = this.baseURl + "/logout";
        System.out.println("post: " + url);
        super.request = new ClientRequest(url);
        super.prepareRequest();
        this.response = request.post(String.class);
        return (String) this.response.getEntity();
    }


}
    

