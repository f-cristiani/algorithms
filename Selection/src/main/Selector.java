package main;

import java.util.Arrays;
import java.util.Random;

public class Selector {

	public int selectOrderStatistic(int[] input, int orderStatistic) {
		return doSelection(input,orderStatistic);
	}

	private int doSelection(int[] input, int orderStatistic) {
		int inputLength = input.length;
		if (inputLength == 1) {
			return input[0];
		}
		
		int pivot = choosePivot(input);
		
		swapValues(input, pivot, 0);
		pivot = 0;
		
		pivot = partitionInputAroundPivot(input, pivot);
		
		if (pivot > transformOrderStatisticToArrayIndexes(orderStatistic)) {
			int beforePivotPart[] = Arrays.copyOfRange(input, 0, pivot);
			return doSelection(beforePivotPart, orderStatistic);
		}
		
		if (pivot < transformOrderStatisticToArrayIndexes(orderStatistic)) {
			int afterPivotPart[] = Arrays.copyOfRange(input, pivot + 1, inputLength);
			return doSelection(afterPivotPart, transformOrderStatisticToArrayIndexes(orderStatistic) - pivot);
		}
		
		return input[pivot];
	}

	private int transformOrderStatisticToArrayIndexes(int orderStatistic) {
		return orderStatistic - 1;
	}

	private int choosePivot(int[] input) {
		Random r = new Random();
		return r.nextInt(input.length);
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
}
