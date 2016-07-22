package org.yoking.pattern.strategy.impl;

import org.yoking.pattern.strategy.Sort;

/**
 * The Class BubbleSort.
 */
public class BubbleSort implements Sort {

	/** 
	 * {@inheritDoc}
	 *
	 * @see org.yoking.pattern.strategy.Sort#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		if (a == null || a.length <= 1)
			return;

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					a[j - 1] ^= a[j];
					a[j] ^= a[j - 1];
					a[j - 1] ^= a[j];
				}
			}
		}
	}

}