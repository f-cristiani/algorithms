package main;

import java.util.Arrays;

public class QuickSort {
	private int comparisons = 0;

	public int[] sort(int[] input) {
		this.comparisons = 0;
		return doSort(input);
	}
	
	private int[] doSort(int[] input) {
		int inputLength = input.length;
		if (inputLength <= 1) {
			return input;
		}
		
		this.comparisons = this.comparisons + inputLength - 1;
		
		int pivot = choosePivot(input);
		
		swapValues(input, pivot, 0);
		pivot = 0;
		
		pivot = partitionInputAroundPivot(input, pivot);
		
		int beforePivotPart[] = Arrays.copyOfRange(input, 0, pivot);
		int afterPivotPart[] = Arrays.copyOfRange(input, pivot + 1, inputLength);
	
		int sortedBeforePivotPart[] = this.doSort(beforePivotPart);
		int sortedAfterPivotPart[] = this.doSort(afterPivotPart);
		
		int[] sortedInput = new int[inputLength];
		
		for (int i = 0; i < sortedBeforePivotPart.length; i++) {
			sortedInput[i] = sortedBeforePivotPart[i];
		}
		
		sortedInput[pivot] = input[pivot];
		
		for (int i = 0; i < sortedAfterPivotPart.length; i++) {
			sortedInput[pivot + 1 + i] = sortedAfterPivotPart[i];
		}
		
		return sortedInput;
	}
	
	public int getComparisons() {
		return this.comparisons;
	}

	private int partitionInputAroundPivot(int[] input, int pivot) {
		int pivotValue = input[pivot];
		int boundarySmallerBiggerThanPivot = pivot + 1;
		for (int j = boundarySmallerBiggerThanPivot; j < input.length; j++) {
			if (input[j] < pivotValue) {
				swapValues(input, j, boundarySmallerBiggerThanPivot);
				boundarySmallerBiggerThanPivot++;
			}
		}
		
		int newPivot = boundarySmallerBiggerThanPivot - 1;
		swapValues(input, pivot, newPivot);

		return newPivot;
	}

	private void swapValues(int[] input, int i, int j) {
		int tempValue = input[i];
		input[i] = input[j];
		input[j] = tempValue;
	}

	private int choosePivot(int[] input) {
		int firstIndex = 0;
		int lastIndex = input.length - 1;
		int middleIndex = 0;
		
		if (input.length % 2 == 0) {
			middleIndex = (input.length/2) - 1;
		} else {
			middleIndex = (int) Math.floor(input.length/2);
		}
		
		int firstElement = input[firstIndex];
		int lastElement = input[lastIndex];
		int middleElement = input[middleIndex];
		
		if (firstElement < lastElement && firstElement > middleElement) {
			return firstIndex;
		}
		
		if (firstElement > lastElement && firstElement < middleElement) {
			return firstIndex;
		}
		
		if (lastElement < firstElement && lastElement > middleElement) {
			return lastIndex;
		}
		
		if (lastElement > firstElement && lastElement < middleElement) {
			return lastIndex;
		}
		
		return middleIndex;
		
	}
	
}
