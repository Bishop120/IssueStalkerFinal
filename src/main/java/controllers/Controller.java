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
    
    public void setToken()
    {
        String token = auth.sessionToken;
        
        admin.adminModel.setToken(token);
        auth.authModel.setToken(token);
        projects.projectModel.setToken(token);
        features.featureModel.setToken(token);
        issues.issueModel.setToken(token);
        reports.reportModel.setToken(token);
    }
    
    public void clearToken()
    {
        String token = "";
        
        admin.adminModel.setToken(token);
        auth.authModel.setToken(token);
        projects.projectModel.setToken(token);
        features.featureModel.setToken(token);
        issues.issueModel.setToken(token);
        reports.reportModel.setToken(token);
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
