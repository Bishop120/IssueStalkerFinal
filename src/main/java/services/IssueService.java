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
    /**
     * Get all Issues listed in the API
     * @return String  
     */
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
    public String postIssue( )
    {
        String response="";
        
        String issue = "";
        /*
        issue = issue + "\",\"createdAt\":\"";
        
        issue = issue + "\",\"description\":\"";
        issue = issue + description;
        issue = issue + "\",\"difficulty\":\"";
        issue = issue + difficulty;
        issue = issue + "\",\"dueDate\":\"";
        issue = issue + dueDate;
        issue = issue + "\",\"milestone\":{\"__type\": \"Pointer\",\"className\": \"Milestone\",\"objectId\": \"";
        issue = issue + FeatureID;
        issue = issue + "\"},";
        issue = issue + "\"modifier\":\"";
        issue = issue + modifier;
        issue = issue + "\",\"name\":\"";
        issue = issue + name;
        issue = issue + "\",\"objectId\":\"";
        issue = issue + IssueID;
        issue = issue + "\",\"points\":\"";
        issue = issue + points;
        issue = issue + "\",\"priority\":\"";
        issue = issue + priority;
        issue = issue + "\",\"updatedAt\":\"";
        issue = issue + updatedAt;
        issue = issue + "\"}";
        
        
        */
            
        
        {
   /* "results": [
        {
            "comment": "ugly comment",
            "createdAt": "2015-11-19T18:18:21.890Z",
            "description": "ugly description",
            "difficulty": "1",
            "dueDate": "12Dec2015",
            "milestone": {
                "__type": "Pointer",
                "className": "Milestone",
                "objectId": "UyNxlPvwRV"
            },
            "modifier": "15",
            "name": "Test Issue",
            "objectId": "5Rb1dtMBVW",
            "points": "20",
            "priority": "1",
            "updatedAt": "2015-12-03T04:20:48.757Z"
        }
]
}*/}
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
        /*
        * Delete a Feature from the API
        * @param issueID
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
}
