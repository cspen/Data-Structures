
public class NodeTest {

	public static void main(String[] args) {
		Node head = new Node(50);
		createList(head, 20);
		printList(head);
	}

	public static void createList(Node head, int length) {
	 	int i = 0;
		Node n = head.next = new Node(i);
		while(i < length) {
			i++;
			n.next = new Node(i);
			n = n.next;		
		}
	}

	public static void printList(Node head) {
		while(head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}