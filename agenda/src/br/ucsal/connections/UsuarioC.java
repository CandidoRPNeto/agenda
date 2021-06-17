package br.ucsal.connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.model.Usuario;

public class UsuarioC {

	private Conexao banco;

	public UsuarioC(Conexao banco) {
		this.banco = banco;
	}

	public void inserir(Usuario usuario) {
		try {
			Statement stmt = banco.getC().createStatement();

			String sql = "INSERT INTO usuario (login_usuario, nome_usuario, email_usuario, senha_usuario, ativo_usuario"
					+ ", role_usuario) VALUES('" + usuario.getLogin() + "','" + usuario.getNome() + "','"
					+ usuario.getEmail() + "','" + usuario.getSenha() + "'," + usuario.getAtivo() + ",'"
					+ usuario.getRole() + "')";

			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void deletar(Integer id) {
		try {
			Statement stmt = banco.getC().createStatement();

			String sql = "DELETE FROM usuario" + "WHERE id_usuario = " + id;

			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void atualizar() {
	}

	public Usuario selecionarPorId(Long id) {
		PreparedStatement stmt;
		Usuario usuario = new Usuario();
		try {
			/** executa um select */
			stmt = banco.getC().prepareStatement("select * from usuario where id_usuario = " + id);
			ResultSet rs = stmt.executeQuery();

			/** Itera no ResultSet */
			while (rs.next()) {
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setLogin(rs.getString("login_usuario"));
				usuario.setNome(rs.getString("nome_usuario"));
				usuario.setEmail(rs.getString("email_usuario"));
				usuario.setSenha(rs.getString("senha_usuario"));
				usuario.setAtivo(rs.getBoolean("ativo_usuario"));
				usuario.setRole(rs.getString("role_usuario"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		PreparedStatement stmt;
		try {
			/** executa um select */
			stmt = banco.getC().prepareStatement("select * from usuario");
			ResultSet rs = stmt.executeQuery();

			/** Itera no ResultSet */
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getString("login_usuario"), rs.getString("nome_usuario"),
						rs.getString("email_usuario"), rs.getString("senha_usuario"), rs.getBoolean("ativo_usuario"),
						rs.getString("role_usuario"));
				usuario.setId(rs.getLong("id_usuario"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuarios;

	}

	public Usuario obterUsuarioLongSenha(String login, String senha) {
		PreparedStatement stmt;
		Usuario usuario = new Usuario();
		try {
			/** executa um select */
			stmt = banco.getC().prepareStatement(
					"select * from usuario where login_usuario = " + login + " and senha_usuario =" + senha);
			ResultSet rs = stmt.executeQuery();

			/** Itera no ResultSet */
			while (rs.next()) {
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setLogin(rs.getString("login_usuario"));
				usuario.setNome(rs.getString("nome_usuario"));
				usuario.setEmail(rs.getString("email_usuario"));
				usuario.setSenha(rs.getString("senha_usuario"));
				usuario.setAtivo(rs.getBoolean("ativo_usuario"));
				usuario.setRole(rs.getString("role_usuario"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;

	}
}
