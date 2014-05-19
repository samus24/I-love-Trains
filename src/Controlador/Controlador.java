package Controlador;

import java.util.ArrayList;

import javax.swing.JTextArea;

import Modelo.Coordenada;
import Modelo.EstadoSenal;
import Modelo.Mundo;
import Modelo.Senal;
import Modelo.Trayecto;
import Modelo.Tren;

public class Controlador {

	private Mundo mundo;

	public Controlador(Mundo mundo){
		this.mundo = mundo;
	}

	
	public void eliminarTren(int id){
		mundo.eliminarTren(id);
	}
	
	public void modificarTren(int id, int numVagones,Trayecto trayecto){
		mundo.modificarTren(id, numVagones,trayecto);
	}
	
	public void crearTren(int numVagones,Coordenada c,Trayecto trayecto){
		mundo.anadirTren(numVagones,c,trayecto);
	}
	
	public void anadirSenal(Coordenada posicion, EstadoSenal estado){
		mundo.anadirSenal(posicion, estado);
	}	
	
	public ArrayList<Tren> getTrenes(){
		return mundo.getTrenes();
	}

	public char[][] getEstadoMundo(){
		return mundo.getEstadoMundo();
	}

	public ArrayList<Senal> getSenal(){
		return mundo.getSenales();
	}
	public void setTrenes(Tren tren){
		mundo.setTren(tren);
	}

	public void setSenal (Senal senal){
		mundo.setSenal(senal);
	}

	public void setEstadoMundo(char[][] nuevoEstadoMundo){
		mundo.setEstadoMundo(nuevoEstadoMundo);
	}
	public void recalcularEstadoTrenes(){
		mundo.recalcularEstadoTrenes();
	}

	public JTextArea mostrarMapa(){
		return mundo.mostrarMapa();
	}


	public void eliminarSenal(Senal senal) {
		mundo.eliminarSenal(senal);
	}
}
