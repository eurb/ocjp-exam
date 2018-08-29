/**
 * 
 */
package com.test.exam.pcj2.inner.classes.in.method.variables;

/**
 * @author eroman
 *
 */
public class Externa {
	
	String s ="Mio";
	
	void proceso () {
		/*final*/ int p=6;
		class Interna {
			void muestra() {
				//la siguiente instrucción es correcta
				System.out.println("Local a  Método "+s);
				//la siguiente instrucción no compilará
				//porque una clase dentro de un método
				//no tiene acceso a las variables locales
				//a menos que la cambiemos a final
				//y sea una constante
				//si descomentamos el final de la varianle p
				//este cpodigo si compilará.
				System.out.println(p);
			}
		}
		
		Interna in = new Interna();
		in.muestra();
	}
}
