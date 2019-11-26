/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import org.json.JSONObject;

/**
 *
 * @author vmagu
 */
public class Json {
    public JSONObject createResponse(String operation,int value){
        JSONObject response=new JSONObject();
        response.append("operation", operation);
        response.append("status", value);
        return response;
                //addProperty("operation",operation);
        
    }
}
