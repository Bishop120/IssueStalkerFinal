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
public class Controller 
{
    public AuthController auth;
    public ProjectController projects;
    public FeatureController features;
    public IssueController issues;
    public AdminController admin;
    public ReportController reports;
    
    /**
     * Clears the authentication token
     */
    
    public void clearToken()
    {
        auth.authModel.setToken("");
    }
    
    /**
     * Returns the session authentication token
     * @return String
     */
    
    public String getToken()
    {
        if(auth.authModel.sessionToken != null)
        {
            return auth.authModel.sessionToken;
        }
        
        else
        {
            return null;
        }
    }
    
    /**
     * Allocates and initializes the controllers
     */
    
    public Controller()
    {
        auth = new AuthController();
        admin = new AdminController();
        projects = new ProjectController();
        features = new FeatureController();
        issues = new IssueController();
        reports = new ReportController();
    }
}
