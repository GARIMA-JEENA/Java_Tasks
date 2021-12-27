package com.sempahore.generator;

import java.util.concurrent.Semaphore;

public class OddEvenGenerator {
	private Semaphore semaphoreOdd = new Semaphore(1);
	private Semaphore semaphoreEven = new Semaphore(0);

	public void printOdd(int number) {
		try {
			semaphoreOdd.acquire();
			System.out.println(Thread.currentThread().getName() + " " + number);
		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			semaphoreEven.release();
		}

	}

	public void printEven(int number) {
		try {
			semaphoreEven.acquire();
			System.out.println(Thread.currentThread().getName() + " " + number);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} finally {
			semaphoreOdd.release();
		}

	}

}
