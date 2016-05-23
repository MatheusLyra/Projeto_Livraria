package livrariadigital.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import livrariadigital.jdbc.FabricaDeConexoes;
import livrariadigital.modelo.Livro;

public class LivroDao {
	private Connection conn;

	// Construtor de LivroDao que pega uma conex√£o na F√°brica de Conex√µes
	public LivroDao() throws SQLException {
		this.conn = new FabricaDeConexoes().getConnection();
	}

	// m√©todo que adiciona livro ao Banco de Dados livrariadigital
	public void adiciona(Livro livro) {
		String sql = "insert into livros(titulo, autor, editora, email, dataLancamento) values (?,?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getEmail());
			stmt.setDate(5, new Date(livro.getDataLancamento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// m√©todo que retorna uma lista de livros pesquisada no Banco de Dados
	// livrariadigital
//	public List<Livro> getLista() {
//		try {
//			List<Livro> livros = new ArrayList<Livro>();
//
//			String sql = "select * from livros";
//
//			PreparedStatement stmt = this.conn.prepareStatement(sql);
//
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				Livro livro = new Livro();
//				livro.setId(rs.getLong("id"));
//				livro.setTitulo(rs.getString("titulo"));
//				livro.setAutor(rs.getString("autor"));
//				livro.setEditora(rs.getString("editora"));
//				livro.setEmail(rs.getString("email"));
//
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataLancamento"));
//				livro.setDataLancamento(data);
//
//				livros.add(livro);
//			}
//
//			rs.close();
//			stmt.close();
//			return livros;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}

	
	
	public List<Livro> getLivro(String id) throws SQLException{     						//j· que o retorno È uma lista utiliza list
		StringBuilder sql = new StringBuilder("");
		
		sql.append("select * from livros ");
		sql.append("where livros.id=" + id);
		
		
		PreparedStatement stm = conn.prepareStatement(sql.toString());
/*
		if (filtro >=0) {
			stm.setString(1, texto);
		}
*/
		ResultSet rset = stm.executeQuery();									//
		List<Livro> livros = new ArrayList<Livro>(); 							//livros È o nome da lista
		
		while(rset.next()){														//next movimenta o ponteiro da memoria atÈ encontrar null
			Livro livro = new Livro();
			livro.setId(Long.parseLong(rset.getString("id")));
			livro.setTitulo(rset.getString("titulo"));
			livro.setAutor(rset.getString("autor"));
			livro.setEditora(rset.getString("editora"));
			livro.setEmail(rset.getString("email"));
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
			try {
				cal.setTime(sdf.parse(rset.getString("dataLancamento")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			livro.setDataLancamento(cal);
			livros.add(livro);													//pega o livro em memoria e joga na lista
		}
		
		rset.close();
		stm.close();
		return livros;
		
	}
	
	
	
	
	
	public List<Livro> getLista(int filtro, String texto) throws SQLException{     						//j· que o retorno È uma lista utiliza list
		StringBuilder sql = new StringBuilder("");
		
		sql.append("select * from livros ");
		
		switch (filtro) {
		case 1:
			sql.append("where livros.id=" + texto);
			break;
		case 2:
			sql.append("WHERE UPPER(livros.titulo) LIKE UPPER('%" + texto + "%')");
			break;
		case 3:
			sql.append("WHERE UPPER(livros.autor) LIKE UPPER('%" + texto + "%')");
			break;
		case 4:
			sql.append("WHERE UPPER(livros.editora) LIKE UPPER('%" + texto + "%')");
			break;
		case 5:
			sql.append("WHERE UPPER(livros.titulo) LIKE UPPER('" + texto + "%')");
			break;
		default:
			break;
		}
		
		PreparedStatement stm = conn.prepareStatement(sql.toString());
/*
		if (filtro >=0) {
			stm.setString(1, texto);
		}
*/
		ResultSet rset = stm.executeQuery();									//
		List<Livro> livros = new ArrayList<Livro>(); 							//livros È o nome da lista
		
		while(rset.next()){														//next movimenta o ponteiro da memoria atÈ encontrar null
			Livro livro = new Livro();
			livro.setId(Long.parseLong(rset.getString("id")));
			livro.setTitulo(rset.getString("titulo"));
			livro.setAutor(rset.getString("autor"));
			livro.setEditora(rset.getString("editora"));
			livro.setEmail(rset.getString("email"));
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
			try {
				cal.setTime(sdf.parse(rset.getString("dataLancamento")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			livro.setDataLancamento(cal);
			livros.add(livro);													//pega o livro em memoria e joga na lista
		}
		
		rset.close();
		stm.close();
		return livros;
		
	}
	
	
	// m√©todo que altera o conte√∫do de um livro no Banco de Dados
	public void altera(Livro livro) {
		String sql = "update livros set titulo=?, autor=?, editora=?, email=?, dataLancamento=? where id=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getEmail());
			stmt.setDate(5, new Date(livro.getDataLancamento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close(); 
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	public void exclui(Livro livro){
		try {
			String sql = "delete from livros where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}