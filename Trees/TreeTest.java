public class TreeTest {

	public static void main(String[] args) {
		TreeTest tt = new TreeTest();
		tt.run();
	}

	

	public void run() {
		SimpleTree st = new SimpleTree();
		System.out.println("Tree created...");

		st.insert(6); // st.printInOrder();System.out.println();

		System.out.println();
		// System.out.println("Height = " + st.height());

		st.insert(2);
		st.insert(1); st.printInOrder();System.out.println();
		st.insert(4);
		st.insert(3); st.printInOrder();System.out.println();
		
		// System.out.println();
		// System.out.println("Height = " + st.height());

		st.insert(5);
		st.insert(7);
		st.insert(9);
		st.insert(8);
		st.insert(10);
		st.insert(11);
		st.insert(12);

		/* System.out.println("Inorder...");
		st.printInOrder();
		System.out.println();
		System.out.println("Preorder....");
		st.printPreOrder();
		System.out.println();
		System.out.println("Postorder....");
		st.printPostOrder(); */

		System.out.println("Level Order...");
		st.printBreadthFirst();
		System.out.println();
/*
		System.out.println(); 
		System.out.println("Height = " + st.height());
		System.out.println("Size = " + st.size());

		System.out.println("Root = " + st.root());
		System.out.println("\nDefoliating...");
		st.defoliate();
		
		System.out.println("Height = " + st.height());
		System.out.println("Size = " + st.size());
*/
		// st.printInOrder();

	}
}