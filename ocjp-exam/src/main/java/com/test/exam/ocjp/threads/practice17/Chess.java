package com.test.exam.ocjp.threads.practice17;
//Given:
public class Chess implements Runnable {
	public void run() {
		move(Thread.currentThread().getId());
	}
	// insert code here
		System.out.print(id+" ");
		System.out.print(id+" ");
	}
	public static void main(String[] args) {
		Chess ch = new Chess();
		new Thread(ch).start();
		new Thread(new Chess()).start();
	}
}

/*
And given these two fragments:
	I. synchronized void move(long id) {
	II. void move(long id) {
*/

/*
When either fragment I or fragment II is inserted at line 7, which are true? (Choose all that apply.)
	A. Compilation fails
	B. With fragment I, an exception is thrown
	C. With fragment I, the output could be 4 2 4 2
	D. With fragment I, the output could be 4 4 2 3
	E. With fragment II, the output could be 2 4 2 4
*/












































/*
Answer:
	C and E are correct. E should be obvious. C is correct because even though move() is
	synchronized, in this case two different objects are invoking it.
	A, B, and D are incorrect based on the above. (Objective 4.3)
*/