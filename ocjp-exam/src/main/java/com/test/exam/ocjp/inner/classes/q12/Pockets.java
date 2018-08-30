package com.test.exam.ocjp.inner.classes.q12;
//Given:
import java.util.*;
public class Pockets {
	public static void main(String[] args) {
		String[] sa = {"nickel", "button", "key", "lint"};
		Sorter s = new Sorter();
		for(String s2: sa) System.out.print(s2 + " ");
		Arrays.sort(sa,s);
		System.out.println();
		for(String s2: sa) System.out.print(s2 + " ");
	}
	class Sorter implements Comparator<String> {
		public int compare(String a, String b) {
			return b.compareTo(a);
		}
	}
}

/*
What is the result?
	A. Compilation fails
	B. button key lint nickel nickel lint key button
	C. nickel button key lint button key lint nickel
	D. nickel button key lint nickel button key lint
	E. nickel button key lint nickel lint key button
	F. An exception is thrown at runtime
*/








































/*
Answer:
	A is correct, the inner class Sorter must be declared static to be called from 
	the static method main(). If Sorter had been static, answer E would be correct.
	
	B, C, D, E, and F are incorrect based on the above. (Objectives 1.1, 1.4, 6.5) 
*/

/*
Mi Explicación:
	Pareciera que todo es correcto incluso la intrucción Sorter s = new Sorter(); pero no es aso
	ya que como se explica la clase Sorter debe ser delcarada como static, para que sea puesa
	usar dentro del método static main.
*/