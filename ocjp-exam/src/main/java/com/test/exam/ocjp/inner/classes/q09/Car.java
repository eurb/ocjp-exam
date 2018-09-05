package com.test.exam.ocjp.inner.classes.q09;
//Given:
public class Car {
	class Engine {
		// insert code here
	}
	public static void main(String[] args) {
		new Car().go();
	}
	void go() {
		new Engine();
	}
	void drive() { System.out.println("hi"); }
}

/*
 * Which, inserted independently at line 5, produce the output "hi"? (Choose all that apply.)
	A. { Car.drive(); }
	B. { this.drive(); }
	C. { Car.this.drive(); }
	D. { this.Car.this.drive(); }
	E. Engine() { Car.drive(); }
	F. Engine() { this.drive(); }
	G. Engine() { Car.this.drive(); }
 */








































/*
 * Answer:
	C and G are correct. C is the correct syntax to access an inner class outer instance
	method from an initialization block, and G is the correct syntax to access it from a constructor.
	
	A, B, D, E, and F are incorrect based on the above. (Objectives 1.1, 1.4)
 * */