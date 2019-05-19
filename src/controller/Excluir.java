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
@WebServlet(name = "Excluir", urlPatterns = { "/Excluir" })
public class Excluir extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */

	String contatosString = "";
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		contatosString = "";
		
		String contatos = request.getParameter("mod");
		if (contatos == null) {
			carregarContatos();
		} else {
			String[] contatosMod = new String[contatos.split(";").length];

			for (int i = 0; i < contatosMod.length; i++) {
				contatosMod[i] = contatos.split(";")[i].trim();
				if (i == 0) {
					gravarArquivoMod(contatosMod[i], true);
				} else {
					gravarArquivoMod(contatosMod[i], false);
				}
			}
			carregarContatos();
		}

		request.setAttribute("contatos", contatosString);
		request.getRequestDispatcher("excluir.jsp").forward(request, response);

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
				contatosString += linha + ";";
			}
			leitor.close();
			bf.close();
		} catch (Exception ex) {
			System.out.println("Não foi possível ler no arquivo");
			System.out.println(ex.getMessage());
		}
	}

	void gravarArquivoMod(String contato, boolean novoArquivo) {
		try {

			String caminhoDir = getServletContext().getRealPath("/WEB-INF/");

			File f = new File(caminhoDir, "contatos.txt");
			FileWriter imp = new FileWriter(f, !novoArquivo);
			imp.write(contato + "\n");
			imp.close();

		} catch (Exception e) {
			System.out.println("Nao poi possivel escrever o arquivo");
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
