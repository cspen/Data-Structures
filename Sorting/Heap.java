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
			heapify(a, a.length, i);
		for(int i = a.length - 1; i > 0; i--) {
			swap(a, 0, i);
			heapify(a, 0, i-1);
		}
	}

	public static void heapify(int[] a, int n, int i) {
		 int t = a[i];
		// System.out.println("n: "+n+" i: "+i);
		while(2*i+1 < n) {
			System.out.println(a[i]);
			int k = 2*i+2;

			if(k < n && a[k] > t)
				k++;

			if(t >= a[k]) break;
			
			a[i] = a[k];
			a[k] = t;
			i = k;		

		        heapify(a, n, t);
		}
			/*
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;

		// if left child is larger than root
		if (l < n && a[l] > a[largest])
        		largest = l;
 
    		// if right child is larger than largest so far
    		if (r < n && a[r] > a[largest])
        		largest = r;
 
    		// if largest is not root
    		if (largest != i) {
        		swap(a, i, largest);
 
        		// recursively heapify the affected sub-tree
        		heapify(a, n, largest);
    		}
		System.out.println("WTF");
		*/
	}

	public static void swap(int[] a, int i, int j) {
		
		if(i == j || a.length < 2) return;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}