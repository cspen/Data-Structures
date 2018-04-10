public class TreeTest2 {

	public static void main(String[] args) {

		
		SimpleTree st1 = new SimpleTree();
		SimpleTree st2 = new SimpleTree();

		st1.insert(5);
		st1.insert(4);
		st1.insert(6);

		st2.insert(5);
		st2.insert(4);
		st2.insert(3);

		/* Testing equals method
		System.out.println(st1.equals(st2));
		System.out.println(st2.equals(st1));
		*/


		/* Test merge method */
		System.out.println("Level Order...*");
		st1.printLevelOrder();

		st1.merge(st2);

		System.out.println("Level Order...*");
		st1.printLevelOrder();


	}
}