package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;

		} else {
			throw new IllegalArgumentException("n/Both parameters must be positive!");
		}
	}

	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}

	int getRandomInt() {

		Random random = new Random();

		return random.nextInt(10) + 1;

	}

	public boolean thisNumberIsOdd(int x) {
		if (x % 2 == 0) {

			throw new IllegalArgumentException("n/This number is not odd!");
		} else

			return true;
	}
}