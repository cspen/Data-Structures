import java.util.*;

public class Insertion {

	public static void main(String[] args) {
		int[] theArr = new int[20];
		System.out.println(Arrays.toString(theArr));
		randomFill(theArr);
		System.out.println(Arrays.toString(theArr));
		insertionSort(theArr);
		System.out.println(Arrays.toString(theArr));
	}

	public static void insertionSort(int[] a) {
		int i = 0;
		while(i < a.length) {
			int j = i;
			while(j > 0 && a[j-1] > a[j]) {
				swap(a, j-1, j);
				j--;
			}
			i++;
		}
	}

	public static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public static void randomFill(int[] a) {
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 100 + 1);
		}
	}
}