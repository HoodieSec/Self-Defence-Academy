/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_assigment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Austin
 */
public class PaymentDAO extends BaseDAO{
    public String fileName(){return "Payment.txt";}
    public String IdPrefix(){return "P";}
    public String[] columnNames(){return new String[]{"PID", "Student_Name","Ammount", "Date","Status", "Method", "SID", "CID"};} 
    
    
    public List<String[]> getByPeriod(String period) throws IOException{
        List<String[]> result = new ArrayList<>();
        List<String[]> rows = getAll();
        for(String[] row : rows){
            if(row[4].equalsIgnoreCase("paid") && row[3].startsWith(period)){
                result.add(row);
            }
        }
        return result;
    }
    
    public double totalRevenue(String period) throws IOException{
        double total = 0;
        List<String[]> rows = getByPeriod(period);
        for (String[] row : rows){
            try{
                double buffer = Double.parseDouble(row[2]);
                total += buffer;
            }
            catch (NumberFormatException e){ //SKip lines that have a different data type
                continue;
            }
        }
        return total;
    }
    
     public int totalRegistration(String period) throws IOException{
         int total = 0;
         List<String[]> rows = getByPeriod(period);
         for (String[] row : rows){
             total += 1;
         }
         return total;
     }
    
    
}
