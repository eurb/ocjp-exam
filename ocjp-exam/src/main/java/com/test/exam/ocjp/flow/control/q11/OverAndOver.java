package com.test.exam.ocjp.flow.control.q11;
//Given
public class OverAndOver {
	static String s = "";
	public static void main(String[] args) {
		try {
			s += "1";
			throw new Exception();
		} catch (Exception e) { s += "2";
		} finally { s += "3"; doStuff(); s += "4";
		}
		System.out.println(s);
	}
	static void doStuff() { int x = 0; int y = 7/x; }
}

/*
What is the result?
A. 12
B. 13
C. 123
D. 1234
E. Compilation fails
F. 123 followed by an exception
G. 1234 followed by an exception
H. An exception is thrown with no other output
*/







































































/*
Answer:
H is correct. It's true that the value of String s is 123 at the
time that the divide-by-zero exception is thrown, but 
finally() is not guaranteed to complete, and in this case 
finally() never completes, so the System.out.println (S.O.P.) 
never executes.
A, B, C, D, E, F, and G are incorrect based on the above. 
(Objective 2.5)
*/
/*
Mi Respuesta:
	F y la tuve mal
	Pense que println todavía sería ejecutado pero no es mas
	ni siquiera el finally se ejecuta, cuando es un error de
	RunTime todo se va al carajo a menos  que antes de que
	sucede en division por cero se hicera un println entonces
	este si seria mostrado pero no despues de que truena
*/