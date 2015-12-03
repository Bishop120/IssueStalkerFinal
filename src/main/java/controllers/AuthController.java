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
                System.out.println(response);
                temp=response.split("\"");
                for(int i=0; i<temp.length; i++)
                {
                    if(temp[i].equals("sessionToken"))
                    {
                        sessionToken = temp[i+2];
                        authModel.setToken(sessionToken);
                        valid = true;
                    }
                }
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
        Boolean valid = false;
        String response;
        
        try 
        {
            response = authModel.logout();
            System.out.println(response);
        } 
        catch (Exception ex) 
        {   
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            response = "Unknown Error";
        }
        
         if(response.contains("{}"))
         {
             valid=true;
         }
        
        return valid;
    }
}
