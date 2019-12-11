import java.util.*;

public class Heap {

	public static void main(String[] args) {

		int[] a = new int[5];
		// for(int i = 0; i < a.length; i++)
		// 	a[i] = (int)(Math.random()*100);
		a[0] = 54;
		a[1] = 19;
		a[2] = 91;
		a[3] = 29;
		a[4] = 4;
		System.out.println(Arrays.toString(a));
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void heapSort(int[] a) {
		for(int i = a.length/2 - 1; i >= 0; i--)
			heapify(a, a.length-1, i);
		for(int i = a.length - 1; i >= 0; i--) {
			swap(a, 0, i);
			heapify(a, 0, i);
		}
	}

	public static void heapify(int[] a, int i, int n) {
		int temp = a[i];
		while(2*i+1 < n) {
			int k = 2*i+1;

			if(k < n && a[k] > a[i]) ++k;

			if(temp >= a[k]) break;

			a[i] = a[k];
			a[k] = temp;
			i = k;

		        heapify(a, 0, temp);
		}
	}

	public static void swap(int[] a, int i, int j) {
		
		if(i == j || a.length < 2) return;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}