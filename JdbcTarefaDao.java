package br.com.caelum.tarefas.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.Lista_Mercado;
import br.com.caelum.tarefas.modelo.Usuario;


public class JdbcTarefaDao<Int> {
	private final Connection connection;

	public JdbcTarefaDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Lista_Mercado mercado) {

		String sql = "insert into lista_mercado (item, preco) values (?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, mercado.getItem());
			stmt.setDouble(2, mercado.getPreco());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Lista_Mercado lista){
		String sql = "update lista_mercado set item = ?, preco = ? where cod_lista = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, lista.getItem());
			stmt.setDouble(2, lista.getPreco());
			stmt.setLong(3, lista.getCod_lista());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Lista_Mercado lista) {

		if (lista.getCod_lista() == 0) {
			throw new IllegalStateException("Codigo da lista de mercado nao deve ser nulo.");
		}

		String sql = "delete from lista_mercado where cod_lista = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, lista.getCod_lista());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Lista_Mercado> lista() {
		try {
			List<Lista_Mercado> linhas = new ArrayList<Lista_Mercado>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from lista_mercado");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona a tarefa na lista
				linhas.add(populaTarefa(rs));
			}

			rs.close();
			stmt.close();

			return linhas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Lista_Mercado buscaPorCod_Lista(int cod_lista) {

		if (cod_lista == 0) {
			throw new IllegalStateException("Codigo da lista de mercado nao deve ser nulo.");
		}

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from lista_mercado where cod_lista = ?");
			
			stmt.setInt(1, cod_lista);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return populaTarefa(rs);
			}

			rs.close();
			stmt.close();

			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	private Lista_Mercado populaTarefa(ResultSet rs) throws SQLException {
		Lista_Mercado lista = new Lista_Mercado();

		// popula o objeto tarefa
		lista.setCod_lista(rs.getInt("cod_lista"));
		lista.setItem(rs.getString("item"));
		lista.setPreco(rs.getDouble("preco"));
		return lista;
	}
	
	public boolean existeUsuario(Usuario usuario) {

		if (usuario == null) {
			throw new IllegalArgumentException("Usuario não deve ser nulo");
		}

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from usuarios where login = ? and senha = ?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
