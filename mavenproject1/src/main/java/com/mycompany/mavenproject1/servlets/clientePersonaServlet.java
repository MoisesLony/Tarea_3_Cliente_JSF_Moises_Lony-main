
package com.mycompany.mavenproject1.servlets;

import com.mycompany.mavenproject1.Personas;
import com.mycompany.mavenproject1.PersonasWebService;
import com.mycompany.mavenproject1.PersonasWebService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;


@WebServlet(name = "clientePersonaServlet", urlPatterns = {"/clientepersonas1"})
public class clientePersonaServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/michael_8080/webservicepersonas/PersonasWebService.wsdl")
    private PersonasWebService_Service service;
    private PersonasWebService port;

    @Override
    public void init() throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
         
        try { // Call Web Service Operation
            port = service.getPersonasWebServicePort();

        } catch (Exception ex) {
            System.err.print(ex);
        }
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet clientePersonaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>");
            List<Personas> personas = port.findAll();
            personas.stream().forEach(p -> {
            out.println("<li>" + p.getNombres() + " " + p.getApellidos() + "</li>");
            });
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
