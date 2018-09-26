package com.test.exam.ocjp.flow.control.q14;
//Given:
public class Clumsy {
	public static void main(String[] args) {
		int j = 7;
		assert(++j > 7);
		assert(++j > 8): "hi";
		assert(j > 10): j=12;
		assert(j==12): doStuff();
		assert(j==12): new Clumsy();
	}
	static void doStuff() { }
}
/*
Which are true? (Choose all that apply
.)
A. Compilation succeeds
B. Compilation fails due to an error on line 6
C. Compilation fails due to an error on line 7
D. Compilation fails due to an error on line 8
E. Compilation fails due to an error on line 9
F. Compilation fails due to an error on line 10
*/









































































/*
Answer:
E is correct. When an assert statement has two expressions, 
the second expression must return a value. 
The only two-expression assert statement that doesn’t return 
a value is on line 9.
A, B, C, D, and F are incorrect based on the above. (Objective 2.3)
*/

/*
Mi Respuesta:
	Selecciona la D pense que habia un error
	en la linea 8 donde hace assert(j > 10): j=12; pero no
	eso esta bien ya que siempre para el segundo argumento
	del assert debe ser una expresion y esa solo asigna
	el valor 12 a j y luego lo convierte a String.
	
	La E era correcta error en la linea 9 ya que invoca
	un método que no regresa un valor ya que es de tipo 
	void.
*/