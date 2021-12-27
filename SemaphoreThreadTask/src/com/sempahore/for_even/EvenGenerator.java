package com.sempahore.for_even;

import com.sempahore.generator.OddEvenGenerator;

public class EvenGenerator implements Runnable {

	private OddEvenGenerator oeGenerator;
	private int totalNumber;

	public EvenGenerator(OddEvenGenerator oeGenerator, int totalNumber) {
		super();
		this.oeGenerator = oeGenerator;
		this.totalNumber = totalNumber;
	}

	@Override
	public void run() {
		for (int i = 2; i <= totalNumber; i += 2) {
			oeGenerator.printEven(i);
		}

	}

}
