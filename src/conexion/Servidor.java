/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author frank
 */
import Model.Database;
import Model.User;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import logica.Files;
import logica.Json;
import org.json.JSONArray;

import org.json.JSONObject;


public class Servidor {
   private ServerSocket serverSocket;
   
   public Servidor(int puerto, int tamanoCola) throws IOException {
      serverSocket = new ServerSocket(puerto, tamanoCola);
   }

   public void run() throws InterruptedException, Exception{
      Json json=new Json();
      Socket socket; 
      while(true) {
         try {
            System.out.println("Esperando cliente en puerto: " + serverSocket.getLocalPort() + "...");
            // Esperar conexiones
            socket = serverSocket.accept();
            
            System.out.println("Se acaba de conectar: " + socket.getRemoteSocketAddress());
            boolean state = true;
            Files file=new Files();
            
            int tries = 0;
            
            while (!socket.isClosed()) {
            	DataInputStream in = new DataInputStream(socket.getInputStream());
            	DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            	if(in.available() != 0) {
            		System.out.println("++New read++");
            		
            		System.out.println(in.available());
            		//JSONParser parser = new JSONParser();
            		//Object obj = parser.parse(in.readUTF());
            		//JSONArray array = (JSONArray)obj;
            		
            	//	JSONParser parser = new JSONParser();
            	//	JSONObject json = (JSONObject) parser.parse(in.readUTF());
            		
            	//	String operation = (String) json.get("operation");
            		
            	//	System.out.println(operation);
            		
            		
                	//String message = in.readUTF();
                	//System.out.println("+Message: " + message);
                	//String[] parts = message.split(",");
              	   	//int operation = Integer.parseInt(parts[0]);
              	   	//String values = parts[1];	
            		
            		
            		JSONObject jsonObject = new JSONObject(in.readUTF());
            		String operation = jsonObject.getString("operation");
            		JSONObject data = (JSONObject)jsonObject.getJSONObject("data");       
                        int flag;
                        
            		switch(operation) 
                    { 
                        case "crear_usuario": 
                            System.out.println("Se crea el usuario");
                            System.out.println("Nombre: " + data.getString("username"));
                            System.out.println("Pass: " + data.getString("password"));
                            User new_user=new User(data.getString("username"),data.getString("password"));
                            new_user.saveUserCredential();
                            JSONObject response= json.createResponse("crear_usuario", 1);
                            out.writeUTF(response.toString());
                            
                            break; 
                        case "login": 
                            System.out.println("two"); 
                            User user=new User(data.getString("username"),data.getString("password"));
                            Boolean isRegisted=user.isRegisted();
                     
                            if(isRegisted){
                                flag=1;
                            }else{
                                flag=0;
                            }
                            JSONObject registrado= json.createResponse("login", flag);
                            out.writeUTF(registrado.toString());
                            break; 
                        case "create_bd": 
                            
                            System.out.println("three");
                            if(file.createFolder(data.getString("password"))){
                                flag=1;
                            }else{
                                flag=0;
                            }
                            JSONObject db_creada= json.createResponse("create_bd", flag);
                            out.writeUTF(db_creada.toString());
                            break;
                        case "crear_tabla":
                            JSONArray rows = data.getJSONArray("rows");
                            String filename = data.getString("name");
                            String base=data.getString("bdname");
                            if(file.FolderChecker(base)){
                                if(file.createTable(filename,rows.toList())){flag=1;}
                                else{flag=0;}
                            }else{
                                flag=0;
                            }
                            JSONObject tabla_creada= json.createResponse("crear_tabla", flag);
                            out.writeUTF(tabla_creada.toString());
                            
                            break;
                        case "eliminar_usuario":
                            User eliminar=new User(data.getString("username"),"1");
                            eliminar.delete();
                            JSONObject delete_user= json.createResponse("eliminar_usuario", 1);
                            out.writeUTF(delete_user.toString());
                            break;
                        case "obtener_bds":
                            List<String> bds=file.findAllDataBases();
                            JSONArray list_bd= new JSONArray(bds);
                            JSONObject respuesta=new JSONObject();
                            respuesta.put("operation", "obtener_bds");
                            respuesta.put("status", list_bd);
                            out.writeUTF(respuesta.toString());
                            
                            
                        default: 
                            System.out.println("no match"); 
                         
                    }
            	} else {
            		tries ++;
            		if (tries >=500000) {
            			socket.close();
            		} else {
            			System.out.println("**************A dormir**************");
                		Thread.sleep(3000);
            		}
            		
            	}
            }
            
           
           // socket.close(); 
         } 
         
         catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            break;
         } 
         
         catch (IOException e) {
            e.printStackTrace();
            break;
         }
      }
   }
   
   public static void main(String[] args) throws InterruptedException, Exception{
       //Files file= new Files();
       //List<String> lista= new ArrayList<String>();
       //lista.add("id");
       //file.createTable("Comercio","Registro"  , lista);
      int puerto = 8067;
      int cola = 10;
      
      try {
         Servidor s = new Servidor(puerto, cola);
         s.run();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
