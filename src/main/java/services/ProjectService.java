/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Coolidge
 */
public class ProjectService extends Service
{
     /**
     * List all Project
     * @return String 
     */
    public String getAll()
    {
        String response;
        
        try 
        {
            response = super.list("Project");
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            response = "Unknown Error";
        }
        
        return response;
    }
    
     /**
     * Get the details of an individual Project
     * @param projectID
     * @return String 
     */
    public String getProject(String projectID)
    {
        String response="";
        
        try 
        {
            response = super.get("Project",projectID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
     /**
     * Post a Project
     * @param description
     * @param name
     * @param comment
     * @return String 
     */
    public String postProject(String name, String description, String comment)
    {
        String response;
        
        String project = "";
        project = project + "{\"description\":\"";
        project = project + description;
        project = project + "\",\"name\":\"";
        project = project + name;
        project = project + "\",\"comment\":\"";
        project = project + comment;
        project = project + "\"}";
        
        try 
        {
            response = super.post("Project",project);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            response = "Uknown Error";
        }
        
        return response;
    }
    
     /**
     * Delete a Project
     * @param projectID
     * @return String 
     */
    public String deleteProject(String projectID)
    {
        String response;
        
        try 
        {
            response = super.delete("Project",projectID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            response = "Uknown Error";
        }
        
        return response;
    }
    
      /**
     * Update the details of an individual Project
     * @param  projectID
     * @param  update
     * @return String 
     */
    public String updateProject(String projectID, String update)
    {
        String response;
        System.out.println(update);
        
        try 
        {
            response = super.update("Project",projectID,update);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            response = "Unknown Error";
        }
        
        return response;
    } 
}
