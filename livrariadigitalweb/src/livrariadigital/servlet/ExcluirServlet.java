package livrariadigital.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;


@WebServlet("/ExcluirLivro")
public class ExcluirServlet extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Long id = Long.parseLong(request.getParameter("codigo"));
        Livro livro = new Livro();
        livro.setId(id);
        LivroDao livroDao;
		try {
			livroDao = new LivroDao();
			livroDao.exclui(livro);
		} catch (SQLException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
       
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
    }

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Retorna do link da tabela
        String id = request.getParameter("id");
        Livro livro = new Livro();
        
        LivroDao livroDao;
		try {
			livroDao = new LivroDao();
			livro = livroDao.getLivro(id);
		} catch (SQLException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
       
		request.setAttribute("livro", livro);
        RequestDispatcher rd = request.getRequestDispatcher("/ExcluirLivro.jsp");
		rd.forward(request, response);
    }

}
