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
     * @param 
     * @return String 
     * @throws java.lang.Exception 
     */
    public String getAll()
    {
        String response="";
        
        try 
        {
            response = super.list("Project");
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
     /**
     * List individual Project
     * @param String projectID
     * @return String 
     * @throws java.lang.Exception 
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
    
    
}
