package com.test.exam.ocjp.inner.classes.q02;

//Given
class Boo {
	Boo(String s) {
	}

	Boo() {
	}
}

class Bar extends Boo {
	Bar() {
	}

	Bar(String s) {
		super(s);
	}

	void zoo() {
		// insert code here
	}
}
/*
Which create an anonymous inner class from within class Bar? (Choose all that apply.)
A. Boo f = new Boo(24) { };
B. Boo f = new Bar() { };
C. Boo f = new Boo() {String s; };
D. Bar f = new Boo(String s) { };
E. Boo f = new Boo.Bar(String s) { };
*/











































/*
Answer:
	B and C. B is correct because anonymous inner classes are no different from any other
class when it comes to polymorphism. That means you are always allowed to declare a
reference variable of the superclass type and have that reference variable refer to an
instance of a subclass type, which in this case is an anonymous subclass of Bar. Since Bar
is a subclass of Boo, it all works. C uses correct syntax for creating an instance of Boo.

	A is incorrect because it passes an int to the Boo constructor, and there is no matching
constructor in the Boo class. D is incorrect because it violates the rules of polymorphism;
you cannot refer to a superclass type using a reference variable declared as the subclass
type. The superclass doesn't have everything the subclass has. E uses incorrect syntax.
*/


/*
 * Mi explicación:
 * 
 *  B es correcta porque define una clase anónima sin nada en su cuerpo.
 *  C también es correcta porque define una clase anónima y dentro empieza a declarar código en este caso solo declara unavariable String s.
 *  
 *  A es incorrecta porque cuando trata de crear la clase anónima le pasa a su constructor un int. pero esta clase solo recibe un contrcutor pode default o con un String
 *  D y E es incorrecto ya que la sintaxis no me cuadra con lo que comentan en el ebook.
*/