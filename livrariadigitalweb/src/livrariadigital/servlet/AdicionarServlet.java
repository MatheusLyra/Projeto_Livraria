package livrariadigital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

@WebServlet("/AdicionarLivro")
public class AdicionarServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Livro livro = new Livro();
        livro.setTitulo(request.getParameter("titulo"));
        livro.setAutor(request.getParameter("autor"));
        livro.setEditora(request.getParameter("editora"));
        livro.setEmail(request.getParameter("email"));

        Calendar cal = Calendar.getInstance();
		DateFormat formatter ; 
		Date date ;
//		cal.setTime(request.getParameter("dataLancamento"));
        
        try
        {
			String data = request.getParameter("data");
 
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (Date)formatter.parse(data);
        		
			cal.setTime(date);
			livro.setDataLancamento(cal);
         } 
         catch (ParseException e){
        	 System.out.println("Exception :"+e);  
        } 
        
        
        LivroDao livroDao;
		try {
			livroDao = new LivroDao();
			livroDao.adiciona(livro);
		} catch (SQLException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
       
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       
        RequestDispatcher rd = request.getRequestDispatcher("/CadastrarLivro.jsp");
		rd.forward(request, response);
    }

}
