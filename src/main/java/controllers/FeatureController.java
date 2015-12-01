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
public class FeatureController 
{
    public FeatureService featureModel;
    
    public FeatureController()
    {
        featureModel = new FeatureService();
    }
    
    public String getProjectFeatures(String projectID)
    {
        String response;
        
        response = featureModel.getProjectFeatures(projectID);
        
        return response;
    }
    
    public String addFeature(String name, String description, String comment, String ProjectID)
    {
        String response;
        
        response = featureModel.postFeature(name,description,comment,ProjectID);
        
        return response;
    }
    
    public String deleteFeature(String featureID)
    {
        String response;
        
        response = featureModel.deleteFeature(featureID);
        
        return response;
    }
}
