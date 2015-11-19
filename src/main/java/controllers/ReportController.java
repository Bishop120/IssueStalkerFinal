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
public class ReportController 
{
    public ReportService reportModel;
    
    public ReportController()
    {
        reportModel = new ReportService();
    }   
}
