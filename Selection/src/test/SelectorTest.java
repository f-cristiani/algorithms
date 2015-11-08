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

}
