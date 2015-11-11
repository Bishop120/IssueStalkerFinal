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
<<<<<<< HEAD
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
            response = authModel.get(username, password);
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
=======

    public AuthController(){
        authModel = new AuthService();
    }

    public String get(String username, String password)
    {
        String str;

        try
        {
            str = authModel.get(username, password);
        }
        catch (Exception ex)
        {   str = "Invalid Login Attempt";
>>>>>>> master
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            sessionID="";
            valid = false;
        }
<<<<<<< HEAD
        
        return valid;
=======

        return str;
>>>>>>> master
    }
}
