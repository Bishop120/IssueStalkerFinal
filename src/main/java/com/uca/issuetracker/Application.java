/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.issuetracker;

import java.util.logging.Level;
import java.util.logging.Logger;
import services.Service;

/**
 *
 * @author danger
 */
public class Application {    
    
    public static void main(String [] args)
    {
        Service service = new Service();
        try {
            System.out.println(service.get("Project", "k32]ITdg83i"));
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
