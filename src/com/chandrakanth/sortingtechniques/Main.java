package com.chandrakanth.sortingtechniques;

public class Main {

	public static void main(String argz[]) {

		final int[] arr = getData();
		final int l = arr.length;
		// getSortedDataByBubbleSort(l, arr, "BubbleSort");
		// getSorteddataByQuickSort(l, getData(), "QuickSort");
		// getSortedDataByMergeSort(l, getData(), "MergeSort");

		getSortedDataBySelectionSort(l, getData(), "SelectionSort");
		// getSortedDataByInsertionSort(l, getData(), "InsertionSort");

	}

	/*
	 * private static final void getSortedDataByInsertionSort(int l, int[] a, String
	 * string) {
	 * 
	 * }
	 */

	private static void getSortedDataBySelectionSort(int l, int[] a, String type) {
		for (int i = 0; i < a.length; i++) {
			int currentIndex = i;
			printValues(a, l, type);
			printIndex(a, l, type);
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] >= a[j - 1] && a[currentIndex] >= a[j - 1]) {
					currentIndex = j - 1;
				}
				if (j == a.length - 1) {
					if (a[currentIndex] >= a[j] && (j) != currentIndex) {
						currentIndex = j;
					}
					if (currentIndex != i)
						swap(a, currentIndex, i);
				}
			}
		}
		printValues(a, l, type);
	}

	private static final void getSortedDataByMergeSort(int l, int[] a, String sortType) {

	}

	private static final int[] getData() {
		return new int[] { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
	}

	protected static final void getSortedDataByBubbleSort(final int l, final int[] a, final String sortType) {

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l - 1; j++) {
				if (a[j] > a[j + 1]) {
					a[j] += a[j + 1];
					a[j + 1] = a[j] - a[j + 1];
					a[j] = a[j] - a[j + 1];
				}
			}
		}
		printValues(a, l, sortType);
	}

	protected static final void getSorteddataByQuickSort(int l, int[] a, final String type) {

		int lLimit = 0;
		int hLimit = l - 2;
		int pivot = a[l - 1];
		int pivotIndex = l - 1;
		printValues(a, l, type);
		printIndex(a, l, type);
		int i = lLimit;
		final int currLen = a.length;
		while (i < hLimit) {
			if (pivotIndex == currLen / 2 && a[hLimit] > a[pivotIndex]) {
				swap(a, hLimit, pivotIndex);
				pivotIndex--;
			} else if (a[i] < pivot) {
				i++;
				continue;
			} else if (a[i] > pivot) {
				swap(a, i, hLimit);
				if (a[hLimit] > a[pivotIndex]) {
					swap(a, hLimit, pivotIndex);
				}
				pivotIndex = hLimit;
				hLimit--;
				i = lLimit;
			}

		}
		printValues(a, l, type);

	}

	private static final void swap(int[] a, int i, int uL) {
		a[i] += a[uL];
		a[uL] = a[i] - a[uL];
		a[i] = a[i] - a[uL];
	}

	private static final void printValues(final int[] a, final int l, final String type) {
		int size = -1;
		while (++size < l) {
			System.out.print((size == 0 ? type + "\t" : "") + a[size] + ((size < l - 1) ? "," : "\n"));
		}
	}

	private static final void printIndex(final int[] a, final int l, final String type) {
		int size = -1;
		while (++size < l) {
			System.out.print((size == 0 ? "order" + "\t\t" : "") + size + ((size < l - 1) ? "," : "\n"));
		}
	}

}
