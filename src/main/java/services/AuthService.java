/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import org.jboss.resteasy.client.*;
/**
 *
 * @author danger
 */
public class AuthService extends Service
{
    /**
     * Username
     * Password
     */
    public String login(String body) throws Exception
    {
        String url = this.baseURl;
        System.out.println("get: " + url);
        super.request = new ClientRequest(url);
        super.prepareRequest();
        super.request.body(body);
        this.response = request.get(String.class);
        return (String) this.response.getEntity();
    }

    /**
     * Username
     * Password
     */
    public String logout() throws Exception
    {
        String url = this.baseURl;
        System.out.println("get: " + url);
        super.request = new ClientRequest(url);
        super.prepareRequest();
        // super.request.body(body);
        this.response = request.post(String.class);
        return (String) this.response.getEntity();
    }





}
