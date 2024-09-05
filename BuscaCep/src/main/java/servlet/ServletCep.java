package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Endereco;
import viacep.ServicoCep;

@WebServlet("/ServletCep")
public class ServletCep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCep() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		

		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()) {
			out.print("<!DOCTYPE html>");
			out.print("<html lang=\"pt-BR\">");
			out.print("<head>");
			
			out.print("<meta charset=\"UTF-8\">");
			out.print("<title>ViaCep</title>");
			out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"StyleServlet.css\">");
			out.print("</head>");
			out.print("<body>");
			out.print("<iframe frameborder=\"0\" width=\"980\" height=\"0%\" class=\"cabecalho\" src=\"./Cabecalho.html\"></iframe>");	
			out.print("<div class=\"resposta\">");
			
			try {
			String cep = request.getParameter("cep");
				
			 Endereco endereco = ServicoCep.BuscarEndereco(cep);
				
				if(endereco != null && endereco.getEstado() != null) {
					out.print("<table border=\"1px solid black\">");
					
					out.print("<tr>");
					out.print("<th colspan=\"2\">CEP</th>");
					out.print("<th colspan=\"2\">"+cep+"</th>");
					out.print("</tr>");
					
					out.print("<tr>");
					out.print("<th>Estado</th>");
					out.print("<th>Bairro</th>");
					out.print("<th>Logradouro</th>");
					out.print("<th>Região</th>");
					out.print("</tr>");
					
					out.print("<td>"+ endereco.getEstado()+"</td>");
					out.print("<td>"+ endereco.getBairro()+"</td>");
					out.print("<td>"+ endereco.getLogradouro()+"</td>");
					out.print("<td>"+ endereco.getRegiao()+"</td>");
					out.print("<tr>");					
					out.print("</tr>");
					out.print("</table");	
					
				}else {
					out.print("<img src=\"./img/nao-encontrado.png\" width=200 />");
					out.print("<h2 id=\"nao-encontrado\">CEP não encontrado!</h2>");
				}
			}catch(Exception e) {
				
			}
			
			out.print("</div>");
			out.print("</body>");
			out.print("</html>");
			
		}
	}

}
