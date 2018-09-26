package com.test.exam.ocjp.flow.control.q08;
//Given:
public class Ebb {
	static int x = 7;
	public static void main(String[] args) {
		String s = "";
		for(int y = 0; y < 3; y++) {
			x++;
			switch(x) {
			case 8: s += "8 ";
			case 9: s += "9 ";
			case 10: { s+= "10 "; break; }
			default: s += "d ";
			case 13: s+= "13 ";
			}
		}
		System.out.println(s);
	}
	static { x++; }
}
/*
What is the result?
A. 9 10 d
B. 8 9 10 d
C. 9 10 10 d
D. 9 10 10 d 13
E. 8 9 10 10 d 13
F. 8 9 10 9 10 10 d 13
G. Compilation fails
*/




































































/*
Answer:
D is correct. Did you catch the static initializer block? 
Remember that switches work on "fall-thru" logic, 
and that fall-thru logic also applies to the default case, 
which is used when no other case matches.

A, B, C, E, F, and G are incorrect based on the above. 
(Objective 2.1)
*/

/*
Mi Respuesta:
	Por poco la tenia mal, ya que al final vi el bloque static
	ese se ejecuta primero cuando se carga la clase, entonces
	ya hace un postincrement, por lo tanto cuando se compila
	ya x = 8 y ahora si empezamos a ver la logica y armar 
	los mensajes salientes. ya tuve bien hay que tener cuidado
	con el fall-thru del switch
*/