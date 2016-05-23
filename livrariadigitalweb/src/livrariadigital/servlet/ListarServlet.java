package livrariadigital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

@WebServlet("/ListarLivros")
public class ListarServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Livro> livros = new  ArrayList<Livro>();
        String busca = request.getParameter("busca").trim();
        int tipoBusca = Integer.parseInt(request.getParameter("tipoBusca"));
        
        LivroDao livroDao;
		try {
			livroDao = new LivroDao();
			livros = livroDao.getLista( tipoBusca, busca);
		} catch (SQLException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
       
        
        
        
        
        
		request.setAttribute("livros", livros);
        RequestDispatcher rd = request.getRequestDispatcher("/tabela.jsp");
		rd.forward(request, response);
    }
 
}
