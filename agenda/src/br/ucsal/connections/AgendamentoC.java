package br.ucsal.connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.model.Agendamento;

public class AgendamentoC {

	private Conexao banco;

	public AgendamentoC(Conexao banco) {
		this.banco = banco;
	}

	public void atualizarRecurso(int id, int recurso) {
		try {
			PreparedStatement st = banco.getC()
					.prepareStatement("UPDATE agendamento SET id_recurso = ? WHERE id_agendamento = ?;");

			st.setInt(1, recurso);
			st.setInt(2, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void inserir(Agendamento agendamento) {
		try {
			Statement stmt = banco.getC().createStatement();

			String sql = "INSERT INTO agendamento (data_agendamento, hora_agendamento, horaT_agendamento) VALUES('"
					+ agendamento.getData() + "','" + agendamento.getHora() + "','" + agendamento.getHoraT() + "')";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void deletar(Integer id) {
		try {
			PreparedStatement st = banco.getC().prepareStatement("DELETE FROM agendamento WHERE id_agendamento = ?;");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public Agendamento selecionarPorId(int id) {
		PreparedStatement stmt;
		Agendamento agenda = new Agendamento();
		try {
			/** executa um select */
			stmt = banco.getC().prepareStatement("select * from agenda where id_agendamento = " + id);
			ResultSet rs = stmt.executeQuery();

			/** Itera no ResultSet */
			while (rs.next()) {
				agenda.setId(rs.getInt("id_agendamento"));
				agenda.setRecurso(rs.getInt("id_recurso"));
				agenda.setData(rs.getString("data_agendamento"));
				agenda.setHora(rs.getString("hora_agendamento"));
				agenda.setHoraT(rs.getString("horaT_agendamento"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return agenda;
	}

	public List<Agendamento> listarAgendas() {
		List<Agendamento> agendamentos = new ArrayList<>();
		PreparedStatement stmt;
		try {
			/** executa um select */
			stmt = banco.getC().prepareStatement("select * from agendamento");
			ResultSet rs = stmt.executeQuery();

			/** Itera no ResultSet */
			while (rs.next()) {
				Agendamento agenda = new Agendamento(rs.getInt("id_recurso"), rs.getString("data_agendamento"),
						rs.getString("hora_agendamento"), rs.getString("horaT_agendamento"));
				agenda.setId(rs.getInt("id_agendamento"));
				agendamentos.add(agenda);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return agendamentos;

	}

	public Agendamento obterAgendaPorData(String data, String hora, String horaT) {
		PreparedStatement stmt;
		Agendamento agenda = new Agendamento();
		try {
			/** executa um select */
			stmt = banco.getC().prepareStatement("select * from agenda where data_agendamento = " + data
					+ "and hora_agendamento = " + hora + " and horaT_agendamento = " + horaT);
			ResultSet rs = stmt.executeQuery();

			/** Itera no ResultSet */
			while (rs.next()) {
				agenda.setId(rs.getInt("id_agendamento"));
				agenda.setRecurso(rs.getInt("id_recurso"));
				agenda.setData(rs.getString("data_agendamento"));
				agenda.setHora(rs.getString("hora_agendamento"));
				agenda.setHoraT(rs.getString("horaT_agendamento"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return agenda;

	}

}
