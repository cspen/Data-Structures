public class TreeTest {

	public static void main(String[] args) {
		TreeTest tt = new TreeTest();
		tt.run();
	}	

	public void run() {
		Tree tree1 = new Tree("Tree One");
		Tree tree2 = new Tree("Tree Two");
		Tree tree3 = new Tree("Tree Three", tree1, tree2);
		Tree tree4 = new Tree("Tree Three", tree1, tree2);
		Tree tree5 = new Tree("Tree Three", tree2, tree1);
		Tree tree6 = new Tree("Tree Four", tree1, tree2);

		Tree.printInOrder(tree3);
		Tree.printInOrder(null);

		System.out.println("Size = " + tree3.size());
		/*
		// Test equals method
		// The Java language requires two equal objects to also
		// have equal hash codes.
		System.out.println("Tree4 equals Tree3: " + tree3.equals(tree4));
		System.out.println("Tree3 hashcode: " + tree3.hashCode());
		System.out.println("Tree4 HashCode: " + tree4.hashCode());
		System.out.println();

		System.out.println("Tree5 equals Tree3: " + tree3.equals(tree5));
		System.out.println("Tree3 hashcode: " + tree3.hashCode());
		System.out.println("Tree5 HashCode: " + tree5.hashCode());
		System.out.println();

		System.out.println("Tree6 equals Tree3: " + tree3.equals(tree6));
		System.out.println("Tree3 hashcode: " + tree3.hashCode());
		System.out.println("Tree6 HashCode: " + tree6.hashCode());
		System.out.println();

		System.out.println("Tree5 equals Tree6: " + tree5.equals(tree6));
		System.out.println("Tree5 hashcode: " + tree5.hashCode());
		System.out.println("Tree6 HashCode: " + tree6.hashCode());
		System.out.println();

		System.out.println("Tree3 equals Tree3: " + tree3.equals(tree3));
		System.out.println("Tree3 hashcode: " + tree3.hashCode());
		System.out.println("Tree3 HashCode: " + tree3.hashCode());
		System.out.println();

		System.out.println("Tree4 equals Tree3: " + tree3.equals(tree4));
		System.out.println("Tree3 hashcode: " + tree3.hashCode());
		System.out.println("Tree4 HashCode: " + tree4.hashCode());
		System.out.println();

		// Test the iterator
		java.util.Iterator it = tree3.iterator();
		while(it.hasNext()) {
			System.out.println("Next node: " + it.next());
		}
		System.out.println("\n\n\n");

		// Test invert function
		System.out.println("Creating tree7...");
		Tree treeA = new Tree("One");
		Tree treeB = new Tree("Two");
		Tree treeC = new Tree("Three", treeA, treeB);
		Tree treeD = new Tree("Four");
		Tree treeE = new Tree("Five");
		Tree treeF = new Tree("Six", treeD, treeE);
		Tree tree7 = new Tree("Seven", treeC, treeF);

		System.out.println("Inverting...");
		Tree.printInOrder(tree7);
		System.out.println();
		Tree.invert(tree7);
		Tree.printInOrder(tree7);
		System.out.println();

		// Test defoliate function
		System.out.println("Defoliating...");
		Tree.printInOrder(tree7);
		System.out.println();
		Tree.defoliate(tree7);
		Tree.printInOrder(tree7);
		System.out.println();

		// Test the equals(Tree, Tree) function
		System.out.println("Testing equals function...");
		System.out.println("Equals(T3, T4): " + Tree.equals(tree3, tree4));
		System.out.println("Equals(T3, T5): " + Tree.equals(tree3, tree5));
		System.out.println("Equals(null, null): " + Tree.equals(null, null));
		System.out.println("Equals(T3, null): " + Tree.equals(tree3, null));
		System.out.println("Equals(T3, T5): " + Tree.equals(tree3, tree5));
		*/

		// Test the 
	}
}