package controller;

import model.Jogador;

import java.io.*;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Junior
 */
@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    String jogador = "";

    boolean cadastrado = false;

    void gravarArquivo(String jogador) {
        try {
            String caminhoDir = getServletContext().getRealPath("/WEB-INF/");

            File f = new File(caminhoDir, "jogadores.txt");
            FileWriter imp = new FileWriter(f, true);
            imp.write(jogador + "\n");
            imp.close();

        } catch (Exception e) {
            System.out.println("Nao poi possivel escrever o arquivo");
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Jogador player = new Jogador();

        player.nome = request.getParameter("jogador");
        player.nomeLogin = request.getParameter("jogadorLogin");
        player.email = request.getParameter("email");
        player.senha = request.getParameter("senha");
        player.dia = request.getParameter("nascimento");
        player.mes = request.getParameter("mes");
        player.ano = request.getParameter("ano");
        player.sexo = request.getParameter("rdsexo");
               
        if (leArquivo(player.nomeLogin)) {

            request.setAttribute("usr", player.nomeLogin);
            request.getRequestDispatcher("jacadastrado.jsp").forward(request, response);
        }
         else {
            gravarArquivo(player.toString());

            request.setAttribute("nome", jogador);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }


    }

    boolean leArquivo(String login) {

        String caminhoDir = getServletContext().getRealPath("/WEB-INF/");
        
        File f = new File(caminhoDir, "jogadores.txt");
        FileReader leitor;
            try {
                leitor = new FileReader(f);
		BufferedReader bf = new BufferedReader(leitor);
		String linha = "";
	        
                while ((linha = bf.readLine()) != null) {
	            String partes[] = linha.split(",");
                    	        
	                if (login.equals(partes[1])) {
	                    cadastrado = true;
	                    break;
	                }
	            }            
	            leitor.close();
	            bf.close();
        } catch (Exception ex) {
            System.out.println("Não foi possível ler no arquivo");
            System.out.println(ex.getMessage());
        }

        return cadastrado;

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


