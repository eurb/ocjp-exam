package com.test.exam.ocjp.threads.practice03;

//Given:
class Test {
	public static void main(String[] args) {
		printAll(args);
	}

	public static void printAll(String[] lines) {
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
			Thread.currentThread().sleep(1000);
		}
	}
}

//The static method Thread.currentThread() returns a reference to the currently executing Thread object. What is the result of this code?
//A. Each String in the array lines will print, with exactly a 1-second pause between lines
//B. Each String in the array lines will print, with no pause in between because this method is not executed in a Thread
//C. Each String in the array lines will print, and there is no guarantee there will be a pause because currentThread() may not retrieve this thread
//D. This code will not compile
//E. Each String in the lines array will print, with at least a one-second pause between lines


























































/*
 * Answer:
	D is correct. The sleep() method must be enclosed in a try/catch block, or the method printAll() 
	must declare it throws the InterruptedException.
	
	E is incorrect, but it would be correct if the InterruptedException was dealt with (A is too precise). 
	B is incorrect (even if the InterruptedException was dealt with) because all Java code, 
		including the main() method, runs in threads. 
	C is incorrect. The sleep() method is static, it always affects the currently executing thread. (Objective 4.2)
*/

//Mi explicación: No hay mas esta claro