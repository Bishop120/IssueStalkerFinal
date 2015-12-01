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
public class AdminService extends Service
{
    /**
     * Returns a list of all projects in database, logs errors
     * @return String  
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
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    /**
     * Gets a given project
     * @param  projectID
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
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    
}
