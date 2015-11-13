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
    
    
}
