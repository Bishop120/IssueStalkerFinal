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
     * @param  points
     * @param  modifier
     * @param  difficulty
     * @param  priority
     * @param  dueDate
     * @param  FeatureID
     * @return String 
     * @throws java.lang.Exception 
     */
    public String postIssue(String FeatureID,String name,String description,String points,String modifier,String difficulty,String priority,String dueDate)
    {
        String response="";
        
        String issue = "";
        
        issue = issue + "{\"description\":\"";
        issue = issue + description;
        issue = issue + "\",\"name\":\"";
        issue = issue + name;
        issue = issue + "\",\"difficulty\":\"";
        issue = issue + difficulty;
        issue = issue + "\",\"dueDate\":\"";
        issue = issue + dueDate;
        issue = issue + "\",\"milestone\":{\"__type\": \"Pointer\",\"className\": \"Milestone\",\"objectId\": \"";
        issue = issue + FeatureID;
        issue = issue + "\"},";
        issue = issue + "\"modifier\":\"";
        issue = issue + modifier;
        issue = issue + "\",\"points\":\"";
        issue = issue + points;
        issue = issue + "\",\"priority\":\"";
        issue = issue + priority;
        issue = issue + "\"}";
        
        
        
   /* "
        {
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
            "points": "20",
            "priority": "1"
        }
]
}*/
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
        public String updateIssues(String issueId, String update)
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
