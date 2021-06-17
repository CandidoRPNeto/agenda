package br.ucsal.connections;

import java.sql.SQLException;
import java.sql.Statement;

import br.ucsal.model.Recurso;

public class RecursoC {
	
	private Conexao banco;
	
	public RecursoC(Conexao banco) {
		this.banco = banco;
	}
	
	public void inserir(Recurso recurso) {
	   	try {
	   		Statement stmt = banco.getC().createStatement();
	   		
	   		String sql = "INSERT INTO recurso (nome_recurso, ativo_recurso) "
	   				+ "VALUES('"+recurso.getNome()+"',"+recurso.getAtivo()+")";

	           stmt.executeUpdate(sql);
	           
	       } catch (SQLException e) {
	       	System.out.println(e);
	       }
	}
	public void deletar() {}
	public void atualizar() {}
	public void selecionar() {}

}
