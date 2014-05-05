package Modelo;

import java.util.ArrayList;

public class Tren{
	private Trayecto trayecto;
	private Coordenada coordenadaInicio;
	private Coordenada coordenadaActual;
	private int numVagones;
	private ArrayList <Vagon> listaVagones;
	
	public Tren(Coordenada coordenada){
		coordenadaInicio = coordenada;
		this.numVagones = 0; //Locomotora
		listaVagones = new ArrayList<Vagon>();
	}
	
	public Tren(Coordenada coordenada, Trayecto trayecto, Vagon[] vagon){
		this.coordenadaInicio = coordenada;
		this.trayecto = trayecto;
		this.listaVagones = new ArrayList<Vagon>();
		numVagones = 0;
		for(Vagon v: vagon){ //Por cada vagon de <vagon> se añade a la lista de vagones			
			this.listaVagones.add(v);
			numVagones++;
		}
	}
	
	public int  getVagones(){		
		return numVagones;
	}
	public String getTrayecto(){
		return trayecto.toString();
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
	
	/**
	 * Cambia la lista de vagones por la que se pasa por parámetro.
	 * Puede cambiar el trayecto, siempre que no implique un salto de via(espacio en blanco) , 
	 * por lo que se deberia de ultilizar una funcion auxilidar que comprobara si se puede hacer
	 * @param trayecto
	 * @param vagon Lista de vagones que a insertar
	 */
	public void modificarTren(Vagon[] nuevalistaVagones, Trayecto trayecto){
		this.trayecto = trayecto;
		
		listaVagones.clear();
		if(nuevalistaVagones != null)
		for(Vagon v: nuevalistaVagones) //Por cada vagon de <vagon> se añade a la lista de vagones			
			this.listaVagones.add(v);
	}
	
	/**
	 * Elimina los vagones y la locomotora por defecto.
	 */
	public void eliminarTren(){
		listaVagones.clear();
		coordenadaInicio = null;		
	}

	public void avanza(Senal[] s) {
		int i = 0;
		boolean enc = false;
		while(i != s.length && !enc){
			if(s[i].getCoordenada() == coordenadaActual){
				enc = true;
			}
			i++;
		}
		if(!enc){
			switch(trayecto){
			case HorizontalDer: coordenadaActual.setX(coordenadaActual.getCoordenadaX() + 1);break;
			case HorizontalIzq: coordenadaActual.setX(coordenadaActual.getCoordenadaX() - 1);break;
			case VerticalArr:coordenadaActual.setY(coordenadaActual.getCoordenadaY() + 1);break;
			case VerticalAba:coordenadaActual.setY(coordenadaActual.getCoordenadaY() - 1);
			}
		}
		
	}
}