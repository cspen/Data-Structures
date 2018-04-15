/**
 * SimpleTree.java - implementation of a tree data structure with basic functionality.
 * 
 * This is an encapsulated version of a tree. After I work out all the logic for this
 * tree I am going to build a node based tree.
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

	public SimpleTree.Node getRoot() {
		return this.root;
	}

	private SimpleTree.Node buildTree(int[] a) {
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
		if(root == null)
			return;

		// Algorithm
		// Find node - if it exists
		Node node = find(root, value);
		if(node == null) return;
		
		// Three cases:
		//	Node has no children
		//	Node has one child
		// 	Node has two children

	}

	// Helper function for remove function
	public SimpleTree.Node find(Node n, int value) {
		if(n == null) return null;
		if(n.value == value)
			return n;
		SimpleTree.Node ln = find(n.left, value);
		SimpleTree.Node rn = find(n.right, value);

		return (ln == null ? rn : ln);
		
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

	/**
	 * Horizontally reverse this SimpleTree.
	 */
	public void reflect() {
		root.reflect();
	}

	/**
	 * Fetch the level of the specified value.
	 */
	public int level(int n) {
		ArrayQueue q1 = new ArrayQueue();
		ArrayQueue q2 = new ArrayQueue();
		q1.enqueue(root);
		int level = 0;

		while((q1.size() > 0) || (q2.size() > 0)) { 
			while(q1.size() > 0) { 
				Node node = (Node)q1.dequeue();
				if(node.value == n) {
					return level;					
				}
				if(node.left != null) {
					q2.enqueue(node.left);
				}
				if(node.right != null) {
					q2.enqueue(node.right);
				}
				
			}
			level++;
			while(q2.size() > 0) {
				Node node = (Node)q2.dequeue();
				if(node.value == n) {
					return level;
				}
				if(node.left != null) {
					q1.enqueue(node.left);
				}
				if(node.right != null) {
					q1.enqueue(node.right);
				}
			}
			level++;
		}
		return -1;
	}

	public int leaves() {
		return root.leaves();
	}

	public boolean isBST() {
        	return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    	}

	private boolean isBST(Node x, int min, int max) {
        	if (x == null) return true;
        	if (x.value < min) return false;
        	if (x.value > max) return false;

        	return isBST(x.left, min, x.value) && isBST(x.right, x.value, max);
    	} 

	/**
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null && root == null) {
			return true;
		} else if(obj == null || root == null) {
			return false;
		}

		SimpleTree tree = (SimpleTree)obj;
		return equals(tree.root, root);
	}


	public boolean equals(Node a, Node b) {
		if (a == null && b == null)
       			return true;
             
       		if (a != null && b != null) 
        		return (a.value == b.value && equals(a.left, b.left)
               			&& equals(a.right, b.right));
  
        	return false;
	}

	/**
	 * Combine this SimpleTree with the 
	 * specified SimpleTree.
	 */
	public SimpleTree.Node merge(SimpleTree s) {
		if(s == null) {
			return this.root;
		}
		if(this.root == null) {
			this.root = s.getRoot();
			return this.root;
		}
		return root.merge(this.root, s.getRoot());
	}
	

/////////////////////////////// Inner class definition

	/**
	 * The node of a tree.
	 */
	class Node {

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

		public void reflect() {
			if(this == null) return;
			if(left != null) left.reflect();
			if(right != null) right.reflect();
			Node temp = left;
			left = right;
			right = temp;
		}

		public int leaves() {
			if(this == null) return 0;
			if(left == null && right == null) return 1;
			int leftLeaves = (left == null? 0: left.leaves());
			int rightLeaves = (right == null? 0: right.leaves());
			return leftLeaves + rightLeaves;
		}

		public SimpleTree.Node merge(SimpleTree.Node n1, SimpleTree.Node n2) {
			// I'm following an algorithm I found online but this next line is not what
			// I thought of merging a tree. I thought a merge would combine
			// the two by adding the values of one tree to the other as new nodes without creating
			// duplicates. I need to find out the true definition of merging trees.

			if(n1 != null && n2 != null) {
				n1.value += n2.value;
        			n1.left = merge(n1.left, n2.left);
       				n1.right = merge(n1.right, n2.right);
			} else {
				if(n1 == null) return n2;
				else return n1;
			}
        		return n1;
		}
			
	}
}