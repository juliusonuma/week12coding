package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")

	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 4, 6, false), arguments(3, 2, 5, false), arguments(7, 5, 12, false),
				arguments(4, 4, 8, false), arguments(0, 4, 4, true), arguments(7, 6, 13, false),
				arguments(-2, 6, -4, true), arguments(6, 4, 10, false));
	}

	@Test
	void assestertThatPairsOfPositiveNumbersAreAddedCorrectly() {

		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);

		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);

		assertThat(testDemo.addPositive(42, 15)).isEqualTo(57);

		assertThat(testDemo.addPositive(30, 10)).isEqualTo(40);

	}

	@Test
	void testThisNumberIsOdd() {
		testDemo = new TestDemo();
		int oddNumber = 7;
		assertThat(testDemo.thisNumberIsOdd(oddNumber));
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {

		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}