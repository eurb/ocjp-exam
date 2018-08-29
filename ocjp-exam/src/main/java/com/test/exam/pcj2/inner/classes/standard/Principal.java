package com.test.exam.pcj2.inner.classes.standard;

/**
 * La siguiente clase crea un objeto de la clase interna e invoca
 * al método muestra de dicha clase
 * @author eroman
 *
 */
public class Principal {

	public static void main(String[] args) {
		Externa ex = new Externa();
		//Aprenernos esta sintaxis de new
		Externa.Interna in = ex.new Interna();
		in.muestra();
		

	}

}
