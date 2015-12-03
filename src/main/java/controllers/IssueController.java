/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.*;

/**
 *
 * @author Thomas Coolidge
 */
public class IssueController 
{
    public IssueService issueModel;
    
    public IssueController()
    {
        issueModel = new IssueService();
    }
    
    public String getFeatureIssues(String featureID)
    {
        String response;
        
        response = issueModel.getFeatureIssues(featureID);
        
        return response;
    }
    
    public String addIssue(String FeatureID,String name,String description,String points,String modifier,String difficulty,String priority,String dueDate)
    {
        String response;
        
        response = issueModel.postIssue(FeatureID,name,description,points,modifier,difficulty,priority,dueDate);
        
        return response;
    }
    
    public String deleteFeature(String issueID)
    {
        String response;
        
        response = issueModel.deleteIssue(issueID);
        
        return response;
    }
    
    public String getIssue(String IssueId)
    {
        String response;
        
        response = issueModel.getIssue(IssueId);
        
        return response;
    }
    public String updateIssue(String FeatureID,String name,String description,String points,String modifier,String difficulty,String priority,String dueDate, String IssueID){
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
        
        
 
        System.out.println(issue);
        
        
       response = issueModel.updateIssues(IssueID,issue);
        
        
        return response;
    }
}
