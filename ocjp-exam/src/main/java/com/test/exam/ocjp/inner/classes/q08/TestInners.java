package com.test.exam.ocjp.inner.classes.q08;


//Given:
 class A { void m() { System.out.println("outer"); } }

 public class TestInners {
	 public static void main(String[] args) {
		 new TestInners().go();
	 }
	 void go() {
		 new A().m();
		 class A { void m() { System.out.println("inner"); } }
	 }
	 class A { void m() { System.out.println("middle"); } }
 }

 
 
/*What is the result?	
	A. inner
	B. outer
	C. middle
	D. Compilation fails
	E. An exception is thrown at runtime*/
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 /*Answer:
	C is correct. The "inner" version of class A isn't used because its declaration comes
	after the instance of class A is created in the go() method.
	
	A, B, D, and E are incorrect based on the above. (Objective 1.1)*/
 
 /*Mi explicación:
  * Siempre va a tomar la del scope mas cercano por ejemplo
  * en la linea 11 que es donde se manda llamar al método m, 
  * se pensaría que la respuesta correcta es A pero no es asi 
  * porque esta se declara despues de que m fue invocado.
  * 
  * Se puede pensar que la respuesta es B pero tampoco ya que esta 
  * esta declarada fuera de la clase por lo tanto tiene un scope 
  * mas grande
  * 
  * La correcta es C ya que esta tiene el scope mas cercano a de 
  * outer por lo que esta es la correcta las otras no lo son.
  * */