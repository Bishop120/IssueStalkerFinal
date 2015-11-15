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
    
        public String getIssue(String issueID)
    {
        String response="";
        
        try 
        {
            response = super.get("Issue",issueID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(IssueService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    
}
