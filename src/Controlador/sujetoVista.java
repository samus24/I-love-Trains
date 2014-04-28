<<<<<<< HEAD:src/Controlador/sujetoVista.java
package controlador;

import modelo.*;

public class sujetoVista 
{
	// Atributos
    Tren misTrenes[];
    Senal misSe�ales[];
=======
package def;
/*
Código revisado por Christian Álvarez
Se han colocado las llaves, renombrar atributos correctamente
*/


public class suejtoVista {
	// Atributos
    Tren misTrenes[];
    Signal misSeñales[];
>>>>>>> 2223528be8e7f01a5c867bac4408eb29b327ce06:src/Controlador/suejtoVista.java
	//observadores misObservadores[]; mejor usar ArrayList
    ArrayList<Observador> misObservadores;
    // SOLO DEL MUNDO

    // Métodos
    void anadir(Observer miObservador){// Añadir un observador a cierto sujeto
    	misObservadores.add(miObservador);
    }
    void quitar(Observer miObservador){ // Obvio, joder
    	misObservadores.remove(miObservador);
    }
    void notificar(){ // Recibir un update
    	// Supongo que notificar a los observadores
    	for (Observador o : misObservadores) o.notificar();
    }
    void actualizar(){ // Actualizar la información de un sujeto (método de un observador)
	for (Observador o : misObservadores) o.actualizar();
    }
    void getEstado(){ // Toma un estado de una entidad
    	// ¿qué entidad?
    }
    void setEstado(){ // Modifica el estado de una entidad
    	// ¿qué entidad?
    }
}
