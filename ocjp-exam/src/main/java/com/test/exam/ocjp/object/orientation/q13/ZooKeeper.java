package com.test.exam.ocjp.object.orientation.q13;
//Given:
class Mammal {
	String name = "furry ";
	String makeNoise() { return "generic noise"; }
}
class Zebra extends Mammal {
	String name = "stripes ";
	String makeNoise() { return "bray"; }
}
public class ZooKeeper {
	public static void main(String[] args) { new ZooKeeper().go(); }
		void go() {
			Mammal m = new Zebra();
			System.out.println(m.name + m.makeNoise());
		}
}


/*
What is the result?
A. furry bray
B. stripes bray
C. furry generic noise
D. stripes generic noise
E. Compilation fails
F. An exception is thrown at runtime
*/






















































/*
Answer:
A is correct. Polymorphism is only for instance methods.
B, C, D, E, and F are incorrect based on the above information.
(Objectives 1.5, 5.4)
*/
/*
Esta tiene un trucaso ya que en efecto el polimorfimos solo
se aplica a los métodos sobreescritos
este programa hace referencia a la variable de instancia
de la superclase no de la subclase
*/