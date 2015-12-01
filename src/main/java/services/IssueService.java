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
public class IssueService extends Service
{
    
    public String getAll()
    {
        String response="";
        
        try 
        {
            response = super.list("Issue");
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(IssueService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
        
     /**
     * Get all Issues assigned to a single Feature
     * @param  featureID
     * @return String  
     */
    public String getFeatureIssues(String featureID)
    {
        String response;
        
        try
        {
            response = super.getFeatureId(featureID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(FeatureService.class.getName()).log(Level.SEVERE, null, ex);
            response = "Invalid ID";
        }
        
        
        return response;
    }
    
    /**
     * Get the tuple relating to a single issue
     * @param  issueID
     * @return String  
     */
    public String getIssue(String issueID)
    {
        String response;
        
        try 
        {
            response = super.get("Issue",issueID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(FeatureService.class.getName()).log(Level.SEVERE, null, ex);
            response = "Invalid ID";
        }
        
        return response;
    }
     
    /**
     * Create and post a Issue
     * @param  name
     * @param  description
     * @param  comment
     * @param  FeatureID
     * @return String 
     * @throws java.lang.Exception 
     */
    public String postIssue(String name, String description, String comment, String FeatureID)
    {
        String response="";
        
        String issue = "";
        issue = issue + "{\"name\":\"";
        issue = issue + name;
        issue = issue + "\",\"description\":\"";
        issue = issue + description;
        issue = issue + "\",\"comment\":\"";
        issue = issue + comment;
        issue = issue + "\",\"milestone\":{\"__type\": \"Pointer\",\"className\": \"Milestone\",\"objectId\": \"";
        issue = issue + FeatureID;
        issue = issue + "\"}}";
        
        System.out.println(issue);
        
        try 
        {
            response = super.post("Issue",issue);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
<<<<<<< HEAD
        public String postIssue(String FeatureId, String name, String description, Integer priority, Integer difficulty, String comment){
            String response="";

            String feature = "";
            feature = feature + "{\"name\":\"";
            feature = feature + name;
            feature = feature + "\",\"description\":\"";
            feature = feature + description;
            feature = feature + "\",\"comment\":\"";
            feature = feature + comment;
            feature = feature + "\",\"project\":{\"__type\": \"Pointer\",\"className\": \"Milestone\",\"objectId\": \"";
            feature = feature + FeatureId;
            feature = feature + "\"}}";

            System.out.println(feature);

            try 
            {
                response = super.post("Issue",feature);
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return response;
        }
        
        /**
        * Delete a Feature from the API
        * @param String projectID
        * @return String 
        * @throws java.lang.Exception 
        */
       public String deleteIssue(String issueId)
       {
           String response="";

           try 
           {
               response = super.delete("Issue",issueId);
           } 
           catch (Exception ex) 
           {
               Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
           }

           return response;
       }
       
       
            /**
        * Update the details of an individual Feature
        * @param  featureID
        * @param  update
        * @return String  
        */
        public String updateIssue(String issueId, String update)
        {
            String response;

            try 
            {
                response = super.update("Issue",issueId,update);
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
                response = "Unknown Error";
            }

            return response;
        }
=======
     /**
     * Delete a Issue from the API
     * @param String projectID
     * @return String 
     * @throws java.lang.Exception 
     */
    public String deleteIssue(String issueID)
    {
        String response="";
        
        try 
        {
            response = super.delete("Issue",issueID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
>>>>>>> origin/Thomas's-Branch
    
     /**
     * Update the details of an individual Issue
     * @param  issueID
     * @param  update
     * @return String  
     */
    public String updateIssue(String issueID, String update)
    {
        String response;
        
        try 
        {
            response = super.update("Issue",issueID,update);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
            response = "Unknown Error";
        }
        
        return response;
    }
}
