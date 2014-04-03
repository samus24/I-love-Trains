package trenes;


/*
 Modificación Calidad: Corregida la colocación de las llaves de apertura
 para que se adapte al estándar. 
 -Christian-
 */




/**
 * Esta clase controla la transferencia de datos entre la interfaz de usuario el mapa y el modelo
 * @version 1.0
*/
public class Controlador {
	private static Controlador elControlador;
	/**
	 * Metodo que crea un controlador estatico         
	 * @return elControlador           
	 */
	public static Controlador setELControlador(){
		if (elControlador==null){
			elControlador=new Controlador();
		}
		return elControlador;
	}
	//Metodos para la creacion y gestion de la ventana principal
	/**
	 * Metodo que crea la ventana principal de la aplicacion
	 */
	void crearVentanaPrincipal(){
		
	}
	//Metodos para la actualizacion de la interfaz y el mapa
	/**
	 * Metodo que actualiza el mapa grafico
	 */
	private void actualizaMapa(){
		
	}
	/**
	 * Metodo que actualiza la interfaz de usuario
	 */
	private void actualizaInterfaz(){
		
	}
	//Metodos diversos para la gestion del trafico de datos entre el modulo y la interfaz
	/**
	 * metodo que llama a crear tren con los datos pasados por la interfaz
	 * @param
	 */
	private void crearTren(){
		
	}
	/**
	 * metodo que llama a modificar tren con los datos pasados por la interfaz
	 * @param
	 */
	private void modificarTren(){
		
	}
	/**
	 * metodo que llama a eliminar tren con los datos pasados por la interfaz
	 * @param
	 */
	private void eliminarTren(){
		
	}
	
}
