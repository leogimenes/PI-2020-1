package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PegadaIndividual;
import service.PegadaService;

/**
 * Servlet implementation class ManterPegada
 */
@WebServlet("/ManterPegada.do")
public class ManterPegada extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		//instanciar o service
		PegadaService ps = new PegadaService();
		RequestDispatcher dispatcher = null;
		
		switch(acao) {
		case "Incluir":
			String pNome = request.getParameter("nomeIndividual");
			String pCpf = request.getParameter("CPF_Individual");
			String pCep = request.getParameter("CEP");
			int pBairro = Integer.parseInt(request.getParameter("Bairro"));
			
			//instanciar o javabean
			PegadaIndividual pegada = new PegadaIndividual();
			pegada.setNomeIndividual(pNome);
			pegada.setCpfIndividual(pCpf);
			pegada.setCepIndividual(pCep);
			pegada.setIdBairro(pBairro);
			
			ps.create(pegada);
			pegada = ps.read(pegada.getId());

			request.setAttribute("pegada", pegada);
			dispatcher = request.getRequestDispatcher("PegadaIndividual.jsp");
			break;
		}
		
		dispatcher.forward(request, response);
		
		
	}

}
