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

	public void printPreOrder(Tree root) {
		if(root != null) {
			System.out.println(root.data);
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	public static void printInOrder(Tree root) {
		if(root != null) {
			printInOrder(root.left);
			System.out.println(root.data);
			printInOrder(root.right);
		} 
	}

	public void printPostOrder(Tree root) {
		if(root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.println(root.data);
		}
	}

	public void printLevelOrder(Tree root) {

	}

	public void printbreadthFirst() {

	}

	public void printDepthFirst() {

	}

	public int height(Tree root) {
		return 0;
	}

	// Returns the min value of BST
	public Object min() {
		if(this.left == null) return this.data;
		return this.left.min();
	}

	// Return the max value of BST
	public Object max(Tree root) {
		if(this.right == null) return this.data;
		return this.right.max();
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

	public boolean isBinarySearchTree(Tree root) {
		return false;
	}

	public static boolean equals(Tree root1, Tree root2) {
		return false;
	}

	public int level(Object object) {
		return 0;
	}

	// Diameter of a tree is the longest path between two leaf nodes in a tree.
	public int diameter(Tree root) {
		return 0;
	}

	public void createTreePreOrder(Object[] a) {
	}

	public void createTreeInOrder(Object[] a) {
	}

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