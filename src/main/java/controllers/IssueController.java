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
    
    public String addIssue()
    {
        String response;
        
        response = issueModel.postIssue();
        
        return response;
    }
    
    public String deleteFeature(String issueID)
    {
        String response;
        
        response = issueModel.deleteIssue(issueID);
        
        return response;
    }
    
    
    
}
