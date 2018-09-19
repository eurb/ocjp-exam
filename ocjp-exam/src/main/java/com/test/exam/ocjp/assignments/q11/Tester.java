package com.test.exam.ocjp.assignments.q11;
//Given:
class Beta { }
class Alpha {
	static Beta b1;
	Beta b2;
}
public class Tester {
	public static void main(String[] args) {
		Beta b1 = new Beta(); Beta b2 = new Beta();
		Alpha a1 = new Alpha(); Alpha a2 = new Alpha();
		a1.b1 = b1;
		a1.b2 = b1;
		a2.b2 = b2;
		a1 = null; b1 = null; b2 = null;
		// do stuff
	}
}


/*
When line 16 is reached, how many objects will be eligible 
for garbage collection?
A. 0
B. 1
C. 2
D. 3
E. 4
F. 5
*/





















































/*
Answer:
B is correct. It should be clear that there is still a reference to the object referred to by a2, and that there is still a reference to the object referred to by a2.b2. What might be less clear is that you can still access the other Beta object through the static variable a2.b1—because it's static.
A, C, D, E, and F are incorrect based on the above. (Objective 7.4)
*/
/*
Mi explicación:
	Esta esta dificil hay que diagramar y aun asi no queda muy clara
	sabebos que como un miebro es static es compartido
	y por lo tanto se guarda en todo el heap, sin embargo 
	creo que el objeto que se reclama es el de a1.b2 ya qe pierde
	el enlace pero no le entendi muy bien :S
*/