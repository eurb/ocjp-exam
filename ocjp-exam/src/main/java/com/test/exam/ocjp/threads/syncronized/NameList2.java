package com.test.exam.ocjp.threads.syncronized;

import java.util.*;

public class NameList2 {
	private List names = new LinkedList();

	public synchronized void add(String name) {
		names.add(name);
	}

	public synchronized String removeFirst() {
		if (names.size() > 0)
			return (String) names.remove(0);
		else
			return null;
	}
	
	public static void main(String[] args) {
		final NameList2 nl = new NameList2();
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