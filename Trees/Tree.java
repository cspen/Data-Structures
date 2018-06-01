import java.util.*;

/**
 * A classic tree data structure
 *
 */

public class Tree {

	/**
	 * Construct a Tree with the specified root value.
	 */
	public Tree(Object data) {
		this.data = data;
		size = 1;
	}

	/**
	 * Construct a Tree with the specified root value
	 * and the specified left and right subtrees.
	 */
	public Tree(Object data, Tree left, Tree right) {
		this(data);
		if(left != null) {
			this.left = left;
			left.parent = this;
			size += left.size();
		}
		if(right != null) {
			this.right = right;
			right.parent = this;
			size += right.size();
		}
	}

	/**
	 * Convert a integer array to a tree. If the array is sorted it
	 * will be converted to a binary search tree.
	 *
	 * Google Interview Question: Given a sorted integer array, write
	 * a method that converts it to a binary search tree.
	 */
	public Tree(int[] a) {
		
	}

	/**
 	 * Overriding the equals method from the Object class.
	 *
	 */
	@Override
	public boolean equals(Object object) {
		if(object == this) return true;
		if(!(object instanceof Tree)) return false;

		Tree tree = (Tree)object;
		boolean b = tree.data.equals(data);
		if(tree.left != null) b = (b && tree.left.equals(left));
		if(tree.right != null) b = (b && tree.right.equals(right));
		if(tree.parent != null) b = (b && tree.parent.equals(parent));
		b = (b && tree.size() == size);
		return b;
	}

	/**
	 * Overriding the hashcode method from the Object class.
	 */
	@Override
	public int hashCode() {
		int hash = data.hashCode() + size;
		if(left != null) hash += left.hashCode();
		if(right != null) hash += right.hashCode();
		return hash;
	}

	/**
	 * The number of nodes in this tree.
	 */
	public int size() {
		return size;
	}

	/**
	 * Iterator for this tree.
	 */
	public Iterator iterator() {
		return new abstractTreeIterator() {
			
			public Object next() {
				if(!rootDone) {
					if(left != null) lit = left.iterator();
					if(right != null) rit = right.iterator();
					rootDone = true;
					return data;
				}

				if(lit != null && lit.hasNext())
					return lit.next();
				if(rit != null && rit.hasNext())
					return rit.next();
				return null;
			}
		};
	} 

	/**
	 * Partial abstractTreeIterator implementation.
	 */
	abstract public class abstractTreeIterator implements java.util.Iterator {
		protected boolean rootDone;
		protected Iterator lit, rit;

		public boolean hasNext() {
			return (!rootDone || lit != null && lit.hasNext() || rit != null && rit.hasNext());
		}

		abstract public Object next();

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// Max Howell's question from Google
	// AKA reflect, reverse
	public static void invert(Tree root) {
		if(root == null) return;
		if(root.left != null) invert(root.left);
		if(root.right != null) invert(root.right);
		Tree temp = root.right;
		root.right = root.left;
		root.left = temp;
	}

	
	public static void defoliate(Tree root) {
		if(root == null) return;
		if(root.left != null) {
			if(root.left.left == null && root.left.right == null) {
				root.left = null;
			} else {
				Tree.defoliate(root.left);
			}
		}
		if(root.right != null) {
			if(root.right.left == null && root.right.right == null) {
				root.right = null;
			} else {
				Tree.defoliate(root.right);
			}
		}
		if(root.left == null && root.right == null) {
			root.data = null;
		}
		
	}

	public void insert(Tree node) {
		
	}

	public void remove(Tree node) {
	
	}

	public Tree find(Object data) {
		return null;
	}

	// A depth first traversal
	// Root - Left - Right
	public void printPreOrder(Tree root) {
		if(root != null) {
			System.out.println(root.data);
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	// A depth first traversal
	// Left - Root - Right
	public static void printInOrder(Tree root) {
		if(root != null) {
			printInOrder(root.left);
			System.out.println(root.data);
			printInOrder(root.right);
		} 
	}

	// A depth first traversal
	// Left - Right - Root
	public void printPostOrder(Tree root) {
		if(root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.println(root.data);
		}
	}

	// Breadth first traversal
	public void printLevelOrder(Tree root) {

	}

	public int height(Tree root) {
		return 0;
	}

	// Returns the min value of BST
	public static Object min(Tree root) {
		if(root == null) return null;
		if(root.left == null) return root.data;
		return Tree.min(root.left);
	}

	// Return the max value of BST
	public static Object max(Tree root) {
		if(root.right == null) return root.data;
		return Tree.max(root.right);
	}

	// Number of leaves on the specified tree
	public static int leaves(Tree root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;

		int leftLeaves = 0;
		int rightLeaves = 0;
		if(root.left != null) leftLeaves = leaves(root.left);
		if(root.right != null) rightLeaves = leaves(root.right);
		return leftLeaves + rightLeaves;
	}

	// Only works for numeric values
	// For this to work with objects it will need a comparator
	/*
	public static boolean isBinarySearchTree(Tree root, int min, int max) {
		if(root == null) return true;
		if(root.left == null && root.right == null) return true;

		if (root.data < min) return false;
        	if (root.data > max) return false;
		return isBinarySearchTree(root.left, min, root.data) && isBinarySearchTree(root.right, root.data, max);	
	}
	*/

	public static boolean equals(Tree root1, Tree root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 == null && root2 != null) return false;
		if(root1 != null && root2 == null) return false;

		if(root1.left != null && root2 != null)
			return equals(root1.left, root2.left);
		if(root1.right != null && root2.right != null)
			return equals(root1.right, root2.right);
		if(root1.data.equals(root2.data))
			return true;
		return false;
	}
  
	public int level(Node root, Object object) {
		ArrayQueue q1 = new ArrayQueue();
		ArrayQueue q2 = new ArrayQueue();
		q1.enqueue(root);
		int level = 0;

		while((q1.size() > 0) || (q2.size() > 0)) { 
			while(q1.size() > 0) { 
				Node node = (Node)q1.dequeue();
				if(node.data.equals(object)) {
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
				if(node.data.equals(object)) {
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

	// Diameter of a tree is the longest path between two leaf nodes in a tree.
	public int diameter(Tree root) {
		return 0;
	}

	// Build a tree from the String array contents.
	// String array must consist of N's and L's (any case)
	// N stands for node and L stands for leaf
	public Tree createTreePreOrder(Object[] preorder, Object[] inorder, int start, int end) {
		
	}

	// See comments for createTreePreOrder
	public void createTreeInOrder(Object[] a) {
	}

	// See comments for createTreePreOrder
	public void createTreePostOrder(Object[] a) {
	}

	// A height-balanced binary tree is defined as a binary tree in which the depth of
	// the two subtrees of every node never differ by more than 1. 
	public boolean isHeightBalanced(Tree root) {
		return true;
	}

	// Cousin nodes: same level of the Binary Tree and have different parents
	public boolean cousinNodes(Tree root, Tree node1, Tree node2) {
		return true;
	}

	// This is also called zig-zag order traversal of a binary tree. Approach: To print the 
	// nodes in spiral order, nodes at different levels should be printed in alternating order. 
	public void recursiveSpiralOrderTraversal(Tree root) {
	}

	// Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree.
	// Print all the keys of tree in range k1 to k2. i.e. print all x such that  k1<=x<=k2 and 
	// x is a element of given BST.
	public void printRange(Tree root, Object k1, Object k2) {
	}


	public void recursiveLevelOrderTraversal(Tree root) {
	}


	

	


	// Components
	private Object data;
	private Tree parent;
	private Tree left;
	private Tree right;
	private int size;
}