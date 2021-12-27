package com.sempahore.for_odd;

import com.sempahore.generator.OddEvenGenerator;

public class OddGenerator implements Runnable {

	private OddEvenGenerator oeGenerator;
	private int totalNumber;

	public OddGenerator(OddEvenGenerator oeGenerator, int totalNumber) {
		super();
		this.oeGenerator = oeGenerator;
		this.totalNumber = totalNumber;
	}

	@Override
	public void run() {
		for (int i = 1; i <= totalNumber; i += 2) {
			oeGenerator.printOdd(i);
		}

	}

}
