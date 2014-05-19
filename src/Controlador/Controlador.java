package Controlador;

import java.util.ArrayList;

import javax.swing.JTextArea;

import Modelo.Coordenada;
import Modelo.EstadoSenal;
import Modelo.Mundo;
import Modelo.Senal;
import Modelo.Tren;
import Vista.Signal;

public class Controlador {

	private Mundo mundo;

	public Controlador(Mundo mundo){
		this.mundo = mundo;
	}

	
	public void eliminarTren(int id){
		mundo.eliminarTren(id);
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

	public void eliminarTren() {
		// TODO Auto-generated method stub
		
	}

	public void anadirSenal() {
		// TODO Auto-generated method stub
		
	}
	public JTextArea mostrarMapa(){
		return mundo.mostrarMapa();
	}


	public void eliminarSenal(Senal senal) {
		mundo.eliminarSenal(senal);
	}
}
