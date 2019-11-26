/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
//import java.util.*

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cifrado;
import logica.Files;




/**
 *
 * @author vmagu
 */
public class User {
    private static String username;
    private static String password;
    public User(String username, String password){
        
        try {
            String encrypt=cifrar(password);
            this.username=username;
            this.password=encrypt;
            
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ërror");
        }

    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    private String cifrar(String password) throws Exception {
        String encriptada=Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
        //System.out.println(encriptada);
        return encriptada;
        
    }

    private void createUsersFile(){
        Files file=new Files();
        if(!file.FileChecker("Users","")){

            String FILE_HEADER = "username,password";
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter("Users.csv");
                fileWriter.append(FILE_HEADER);
                fileWriter.append("\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void saveUserCredential() throws Exception{
    String fileName="Users.csv";
    createUsersFile();
    //Delimiter used in CSV file
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
        FileWriter fileWriter = null;
        Cifrado password_enciptada= new Cifrado();
       
        //password_encriptada.cifrar(login.getPassword());
        try {
            
            fileWriter = new FileWriter(fileName,true);
            //Add a new line separator after the header
            
            //Write a new student object list to the CSV file
                fileWriter.append(String.valueOf(username));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(password);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
                                fileWriter.flush();
                fileWriter.close();
            //} 
            System.out.println("User save");
             
        } catch (IOException e) {
            System.out.println("Error");

    }
}
    public Boolean isRegisted() throws IOException, Exception {
        String resultRow = null;
        BufferedReader br = new BufferedReader(new FileReader("Users.csv"));
        String line;
        //Cifrado password_sin_cifrado=new Cifrado();
        //String contrasenna=password_sin_cifrado.cifrar(password);
        while ( (line = br.readLine()) != null ) {

            String[] values = line.split(",");
            if(values[0].equals(username)) {
                if(values[1].equals(password)){
                    return true;
                }
            }
        }
        br.close();
        return false;
}

}
