/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uv.es.g01.proyectofinal.entity.Compra;
import uv.es.g01.proyectofinal.entity.Entrada;
import uv.es.g01.proyectofinal.service.ServiceEntrada;

/**
 *
 * @author danilosalaz
 */
@WebServlet("/compradas")
public class listarEntradasServlet extends TemplateServlet {

    public listarEntradasServlet() {
        super(new Compra());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceEntrada service = new ServiceEntrada();
        List<Compra> listEntradas = service.getEntradasCompradas(Integer.parseInt(req.getParameter("id")));
        
        responseJson(resp.getWriter(), listEntradas);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
