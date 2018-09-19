package com.test.exam.ocjp.assignments.q07;
//Given:
public class Bridge {
	public enum Suits {
		CLUBS(20), DIAMONDS(20), HEARTS(30), SPADES(30),
		NOTRUMP(40) { public int getValue(int bid) {return ((bid-1)*30)+40; } };
		Suits(int points) { this.points = points; }
		private int points;
		public int getValue(int bid) { return points * bid; }
	}
	public static void main(String[] args) {
		System.out.println(Suits.NOTRUMP.getValue(3));
		System.out.println(Suits.SPADES + " " + Suits.SPADES.points);
		System.out.println(Suits.values());
	}
}

/*
Which are true? (Choose all that apply.)
A. The output could contain 30
B. The output could contain @bf73fa
C. The output could contain DIAMONDS
D. Compilation fails due to an error on line 6
E. Compilation fails due to an error on line 7
F. Compilation fails due to an error on line 8
G. Compilation fails due to an error on line 9
H. Compilation fails due to an error within lines 12 to 14
*/



















































/*
Answer:
A and B are correct. The code compiles and runs without exception. 
The values() method returns an array reference, not the contents 
of the enum, so DIAMONDS is never printed.
C, D, E, F, G, and H are incorrect based on the above. (Objective 1.3)
*/
/*
Mi Respuesta:
	Elegi B y H, me fui con la finta de que en una enum no se puede acceder
	a los atributos private Suits.SPADES.points pero SI SE PUEDE :S
	todo lo demas esta ok.
	La respuesta era  A y B.
*/