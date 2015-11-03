package test;

import main.QuickSort;
import main.Sort;

public class QuickSortTest extends SortTest {
	protected Sort getSortInstance() {
		return new QuickSort();
	}

}