/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.jason_blankenberg_220229171_assignment3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class SuppliersTxt {
    
    ObjectOutputStream output;
         
        public void openFile(){
        try{
            output = new ObjectOutputStream( new FileOutputStream( "stakeholder.ser" ) ); 
            System.out.println("=================== SUPPLIERS ============================");               
            System.out.println("ID  Name            Prod Type       Description");
        }  
        catch (IOException ioe){
            System.out.println("error opening ser file: " + ioe.getMessage());
            System.exit(1);
            }
        }
         public void closeFile(){
        try{
        output.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("error closing ser file: " + ioe.getMessage());
            System.exit(1);
        }        
    }        
    public void writeToFile(){
        
        try{
           output.writeObject(new Supplier("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan"));
           output.writeObject(new Supplier("S400", "Prime Motors", "Lexus", "Luxury sedan"));
           output.writeObject(new Supplier("S300", "We got Cars", "Toyota", "10-seater minibus"));
           output.writeObject(new Supplier("S350", "Auto Delight", "BMW", "Luxury SUV"));
           output.writeObject(new Supplier("S290", "MotorMania", "Hyundai", "compact budget"));
       }
        catch(IOException fnfe )
        {
            System.out.println(fnfe);
            System.exit(1);
        
        }   
    } 
    
    
    public static void main(String[] args) {
        SuppliersTxt obj = new SuppliersTxt();
        obj.openFile();
        obj.writeToFile();
        obj.closeFile();
    }
}