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
public class FeatureService extends Service
{
    
    public String getAll()
    {
        String response="";
        
        try 
        {
            response = super.list("Milestone");
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(FeatureService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    public String getFeature(String featureID)
    {
        String response="";
        
        try 
        {
            response = super.get("Milestone",featureID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(FeatureService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
        
    public String postFeature(String description, String name, String comment)
    {
        String response="";
        
        String feature = "";
        feature = feature + "{\"description\":\"";
        feature = feature + description;
        feature = feature + "\",\"name\":\"";
        feature = feature + name;
        feature = feature + "\",\"comment\":\"";
        feature = feature + comment;
        feature = feature + "\"}";
        
        
        //System.out.println(feature);
        
        try 
        {
            response = super.post("Project",feature);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
     /**
     * Delete a Milestone
     * @param String projectID
     * @return String 
     * @throws java.lang.Exception 
     */
    public String deleteProject(String projectID)
    {
        String response="";
        
        try 
        {
            response = super.delete("Milestone",projectID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
     /**
     * Delete a Milestone
     * @param String milestoneID
     * @return String 
     * @throws java.lang.Exception 
     */
    public String updateProject(String milestoneID, String update)
    {
        String response="";
        
        try 
        {
            response = super.update("Milestone",milestoneID,update);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    
}
