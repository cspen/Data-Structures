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
 	 * Overriding the hashcode method from the Object class.
	 */
	@Override
	public boolean equals(Object object) {
		if(object == this)
			return true;
		if(!(object instanceof Tree))
			return false;
		Tree tree = (Tree)object;
		return (tree.data.equals(data) ||
			tree.left.equals(left) ||
			tree.right.equals(right) ||
			tree.parent.equals(parent) ||
			tree.size() == size);
	}

	/**
	 * Overriding the hashcode method from the Object class.
	 */
	@Override
	public int hashCode() {
		return data.hashCode() + left.hashCode() + right.hashCode() + size;
	}

	/**
	 * The size of this tree.
	 */
	public int size() {
		return size;
	}

	/**
	 * Iterator for this tree.
	 */
	public Iterator iterator() {
		return new java.util.Iterator() {
			private boolean rootDone;
			private Iterator lit, rit;

			public boolean hasNext() {
				return (!rootDone || lit != null && lit.hasNext() || rit != null && rit.hasNext());
			}

			
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
			
			public void remove()  {
				throw new UnsupportedOperationException();
			} 
		};
	} 

	/**
	 *
	 */
	abstract public class TreeIterator {
		protected boolean rootDone;
		protected TreeIterator lit, rit;

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
	public void invert(Tree root) {

	}

	public void defoliate(Tree root) {

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

	public Object min(Tree root) {
		return null;
	}

	public Object max(Tree root) {
		return null;
	}

	public int leaves(Tree root) {
		return 0;
	}

	public boolean isBinarySearchTree(Tree root) {
		return false;
	}

	public boolean equals(Tree root1, Tree root2) {
		return false;
	}

	public int level(Object object) {
		return 0;
	}

	// Diameter of a tree is the longest path between two leaf nodes in a tree.
	public int diameter(Tree root) {
		return 0;
	}

	// Components
	private Object data;
	private Tree parent;
	private Tree left;
	private Tree right;
	private int size;
}