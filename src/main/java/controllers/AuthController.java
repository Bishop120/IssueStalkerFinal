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
public class AuthController {
    public AuthService authModel;
    public String sessionID;
    
    public AuthController(){
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
                sessionID=temp[11];
                sessionID.replaceAll("\"","");
               valid = true; 
            }
            else
            {
                sessionID="";
            }
        } 
        catch (Exception ex) 
        {   
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            sessionID="";
            valid = false;
        }
        
        return valid;
    }
    
        public Boolean logout(String username, String password)
    {
        Boolean valid = false;
        String response;
        String[] temp;
        
        try 
        {
            response = authModel.logout(username, password);
            if(response.contains("sessionToken"))
            {
                temp=response.split("\"");
                sessionID=temp[11];
                sessionID.replaceAll("\"","");
               valid = true; 
            }
            else
            {
                sessionID="";
            }
        } 
        catch (Exception ex) 
        {   
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            sessionID="";
            valid = false;
        }
        
        return valid;
    }
}
