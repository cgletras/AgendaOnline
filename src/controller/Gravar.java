package controller;

import model.Contato;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Junior
 */
@WebServlet(name = "Gravar", urlPatterns = {"/Gravar"})
public class Gravar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    String contato = "";

    void gravarArquivo(String contato) {
        try {
            String caminhoDir = getServletContext().getRealPath("/WEB-INF/");

            File f = new File(caminhoDir, "contatos.txt");
            FileWriter imp = new FileWriter(f, true);
            imp.write(contato.trim() + "\n");
            imp.close();

        } catch (Exception e) {
            System.out.println("Nao poi possivel escrever o arquivo");
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Contato contato = new Contato();

        contato.nome = request.getParameter("nome");
        contato.nota1= request.getParameter("nota1");
        contato.nota2= request.getParameter("nota2");
        
        if (contato.nome!=null){
                gravarArquivo(contato.toString());
                
                request.setAttribute("nome", contato.nome);
                request.getRequestDispatcher("index.html").forward(request, response);
            
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
