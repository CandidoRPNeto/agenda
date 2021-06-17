package br.ucsal.connections;

import java.sql.SQLException;
import java.sql.Statement;

import br.ucsal.model.Agendamento;

public class AgendamentoC {
	
	private Conexao banco;
	
	public AgendamentoC(Conexao banco) {
		this.banco = banco;
	}
	
	public void inserir(Agendamento agendamento) {
	   	try {
	   		Statement stmt = banco.getC().createStatement();
	   		
	   		String sql = "INSERT INTO agendamento (data_agendamento, hora_agendamento, horaT_agendamento) VALUES('" 
	   	            +agendamento.getData()+"','"+agendamento.getHora()+"','"+agendamento.getHoraT()+"')";

	           stmt.executeUpdate(sql);
	           
	       } catch (SQLException e) {
	       	System.out.println(e);
	       }
	}
	public void deletar() {}
	public void atualizar() {}
	public void selecionar() {}
}
