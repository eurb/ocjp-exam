package com.test.exam.ocjp.flow.control.q06;
//Given
public class Emu {
	static String s = "-";
	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception e) {
			try {
				try { throw new Exception();
				} catch (Exception ex) { s += "ic "; }
				throw new Exception(); }
			catch (Exception x) { s += "mc "; }
			finally { s += "mf "; }
		} finally { s += "of "; }
		System.out.println(s);
} }
/*
What is the result?
A. -ic of
B. -mf of
C. -mc mf
D. -ic mf of
E. -ic mc mf of
F. -ic mc of mf
G. Compilation fails
*/

































































/*
Answer:
E is correct. There is no problem nesting try / catch blocks. 
As is normal, when an exception is thrown, the code in the catch 
block runs, then the code in the finally block runs.
A, B, C, D, and F are incorrect based on the above. 
(Objective 2.5)
*/
/*
Mi Respuesta
	La tube bien pero me confundio la identación del ejercicio
	hay que tener cuidado en eso ya que si me llevo tiempo
	descifrando donde terminaba un catch o un try
*/