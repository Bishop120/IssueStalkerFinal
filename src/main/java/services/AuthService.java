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
    public String login(String username, String password) throws Exception
    {
        String url = this.baseURl + "/login/?username=" + username + "&password=" + password;
        System.out.println("get: " + url);
        super.request = new ClientRequest(url);
        super.prepareRequest();
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }
    
    public String logout(String username, String password) throws Exception
    {
        String url = this.baseURl + "/logout/?username=" + username + "&password=" + password;
        System.out.println("get: " + url);
        super.request = new ClientRequest(url);
        super.prepareRequest();
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }


}
    

