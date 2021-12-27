package com.sempahore.method;

import com.sempahore.for_even.EvenGenerator;
import com.sempahore.for_odd.OddGenerator;
import com.sempahore.generator.OddEvenGenerator;

public class OddEvenUsingSempahore {
	public static void main(String args[]) {
		int total = 20;
		OddEvenGenerator oeGenerator = new OddEvenGenerator();
		OddGenerator oGenerator = new OddGenerator(oeGenerator, total);
		EvenGenerator eGenerator = new EvenGenerator(oeGenerator, total);

		Thread todd = new Thread(oGenerator, "Thread-odds");
		Thread teven = new Thread(eGenerator, "Thread-even");

		todd.start();
		teven.start();
	}

}
