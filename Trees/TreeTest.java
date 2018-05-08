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

		java.util.Iterator it = tree3.iterator();
		while(it.hasNext()) {
			System.out.println("Next node: " + it.next());
		}
		
	}
}