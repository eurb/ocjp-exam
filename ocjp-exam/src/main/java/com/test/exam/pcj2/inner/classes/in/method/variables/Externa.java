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
				//la siguiente instrucci�n es correcta
				System.out.println("Local a  M�todo "+s);
				//la siguiente instrucci�n no compilar�
				//porque una clase dentro de un m�todo
				//no tiene acceso a las variables locales
				//a menos que la cambiemos a final
				//y sea una constante
				//si descomentamos el final de la varianle p
				//este cpodigo si compilar�.
				System.out.println(p);
			}
		}
		
		Interna in = new Interna();
		in.muestra();
	}
}
