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
    
    public String getProjectFeatures(String projectID)
    {
        String response ="";
        
        try
        {
            response = super.getProjectId(projectID);
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
        
    public String postFeature(String name, String description, String comment, String ProjectID)
    {
        String response="";
        
        String feature = "";
        feature = feature + "{\"name\":\"";
        feature = feature + name;
        feature = feature + "\",\"description\":\"";
        feature = feature + description;
        feature = feature + "\",\"comment\":\"";
        feature = feature + comment;
        feature = feature + "\",\"project\":{\"__type\": \"Pointer\",\"className\": \"Project\",\"objectId\": \"";
        feature = feature + ProjectID;
        feature = feature + "\"}}";
        
        System.out.println(feature);
        
        try 
        {
            response = super.post("Milestone",feature);
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
    public String deleteFeature(String featureID)
    {
        String response="";
        
        try 
        {
            response = super.delete("Milestone",featureID);
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
