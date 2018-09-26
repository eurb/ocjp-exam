package com.test.exam.ocjp.flow.control.q12;
//Given:
public class Wind {
	public static void main(String[] args) {
		foreach:
			for(int j=0; j<5; j++) {
				for(int k=0; k< 3; k++) {
					System.out.print(" " + j);
					if(j==3 && k==1) break foreach;
					if(j==0 || j==2) break;
				}
			}
	}
}
/*
What is the result?
A. 0 1 2 3
B. 1 1 1 3 3
C. 0 1 1 1 2 3 3
D. 1 1 1 3 3 4 4 4
E. 0 1 1 1 2 3 3 4 4 4
F. Compilation fails
*/











































































/*
Answer:
C is correct. A break breaks out of the current innermost loop 
and continues. A labeled break breaks out of and terminates the 
current loops.
A, B, D, E, and F are incorrect based on the above. 
(Objective 2.2)
*/
/*
Mi Respuesta:
	Selecciona F por falta de tiempo intente hacerlo
	pero no me dio tiempo, la respuesta fue casi aleatoria
	despues la volvi a analizar y ya me salio hay que hacer
	pruebas en el cuaderno el truco es que
	cuando se hace un break labeled este se sale no de las mas 
	interno sino de donde le indiques en que etiqueta se salga
	asi existan 5 ciclos anidados si le indicas el label 
	y este label esta hasta arriba de los 5 ciclos
	se sale de todos.
*/