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
    /**
     * Logs in to the API with Username and Password
     * @param username
     * @param password
     * @return String
     * @throws java.lang.Exception 
     */
    public String login(String username, String password) throws Exception
    {
        String url = this.baseURl + "/login/?username=" + username + "&password=" + password;
        super.request = new ClientRequest(url);
        super.prepareLogin();
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }
    
    /**
     * Send a logout request to the API
     * @return String
     * @throws java.lang.Exception 
     */
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
    

