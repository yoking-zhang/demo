package org.yoking.pattern.strategy;

import java.util.Arrays;

import org.yoking.pattern.strategy.impl.BubbleSort;
import org.yoking.pattern.strategy.impl.QuickSort;

public class SortTest {

	public static void main(String[] args) {
		int[] a = { 3, 8, 2, 5, 9, 4, 1, 7, 6 };
		int[] b = { 3, 8, 2, 5, 9, 4, 1, 7, 6 };

		Sort bs = new BubbleSort();
		Sort qs = new QuickSort();
		
		System.out.println(Arrays.toString(a));
		bs.sort(a);
		System.out.println("Bubble Sorted: " + Arrays.toString(a));
		
		System.out.println(Arrays.toString(b));
		qs.sort(b);
		System.out.println("Quick Sorted: " + Arrays.toString(b));
	}

}