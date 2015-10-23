package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.InversionsCounter;

public class InversionsCounterTest {

	@Test
	public void shouldReturn0WithAOneElementArray() {
		InversionsCounter inversionsCounter = new InversionsCounter();
		
		int oneElementArray[] = new int[1];
		oneElementArray[0] = 1;
		
		assertEquals(0, inversionsCounter.count(oneElementArray));
	}
}
