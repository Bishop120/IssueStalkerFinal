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
    public String sessionToken;
    
    public AuthController()
    {
        authModel = new AuthService();
    }
    
    public Boolean login(String username, String password)
    {
        Boolean valid = false;
        String response;
        String[] temp;
        
        try 
        {
            response = authModel.login(username, password);
            if(response.contains("sessionToken"))
            {
                temp=response.split("\"");
                sessionToken=temp[11];
                sessionToken.replaceAll("\"","");
               valid = true; 
            }
            else
            {
                sessionToken="";
            }
        } 
        catch (Exception ex) 
        {   
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            sessionToken="";
            valid = false;
        }
        
        return valid;
    }
    
    public Boolean logout()
    {
        Boolean valid = false;
        String response;
        
        try 
        {
            response = authModel.logout();
            if(response.contains("{}"))
            {
                
                sessionToken="";
                valid = true; 
            }
            else
            {
                sessionToken="";
                valid=false;
            }
        } 
        catch (Exception ex) 
        {   
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            sessionToken="";
            valid = false;
        }
        
        return valid;
    }
}
