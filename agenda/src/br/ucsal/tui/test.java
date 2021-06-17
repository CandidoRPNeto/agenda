package br.ucsal.tui;

import java.util.List;
import java.util.Scanner;

import br.ucsal.connections.AgendamentoC;
import br.ucsal.connections.Conexao;
import br.ucsal.connections.RecursoC;
import br.ucsal.connections.UsuarioC;
import br.ucsal.model.Agendamento;
import br.ucsal.model.Recurso;
import br.ucsal.model.Usuario;

public class test {
	private static Scanner s = new Scanner(System.in);
	private static UsuarioC u;
	private static RecursoC r;
	private static AgendamentoC ag;

	public static void main(String[] args) {
		Conexao banco = new Conexao("PostgreSql", "localhost", "5432", "agenda", "postgres", "5432");
		banco.conect();
		System.out.println("Conexão Bem sucedida");
		System.out.println("Carregando lista de opções");
		u = new UsuarioC(banco);
		ag = new AgendamentoC(banco);
		r = new RecursoC(banco);
		entradaDados(banco);
	}

	public static void entradaDados(Conexao banco) {
		int a = 0, b = 0;
		System.out.println("1 -- Inserir\n" + "2 -- Deletar\n" + "3 -- Atualizar\n" + "4 -- Listar");
		a = s.nextInt();
		
		if(a == 3)
			System.out.println("1 -- mudar o nome de usuario\n" + "2 -- mudar o recurso de agendamento\n"
							 + "3 -- mudar atividade de recurso");
		else
			System.out.println("1 -- usuario\n" + "2 -- agendamento\n" + "3 -- recurso");
		
		b = s.nextInt();
		if (a == 1) {
			if (b == 1)
				inserirUsuario(banco);
			else if (b == 2)
				inserirAgendamento(banco);
			else
				inserirRecurso(banco);
		} else if (a == 2) {
			if (b == 1)
				deletarUsuario(banco);
			else if (b == 2)
				deletarAgendamento(banco);
			else
				deletarRecurso(banco);
		} else if (a == 3) {
			if (b == 1)
				mudarNomeUsuario(banco);
			else if (b == 2)
				mudarRecursoAgendamento(banco);
			else
				mudarAtividadeRecurso(banco);
		} else {
			if (b == 1)
				listarUsuario(banco);
			else if (b == 2)
				listarAgendamento(banco);
			else
				listarRecurso(banco);
		}
	}


	public static void mudarNomeUsuario(Conexao banco) {
		System.out.print("Nome:");
		String nome = s.next();
		System.out.print("insira o ID: ");
		u.atualizarNome(s.nextInt(),nome);
	}

	public static void mudarRecursoAgendamento(Conexao banco) {
		System.out.print("Recurso:");
		int recurso = s.nextInt();
		System.out.print("insira o ID: ");
		ag.atualizarRecurso(s.nextInt(),recurso);
	}

	public static void mudarAtividadeRecurso(Conexao banco) {
		System.out.println("Ativo? (true/false)");
		s.nextLine();
		boolean ativ = s.nextBoolean();
		System.out.print("insira o ID: ");
		r.atualizarAtivo(s.nextInt(),ativ);
	}
	
	public static void inserirUsuario(Conexao banco) {
		System.out.print("Login:");
		String login = s.next();
		System.out.print("Nome:");
		String nome = s.next();
		System.out.print("Email:");
		String email = s.next();
		System.out.print("Senha:");
		String senha = s.next();
		System.out.print("Ativo:");
		s.nextLine();
		Boolean ativo = s.nextBoolean();
		System.out.print("Role:");
		String role = s.next();
		
		u.inserir(new Usuario(login, nome, email, senha, ativo, role));
	}

	public static void inserirAgendamento(Conexao banco) {
		System.out.print("Recurso:");
		int recurso = s.nextInt();
		System.out.print("Data:");
		String data = s.next();
		System.out.print("Hora:");
		String hora = s.next();
		System.out.print("HoraT:");
		String horaT = s.next();
		ag.inserir(new Agendamento(recurso, data, hora, horaT));
	}

	public static void inserirRecurso(Conexao banco) {
		String nome;
		System.out.print("Nome: ");
		nome = s.next();
		System.out.println("Ativo? (true/false)");
		s.nextLine();
		r.inserir(new Recurso(nome, s.nextBoolean()));
	}

	public static void deletarUsuario(Conexao banco) {
		System.out.print("insira o ID: ");
		u.deletar(s.nextInt());
	}

	public static void deletarAgendamento(Conexao banco) {
		System.out.print("insira o ID: ");
		ag.deletar(s.nextInt());
	}

	public static void deletarRecurso(Conexao banco) {
		System.out.print("insira o ID: ");
		r.deletar(s.nextInt());
	}

	public static void listarUsuario(Conexao banco) {
		List<Usuario> usuarios = u.listarUsuarios();
		for (Usuario usuario : usuarios) {
			System.out.println("Nome: " + usuario.getNome() + "\nE-mail: " + usuario.getEmail());
		}
	}

	public static void listarAgendamento(Conexao banco) {
		List<Agendamento> agendamentos = ag.listarAgendas();
		for (Agendamento agenda : agendamentos) {
			System.out.println("Data: " + agenda.getData() + " | Horario: " + agenda.getHora());
		}
	}

	public static void listarRecurso(Conexao banco) {
		List<Recurso> recursos = r.listarRecursos();
		for (Recurso recurso : recursos) {
			System.out.println("Nome: " + recurso.getNome());
		}
	}
}
