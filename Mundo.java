package World;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


import Entidad.Senal;
import Entidad.Tren;

public class Mundo {
	private Tren[] trenes;
	private Senal[] senales;
	private char[][] estadoMundo;
	private static final  int DIM = 60;
	public void main(String[] args) {
		try {
			InputStream mapa = new FileInputStream("mapa(txt).txt");
			CargarMundo cargarMundo = new CargarMundo();
			estadoMundo = cargarMundo.cargarMapa(mapa);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(true){
			recalcularEstadoTrenes();
		}
		
		
	}
	
	public void recalcularEstadoTrenes(){
		for(Tren e: trenes){
			 e.avanza(senales);
		}
	}
	public void mostrarMapa(){
		for(int i = 0; i < DIM; i++){
			for(int j = 0; j < DIM; j++){
				if(estadoMundo[i][j] == '*')
					System.out.print(" ");
				else System.out.print(estadoMundo[i][j]);
			}
			System.out.println("");
		}
	}
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
	
	
}
