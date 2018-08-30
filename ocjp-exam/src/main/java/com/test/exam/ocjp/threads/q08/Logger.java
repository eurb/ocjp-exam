/**
 * 
 */
package com.test.exam.ocjp.threads.q08;

//Given the scenario: This class is intended to allow users to write a series of messages, 
//so that each message is identified with a timestamp and the name of the thread that wrote the message:
public class Logger {
	private StringBuilder contents = new StringBuilder();

	public void log(String message) {
		contents.append(System.currentTimeMillis());
		contents.append(": ");
		contents.append(Thread.currentThread().getName());
		contents.append(message);
		contents.append("\n");
	}

	public String getContents() {
		return contents.toString();
	}
}
//How can we ensure that instances of this class can be safely used by multiple threads?
//	A. This class is already thread-safe
//	B. Replacing StringBuilder with StringBuffer will make this class thread-safe
//	C. Synchronize the log() method only
//	D. Synchronize the getContents() method only
//	E. Synchronize both log() and getContents()
//	F. This class cannot be made thread-safe





































/*
 * Answer:
	E is correct. Synchronizing the public methods is sufficient to make this safe, so F is false. This class is not thread-safe unless some sort of synchronization protects the changing data.
	
	B is not correct because although a StringBuffer is synchonized internally, we call
	append() multiple times, and nothing would prevent two simultaneous log() calls from mixing up their messages. C and D are not correct because if one method remains unsynchronized, it can run while the other is executing, which could result in reading the contents while one of the messages is incomplete, or worse. (You don't want to call getString() on
	the StringBuffer as it's resizing its internal character array.) (Objective 4.3)
 * */


/*
 * Mi explicaci�n:
 * 
 * En un prinicpio se puede pensar que la correcta es la B. pensando que convieriendo el StringBuilder
 * a StringBuffer serpa suficiente, sin emabargo StringBuffer si es synchronized de forma interna, pero
 * nada nos garantiza que m�ltiples Threads invoquen al mpetodo append al mismo tiempo, por lo que
 * esta opci�n no es la correcta.
 * 
 * Sincronizando los m�todos p�blicos es suficiente para que sea thread safe, asi que la opci�n F es falsa
 * ya que si se puede hacer thread safe a estos m�todos.
 * 
 * Finalemnte la C y la D no son correctas ya que ambos m�todos deben ser sincronizados ya que si solo
 * ponemos un solo m�todo sibcronnizado entonces caemos en lo mismo una esta a salvo y el otro no
 * por lo que ambos deben ser synchronized, entonces la respuesta correcta es E.
 * */