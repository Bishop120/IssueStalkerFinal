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
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str;
    }
}
