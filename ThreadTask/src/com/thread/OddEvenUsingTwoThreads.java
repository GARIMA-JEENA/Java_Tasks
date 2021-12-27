package com.thread;

import com.thread.OddEvenUsingTwoThreads;

public class OddEvenUsingTwoThreads {

	int counter = 1;
	static int n;

	public static void main(String[] args) {
		n = 10;
		OddEvenUsingTwoThreads oe = new OddEvenUsingTwoThreads();

		Thread todd = new Thread(new Runnable() {
			public void run() {
				oe.printOddNumber();
			}
		}, "Thread-odds");

		Thread teven = new Thread(new Runnable() {
			public void run() {
				oe.printEvenNumber();
			}
		}, "Thread-even");

		todd.start();
		teven.start();

	}

	public void printOddNumber() {
		synchronized (this) {
			while (counter < n) {
				while (counter % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "   " + counter);
				counter++;
				notify();
			}
		}
	}

	public void printEvenNumber() {
		synchronized (this) {
			while (counter < n) {
				while (counter % 2 != 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + "   " + counter);
				counter++;
				notify();
			}
		}
	}

}
