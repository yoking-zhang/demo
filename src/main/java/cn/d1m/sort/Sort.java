package cn.d1m.sort;

import java.util.Arrays;

public class Sort {

	private static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					swap(a, j, j - 1);
				}
			}
		}
	}

	private static void quickSort(int[] a, int left, int right) {
		if (left > right)
			return;

		int i = left, j = right, temp = a[left];

		while (i < j) {
			while (a[j] > temp && i < j)
				j--;
			a[i] = a[j];

			while (a[i] < temp && i < j)
				i++;
			a[j] = a[i];
		}
		a[i] = temp;

		quickSort(a, left, i - 1);
		quickSort(a, i + 1, right);
	}

	private static void swap(int[] arr, int a, int b) {
		arr[a] ^= arr[b];
		arr[b] ^= arr[a];
		arr[a] ^= arr[b];
	}

	public static void main(String[] args) {
		int[] a = { 4, 6, 2, 8, 1, 5, 9, 3, 7 };
		int[] b = { 4, 6, 2, 8, 1, 5, 9, 3, 7 };

		System.out.println("------ Bubble Sort ------");
		System.out.println("Before: " + Arrays.toString(a));
		bubbleSort(a);
		System.out.println("After: " + Arrays.toString(a));

		System.out.println("------ Quick Sort ------");
		System.out.println("Before: " + Arrays.toString(b));
		quickSort(b, 0, b.length - 1);
		System.out.println("After: " + Arrays.toString(b));
	}
}
