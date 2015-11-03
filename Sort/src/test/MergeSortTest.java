package test;

import main.MergeSort;
import main.Sort;

public class MergeSortTest extends SortTest {

	protected Sort getSortInstance() {
		return new MergeSort();
	}

}