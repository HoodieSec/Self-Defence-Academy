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
public class EmployeeDAO extends BaseDAO {
    public String fileName(){return "Employee.txt";}
    public String IdPrefix(){return "E";}
    public String[] columnNames(){return new String[]{"EID", "Name","Email", "Address","Phone_Num", "Role"};} //No password bc its sensitive info
    
    
    public List<String[]> getByRoleORName(String role, String name) throws IOException{
        List<String[]> result = new ArrayList<>();
        List<String[]> rows = getExcludeManager();
        if(name.isEmpty()){
            name = "none";
        }
        if(!role.equalsIgnoreCase("All") && name.equalsIgnoreCase("none")){
            for(String[] row : rows){
                if(row[5].equalsIgnoreCase(role)){
                    result.add(row);
                }
            }
        }
        else if (role.equalsIgnoreCase("All") && name.equalsIgnoreCase("none")){
            for(String[] row : rows){
                    result.add(row);
            }   
        }
        else if (!role.equalsIgnoreCase("All") && !name.equalsIgnoreCase("none")){
            for(String[] row : rows){
                if(row[5].equalsIgnoreCase(role) && row[1].equalsIgnoreCase(name)){
                    result.add(row);
                }
            }
        }
        else if (role.equalsIgnoreCase("All") && !name.equalsIgnoreCase("none")){
            for(String[] row : rows){
                if(row[1].equalsIgnoreCase(name)){
                    result.add(row);
                }
            }
        }
        return result;
    }
    
    public int totalRole(String role, String name) throws IOException{
         int total = 0;
         
         List<String[]> rows = getByRoleORName(role, name);
         for (String[] row : rows){
             total += 1;
         }
         return total;
     }
    
    public List<String[]> getExcludeManager() throws IOException{
        List<String[]> results = new ArrayList<>();
        List<String[]> rows = getAll();
        
        for (String[] row : rows)
        {
            if (!row[5].equalsIgnoreCase("Manager")){
                results.add(row);
            }
        }
        return results;
    }
    
     public List<String[]> getAdminOnly() throws IOException{
        List<String[]> results = new ArrayList<>();
        List<String[]> rows = getAll();
        
        for (String[] row : rows)
        {
            if (row[5].equalsIgnoreCase("Administrator")){
                results.add(row);
            }
        }
        return results;
    }
     
    public List<String[]> getByAdminName(String name) throws IOException{
        List<String[]> rows = getAdminOnly();
        List<String[]> result = new ArrayList<>();
        for(String[] row : rows){
            if(row[1].trim().equalsIgnoreCase(name)){
                result.add(row);
            }
        }
        return result;
    }
    
    public List<String[]> getByAdminEmail(String email) throws IOException{
        List<String[]> rows = getAdminOnly();
        List<String[]> result = new ArrayList<>();
        for(String[] row : rows){
            if(row[2].trim().equalsIgnoreCase(email)){
                result.add(row);
            }
        }
        return result;
    }
    
    public List<String[]> getByAdminAddress(String add) throws IOException{
        List<String[]> rows = getAdminOnly();
        List<String[]> result = new ArrayList<>();
        for(String[] row : rows){
            if(row[3].trim().equalsIgnoreCase(add)){
                result.add(row);
            }
        }
        return result;
    }
    
    public List<String[]> getByAdminPhone(String num) throws IOException{
        List<String[]> rows = getAdminOnly();
        List<String[]> result = new ArrayList<>();
        for(String[] row : rows){
            if(row[4].trim().equalsIgnoreCase(num)){
                result.add(row);
            }
        }
        return result;
    }
    
    public String[] getByAdminId(String id) throws IOException{
        List<String[]> rows = getAdminOnly();
        for(String[] row : rows){
            if(row[0].trim().equalsIgnoreCase(id)){
                return row;
            }
        }
        return null;
    }
    
}