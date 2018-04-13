public class TreeTest2 {

	public static void main(String[] args) {

		
		SimpleTree st1 = new SimpleTree();
		SimpleTree st2 = new SimpleTree();

		st1.insert(5);
		/* st1.insert(4);
		st1.insert(3);
		st1.insert(9);
		st1.insert(0); */

		st2.insert(5);
		/* st2.insert(4);
		st2.insert(7); */

		/* Testing equals method
		System.out.println(st1.equals(st2));
		System.out.println(st2.equals(st1));
		*/


		/* Test merge method */
		System.out.println("Level Order...First Tree*");
		st1.printLevelOrder();
		System.out.println("\nLevel Order...Second Tree*");
		st2.printLevelOrder();


		System.out.println("\nMerging...");
		st1.merge(st2);

		System.out.println("\nLevel Order...*");
		st1.printLevelOrder();


	}
}