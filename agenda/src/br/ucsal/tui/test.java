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

	public static void main(String[] args) {
		Conexao banco = new Conexao("PostgreSql", "localhost", "5432",
    			"agenda", "postgres", "5432");
    	banco.conect();
    	System.out.println("quer criar um usuario");
    	int a = s.nextInt();
    	if(a == 1) {
    		System.out.println("e pra ja chefe");
    		UsuarioC u = new UsuarioC(banco);
    		u.inserir(new Usuario("a","a","a","a",true,"ADM"));
    		List<Usuario> usuarios = u.listarUsuarios();
    		for (Usuario usuario : usuarios) {
    			System.out.println("Nome: "+usuario.getNome()+"\nE-mail: "+usuario.getEmail());
			}
    	}
    	if(a == 2) {
    		System.out.println("e pra ja chefe, recurso saindo");
    		RecursoC r = new RecursoC(banco);
    		r.inserir(new Recurso("a",true));
    		List<Recurso> recursos = r.listarRecursos();
    		for (Recurso recurso : recursos) {
    			System.out.println("Nome: "+recurso.getNome());
			}
    	}
    	if(a == 2) {
    		System.out.println("ok ok, tome um agendamento");
    		AgendamentoC ag = new AgendamentoC(banco);
    		ag.inserir(new Agendamento(3,"a","b","c"));
    		List<Agendamento> agendamentos = ag.listarAgendas();
    		for (Agendamento agenda : agendamentos) {
    			System.out.println("Data: "+agenda.getData()+" | Horario: "+agenda.getHora());
			}
    	}
    }
}
