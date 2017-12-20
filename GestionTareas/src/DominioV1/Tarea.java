package DominioV1;

import java.util.ArrayList;

public class Tarea {

	private String Descripion;
	private String Definicion;
	private int Prioridad;
	private int Estado;
	private ArrayList<String> Participantes;

	public Tarea(String descripion, int prioridad, int estado, ArrayList<String> participantes, String definicion) {
		Descripion = descripion;
		Prioridad = prioridad;
		Estado = estado;
		Definicion = definicion;
		Participantes = participantes;
	}

	public String getDefinicion() {
		return Definicion;
	}

	public void setDefinicion(String definicion) {
		Definicion = definicion;
	}

	public String getDescripion() {
		return Descripion;
	}

	public void setDescripion(String descripion) {
		Descripion = descripion;
	}

	public int getPrioridad() {
		return Prioridad;
	}

	public void setPrioridad(int prioridad) {
		Prioridad = prioridad;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	public ArrayList<String> getParticipantes() {
		return Participantes;
	}

	public void setParticipantes(ArrayList<String> participantes) {
		Participantes = participantes;
	}

	public int getNumeroParticipantes() {
		return Participantes.size();
	}

}
