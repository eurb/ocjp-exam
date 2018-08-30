package com.test.exam.ocjp.threads.practice02;
//Given:
class MyThread extends Thread {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		Thread x = new Thread(t);
		x.start();
	}
	public void run() {
		for (int i = 0; i < 3; ++i) {
			System.out.print(i + "..");
		}
	}
}

//What is the result of this code?
//	A. Compilation fails
//	B. 1..2..3..
//	C. 0..1..2..3..
//	D. 0..1..2..
//	E. An exception occurs at runtime














































//Answer:
//D is correct. The thread MyThread will start and loop three times (from 0 to 2).
//A is incorrect because the Thread class implements the Runnable interface; therefore, in line 5, 
//Thread can take an object of type Thread as an argument in the constructor (this is NOT recommended). 
//B and C are incorrect because the variable i in the for loop 
//starts with a value of 0 and ends with a value of 2. E is incorrect based on the above. (Obj. 4.1)


//No hay mas explicación mas que la que se indica.