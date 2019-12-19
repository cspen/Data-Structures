import java.util.*;

public class TestQuick {

	public static void main(String[] args) {

		int[] a = new int[10];
		for(int i = 0; i < a.length; i++)
			a[i] = (int)(Math.random()*100);

		System.out.println(Arrays.toString(a));
		System.out.println("Selection sorting...");
		quickSort(a);
		System.out.println("Finished sorting");
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int[] a) {
		if(a.length > 1) quickSort(a, 0, a.length);		
	}

	public static void quickSort(int[] a, int k, int n) {
		if(n < 2) return;

		int pivot = a[k];
		int i = k;
		int j = k+n;
		while(i < j) {
			while(i+1 < k+n && a[++i] < pivot);
			while(a[--j] > pivot);
			if(i < j) swap(a, j, i);
		}
		swap(a, j, k);
		quickSort(a, k, j-k);
		quickSort(a, j+1, k+n-j-1);
	}

	public static void swap(int[] a, int i, int j) {
		if(i == j || a.length < 2) return;

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}