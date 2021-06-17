package br.ucsal.model;

public class Agendamento {
	private int id;
	private int idRecurso;
	private String data;
	private String hora;
	private String horaT;

	
	
	public Agendamento() {}
	public Agendamento(int recurso, String data, String hora, String horaT) {
		
		this.idRecurso = recurso;
		this.data = data;
		this.hora = hora;
		this.horaT = horaT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecurso() {
		return idRecurso;
	}

	public void setRecurso(int recurso) {
		this.idRecurso = recurso;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getHoraT() {
		return horaT;
	}

	public void setHoraT(String horaT) {
		this.horaT = horaT;
	}
}
