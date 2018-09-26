package com.test.exam.ocjp.flow.control.q10;
//Given
public class Circles {
	public static void main(String[] args) {
		int[] ia = {1,3,5,7,9};
		for(int x : ia) {
			for(int j = 0; j < 3; j++) {
				if(x > 4 && x < 8) continue;
				System.out.print(" " + x);
				if(j == 1) break;
				continue;
			}
			continue;
		}
	}
}

/*
What is the result?
A. 1 3 9
B. 5 5 7 7
C. 1 3 3 9 9
D. 1 1 3 3 9 9
E. 1 1 1 3 3 3 9 9 9
F. Compilation fails
*/








































































/*
Answer:
D is correct. The basic rule for unlabeled continue statements 
is that the current iteration stops early and execution jumps 
to the next iteration. The last two continue statements 
are redundant!
A, B, C, E, and F are incorrect based on the above. 
(Objective 2.2)
*/

/*
Mi Respuesta:
	La tuve bien, solo hay que recordar que cuano son sin eqtiueta
	las intrucciones break y continue afectan al cliclo que 
	las esta usando si es break rompe el ciclo mas interno
	y se sale del clclo actual pero no de los otros cilcos
	si los hubiera, continue es parecido pero este no se sale
	sino que incrementa el contador y evalua de nuevo la exprecion.
	
	Otro truco es que si se usa continue en un for mejorado
	este continua con el siguiente elemento del array o lista
*/