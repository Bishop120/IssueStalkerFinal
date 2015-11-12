/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Thomas Coolidge
 */
public class Controller {
    public AuthController auth;
    public ProjectController projects;
    
    public Controller(){
        auth = new AuthController();
        projects = new ProjectController();
    }
}
