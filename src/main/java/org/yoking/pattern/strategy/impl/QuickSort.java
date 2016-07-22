package org.yoking.pattern.strategy.impl;

import org.yoking.pattern.strategy.Sort;

/**
 * The Class QuickSort.
 */
public class QuickSort implements Sort {

	/** 
	 * {@inheritDoc}
	 *
	 * @see org.yoking.pattern.strategy.Sort#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		if (a == null || a.length <= 1)
			return;

		internalSort(a, 0, a.length - 1);
	}
	
	/**
	 * Internal sort.
	 *
	 * @param a the a
	 * @param left the left
	 * @param right the right
	 */
	public void internalSort(int[] a, int left, int right) {
		if (left > right)
			return;

		int i = left, j = right;
		int temp = a[i];

		while (i < j) {
			while (a[j] > temp && i < j)
				j--;
			a[i] = a[j];

			while (a[i] < temp && i < j)
				i++;
			a[j] = a[i];
		}
		a[i] = temp;

		internalSort(a, left, i - 1);
		internalSort(a, i + 1, right);
	}

}