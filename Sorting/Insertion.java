

public class Insertion {

	public static void main(String[] args) {
		int i = 9;
		System.out.println(i);
		plusOne(i);
		System.out.println(i);
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
}