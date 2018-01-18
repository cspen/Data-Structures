import java.util.*;

public class BinaryTree extends AbstractCollection {

	private Object root;
	private BinaryTree left, right, parent;
	private int size;

	public BinaryTree() {}

	public BinaryTree(Object root) {
		this.root = root;
	}

	public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
		this(root);
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

	public boolean equals(Object object) {
		if(object == this) return true;
		if(!(object instanceof BinaryTree)) return false;
		BinaryTree tree = (BinaryTree)object;
		return (tree.root.equals(root) ||
			tree.left.equals(left) ||
			tree.right.equals(right) ||
			tree.parent.equals(parent) ||
			tree.size() == size);
	}

	public int hashCode() {
		return root.hashCode() + left.hashCode() + right.hashCode() + size;
	}

	public int size() { return size; }

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
					return root;
				}
				if(lit != null && lit.hasNext())
					return lit.next();
				if(rit != null && rit.hasNext())
					return rit.next();
				return null;
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

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

	public class PreOrder extends TreeIterator {
		public PreOrder() {
			if(left != null) lit = left.new PreOrder();
			if(right != null) rit = right.new PreOrder();
		}
		public Object next() {
			if(!rootDone) {
				rootDone = true;
				return root;
			}
			if(lit != null && lit.hasNext())
				return lit.next();
			if(rit != null && rit.hasNext())
				return rit.next();
			return null;
		}
	}

	public class InOrder extends TreeIterator {
		public InOrder() {
			if(left != null) lit = left.new InOrder();
			if(right != null) rit = right.new InOrder();
		}
		public Object next() {
			if(lit != null && lit.hasNext())
				return lit.next();
			if(!rootDone) {
				rootDone = true;
				return root;
			}
			if(rit != null && rit.hasNext())
				return rit.next();
			return null;
		}
	}

	public class PostOrder extends TreeIterator {
		public PostOrder() {
			if(left != null) lit = left.new PostOrder();
			if(right != null) rit = right.new PostOrder();
		}
		public Object next() {
			if(lit != null && lit.hasNext())
				return lit.next();
			if(rit != null && rit.hasNext())
				return rit.next();
			if(!rootDone) {
				rootDone = true;
				return root;
			}
			return null;
		}
	}


	public int leaves() {
		if(this == null) return 0;
		if(left == null && right == null) return 1;
		int leftLeaves = (left == null? 0: left.leaves());
		int rightLeaves = (right == null? 0: right.leaves());
		return leftLeaves + rightLeaves;
	}

	public int height() {
		if(this == null) return -1;
		int leftHeight = (left == null? -1:left.height());
		int rightHeight = (right == null? -1:right.height());
		return 1 + (leftHeight < rightHeight? rightHeight:leftHeight);
	}

	public int level(Object object) {
		if(this == null) return -1;
		if(object == root) return 0;
		int leftLevel = (left == null? -1: left.level(object));
		int rightLevel = (right == null? -1: right.level(object));
		return 1 + (leftLevel < rightLevel? rightLevel:leftLevel);
	}

	public void reflect() {
		if(this == null) return;
		if(left != null) left.reflect();
		if(right != null) right.reflect();
		BinaryTree temp = left;
		left = right;
		right = temp;
	}

	public void defoliate() { 
		if(this == null) return;		
		if(left == null && right == null) {
			root = null;
			return;
		}
		if(left != null) {
			if(left.left == null && left.right == null) 
				left = null;
			else
				left.defoliate();
		}
		if(right != null) {
			if(right.left != null && right.right != null)
				right = null;
			else
				right.defoliate();
		}		
	}

}