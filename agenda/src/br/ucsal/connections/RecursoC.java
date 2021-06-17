package br.ucsal.connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.model.Recurso;

public class RecursoC {

	private Conexao banco;

	public RecursoC(Conexao banco) {
		this.banco = banco;
	}
	
	public void atualizarAtivo(int id, boolean atividade) {
		
		try {	
	        PreparedStatement st = banco.getC().prepareStatement(
	        		"UPDATE usuario SET ativo_recurso = ? WHERE id_recurso = ?;");
	        st.setBoolean(1,atividade);
	        st.setInt(2,id);
	        st.executeUpdate(); 
	} catch (SQLException e) {
		System.out.println(e);
	}
	}

	public void inserir(Recurso recurso) {
		try {
			Statement stmt = banco.getC().createStatement();

			String sql = "INSERT INTO recurso (nome_recurso, ativo_recurso) " + "VALUES('" + recurso.getNome() + "',"
					+ recurso.getAtivo() + ")";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void deletar(Integer id) {
		try {	
		        PreparedStatement st = banco.getC().prepareStatement("DELETE FROM recurso WHERE id_recurso = ?;");
		        st.setInt(1,id);
		        st.executeUpdate(); 
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void atualizar() {
	}

	public Recurso selecionarporId(int id) {
		PreparedStatement stmt;
		Recurso recurso = new Recurso();
		try {
			/** executa um select */
			stmt = banco.getC().prepareStatement("select * from recurso where id_recurso = " + id);
			ResultSet rs = stmt.executeQuery();

			/** Itera no ResultSet */
			while (rs.next()) {
				recurso.setId(rs.getLong("id_recurso"));
				recurso.setNome(rs.getString("nome_recurso"));
				recurso.setAtivo(rs.getBoolean("ativo_recurso"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return recurso;
	}

	public List<Recurso> listarRecursos() {
		List<Recurso> recursos = new ArrayList<>();
		PreparedStatement stmt;
		try {
			/** executa um select */
			stmt = banco.getC().prepareStatement("select * from recurso");
			ResultSet rs = stmt.executeQuery();

			/** Itera no ResultSet */
			while (rs.next()) {
				Recurso recurso = new Recurso(rs.getString("nome_recurso"), rs.getBoolean("ativo_recurso"));
				recurso.setId(rs.getLong("id_recurso"));
				recursos.add(recurso);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return recursos;

	}

}
