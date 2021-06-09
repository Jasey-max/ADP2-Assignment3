/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.jason_blankenberg_220229171_assignment3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CustomerTxt {
    ObjectOutputStream output;    
    
    public void openFile(){
        try{
            output = new ObjectOutputStream( new FileOutputStream( "stakeholder.ser" ) ); 
            System.out.println("=================== CUSTOMERS ============================");               
            System.out.println("ID  Name        Surname    Date of birth       Age");
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
           output.writeObject(new Customer("C150", "Luke", "Atmyass", "Bellville", "27 January 1981", 1520.50, false));
           output.writeObject(new Customer("C130", "Stu", "Padassol", "Sea Point", "18 May 1987", 645.25, true));
           output.writeObject(new Customer("C100", "Mike", "Rohsopht", "Bellville", "24 January 1993", 975.10, true));
           output.writeObject(new Customer("C250", "Eileen", "Sideways", "Nyanga", "27 November 1999", 190.85, true));
           output.writeObject(new Customer("C260", "Ima", "Stewpidas", "Atlantis", "27 January 2001", 1890.70, true));
       }//end try
        catch(IOException fnfe )
        {
            System.out.println(fnfe);
            System.exit(1);
        
        }   
    }
    
    public static void main(String[] args) {
        CustomerTxt obj = new CustomerTxt();
        obj.openFile();
        obj.writeToFile();
        obj.closeFile();
    }
}
