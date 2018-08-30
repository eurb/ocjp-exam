package com.test.exam.ocjp.inner.classes.q06;

public abstract class AbstractTest {
	public int getNum() {
		return 45;
	}
	public abstract class Bar {
		public int getNum() {
			return 38;
		}
	}
	public static void main(String[] args) {
		AbstractTest t = new AbstractTest() {
			public int getNum() {
				return 22;
			}
		};
		AbstractTest.Bar f = t.new Bar() {
			public int getNum() {
				return 57;
			}
		};
		System.out.println(f.getNum() + " " + t.getNum());
	}
}

/*
 * What is the result?
	A. 57 22
	B. 45 38
	C. 45 57
	D. An exception occurs at runtime
	E. Compilation fails
*/





















































/*
 * Answer:
	A. You can define an inner class as abstract, which means you can instantiate only
	concrete subclasses of the abstract inner class. The object referenced by the variable t
	is an instance of an anonymous subclass of AbstractTest, and the anonymous class
	overrides the getNum() method to return 22. The variable referenced by f is an instance
	of an anonymous subclass of Bar, and the anonymous Bar subclass also overrides the
	getNum() method (to return 57). Remember that to create a Bar instance, we need an
	instance of the enclosing AbstractTest class to tie to the new Bar inner class instance.
	AbstractTest can't be instantiated because it's abstract, so we created an anonymous
	subclass (non-abstract) and then used the instance of that anonymous subclass to tie
	to the new Bar subclass instance.

	B, C, D, and E are incorrect based on the program logic described above.
*/

/*Mi explicación
 * Esta esta chida porque explican bien como y donde definir clases internas abstractas
 * solo hay que aprenderse la sintaxis pero todo es muy claro
 * */
