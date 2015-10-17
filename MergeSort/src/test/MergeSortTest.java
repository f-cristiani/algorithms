package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.MergeSort;

public class MergeSortTest {

	@Test
	public void whenConstructedWithoutArgumentsShouldNotThrowAnyException() {
		new MergeSort();
	}
	
	@Test
	public void shouldCorrectlySortAnArrayWithOnlyOneElement() {
		MergeSort mergeSort = new MergeSort();
		
		int oneElementArray[] = new int[1];
		oneElementArray[0] = 1;
		
		assertEquals(mergeSort.sort(oneElementArray), oneElementArray);
	}

}
