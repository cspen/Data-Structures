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

	/**
 	 * Overriding the hashcode method from the Object class.
	 */
	@Override
	public boolean equals(Object object) {
		return false;
	}

	/**
	 * Overriding the hashcode method from the Object class.
	 */
	@Override
	public int hashCode() {
		return 0;
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
	 * Overriding the iterator method from the AbstractCollection class.
	 */
	@Override
	public Iterator iterator() {
		return null;
	}




	private Object value;
	private Tree parent;
	private Tree left;
	private Tree right;
	private int size;
}