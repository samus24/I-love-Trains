package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import Utiles.Constantes;
import Utiles.Lector;
/**
	CorrecciÃ³n por Ignacio Rocillo
	
*/

public class Mundo {
	private Tren[] trenes;
	private Senal[] senales;
	private char[][] estadoMundo;
	//private static final  int DIM = 60; si no hay mostrarMapa ya no es necesaria
	
	public Mundo(){
		trenes = new Tren[Constantes.MAX_TRENES];
		senales = new Senal[Constantes.MAX_SENALES];
		
		cargarModelo();
	}
	
	public void cargarModelo() {
		try {
			InputStream mapa = new FileInputStream(Constantes.NOMBRE_ARCHIVO);
			Lector lector = new Lector();
			estadoMundo = lector.cargarMapa(mapa);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo");
		}
	}	
	public void recalcularEstadoTrenes(){
		for(Tren e: trenes){
			 e.avanza(senales);
		}
	}
	
	//A dia 5/5 el grupo de diseño al completo ve incorrecto este metodo porque es la vista
	//la que se encarga de mostrar cosas
	
	/*public void mostrarMapa(){
		for(int i = 0; i < DIM; i++){
			for(int j = 0; j < DIM; j++){
				if(estadoMundo[i][j] == '*')
					System.out.print(" ");
				else System.out.print(estadoMundo[i][j]);
			}
			System.out.println("");
		}
	}*/
	
	public Senal[] getSenales() {
		return senales;
	}
	
	public void setSenal(Senal senal, int i) {
		senales[i] = senal;
	}
	
	public Tren[] getTrenes() {
		return trenes;
	}
	
	public void setTren(Tren _trenes, int i) {
		trenes[i] = _trenes;
	}
	
	public char[][] getEstadoMundo() {
		return estadoMundo;
	}
	
	public void setEstadoMundo(char[][] _estadoMundo) {
		estadoMundo = _estadoMundo;
	}

	public void anadirSenal(Coordenada posicion, EstadoSenal estado) {
		// TODO Auto-generated method stub
		
	}

	public void elimnarTren(int id) {
		// TODO Auto-generated method stub
		
	}

	public void modificarTren(int id, int numVagones) {
		// TODO Auto-generated method stub
		
	}

	public void crearTren(int numVagones) {
		// TODO Auto-generated method stub
		
	}
	
}
