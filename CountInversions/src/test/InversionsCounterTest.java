package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.InversionsCounter;

public class InversionsCounterTest {

	@Test
	public void shouldReturn0WithAOneElementArray() {
		InversionsCounter inversionsCounter = new InversionsCounter();

		int oneElementArray[] = {1};

		assertEquals(0, inversionsCounter.count(oneElementArray));
	}

	@Test
	public void shouldReturn1WithATwoElementArraySortedInDescendingOrder() {
		InversionsCounter inversionsCounter = new InversionsCounter();

		int twoElementArrayDescendingOrder[] = {2, 1};

		assertEquals(1, inversionsCounter.count(twoElementArrayDescendingOrder));
	}

	@Test
	public void shouldReturnTheMaxNumberOfInversionsWithAnArraySortedInDescendingOrder() {
		InversionsCounter inversionsCounter = new InversionsCounter();

		int[] arrayDescendingOrder = getArrayDescendingOrder(100000);

		int expectedNumberOfInversions = (arrayDescendingOrder.length * (arrayDescendingOrder.length - 1))/2;

		assertEquals(expectedNumberOfInversions, inversionsCounter.count(arrayDescendingOrder));
	}

	private int[] getArrayDescendingOrder(int size) {
		int[] arrayDescendingOrder = new int[size];

		int j = 0;
		for(int i = arrayDescendingOrder.length; i > 0 ; i--) {
			arrayDescendingOrder[j] = i;
			j++;
		}

		return arrayDescendingOrder;
	}
}