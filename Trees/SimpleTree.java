/**
 *
 *
 */


public class SimpleTree {

	private Node root;

	/**
	 * Create a new empty tree.
	 */
	public SimpleTree() {
		root = null;
	}

	/**
	 * Insert the specified value
	 * into this tree.
	 */
	public void insert(int value) {
		if(root != null) {
			insert(root, value);
		} else {
			root = new Node(value);
		}
	}

	private void insert(Node node, int value) {
		if(value < node.value) {

			if(node.left != null) {
				insert(node.left, value);
			} else {
				node.left = new Node(value);
			} 

		} else if(value > node.value) {

			if(node.right != null) {
				insert(node.right, value);
			} else {
				node.right = new Node(value);
			}
		} else {
			// Do nothing - value already in tree
		}
	}

	/**
	 * Delete the specified value from this
	 * tree.
	 */
	public void delete(int value) {
		// Algorithm not in book
	}

	/**
	 * Print the tree node values
	 * in preorder traversal.
	 */
	public void printInOrder() {
		if(root != null) {
			printInOrder(root);
		} else {
			System.out.println("Empty");
		}
	}

	private void printInOrder(Node node) {
		if(node != null) {
			printInOrder(node.left);
			System.out.println(node.value);
			printInOrder(node.right);
		}
	}

	/**
	 * Print the tree node values
	 * in preorder traversal.
	 */
	public void printPreOrder() {
		if(root != null) {
			printPreOrder(root);
		} else {
			System.out.println("Empty");
		}
	}

	private void printPreOrder(Node node) {
		if(node == null) 
			return;

		System.out.println(node.value);
		printPreOrder(node.left);
		printPreOrder(node.right);
			
	}

	/**
	 * Print the tree node values
	 * in preorder traversal.
	 */
	public void printPostOrder() {
		if(root != null) {
			printPostOrder(root);
		} else {
			System.out.println("Empty");
		}
	}

	private void printPostOrder(Node node) {
		if(node == null)
			return;

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.value);
	}

	/**
	 * Fetch the height of this tree.
	 */
	public int height() {
		return height(root);
	}

	public int height(Node node) {

		// No height
		if(node == null)
			return -1;

		int leftHeight;
		int rightHeight;

		// Get left height
		if(node.left == null)
			leftHeight = -1;
		else
			leftHeight = height(node.left);


		// Get right height
		if(node.right == null)
			rightHeight = -1;
		else
			rightHeight = height(node.right);

		// Determine which is higher - left or right
		int result;
		if(leftHeight < rightHeight) 
			result =  1 + rightHeight;
		else
			result = 1 + leftHeight;

		return result;
	}

	/**
	 * Fetch the number of nodes
	 * in this tree.
	 */
	public int size() {
		if(root != null)
			return size(root);

		return 0;		
	}

	private int size(Node node) {
		int size = 0;
		if(node != null) {
			size = 1 + size(node.left) + size(node.right);
		}

		return size;
	}

/////////////////////////////// Inner class definition

	/**
	 * The node of a tree.
	 */
	private class Node {

		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}		
	}
}