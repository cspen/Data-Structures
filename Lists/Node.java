

public class Node {

	public Node() {
		this.nextNode = null;
		this.data = null;
	}

	public Node(Node next, Object data) {
		this.data = data;
		this.nextNode = next;
	}

	private Node nextNode;
	private Object data;
}