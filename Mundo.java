package World;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import Command.Command;
import Entidad.Entidad;

public class Mundo {
	private Entidad[] entidades;
	private char[][] estadoMundo;
	private Command comandos;
	private static  final  int DIM = 60;
	public void main(String[] args) {
		try {
			InputStream mapa = new FileInputStream("mapa(txt).txt");
			CargarMundo cargarMundo = new CargarMundo();
			estadoMundo = cargarMundo.cargarMapa(mapa);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(true){
			ConsultarIntenciones();
			interaciones();
			mostrarMapa();
		}
		
		
	}
	public void ConsultarIntenciones(){
		/*Recopilar el comando ejecutado*/
	}
	public void interaciones(){
		/*recopilar interaciones de las entidades*/
	}
	public void recalcularEstado(){
		for(Entidad e: entidades){
			 e.update();
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
	public Entidad[] getEntidades() {
		return entidades;
	}
	public void setEntidades(Entidad[] _entidades) {
		entidades = _entidades;
	}
	public char[][] getEstadoMundo() {
		return estadoMundo;
	}
	public void setEstadoMundo(char[][] _estadoMundo) {
		estadoMundo = _estadoMundo;
	}
	
	
}
