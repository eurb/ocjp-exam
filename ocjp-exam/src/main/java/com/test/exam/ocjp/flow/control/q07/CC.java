package com.test.exam.ocjp.flow.control.q07;
//Given
class SubException extends Exception { }
class SubSubException extends SubException { }

public class CC { void doStuff() throws SubException { } }

class CC2 extends CC { void doStuff() throws SubSubException { } }

class CC3 extends CC { void doStuff() throws Exception { } }

class CC4 extends CC { void doStuff(int x) throws Exception { } }

class CC5 extends CC { void doStuff() { } }

/*
What is the result? (Choose all that apply
.)
A. Compilation succeeds
B. Compilation fails due to an error on line 8
C. Compilation fails due to an error on line 10
D. Compilation fails due to an error on line 12
E. Compilation fails due to an error on line 14
*/









































































/*
Answer:
C is correct. An overriding method cannot throw a broader 
exception than the method it's overriding. Class CC4's 
method is an overload, not an override.
A, B, D, and E are incorrect based on the above. 
(Objectives 1.5, 2.4)
*/

/*
Mi Respuesta:
	C y E la tuve mal, se que en la C si falla en la liena 10
	ya que no puedes sobreescribir un método con una excepcion
	checked mas grande que la de la super clase.
	
	Seleccione la E porque pense que como es checked estabamos
	obligados a declarar la excepción en el método 
	sobreescrito, sin embargo esto no es asi, si no declaramos
	la excepción checked no pasa nada, solo pasa si declaramos
	una excepcion mas arriba de la cheked que sea una super clase
	como en el ejemplo, hay que leer las reglas de la 
	sobreescritura para mas info, por lo demas creo que no
	hay dudas.
	
	Tambien como nota esto si lo entendi en la linea 12
	está haciendo una sobrecarga y no una sobreescritura por eso
	no hay problema que lanze una Exception ya que es una 
	sobrecarga y se toma como otro método que no es el de 
	la superclase. 
*/