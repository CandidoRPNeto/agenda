package br.ucsal.connections;

import java.sql.SQLException;
import java.sql.Statement;

import br.ucsal.model.Usuario;

public class UsuarioC {
	
	private Conexao banco;
	
	public UsuarioC(Conexao banco) {
		this.banco = banco;
	}
	
	public void inserir(Usuario usuario) {
	   	try {
	   		Statement stmt = banco.getC().createStatement();
	   		
	   		String sql = "INSERT INTO usuario (login_usuario, nome_usuario, email_usuario, senha_usuario, ativo_usuario"+
	   	            ", role_usuario) VALUES('" 
	   	            +usuario.getLogin()+"','"+usuario.getNome()+"','"+usuario.getEmail()+"','"+usuario.getSenha()
	   	            +"',"+usuario.getAtivo()+",'"+usuario.getRole()+"')";

	           stmt.executeUpdate(sql);
	       } catch (SQLException e) {
	       	System.out.println(e);
	       }
	}
	public void deletar() {}
	public void atualizar() {}
	public void selecionar() {}
}
