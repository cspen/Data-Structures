import java.util.*;

public class ArrayQueue extends AbstractQueue {

	private Object[] objects;
	private int front = 0;
	private int back = 0;
	private int capacity = 16;

	public ArrayQueue() {
		objects = new Object[capacity];
	}

	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		objects = new Object[capacity];
	}

	public Object enqueue(Object object) {
		if(back >= capacity) {
			Object[] temp = objects;
			capacity *= 2;
			objects = new Object[capacity];
			for(int i = 0; i < size(); i++) 
				objects[i] = temp[i+front];
			back -= front;	
			front = 0;
		}
		objects[back++] = object;
		return object;		
	}

	public Object dequeue() {
		if(!isEmpty())
			throw new NoSuchElementException("Queue Empty");
		Object x = objects[front++];
		if(2*front >= capacity) {
			for(int i = 0; i < size(); i++)
				objects[i] = objects[i+front];
			back -= front;
			front = 0;
		}
		return x;		
	}

	public Object getFront() {
		if(!isEmpty())
			throw new NoSuchElementException("Queue Empty");
		return objects[front];
	}

	public Object getBack() {
		if(!isEmpty())
			throw new NoSuchElementException("Queue Empty");
		return objects[back-1];
	}

	public int size() {
		return back - front;
	}

	public Iterator iterator() {
		return new Iterator() {
			private int cursor = -1;
			public boolean hasNext() {
				return cursor < back;
			}
			public Object next() {
				if(cursor >= back)
					throw new NoSuchElementException();
				return objects[cursor++];
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}