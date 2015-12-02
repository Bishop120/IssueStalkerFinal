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
    
    /**
     * Returns all the features for a given project
     * @param projectID
     * @return String
     */
    public String getProjectFeatures(String projectID)
    {
        String response;
        
        response = featureModel.getProjectFeatures(projectID);
        
        return response;
    }
    
    /**
     * Adds a feature to a project
     * @param name
     * @param description
     * @param comment
     * @param ProjectID
     * @return String
     */
    public String addFeature(String name, String description, String comment, String ProjectID)
    {
        String response;
        
        response = featureModel.postFeature(name,description,comment,ProjectID);
        
        return response;
    }
    
    /**
     * Removes a feature from a project
     * @param featureID
     * @return String
     */
    public String deleteFeature(String featureID)
    {
        String response;
        
        response = featureModel.deleteFeature(featureID);
        
        return response;
    }
    
    public String updateFeature(String name, String description, String comment, String ProjectID, String FeatureID){
        String response;
       
        
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
        
        response = featureModel.updateFeature(FeatureID, feature);
        
        return response;
    }
       
}
