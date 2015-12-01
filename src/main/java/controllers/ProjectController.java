/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import services.*;

/**
 *
 * @author Thomas Coolidge
 */
public class ProjectController 
{
    public ProjectService projectModel;
    
    public ProjectController()
    {
        projectModel = new ProjectService();
    }
    
    public String getAllProject()
    {
        String response;
        
        response = projectModel.getAll();
        
        return response;
    }
    
    public String addProject(String name, String description, String comment)
    {
        String response;
        
        response = projectModel.postProject(name,description,comment);
        
        return response;
    }
    
        public String deleteProject(String projectID)
    {
        String response;
        
        response = projectModel.deleteProject(projectID);
        
        return response;
    }  
}
