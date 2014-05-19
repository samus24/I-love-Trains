package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JTextArea;

import Utiles.Constantes;
import Utiles.Lector;
/**
	CorrecciÃ³n por Ignacio Rocillo
	
*/

public class Mundo {
	private ArrayList<Senal> senales;
	private ArrayList<Tren> trenes ;
	private char[][] estadoMundo;
	private static final  int DIM = 60; 
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
		// TODO Auto-generated method stub
		this.senales.add(new Senal(posicion, estado));
	}
	public void eliminarSenal(Senal del){
		this.senales.remove(del);
	}
	public void eliminarTren(int id) {
		// TODO Auto-generated method stub
		
	}

	public void modificarTren(int id, int numVagones) {
		// TODO Auto-generated method stub
		
	}

	public void crearTren(int numVagones) {
		// TODO Auto-generated method stub
		
	}

	public JTextArea mostrarMapa() {
		// TODO Auto-generated method stub
	    /* * */JTextArea texto = new JTextArea();
        /* * */StringBuilder contenido = new StringBuilder();
        for(int i = 0; i < DIM; i++){
            for(int j = 0; j < DIM; j++){
                if(estadoMundo[j][i] == '*')//Columnas extrapoladas, se han corregido (antes era [i][j]
                    //System.out.print(" ");
                    /* * */contenido.append(" ");    
                else
                    //System.out.print(estadoMundo[i][j]);
                    /* * */contenido.append(estadoMundo[j][i]);                
            }
            //System.out.println("");
            /* * */contenido.append('\n');
        }
        /* * */texto.setText(contenido.toString());
        /* * */return texto;
	}

	public void setTren(boolean add) {
		// TODO Auto-generated method stub
		
	}
	
}
