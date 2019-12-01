import java.util.*;

public class Selection {

	public static void main(String[] args) {
		int[] a = new int[20];
		randomFill(a);
		System.out.println(Arrays.toString(a));
		selection(a);
		System.out.println(Arrays.toString(a));
	}

	public static void selection(int[] a) {
		
		for(int i = 0; i < a.length; i++) {
			int min = i;
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[min])
					min = j;
			}
			if(min != i) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		} 
		
	}

	public static void randomFill(int[] a) {
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 100 + 1);
		}
	}

	

}