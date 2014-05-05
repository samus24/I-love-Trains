package Controlador;

import Modelo.Coordenada;
import Modelo.EstadoSenal;
import Modelo.Mundo;
import Modelo.Senal;
import Modelo.Tren;

public class Controlador {

	private Mundo mundo;

	public Controlador(Mundo mundo){
		this.mundo = mundo;
	}

	
	public void eliminarTren(int id){
		mundo.elimnarTren(id);
	}
	
	public void modificarTren(int id, int numVagones){
		mundo.modificarTren(id, numVagones);
	}
	
	public void crearTren(int numVagones){
		mundo.crearTren(numVagones);
	}
	
	public void anadirSenal(Coordenada posicion, EstadoSenal estado){
		mundo.anadirSenal(posicion, estado);
	}	
	

	public Tren[] getTrenes(){
		return mundo.getTrenes();
	}

	public char[][] getEstadoMundo(){
		return mundo.getEstadoMundo();
	}

	public Senal[] getSenal(){
		return mundo.getSenales();
	}
	public void setTrenes(Tren tren, int i){
		mundo.setTren(tren, i);
	}

	public void setSenal (Senal senal, int i){
		mundo.setSenal(senal, i);
	}

	public void setEstadoMundo(char[][] nuevoEstadoMundo){
		mundo.setEstadoMundo(nuevoEstadoMundo);
	}
	public void recalcularEstadoTrenes(){
		mundo.recalcularEstadoTrenes();
	}

	public void eliminarTren() {
		// TODO Auto-generated method stub
		
	}

	public void anadirSenal() {
		// TODO Auto-generated method stub
		
	}
}