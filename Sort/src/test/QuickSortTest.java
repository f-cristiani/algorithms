package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.QuickSort;
import main.Sort;

public class QuickSortTest {

	@Test
	public void whenConstructedWithoutArgumentsShouldNotThrowAnyException() {
		getSortInstance();
	}
	
	@Test
	public void shouldCorrectlySortAnArrayWithOnlyOneElement() {
		Sort sort = getSortInstance();
		
		int oneElementArray[] = new int[1];
		oneElementArray[0] = 1;
		
		assertArrayEquals(oneElementArray, sort.sort(oneElementArray));
	}
	
	@Test
	public void shouldCorrectlySortAnArrayWithTwoElements() {
		Sort sort = getSortInstance();
		
		int toBeSortedArray[] = {2, 1};
		int sortedArray[] = {1, 2};

		assertArrayEquals(sortedArray, sort.sort(toBeSortedArray));
	}
	
	@Test
	public void shouldCorrectlySortAnArrayWithThreeElements() {
		Sort sort = getSortInstance();
		
		int toBeSortedArray[] = {2, 1, 3};
		int sortedArray[] = {1, 2, 3};
		
		assertArrayEquals(sortedArray, sort.sort(toBeSortedArray));
	}
	
	@Test
	public void shouldCorrectlySortAnArrayWithFiveElements() {
		Sort sort = getSortInstance();
		
		int toBeSortedArray[] = {2, 1, 5, 3, 4};
		int sortedArray[] = {1, 2, 3, 4, 5};

		assertArrayEquals(sortedArray, sort.sort(toBeSortedArray));
	}
	
	@Test
	public void shouldCorrectlySortAnArrayWith50Elements() {
		Sort sort = getSortInstance();
		
		int toBeSortedArray[] = {347523, 477804, 934666, 927084, 973078, 616626, 126202, 738233, 136526, 651868, 79185, 740886, 786416, 565151, 454398, 960612, 807463, 259339, 546431, 738397, 113505, 622120, 210643, 987452, 214240, 461133, 364612, 995311, 769599, 164958, 651435, 190097, 761315, 499004, 524945, 198045, 228076, 640325, 261789, 324867, 44785, 713343, 651793, 270136, 757761, 319230, 31895, 286997, 112839, 745662, 784538, 93521, 536795, 250742, 53399, 737657, 249800, 792917, 441197, 461955, 728776, 625137, 353897, 645458, 840258, 719316, 191342, 91028, 94553, 34138, 867937, 259913, 548401, 183272, 926195, 830172, 125483, 717367, 808575, 331285, 858415, 243891, 241104, 852290, 959152, 487188, 46374, 324067, 760369, 217569, 509474, 841675, 465497, 832365, 923925, 14215, 428282, 849740, 660221, 443601};
		int sortedArray[] = {14215, 31895, 34138, 44785, 46374, 53399, 79185, 91028, 93521, 94553, 112839, 113505, 125483, 126202, 136526, 164958, 183272, 190097, 191342, 198045, 210643, 214240, 217569, 228076, 241104, 243891, 249800, 250742, 259339, 259913, 261789, 270136, 286997, 319230, 324067, 324867, 331285, 347523, 353897, 364612, 428282, 441197, 443601, 454398, 461133, 461955, 465497, 477804, 487188, 499004, 509474, 524945, 536795, 546431, 548401, 565151, 616626, 622120, 625137, 640325, 645458, 651435, 651793, 651868, 660221, 713343, 717367, 719316, 728776, 737657, 738233, 738397, 740886, 745662, 757761, 760369, 761315, 769599, 784538, 786416, 792917, 807463, 808575, 830172, 832365, 840258, 841675, 849740, 852290, 858415, 867937, 923925, 926195, 927084, 934666, 959152, 960612, 973078, 987452, 995311};
		
		assertArrayEquals(sortedArray, sort.sort(toBeSortedArray));
	}

	@Test
	public void shouldCorrectlySortAnArrayWithRepeatedElements() {
		Sort sort = getSortInstance();
		
		int toBeSortedArray[] = {1, 5, 2, 4, 2, 5, 1, 1, 6, 10, 8, 10, 10, 12};
		int sortedArray[] = {1, 1, 1, 2, 2, 4, 5, 5, 6, 8, 10, 10, 10, 12};

		assertArrayEquals(sortedArray, sort.sort(toBeSortedArray));
	}

	private Sort getSortInstance() {
		return new QuickSort();
	}

}
