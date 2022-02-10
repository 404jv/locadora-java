/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.MVC.Controllers;

import br.edu.ifpr.MVC.Entities.Client;
import br.edu.ifpr.MVC.Models.ClientModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joao
 */
@WebServlet(name = "CreateClientController", urlPatterns = {"/client/create"})
public class CreateClientController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        String phone = request.getParameter("phone");
        String cpf = request.getParameter("cpf");

        Client client = new Client(name, address, district, phone, cpf);

        ClientModel clientModel = new ClientModel();

        try {
            clientModel.create(client);
        } catch (Exception e) {
          response.sendError(400, e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
