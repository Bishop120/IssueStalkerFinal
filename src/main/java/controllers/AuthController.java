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
 * @author danger
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
        String str;
        String[] temp;
        
        try 
        {
            str = authModel.get(username, password);
            if(str.contains("sessionToken"))
            {
                temp=str.split("\"");
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
