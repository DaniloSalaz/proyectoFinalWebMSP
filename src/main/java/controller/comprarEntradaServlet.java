/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uv.es.g01.proyectofinal.entity.Compra;
import uv.es.g01.proyectofinal.service.ServiceEntrada;

/**
 *
 * @author danilosalaz
 */
@WebServlet("/comprar")
public class comprarEntradaServlet extends TemplateServlet{
    
    public comprarEntradaServlet() {
        super(new Compra());
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        
        ServiceEntrada service = new ServiceEntrada();
        
        Compra nuevaCompra = gson.fromJson(reader, Compra.class);
        
        service.comprarEntrada(nuevaCompra.getUsuario().getIdUsuario(), nuevaCompra.getEntradas(), nuevaCompra.getMetodoPago());
        resp.setStatus(200);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "DELETE, POST, GET, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        
    }
}
