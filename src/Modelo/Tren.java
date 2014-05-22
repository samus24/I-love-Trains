package Modelo;

import java.util.ArrayList;

public class Tren{
	private Trayecto trayecto;
	private Coordenada coordenadaInicio;
	private Coordenada coordenadaActual;
	private int numVagones;
	
	public Tren(Coordenada coordenada){
		coordenadaInicio = coordenada;
		this.numVagones = 0; //Locomotora
	}
	
	public Tren(Coordenada coordenada, Trayecto trayecto){
		this.coordenadaInicio = coordenada;
		this.trayecto = trayecto;
		this.numVagones = 0;
	}
	
	public Tren(Coordenada coordenada, Trayecto trayecto,int numVagones){
		this.coordenadaInicio = coordenada;
		this.trayecto = trayecto;
		this.numVagones = numVagones;
	}
	
	public int  getVagones(){		
		return numVagones;
	}
	public Trayecto getTrayecto(){
		return trayecto;
	}
	public Coordenada getCoordenadaInicio(){
		return coordenadaInicio;
	}
	public Coordenada getCoordenadaActual(){
		return coordenadaActual;
	}
	public void setTrayecto(Trayecto t){
		trayecto = t;
	}

	public void avanza(ArrayList<Senal> s) {
		int i = 0;
		boolean enc = false;
		while(i != s.size()&& !enc){
			if(s.get(i).getCoordenada() == coordenadaActual){
				enc = true;
			}
			i++;
		}
		if(!enc){
			switch(trayecto){
			case HorizontalDerecha: coordenadaActual.setX(coordenadaActual.getCoordenadaX() + 1);break;
			case HorizontalIzquierda: coordenadaActual.setX(coordenadaActual.getCoordenadaX() - 1);break;
			case VerticalArriba:coordenadaActual.setY(coordenadaActual.getCoordenadaY() + 1);break;
			case VerticalAbajo:coordenadaActual.setY(coordenadaActual.getCoordenadaY() - 1);
			}
		}
		
	}

	public void setVagones(int numVagones) {
		// TODO Auto-generated method stub
		this.numVagones=numVagones;
	}
}