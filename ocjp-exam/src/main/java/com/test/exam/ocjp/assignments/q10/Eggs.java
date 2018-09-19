package com.test.exam.ocjp.assignments.q10;
//Given:
class Dozens {
	int[] dz = {1,2,3,4,5,6,7,8,9,10,11,12};
}
public class Eggs {
	public static void main(String[] args) {
		Dozens [] da = new Dozens[3];
		da[0] = new Dozens();
		Dozens d = new Dozens();
		da[1] = d;
		d = null;
		da[1] = null;
		// do stuff
	}
}

/*
Which two are true about the objects created within main(), and eligible for garbage collection when line 14 is reached?
A. Three objects were created
B. Four objects were created
C. Five objects were created
D. Zero objects are eligible for GC
E. One object is eligible for GC
F. Two objects are eligible for GC
G. Three objects are eligible for GC
*/




























































/*
Answer:
C and F are correct. da refers to an object of type 
"Dozens array," and each Dozens object that is created 
comes with its own "int array" object. When line 14 is reached, 
only the second Dozens object (and its "int array" object) 
are not reachable.
A, B, D, E, and G are incorrect based on the above. (Objective 7.4)
*/

/*En esta igual debemos diagramar y ver que el truco
 * es que en la clase Dozens hay un array entonces cuando
 * un objeto deja de hacer refrencia a Dozens tambien lo deja
 * para el array dz y es considerado para el recolector 
 * 
 * Tambien hay que leer bien la pregunta ya que debemos elegir
 * tanto los objetos que son elegibles para el GC y cuantos
 * objeto fueron creados.
 * */