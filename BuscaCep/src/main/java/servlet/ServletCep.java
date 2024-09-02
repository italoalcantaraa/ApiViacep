package servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.Endereco;
import viacep.ServicoDeCep;

@WebServlet("/ServletCep")
public class ServletCep extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ServletCep() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		Endereco endereco = ServicoDeCep.buscaEnderecoPelo(request.getParameter("cep"));
		
		if(endereco == null) {
			RequestDispatcher dispacher = request.getRequestDispatcher("EnderecoNull.jsp");
			dispacher.forward(request, response);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("cep", endereco);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("Home.jsp");
		dispacher.forward(request, response);
	}

}
	