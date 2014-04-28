package World;

import java.io.InputStream;
import java.util.Scanner;

import Entidad.Coordenada;
import Entidad.EstadoSenal;
import Entidad.Senal;
import Entidad.Trayecto;
import Entidad.Tren;
import World.Exceptions.WrongMapFormatException;

public class CargarMundo {
	
	private final static char vacia = '*';
	private final static char vagon = 't';
	private final static char locomotora = 'l';
	private final static char semV = 'v';
	private final static char semR = 'r';
	private final static char casI = 'i';
	private final static char casF = 'f';
	private final static char via = 'c';
	private static  final  int DIM = 60; //Dimensi�n del tablero
	private static char[][] tablero = new char[DIM][DIM];
	private Mundo mundo;
	private Senal[] _senales;
	private Tren[] _trenes ;
	
	
	/**
	 * Recibe un archivo abierto <mapa>
	 */
	public char[][] cargarMapa(InputStream mapa){
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
						case locomotora: tablero[i][j] = locomotora; locomotora(i, j); break;
						case semV: tablero[i][j] = semV;semV(i,j); break;
						case semR: tablero[i][j] = semR;semR(i,j); break;
						case casI: tablero[i][j] = casI; break;
						case casF: tablero[i][j] = casF; break;
						case via: tablero[i][j] = via; break;
						default: throw new WrongMapFormatException(" Archivo incorrecto");
					}				
				}
				j++;
			}
		}catch(WrongMapFormatException e){
			System.err.print(e.getMessage());
			System.exit(1);
		}
		agregarTrayecto();
		sc.close();
		return tablero;
	}
	
	private void locomotora(int i , int j) {
		int k = _trenes.length + 1;
		Coordenada c = new Coordenada(i, j);
		mundo.setTren(_trenes[k] = new Tren(c), k);
	}
	
	private void semV(int i, int j) {
		int k = _senales.length + 1;
		Coordenada c = new Coordenada(i, j);
		mundo.setSenal(_senales[k] = new Senal(c, EstadoSenal.VERDE), k);
		
	}
	
	private void semR(int i, int j) {
		int k = _senales.length + 1;
		Coordenada c = new Coordenada(i, j);
		mundo.setSenal(_senales[k] = new Senal(c, EstadoSenal.ROJO), k);
		
	}
	private void agregarTrayecto(){
		for(Tren e : _trenes ){
			int row = e.getCoordenadaInicio().getCordenadaY();
			int colum = e.getCoordenadaInicio().getCordenadaX();
			boolean hayVia = true;
			boolean encFinal = false;
			while(hayVia && colum < DIM && !encFinal){
				colum++;
				if(tablero[colum][row] != via){
					hayVia = false;
				}if(tablero[colum][row] == casF){
					encFinal = true;
					e.setTrayecto(Trayecto.HorizontalDer);
				}	
			}
			colum = e.getCoordenadaInicio().getCordenadaX();
			while(hayVia && colum > 0 && !encFinal){
				colum--;
				if(tablero[colum][row] != via){
					hayVia = false;
				}if(tablero[colum][row] == casF){
					encFinal = true;
					e.setTrayecto(Trayecto.HorizontalIzq);
				}	
			}
			colum = e.getCoordenadaInicio().getCordenadaX();
			while(hayVia && row > 0 && !encFinal){
				row--;
				if(tablero[colum][row] != via){
					hayVia = false;
				}if(tablero[colum][row] == casF){
					encFinal = true;
					e.setTrayecto(Trayecto.VerticalArr);
				}	
			}
			colum = e.getCoordenadaInicio().getCordenadaX();
			row = e.getCoordenadaInicio().getCordenadaY();
			while(hayVia && row < DIM && !encFinal){
				row++;
				if(tablero[colum][row] != via){
					hayVia = false;
				}if(tablero[colum][row] == casF){
					encFinal = true;
					e.setTrayecto(Trayecto.VerticalAba);
				}	
			}
		}	
		
	}
	
}
