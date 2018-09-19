package com.test.exam.ocjp.assignments.q09;
//Given:
public class Bertha {
	static String s = "";
	public static void main(String[] args) {
		int x = 4; Boolean y = true; short[] sa = {1,2,3};
		doStuff(x, y);
		doStuff(x);
		doStuff(sa, sa);
		System.out.println(s);
	}
	static void doStuff(Object o) { s += "1"; }
	static void doStuff(Object... o) { s += "2"; }
	static void doStuff(Integer... i) { s += "3"; }
	static void doStuff(Long L) { s += "4"; }
}

/*
What is the result?
A. 212
B. 232
C. 234
D. 312
E. 332
F. 334
G. Compilation fails
*/

































































/*
Answer:
A is correct. It's legal to autobox and then widen. 
The first call to doStuff() boxes the int to an Integer 
then passes two objects. The second call cannot widen and 
then box (making the Long method unusable), so it boxes 
the int to an Integer. As always, a var-args method 
will be chosen only if no non-var-arg method is possible. 
The third call is passing two objects—they are of type 
'short array.'
B, C, D, E, F, and G are incorrect based on the above. (Objective 3.1)
*/
/*
Mi Respuesta:
	La tuve bien sin embargo hay qeu tener cuiado ya que casi me
	confundo con la parte del widenning, en la primer llamada manda un
	int y un boolean como no hay una firma del metodo con esos valores
	entonces el que mas se parece es el var args de Object ya que
	el compilador hace un Boxing de int a Integer y Boolean ya es
	un objeto y como heredan de object si cabe por lo que primero 
	imprime 2.
	Despues manda llamar el segundo doStuff(x) esta esta confusa ya 
	que hay un doStuff que recibe un Integer y en efecto hace el 
	box y lo saca como Integer sin embargo ese método es un
	Integer con var args por lo que la regla es que los var args
	se elegian al final, asi que para este caso elige mejor al de
	Object por lo que a continuacion imprime 1
	Finalemnte manda dos veces el array de short doStuff(sa, sa)
	por lo que el unico que puede llamar el el var agrs de object
	entonces imprime de nuevo 2
*/