/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezerv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Responsible for do from file
 * @author stanislaw
 */
public class FileWork {
    private static FileWork fileWork = null;
    
    private FileWork () {
        
    }
    
    public static FileWork getInctanse () {
        if (fileWork == null) fileWork = new FileWork();
        return fileWork;
    }
    /**
    *Read file
    * 
    */
    public String read(String URL) {
        BufferedReader in; 
        String s = null; 
        
            try {
                in = new BufferedReader(new InputStreamReader(new FileInputStream(URL),"pc125")); 
                
                while (in.ready()){
                    s = in.readLine();  
                    System.out.println(s);
                }
                in.close();
                
                return s;
            } catch (IOException e) {
                System.err.println(e.getMessage());
                return null;
            } finally{

            }
    }
    /**
    *Read file in line
    * 
    */
    public String read_in_line(String URL) {
        try {
            File file = new File(URL);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();

            return line;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
    *Write to file
    * 
    */
    public void write(String URL, String txt) {
        try{
            FileWriter writer = new FileWriter(URL, true);

            writer.close();

            Files.write(Paths.get(URL), (txt).getBytes(), StandardOpenOption.APPEND);

        }catch (FileNotFoundException ex) {
        }catch (IOException ex) {                    
        }
    }
    /**
    *File rewriting
    * 
    */
    public void rewrite(String URL, String txt) {
        try{
            File file = new File(URL);
            if (file.exists()) file.delete();
            FileWriter writer = new FileWriter(URL, true);

            writer.close();

            Files.write(Paths.get(URL), (txt).getBytes(), StandardOpenOption.APPEND);

        }catch (FileNotFoundException ex) {
        }catch (IOException ex) {                    
        }
    }

}
