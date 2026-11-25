/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodja.self_defense_academy;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Austin
 */
abstract public class BaseDAO {
    abstract public String fileName();
    abstract public String IdPrefix();
    abstract public String[] columnNames();
    
    public List<String[]> getAll() throws IOException {
        List<String[]> rows = new ArrayList<>();
        File f = new File(fileName());
        
        // Create a file if doesn't exist
        if (!f.exists()){
            f.createNewFile();
            return rows;
        }
        for (String line : Files.readAllLines(f.toPath())){
            if(line.isBlank()){
                continue; //skip if the line is blank
            }
            String[] parts = line.split("\\|",-1);
            rows.add(parts);
        }
        return rows;
    }
    public String nextId() throws IOException{
        List<String[]> rows = getAll();
        String prefix = IdPrefix();
        int max = 0;
        if (rows.isEmpty()){
            return prefix + "1";
        }
        
        for(String[] i : rows){
           String id = i[0].trim();
           // Remove the prefix, then convert the number into intiger
           int num = Integer.parseInt(id.substring(prefix.length()));
           if (num > max){
               max = num;
           }
        }
        return prefix + (max+1);
    }
    
    public String[] getById(String id) throws IOException{
        List<String[]> rows = getAll();
        for(String[] row : rows){
            if(row[0].trim().equalsIgnoreCase(id)){
                return row;
            }
        }
        return null;
    }
    
    public void deleteById(String id) throws IOException{
        List<String[]> rows = getAll();
        List<String> new_rows = new ArrayList<>();
        boolean found = false;
        
        for(String[] row : rows){
            if(row[0].trim().equalsIgnoreCase(id)){
                found = true;
            }
            else{
                new_rows.add(String.join("|", row));
            }
        }
        if(!found){
            JOptionPane.showMessageDialog(null, "Id Not Found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (found){
            Files.write(Path.of(fileName()), new_rows);
            JOptionPane.showMessageDialog(null, "Deleted Succesfully");
        }
    }
    
    //Make sure format it first before calling this
    //EXAMPLE: P1|Rudy|21.00
    public void updateById(String id, String updatedRow) throws IOException{
        List<String[]> rows = getAll();
        List<String> new_rows = new ArrayList<>();
        boolean found = false;
        
        for(String[] row : rows){
            if(row[0].trim().equalsIgnoreCase(id)){
                new_rows.add(updatedRow); 
                found = true;
            }
            else{
                new_rows.add(String.join("|", row));
            }
        }
        if(!found){
            JOptionPane.showMessageDialog(null, "Id Not Found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (found){
            Files.write(Path.of(fileName()), new_rows);
            JOptionPane.showMessageDialog(null, "Updated Succesfully");
        }
    }
    // Make sure give the formatted line before calling 
    // EXAMPLE: Ali|2026|Cool
    public void addNewEntry(String row) throws IOException{
        String id = nextId();
        String Final_row = id + "|" + row + "\n";
        Path p = Path.of(fileName());
        // creates the file if it does not exist yet
        Files.writeString(p, Final_row, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        JOptionPane.showMessageDialog(null, "Succesfully Added");
    }
    
}
