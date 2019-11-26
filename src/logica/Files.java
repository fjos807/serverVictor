/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComboBox;
import logica.Cifrado;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author vmagu
 */
public class Files {
public Boolean isRegisted(String username, String password) throws IOException, Exception {
    String resultRow = null;
    BufferedReader br = new BufferedReader(new FileReader("Users.csv"));
    String line;
    Cifrado password_sin_cifrado=new Cifrado();
    String contrasenna=password_sin_cifrado.cifrar(password);
    while ( (line = br.readLine()) != null ) {
        
        String[] values = line.split(",");
        if(values[0].equals(username)) {
            if(values[1].equals(contrasenna)){
                return true;
            }
        }
    }
    br.close();
    return false;
}

public boolean FileChecker(String filename,String root) {
	  File f = new File(root+"\\"+filename+".csv");

	  if(f.exists()){
                System.out.println("File existed");
              return true;
		
	  }else{
              System.out.println("File not found!");
              return false;
	  }
}
public boolean FolderChecker(String foldername) {
	  File f = new File(foldername);

	  if(f.exists()){
                System.out.println("Folder existed");
              return true;
		
	  }else{
              System.out.println("Folder not found!");
              return false;
	  }
}
public boolean createFolder(String foldername){
    if(!FolderChecker(foldername)){
        new File("Bases"+"\\"+foldername).mkdir();
        System.out.println("Folder creado");
        return true;
    }else{
        return false;
    }
}
/*public boolean createTable(String tableName, String db,List<String> rows) throws IOException{
        
        File table= new File("Bases"+"\\"+db+"\\"+tableName+".csv");
        table.getParentFile().mkdirs();
        FileWriter writer=new FileWriter(tableName);
        System.out.println("Folder creado");
        String FILE_HEADER = "";
        for (int i = 0; i < rows.size(); i++) {
            FILE_HEADER+=rows.get(i)+",";
        }
            try {
                writer.append(FILE_HEADER);
                writer.append("\n");
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        return true;
}
  
*/

public List<String> findAllDataBases() {
    String cwd = System.getProperty("user.dir");
    File directory = new File(cwd+"\\"+"Bases");
	
    FileFilter directoryFileFilter = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
		
    File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
    //System.out.println(directoryListAsFile);
    List<String> foldersInDirectory = new ArrayList<String>(directoryListAsFile.length);
    System.out.println(foldersInDirectory);
    for (File directoryAsFile : directoryListAsFile) {
        //System.out.println(foldersInDirectory.add(directoryAsFile.getName()));
        foldersInDirectory.add(directoryAsFile.getName());
    }
    System.out.println(foldersInDirectory);
    return foldersInDirectory;
}

 public Boolean createTable(String filename,List<Object> rows){
    String fileName=filename+".csv";
    //Delimiter used in CSV file
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
        FileWriter fileWriter = null;
        //password_encriptada.cifrar(login.getPassword());
        try {
            String FILE_HEADER = "";
            fileWriter = new FileWriter(fileName,true);
            for(int i=0;i<rows.size();i++){
                FILE_HEADER+=rows.get(i)+",";
        }
            try {
                fileWriter.append(FILE_HEADER);
                fileWriter.append("\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error");
            return false;
            
    }
 }

}

