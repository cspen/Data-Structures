/**
 * SimpleTree.java - implementation of a tree data structure with basi functionality.
 *
 * @author Craig Spencer
 * 
 *
 */
import java.util.*;

public class SimpleTree {

	private Node root;

	/**
	 * Create a new empty tree.
	 */
	public SimpleTree() {
		root = null;
	}

	/**
	 * Create a SimpleTree from a sorted
	 * integer array.
	 *
	 * My Google interviewer asked the following question:
	 * Given a sorted integer array, write a method that
	 * converts it into a binary serach tree.
	 */
	public SimpleTree(int[] a) {
		if(a.length == 0)
			return;

		root = buildTree(a);		
	}

	private Node buildTree(int[] a) {
		if(a.length <= 0)
			return null;

		if(a.length == 1) {
			return new Node(a[0]);
		} else {
			int i = (int)(a.length/2);
			Node n = new Node(a[i]);
			n.left = buildTree(Arrays.copyOfRange(a, 0, i));
			n.right = buildTree(Arrays.copyOfRange(a, i+1, a.length));
			return n;
		}
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
		// To do
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
	 * Breadth-first (level order) traversal.
	 */
	public void breadthFirst() {
		ArrayQueue q = new ArrayQueue();
		

		System.out.print(root);q.enqueue(root);
		while(q.size() > 0) {
			Node node = (Node)q.dequeue();
			System.out.println();

			if(node.left != null) {
				q.enqueue(node.left);
				System.out.print(node.left);
			}			
			if(node.right != null) {
				q.enqueue(node.right);
				System.out.print(node.right);
			}
		}
	}

	/**
	 *
	 */
	public void printLevelOrder() {
		ArrayQueue q1 = new ArrayQueue();
		ArrayQueue q2 = new ArrayQueue();
		q1.enqueue(root);

		while((q1.size() > 0) || (q2.size() > 0)) { 
			while(q1.size() > 0) { 
				Node node = (Node)q1.dequeue();
				if(node.left != null) {
					q2.enqueue(node.left);
				}
				if(node.right != null) {
					q2.enqueue(node.right);
				}
				System.out.print(node + " ");
			}
			System.out.println();
			while(q2.size() > 0) {
				Node node = (Node)q2.dequeue();
				if(node.left != null) {
					q1.enqueue(node.left);
				}
				if(node.right != null) {
					q1.enqueue(node.right);
				}
				System.out.print(node + " ");
			}
			System.out.println();
		}
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

	/**
	 * Fetch the root value for this tree.
	 */
	public int root() {
		return this.root.value;
	}
	
	/**
	 * Remove all nodes leaving only the root.
	 */
	public void defoliate() { 
		root.defoliate();
	}

	/**
	 * Fetch the greatest value in this tree.
	 */
	public int max() {
		return root.max();
	}

	/**
	 * Fetch the smallest value in this tree.
	 */
	public int min() {
		return root.min();
	}

	public void reflect() {
		if(this == null) return;
		if(left != null) left.reflect();
		if(right != null) right.reflect();
		BinaryTree temp = left;
		left = right;
		right = temp;
	}


/////////////////////////////// Inner class definition

	/**
	 * The node of a tree.
	 */
	private class Node {

		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}

		public String toString() {
			return "" + value;
		}

		void defoliate() {
			if(left != null) {
				if(left.left == null  && left.right == null) {
					left = null;
				} else {
					if(left.left != null) {
						left.left.defoliate();
					}						
					if(left.right != null) {
						left.right.defoliate();
					}
					left = null;
				}
			}
			if(right != null) {
				if(right.left == null && right.right == null) {
					right = null;
				} else { 
					if(right.left != null) {
						right.left.defoliate();
					}
					if(right.right != null) {
						right.right.defoliate();
					}
					right = null; 
				}
			}		
		}

		int min() { 
        		if (this.left == null)
				return this.value; 
       			else
                		return this.left.min(); 
   		} 

    		int max() { 
        		if (this.right == null)
				return this.value; 
        		else
		        	return this.right.max(); 
    		}	
	}
}