package Trenes;


/*
 Modificación Calidad: Corregida la colocación de las llaves de apertura
 para que se adapte al estándar. 
 -Christian-
 */
/*
 Modificación Calidad: 
 	CORREGIDO CONCEPTO ERRÓNEO DE CONSTRUCTOR.
 		(en serio alguien confunde un setter con un constructor??)
 	Corregido el espaciado de métodos, llaves y operadores.
 	Correcciones para seguir el estandar:
 		Corregido nombre de paquete en minúscula.
 		Corregido nombres de métodos (actualizarInterfaz, actualizarMapa).
 -Héctor-
 */



/**
 * Esta clase controla la transferencia de datos entre la interfaz de usuario el mapa y el modelo
 * @version 1.0
*/
public class Controlador {
	private static Controlador controlador;
	
	/**
	 * Metodo que crea un controlador estatico         
	 * @return controlador           
	 */
	public Controlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
	}
	
	//Metodos para la creacion y gestion de la ventana principal
	/**
	 * Metodo que crea la ventana principal de la aplicacion
	 */
	void crearVentanaPrincipal() {
		
	}
	
	//Metodos para la actualizacion de la interfaz y el mapa
	/**
	 * Metodo que actualiza el mapa grafico
	 */
	private void actualizarMapa() {
		
	}
	
	/**
	 * Metodo que actualiza la interfaz de usuario
	 */
	private void actualizarInterfaz() {
		
	}
	
	//Metodos diversos para la gestion del trafico de datos entre el modulo y la interfaz
	/**
	 * metodo que llama a crear tren con los datos pasados por la interfaz
	 * @param
	 */
	private void crearTren() {
		
	}
	
	/**
	 * metodo que llama a modificar tren con los datos pasados por la interfaz
	 * @param
	 */
	private void modificarTren() {
		
	}
	
	/**
	 * metodo que llama a eliminar tren con los datos pasados por la interfaz
	 * @param
	 */
	private void eliminarTren() {
		
	}
	
}
