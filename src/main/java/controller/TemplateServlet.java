/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author danilosalaz
 * @param <T>
 */
public class TemplateServlet<T> extends HttpServlet{
    
    private final T object;
    
    public TemplateServlet(T object) {
        this.object = object;
    }
    
    public void responseJson(PrintWriter pw, T Object){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();;
        String jsonResponse = gson.toJson(Object);
        
        pw.println(jsonResponse);
        pw.flush();
        pw.close();
    }
    
}
