package modelo;

public class Senal{

	private Coordenada posicion;
	private EstadoSenal estado;

	//Se construye pasando las coordenadas de la señal y por defecto está en rojo
	public Senal(Coordenada posicion, EstadoSenal estado){
		this.posicion = posicion;
		this.estado = estado;
	}

	public void setEstado(){
		if (this.estado == EstadoSenal.ROJO) {
			this.estado = EstadoSenal.VERDE;
		}
		else {
			this.estado = EstadoSenal.ROJO;
		}
	}

	public EstadoSenal getEstado(){
		return this.estado;
	}

	public Coordenada getCoordenada(){
		return this.posicion;
	}

	public String toString(){
		Coordenada pos = this.posicion;
		return "Senal "+ pos.toString();
	}
}
