package Controlador;

import java.util.ArrayList;

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

	public void modificarTren(int id, int numVagones){
		mundo.modificarTren(id, numVagones);
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

	public ArrayList<Senal> getSenales(){
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

	public void eliminarSenal(int id,Coordenada c) {
		mundo.eliminarSenal(id,c);
	}

	public void modificarSenal(int id, Coordenada c) {
		// TODO Auto-generated method stub
		mundo.modificarSenal(id,c);
	}
	public boolean start(){
		char[][] tablero = getEstadoMundo();
		ArrayList<Tren> trenes= getTrenes();

		for(int j=0; j < trenes.size(); j++){
			Tren e=trenes.get(j);
			tablero[e.getCoordenadaInicio().getCoordenadaX()][e.getCoordenadaInicio().getCoordenadaY()]='l';
			Coordenada c=e.getCoordenadaInicio();

			if(tablero[c.getCoordenadaX()-1][c.getCoordenadaY()]== 'f' ||
					tablero[c.getCoordenadaX()+1][c.getCoordenadaY()]== 'f' ||
					tablero[c.getCoordenadaX()][c.getCoordenadaY()+1]== 'f' ||
					tablero[c.getCoordenadaX()][c.getCoordenadaY()-1]== 'f' ||
					tablero[c.getCoordenadaX()+1][c.getCoordenadaY()]== 'i' ||
					tablero[c.getCoordenadaX()-1][c.getCoordenadaY()]== 'i' ||
					tablero[c.getCoordenadaX()][c.getCoordenadaY()+1]== 'i' ||
					tablero[c.getCoordenadaX()][c.getCoordenadaY()-1]== 'i'){
				trenes.remove(e);
			}
			else{
				switch (e.getTrayecto()) {
				case HorizontalDerecha:
					if(tablero[c.getCoordenadaX()+1][c.getCoordenadaY()]=='r' || tablero[c.getCoordenadaX()-1][c.getCoordenadaY()]=='r'){
					}
					else{
						tablero[c.getCoordenadaX()][c.getCoordenadaY()+1]='l';
						for(int i=1; i <= e.getVagones(); i++)
							tablero[c.getCoordenadaX()][c.getCoordenadaY()-i+1]='t';
						//marcamos la ultima casilla como que hemos pasado por ella
						tablero[c.getCoordenadaX()][c.getCoordenadaY()-e.getVagones()]='c';
						//actualizamos en el arraylist
						e.getCoordenadaInicio().setX(c.getCoordenadaX());
						e.getCoordenadaInicio().setY(c.getCoordenadaY()+1);
					}
					break;
				case HorizontalIzquierda:
					if(tablero[c.getCoordenadaX()-1][c.getCoordenadaY()]=='r' || tablero[c.getCoordenadaX()+1][c.getCoordenadaY()]=='r'){
					}
					else{
						tablero[c.getCoordenadaX()][c.getCoordenadaY()-1]='l';
						for(int i=1; i <= e.getVagones(); i++)
							tablero[c.getCoordenadaX()][c.getCoordenadaY()-i-1]='t';
						//marcamos la ultima casilla como que hemos pasado por ella
						tablero[c.getCoordenadaX()][c.getCoordenadaY()-e.getVagones()]='c';
						//actualizamos en el arraylist
						e.getCoordenadaInicio().setX(c.getCoordenadaX());
						e.getCoordenadaInicio().setY(c.getCoordenadaY()-1);
					}
					break;
				case VerticalAbajo:
					if(tablero[c.getCoordenadaX()][c.getCoordenadaY()+1]=='r' || tablero[c.getCoordenadaX()][c.getCoordenadaY()-1]=='r'){
					}
					else{
						tablero[c.getCoordenadaX()+1][c.getCoordenadaY()]='l';
						for(int i=1; i <= e.getVagones(); i++)
							tablero[c.getCoordenadaX()-i+1][c.getCoordenadaY()]='t';
						//marcamos la ultima casilla como que hemos pasado por ella
						tablero[c.getCoordenadaX()-e.getVagones()][c.getCoordenadaY()]='c';
						//actualizamos en el arraylist
						e.getCoordenadaInicio().setX(c.getCoordenadaX()+1);
						e.getCoordenadaInicio().setY(c.getCoordenadaY());
					}
					break;

				case VerticalArriba:
					if(tablero[c.getCoordenadaX()][c.getCoordenadaY()-1]=='r' || tablero[c.getCoordenadaX()][c.getCoordenadaY()+1]=='r'){
					}
					else{
						tablero[c.getCoordenadaX()-1][c.getCoordenadaY()]='l';
						for(int i=1; i <= e.getVagones(); i++)
							tablero[c.getCoordenadaX()-i-1][c.getCoordenadaY()]='t';
						//marcamos la ultima casilla como que hemos pasado por ella
						tablero[c.getCoordenadaX()-e.getVagones()][c.getCoordenadaY()]='c';	
						//actualizamos en el arraylist
						e.getCoordenadaInicio().setX(c.getCoordenadaX());
						e.getCoordenadaInicio().setY(c.getCoordenadaY()-1);
					}
					break;
				}
			}
		}
		return trenes.isEmpty();
	}
}
