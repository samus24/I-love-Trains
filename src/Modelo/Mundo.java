package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import Utiles.Constantes;
import Utiles.Lector;

public class Mundo {
	private ArrayList<Senal> senales;
	private ArrayList<Tren> trenes;
	private char[][] estadoMundo;
	public Mundo(){
		trenes = new ArrayList<Tren>();
		senales =  new ArrayList<Senal>();
		
		cargarModelo();
	}
	
	public void cargarModelo() {
		try {
			InputStream mapa = new FileInputStream(Constantes.NOMBRE_ARCHIVO);
			Lector lector = new Lector();
			estadoMundo = lector.cargarMapa(mapa,this);
		} catch (FileNotFoundException e) {
		}
	}	
	public void recalcularEstadoTrenes(){
		for(Tren e: trenes){
			 e.avanza(senales);
		}
	}

	public ArrayList<Senal> getSenales() {
		return senales;
	}
	
	public void setSenal(Senal senal) {
		senales.add(senal);
	}
	
	public ArrayList<Tren> getTrenes() {
		return trenes;
	}
	
	public void setTren(Tren tren) {
		trenes.add(tren);

	}
	
	public char[][] getEstadoMundo() {
		return estadoMundo;
	}
	
	public void setEstadoMundo(char[][] _estadoMundo) {
		estadoMundo = _estadoMundo;
	}

	public void anadirSenal(Coordenada posicion, EstadoSenal estado) {
		this.senales.add(new Senal(posicion, estado));
		estadoMundo[posicion.getCoordenadaX()][posicion.getCoordenadaY()]='r';
	}
	public void eliminarSenal(int id,Coordenada c){
		this.senales.remove(this.senales.get(id));
		estadoMundo[c.getCoordenadaX()][c.getCoordenadaY()]='*';
	}
	public void eliminarTren(int id) {
		Tren e=this.trenes.get(id);

		estadoMundo[e.getCoordenadaInicio().getCoordenadaX()][e.getCoordenadaInicio().getCoordenadaY()]='c';
		switch (e.getTrayecto()) {
		case HorizontalDerecha:
				for(int i=1; i <= e.getVagones(); i++)
					estadoMundo[e.getCoordenadaInicio().getCoordenadaX()][e.getCoordenadaInicio().getCoordenadaY()-i]='c';
			break;
		case HorizontalIzquierda:
				for(int i=1; i <= e.getVagones(); i++)
					estadoMundo[e.getCoordenadaInicio().getCoordenadaX()][e.getCoordenadaInicio().getCoordenadaY()+i]='c';
			break;
		case VerticalAbajo:
				for(int i=1; i <= e.getVagones(); i++)
					estadoMundo[e.getCoordenadaInicio().getCoordenadaX()-i][e.getCoordenadaInicio().getCoordenadaY()]='c';
			break;
		case VerticalArriba:
				for(int i=1; i <= e.getVagones(); i++)
					estadoMundo[e.getCoordenadaInicio().getCoordenadaX()+i][e.getCoordenadaInicio().getCoordenadaY()]='c';				
			break;
		}
		this.trenes.remove(e);
	}

	public void modificarTren(int id, int numVagones) {
		Tren e=this.trenes.get(id);
		e.setVagones(numVagones);
		estadoMundo[e.getCoordenadaInicio().getCoordenadaX()][e.getCoordenadaInicio().getCoordenadaY()]='l';
		Coordenada c=e.getCoordenadaInicio();
		switch (e.getTrayecto()) {
		case HorizontalDerecha:
				for(int i=1; i <= numVagones; i++)
					estadoMundo[c.getCoordenadaX()][c.getCoordenadaY()-i]='t';
			break;
		case HorizontalIzquierda:
				for(int i=1; i <= numVagones; i++)
					estadoMundo[c.getCoordenadaX()][c.getCoordenadaY()+i]='t';
			break;
		case VerticalAbajo:
				for(int i=1; i <= numVagones; i++)
					estadoMundo[c.getCoordenadaX()-i][c.getCoordenadaY()]='t';
			break;
		case VerticalArriba:
				for(int i=1; i <= numVagones; i++)
					estadoMundo[c.getCoordenadaX()+i][c.getCoordenadaY()]='t';				
			break;
		}
		
		
	}

	public void anadirTren(int numVagones,Coordenada c,Trayecto trayecto) {
		this.trenes.add(new Tren(c,trayecto,numVagones));
		estadoMundo[c.getCoordenadaX()][c.getCoordenadaY()]='l';
			switch (trayecto) {
			case HorizontalDerecha:
					for(int i=1; i <= numVagones; i++)
						estadoMundo[c.getCoordenadaX()][c.getCoordenadaY()-i]='t';
				break;
			case HorizontalIzquierda:
					for(int i=1; i <= numVagones; i++)
						estadoMundo[c.getCoordenadaX()][c.getCoordenadaY()+i]='t';
				break;
			case VerticalAbajo:
					for(int i=1; i <= numVagones; i++)
						estadoMundo[c.getCoordenadaX()-i][c.getCoordenadaY()]='t';
				break;
			case VerticalArriba:
					for(int i=1; i <= numVagones; i++)
						estadoMundo[c.getCoordenadaX()+i][c.getCoordenadaY()]='t';				
				break;
			}
	}
	public void modificarSenal(int id, Coordenada c) {
		this.senales.get(id).setEstado();
		if(this.senales.get(id).getEstado() == EstadoSenal.ROJO)
			estadoMundo[c.getCoordenadaX()][c.getCoordenadaY()]='r';
		else
			estadoMundo[c.getCoordenadaX()][c.getCoordenadaY()]='v';
	}
}
