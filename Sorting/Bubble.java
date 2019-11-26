// Classic Bubble sort
import java.util.*;

public class Bubble {

	public static void main(String[] args) {
		int[] theArr = new int[20];
		System.out.println(Arrays.toString(theArr));
		randomFill(theArr);
		System.out.println(Arrays.toString(theArr));
		sort(theArr);
		System.out.println(Arrays.toString(theArr));
		System.out.println();
		specificFill(theArr);
		System.out.println(Arrays.toString(theArr));
		sort(theArr);
		System.out.println(Arrays.toString(theArr));
	}

	public static void sort(int[] a) {
		for(int i = 0; i < a.length-1; i++)
			for(int j = i+1; j < a.length; j++) {
				if(a[i] > a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
	}

	public static void randomFill(int[] a) {
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 100 + 1);
		}
	}

	public static void specificFill(int[] a) {
		int value = 200;
		for(int i = 0; i < a.length; i++) {
			a[i] = value;
			value -= 5;
		}
	}
}