/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import services.AuthService;
/**
 *
 * @author Thomas Coolidge
 */
public class AuthController 
{
    public AuthService authModel;
    
    public AuthController()
    {
        authModel = new AuthService();
    }
    
    /**
     * Logs in to the API with Username and Password
     * @param username
     * @param password
     * @return Boolean
     */
    public Boolean login(String username, String password)
    {
        Boolean valid = false;
        String response;
        String[] temp;
        String sessionToken;
        
        try 
        {
            response = authModel.login(username, password);
            if(response.contains("sessionToken"))
            {
                temp=response.split("\"");
                sessionToken=temp[11];
                valid = true;
                authModel.setToken(sessionToken);
            }
        } 
        catch (Exception ex) 
        {   
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            valid = false;
        }
        
        return valid;
    }
    
    /**
     * Logout of the API and clear session tokens
     * @return Boolean
     */
    public Boolean logout()
    {
        Boolean valid;
        String response;
        
        try 
        {
            response = authModel.logout();
        } 
        catch (Exception ex) 
        {   
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            response = "Unknown Error";
        }
        
        valid = response.equals("{}");
        
        return valid;
    }
}
