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
@WebServlet(name = "Pesquisar", urlPatterns = {"/Pesquisar"})
public class Pesquisar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

    String contatos = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	contatos = "";
    	
    	String pesquisar = request.getParameter("pesquisar");
    	
    	carregarContatos();
    	pesquisarContatos(pesquisar);
    	    	          
        request.setAttribute("contatos", contatos);
        request.getRequestDispatcher("pesquisar.jsp").forward(request, response);
     
    }
    private void pesquisarContatos(String nome) {
		if(nome!= null) {
			
			boolean naoTem = false;
			
			String [] vetNome = contatos.split(";");
			contatos="";
			
			for (int i = 0; i < vetNome.length; i++) {
				if (vetNome[i].contains(nome)) {
					contatos+= vetNome[i]+";";
					naoTem=true;
				}
			}
			
			if (naoTem == false) {
				contatos = "Este contato não existe,0";
			}
			
		} else {
			contatos = "Este contato não existe,0";
		}
		
	}
	public void carregarContatos() {
    	String caminhoDir = getServletContext().getRealPath("/WEB-INF/");
        
        File f = new File(caminhoDir, "contatos.txt");
        FileReader leitor;
            try {
                leitor = new FileReader(f);
	    		BufferedReader bf = new BufferedReader(leitor);
	    		String linha = "";
	        
                while ((linha = bf.readLine()) != null) {
	            
                	contatos += linha+";";
                   	              
	            }            
	            leitor.close();
	            bf.close();
        } catch (Exception ex) {
            System.out.println("Não foi possível ler no arquivo");
            System.out.println(ex.getMessage());
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
