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
     * Sets the token a
     * @param username
     * @param password
     * @return String
     * @throws java.lang.Exception 
     */
    public void setToken()
    {
        String token = auth.sessionToken;
        
        auth.authModel.setToken(token);
    }
    
    public void clearToken()
    {
        String token = "";
        
        auth.authModel.setToken(token);
    }
    
    public String getToken()
    {
        return auth.sessionToken;
    }
    
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
