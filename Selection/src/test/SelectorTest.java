package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Selector;

public class SelectorTest {

	@Test
	public void shouldSelectAlwaysTheSameValueOfAnOneElementArrayNoMatterWhatOrderStatisticYouChoose() {
		Selector selector = new Selector();
		
		int oneElementArrayUniqueValue = 5;
		int[] oneElementArray = {oneElementArrayUniqueValue};
		
		assertEquals(oneElementArrayUniqueValue, selector.selectOrderStatistic(oneElementArray, 1));
		assertEquals(oneElementArrayUniqueValue, selector.selectOrderStatistic(oneElementArray, 2));
		assertEquals(oneElementArrayUniqueValue, selector.selectOrderStatistic(oneElementArray, 3));
		assertEquals(oneElementArrayUniqueValue, selector.selectOrderStatistic(oneElementArray, 10));
	}
	
	@Test
	public void whenTheInputArrayIsInAscendingOrderTheOrderStatisticAndThePositionOfTheArrayShouldBeEquivalent() {
		Selector selector = new Selector();

		int input[] = getArrayAscendingOrder(1000);
		
		int orderStatistic = 0;
		for (int i = 0; i < input.length; i++) {
			orderStatistic = i + 1;
			assertEquals(input[i], selector.selectOrderStatistic(input, orderStatistic));
		}
	}
	
	private int[] getArrayAscendingOrder(int size) {
		int[] arrayAscendingOrder = new int[size];

		int j = 0;
		for(int i = 0; i < arrayAscendingOrder.length ; i++) {
			arrayAscendingOrder[i] = i + 1;
		}

		return arrayAscendingOrder;
	}
}
