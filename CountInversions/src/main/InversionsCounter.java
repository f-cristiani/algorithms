package main;

import java.util.Arrays;

public class InversionsCounter {

	public long count(int[] input) {
		return doCount(input);
	}

	private long doCount(int[] input) {
		int inputLength = input.length;

		if (inputLength == 1) {
			return 0;
		}

		int firstHalf[] = Arrays.copyOfRange(input, 0, inputLength/2);
		int secondHalf[] = Arrays.copyOfRange(input, (inputLength/2), inputLength);

		long firstHalfInversions = doCount(firstHalf);
		long secondHalfInversions = doCount(secondHalf);
		long splittedInversions = countSplittedInversions(input);

		return firstHalfInversions + secondHalfInversions + splittedInversions;
	}

	private long countSplittedInversions(int[] input) {
		return sortAndCountSplittedInversions(input).numberOfInversions;
	}

	private SortedArrayAndNumberOfInversions sortAndCountSplittedInversions(int[] input) {
		int inputLength = input.length;

		if (inputLength == 1) {
			return new SortedArrayAndNumberOfInversions(input, 0);
		}

		int firstHalf[] = Arrays.copyOfRange(input, 0, inputLength/2);
		int secondHalf[] = Arrays.copyOfRange(input, (inputLength/2), inputLength);

		SortedArrayAndNumberOfInversions firstHalfSortedArrayAndNumberOfInversions = this.sortAndCountSplittedInversions(firstHalf);
		SortedArrayAndNumberOfInversions secondHalfSortedArrayAndNumberOfInversions = this.sortAndCountSplittedInversions(secondHalf);

		return mergeArraysAndCountSplittedInversions(firstHalfSortedArrayAndNumberOfInversions.sortedArray, secondHalfSortedArrayAndNumberOfInversions.sortedArray);
	}

	private SortedArrayAndNumberOfInversions mergeArraysAndCountSplittedInversions(int[] sortedFirstArray, int[] sortedSecondArray) {
		int lengthSortedMergedArray = sortedFirstArray.length + sortedSecondArray.length;
		int[] sortedMergedArray = new int[lengthSortedMergedArray];

		long numberOfInversions = 0;

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
				numberOfInversions += (sortedFirstArray.length - firstArrayIndex);
				secondArrayIndex++;
			}
		}

		return new SortedArrayAndNumberOfInversions(sortedMergedArray, numberOfInversions);
	}

	private boolean indexOutOfBound(int[] theArray, int index) {
		return index >= theArray.length;
	}

	public class SortedArrayAndNumberOfInversions {
		private int[] sortedArray;
		private long numberOfInversions;

		public SortedArrayAndNumberOfInversions(int[] sortedArray, long numberOfInversions) {
			this.sortedArray = sortedArray;
			this.numberOfInversions = numberOfInversions;
		}
	}
}

