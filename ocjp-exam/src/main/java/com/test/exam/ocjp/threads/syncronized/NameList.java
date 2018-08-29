package com.test.exam.ocjp.threads.syncronized;

import java.util.*;

/**
 * 
 * @author eroman
 *The thing to realize here is that in a "thread-safe" class 
 *like the one returned by synchronizedList(), each 
 *individual method is synchronized. So names.size() 
 *is synchronized, and names.remove(0) is synchronized. 
 *But nothing prevents another thread from doing 
 *something else to the list in between those two calls. 
 *And that's where problems can happen.
 */
public class NameList {
	private List names = Collections.synchronizedList(new LinkedList());

	public void add(String name) {
		names.add(name);
	}

	public String removeFirst() {
		if (names.size() > 0)
			return (String) names.remove(0);
		else
			return null;
	}

	public static void main(String[] args) {
		final NameList nl = new NameList();
		nl.add("Ozymandias");
		class NameDropper extends Thread {
			public void run() {
				String name = nl.removeFirst();
				System.out.println(name);
			}
		}
		Thread t1 = new NameDropper();
		Thread t2 = new NameDropper();
		t1.start();
		t2.start();
	}
}