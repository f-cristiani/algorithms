package main;

import java.util.Arrays;

public class MergeSort implements Sort {

	public int[] sort(int[] toBeSortedArray) {
		return doSort(toBeSortedArray);
	}

	private int[] doSort(int[] toBeSortedArray) {
		int toBeSortedLen = toBeSortedArray.length;

		if (toBeSortedLen == 1) {
			return toBeSortedArray;
		}
		
		int firstHalfToBeSorted[] = Arrays.copyOfRange(toBeSortedArray, 0, toBeSortedLen/2);
		int secondHalfToBeSorted[] = Arrays.copyOfRange(toBeSortedArray, (toBeSortedLen/2), toBeSortedLen);
	
		int sortedFirstHalf[] = this.doSort(firstHalfToBeSorted);
		int sortedSecondHalf[] = this.doSort(secondHalfToBeSorted);
		
		return this.mergeArraysAndSort(sortedFirstHalf, sortedSecondHalf);
	}

	private int[] mergeArraysAndSort(int[] sortedFirstArray, int[] sortedSecondArray) {
		int lengthSortedMergedArray = sortedFirstArray.length + sortedSecondArray.length;
		int[] sortedMergedArray = new int[lengthSortedMergedArray];

		int firstArrayIndex = 0;
		int secondArrayIndex = 0;
		for (int i = 0; i < sortedMergedArray.length; i++) {
			if (indexOutOfBound(sortedFirstArray, firstArrayIndex)) {
				sortedMergedArray[i] = sortedSecondArray[secondArrayIndex];
				secondArrayIndex++;
				continue;
			}
			
			if (indexOutOfBound(sortedSecondArray, secondArrayIndex)) {
				sortedMergedArray[i] = sortedFirstArray[firstArrayIndex];
				firstArrayIndex++;
				continue;
			}

			if (sortedFirstArray[firstArrayIndex] < sortedSecondArray[secondArrayIndex]) {
				sortedMergedArray[i] = sortedFirstArray[firstArrayIndex];
				firstArrayIndex++;
			} else {
				sortedMergedArray[i] = sortedSecondArray[secondArrayIndex];
				secondArrayIndex++;
			}
		}
		
		return sortedMergedArray;
	}

	private boolean indexOutOfBound(int[] theArray, int index) {
		return index >= theArray.length;
	}
}
