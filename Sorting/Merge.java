import java.util.*;

public class TestMerge {

	public static void main(String[] args) {

		int[] a = new int[10];
		for(int i = 0; i < a.length; i++)
			a[i] = (int)(Math.random()*100);

		System.out.println(Arrays.toString(a));
		System.out.println("Merge sorting...");
		mergeSort(a);
		System.out.println("Finished sorting...");
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(int[] a) {
		if(a.length > 1) mergeSort(a, 0, a.length);
	}

	public static void mergeSort(int[] a, int start, int end) {
		if( end-start < 2) return;

		int mid = (end-start)/2;
		mergeSort(a, start, start+mid);
		mergeSort(a, start+mid, end);
		merge(a, start, end);
	}

	public static void merge(int[] a, int start, int end) {
		int[] temp = new int[end];

		int i = 0;
		int lo = start;
		int hi = (end+start)/2;

		while(lo < (end+start)/2 && hi < end) {
			if(a[lo] <= a[hi])
				temp[i++] = a[lo++];
			else
				temp[i++] = a[hi++];
		}

		while(lo < (end+start)/2 && lo < temp.length)
			temp[i++] = a[lo++];
		while(hi < end)
			temp[i++] = a[hi++];
		for(i = start; i < end; i++)
			a[i] = temp[i-start];
	}

}