import java.util.*;

public abstract class AbstractQueue extends AbstractCollection implements Queue {

	protected AbstractQueue() {}

	public boolean equals(Object object) {
		if(object == this) return true;
		if(!(object instanceof AbstractQueue)) return false;
		AbstractQueue abstractQueue = (AbstractQueue)object;
		if(abstractQueue.size() != size()) return false;
		return containsAll(abstractQueue);
	}

	public int hashCode() {
		int n = 0;
		for(Iterator it = iterator(); it.hasNext(); ) {
			Object x = it.next();
			if(x != null) n += x.hashCode();
		}
		return n;
	}

	public abstract int size();
	public abstract Iterator iterator();
	public abstract Object enqueue(Object object);
	public abstract Object dequeue();
	public abstract Object getFront();
	public abstract Object getBack();
}
