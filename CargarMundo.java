package World;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import World.Exceptions.WrongMapFormatException;

public class CargarMundo {
	
	private final static char vacia = '*';
	private final static char tren = 't';
	private final static char locomotora = 'l';
	private final static char semV = 'v';
	private final static char semR = 'r';
	private final static char casI = 'i';
	private final static char casF = 'f';
	private final static char via = 'c';
	private static  final  int DIM = 60; //Dimensión del tablero
	private static char[][] tablero = new char[DIM][DIM];
	
	
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
						case tren: tablero[i][j] = tren;  break;
						case locomotora: tablero[i][j] = locomotora; break;
						case semV: tablero[i][j] = semV; break;
						case semR: tablero[i][j] = semR; break;
						case casI: tablero[i][j] = casI; break;
						case casF: tablero[i][j] = casF; break;
						case via: tablero[i][j] = via; break;
						default: throw new WrongMapFormatException(" Archivo incorrecto");
					}				
				}j++;
			}
		}catch(WrongMapFormatException e){
			System.err.print(e.getMessage());
			System.exit(1);
		}
		sc.close();
		return tablero;
	}
	/*
	//main de prueba
	public static void main(String[] args) throws FileNotFoundException{
		InputStream mapa = new FileInputStream("F:/workspace/IS/mapa(txt).txt");
		cargarMapa(mapa);
		mapa();
	}
	*/
	//Prueba
	/**
	//Necesaria siempre que se vaya a cargar el mapa de un fichero de texto
	//Comprueba los distintos errores que pueden darse en el mapa
	public void comprobarMapa()throws WrongMapFormatException{
		//Que haya un un inicio pero no un fin en la misma recta
		int i = 0;
		int j = 0;
		while(i < DIM){
			while(j < DIM){
				if(CargarMapa.tablero[i][j] == casI){
					
				}
			}
		}
		//Que haya un semáforo fuera de una vía
		//Una vía cortada por un espacio vacío
		//Vagón sin locomotora
	}
	*/
	
}
