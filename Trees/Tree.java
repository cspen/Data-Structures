/**
 * A classic tree data structure.
 *
 */

public class Tree {

	/**
	 * Construct a Tree with the specified root value.
	 */
	public Tree(Object value) {
		this.value = value;
	}

	/**
	 * Construct a Tree with the specified root value
	 * and the specified left and right subtrees.
	 */
	public Tree(Object value, Tree left, Tree right) {
		this(value);
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

	public int size() {
		return size;
	}

	



	private Object value;
	private Tree parent;
	private Tree left;
	private Tree right;
	private int size;
}