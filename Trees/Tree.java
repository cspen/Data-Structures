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


	// Components
	private Object data;
	private Tree parent;
	private Tree left;
	private Tree right;
	private int size;
}