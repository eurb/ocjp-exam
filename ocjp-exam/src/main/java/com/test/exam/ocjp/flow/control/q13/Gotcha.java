package com.test.exam.ocjp.flow.control.q13;
//Given:
public class Gotcha {
	public static void main(String[] args) {
		// insert code here

	}
	void go() {
		go();
	}
}
/*
And given the following three co
de fragments:

I. new Gotcha().go();

II. try { new Gotcha().go(); }
	catch (Error e) { System.out.println("ouch"); }
	
III. try { new Gotcha().go(); }
catch (Exception e) { System.out.println("ouch"); }
*/

/*
When fragments I - III are added, independently, at line 5, which are true? (Choose all that apply.)
A. Some will not compile
B. They will all compile
C. All will complete normally
D. None will complete normally
E. Only one will complete normally
F. Two of them will complete normally
*/






























































/*
Answer:
B and E are correct. First off, go() is a badly designed 
recursive method, guaranteed to cause a StackOverflowError. 
Since Exception is not a superclass of Error, 
catching an Exception will not help handle an Error, 
so fragment III will not complete normally. 
Only fragment II will catch the Error.
A, C, D, and F are incorrect based on the above. (Objective 2.5)
*/

/*
Mi Respuesta:
	Seleccione A y E
	Veamos en esta selecciona la E que en efecto esta nos indica
	que solo una va termianr de forma normal y esa es la que 
	cacha el Error cuadno se da un StackOverFlowError por el
	metodo recursivo y como es cachado no hay bronca lo atrapa
	e imprime ouch.
	
	El A es elq que esta mal ya que dice que alguno no compilara
	pero no es asi todos compilan bien, me fui con la finta
	que en el fragmento III no compila porque haceun catch(Exception)
	pero como este error es de runtime no importa si lo declaras o no
	y eso me confundio debido a esto
	como todos compilan bien la B era la otra rspuesta correcta.
*/
