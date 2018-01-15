package com.chandrakanth.sortingtechniques;

public class Main {

	public static void main(String argz[]) {

		final int[] arr = getData();
		final int l = arr.length;
		getSortedDataByBubbleSort(l, arr, "BubbleSort");
		getSorteddataByQuickSort(l, getData(), "QuickSort");

	}

	private static final int[] getData() {
		return new int[] { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
	}

	protected static final void getSortedDataByBubbleSort(final int l, final int[] a, final String sortType) {

		for (int i = 0; i < l; i++) {
			for (int j = -1; (++j < l - 1);) {
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
		for (int i = lLimit; i < hLimit; ++i) {
			if (a[i] < pivot) {
				continue;
			} else if (a[i] > pivot) {
				// Swap the numbers that are on the wrong side of the pivot value
				a[i] += a[hLimit];

				a[hLimit] = a[i] - a[hLimit];
				a[i] = a[i] - a[hLimit];
				// Swap the pivot value with the newly swapped value.
				System.out.println("Before Swap pivot");
				printValues(a, l, type);
				if (a[hLimit] > a[pivotIndex]) {
					a[hLimit] += a[pivotIndex];
					a[pivotIndex] = a[hLimit] - a[pivotIndex];
					a[hLimit] = a[hLimit] - a[pivotIndex];
				}
				System.out.println("After swap pivot");
				printValues(a,l,type);
				System.out.println(i+"\tPivotIndex"+pivotIndex+"\tHigherLimit"+hLimit);
				pivotIndex = hLimit;
				hLimit--;
				i = lLimit;

			}

		}
		System.out.println();
		printValues(a, l, type);

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
