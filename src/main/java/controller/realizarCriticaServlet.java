/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uv.es.g01.proyectofinal.entity.Pelicula;
import uv.es.g01.proyectofinal.service.ServicePelicula;

/**
 *
 * @author danilosalaz
 */

@WebServlet("/peliculas")
public class realizarCriticaServlet extends TemplateServlet{
    
    public realizarCriticaServlet() {
        super(new Pelicula());
    }

    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        
        ServicePelicula service = new ServicePelicula();
        Pelicula peliculaJson = gson.fromJson(reader, Pelicula.class);
        if(service.setCritica(peliculaJson.getIdPelicula(), peliculaJson.getCritica().get(peliculaJson.getCritica().size() -1))){
            responseJson(resp.getWriter(), service.getPelicula(peliculaJson.getIdPelicula()));
            resp.setStatus(200); 
            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setHeader("Access-Control-Allow-Methods", "DELETE, POST, GET, OPTIONS");
            resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
            
        }else{
            resp.sendError(500);
        }
        
    }
    
    
    
}
