public class TreeTest {

	public static void main(String[] args) {
		TreeTest tt = new TreeTest();
		tt.run();
	}	

	public void run() {
		Tree tree1 = new Tree("Tree One");
		Tree tree2 = new Tree("Tree Two");
		Tree tree3 = new Tree("Tree Three", tree1, tree2);

		Tree.printInOrder(tree3);
		Tree.printInOrder(null);
	}
}