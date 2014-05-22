package Utiles;

import java.io.InputStream;
import java.util.Scanner;

import Modelo.Coordenada;
import Modelo.EstadoSenal;
import Modelo.Mundo;
import Modelo.Senal;
import Modelo.Trayecto;
import Modelo.Tren;

public class Lector {
	
	private final static char vacia = '*';
	private final static char vagon = 't';
	private final static char locomotora = 'l';
	private final static char semV = 'v';
	private final static char semR = 'r';
	private final static char casI = 'i';
	private final static char casF = 'f';
	private final static char via = 'c';
	private static char[][] tablero = new char[Constantes.DIMENSION_MAPA_X][Constantes.DIMENSION_MAPA_Y];
	
	/**
	 * Recibe un archivo abierto <mapa>
	 */
	public char[][] cargarMapa(InputStream mapa,Mundo mundo){
		Scanner sc = new Scanner(mapa);
		String fila;
		char[] array;
		int j = 0;
		try{
			while(sc.hasNext()){
				fila = sc.next();
				array = fila.toCharArray();
				for(int i = 0; i < array.length; i++){
					switch (array[i]){
						case vacia: tablero[i][j] = vacia; break;
						case vagon: tablero[i][j] = vagon; break;
						case locomotora: tablero[i][j] = locomotora; locomotora(i, j,mundo); break;
						case semV: tablero[i][j] = semV;semV(i,j,mundo); break;
						case semR: tablero[i][j] = semR;semR(i,j,mundo); break;
						case casI: tablero[i][j] = casI; break;
						case casF: tablero[i][j] = casF; break;
						case via: tablero[i][j] = via; break;
						default: throw new WrongMapFormatException(" Archivo incorrecto");
					}				
				}
				j++;
			}
		} catch (WrongMapFormatException e) {
			System.err.print(e.getMessage());
			System.exit(1);
		}
		
		agregarTrayecto(mundo);
		sc.close();
		return tablero;
	}
	
	private void locomotora(int i , int j, Mundo mundo) {
		Coordenada c = new Coordenada(i, j);
		mundo.setTren(new Tren(c));
	}
	
	private void semV(int i, int j, Mundo mundo) {
		Coordenada c = new Coordenada(i, j);
		mundo.setSenal(new Senal(c, EstadoSenal.VERDE));
	}
	
	private void semR(int i, int j, Mundo mundo) {
		Coordenada c = new Coordenada(i, j);
		mundo.setSenal(new Senal(c, EstadoSenal.ROJO));
		
	}
	private void agregarTrayecto(Mundo mundo) {
		Tren e;
		for(int i=0; i<mundo.getTrenes().size();i++){
			e =  mundo.getTrenes().get(i);
			int row = e.getCoordenadaInicio().getCoordenadaY();
			int colum = e.getCoordenadaInicio().getCoordenadaX();
			boolean hayVia = true;
			boolean encFinal = false;
			
			while(hayVia && colum < Constantes.DIMENSION_MAPA_X && !encFinal){
				colum++;
				if(tablero[colum][row] != via){
					hayVia = false;
				}if(tablero[colum][row] == casF){
					encFinal = true;
					e.setTrayecto(Trayecto.HorizontalDerecha);
				}	
			}
			
			colum = e.getCoordenadaInicio().getCoordenadaX();
			while(hayVia && colum > 0 && !encFinal){
				colum--;
				if(tablero[colum][row] != via){
					hayVia = false;
				}if(tablero[colum][row] == casF){
					encFinal = true;
					e.setTrayecto(Trayecto.HorizontalIzquierda);
				}	
			}
			
			colum = e.getCoordenadaInicio().getCoordenadaX();
			while(hayVia && row > 0 && !encFinal){
				row--;
				if(tablero[colum][row] != via){
					hayVia = false;
				}if(tablero[colum][row] == casF){
					encFinal = true;
					e.setTrayecto(Trayecto.VerticalArriba);
				}	
			}
			
			colum = e.getCoordenadaInicio().getCoordenadaX();
			row = e.getCoordenadaInicio().getCoordenadaY();
			while(hayVia && row < Constantes.DIMENSION_MAPA_X && !encFinal){
				row++;
				if(tablero[colum][row] != via){
					hayVia = false;
				}if(tablero[colum][row] == casF){
					encFinal = true;
					e.setTrayecto(Trayecto.VerticalAbajo);
				}	
			}
		}	
		mundo.getTrenes().get(0).setTrayecto(Trayecto.HorizontalDerecha);
		mundo.getTrenes().get(0).setVagones(4);
		mundo.getTrenes().get(1).setTrayecto(Trayecto.VerticalAbajo);
		mundo.getTrenes().get(1).setVagones(6);
	}
	
}
