package procesos;

import java.util.ArrayList;
//Fran Vabe && David Valdivia

public class Tren {
	private Object trayecto;
	private Object locomotora; 
	private int numVagones;
	private ArrayList <Vagon> listaVagones;
	
	public Tren(Object tracy){
		
		this.numVagones = 1; //Locomotora
	}
	public Tren(Object locomotora, Object trayecto, Vagon vagon){
		this.locomotora = locomotora;
		this.trayecto = trayecto;
		this.vagones = vagon;
	}
	
	public Tren crearTren(Object locomotora, Object trayecto, Vagon vagon){
		Tren tren = null;
		
		if(aplicacionAbierta() && mapaExistente() && trayectoDisponible()){
			tren = new Tren(locomotora, trayecto, vagon);
		}
		
		return tren;		
	}

	public void modificarTren(Object locomotora, Object trayecto, Vagon vagon){
		
		this.locomotora = locomotora;
		this.trayecto = trayecto;
		this.vagones = vagon;
	}
	public void eliminarTren(){
		//En el mapa 
	}
	
	
	
	
	
	private boolean trayectoDisponible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean mapaExistente() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean aplicacionAbierta() {
		// TODO Auto-generated method stub
		return false;
	}
}