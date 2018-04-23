import java.util.*;

/**
 * A classic tree data structure with the added
 * functionality of the Java Collection Framework.
 *
 */

public class Tree extends AbstractCollection {

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
	 * Overriding the add method from the AbstractCollection class.
	 * Required to make this Tree modifiable.
	 */
	public boolean add(Object e) {
		System.out.println("My Method Called");
		return true;
	}

	/**
	 * Overriding the size method from the AbstractCollection class.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Implementing the iterator method from the AbstractCollection class.
	 */
	@Override
	public Iterator iterator() {
		return null;
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


	// Components
	private Object data;
	private Tree parent;
	private Tree left;
	private Tree right;
	private int size;
}