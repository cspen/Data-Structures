/**
 * Standard linked list.
 *
 * @author Craig Spencer <craigspencer@modintro.com>
 *
 */

public class LinkedList {

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Need to add basic functionality

	public void add(Object obj) {
		if(this.head != null) {
			this.head = new ListNode(obj);
			this.tail = this.head;
		} else {
			this.tail.next = new ListNode(obj);
			this.tail = this.tail.next;
		}
	}
		

	private static class ListNode {
		ListNode() {
			this.data = null;
			this.next = null;
		}

		ListNode(Object data, ListNode next) {
			this.data = data;
			this.next = next;
		}

		ListNode(Object data) {
			this(data, null);
		}

		private ListNode next;
		private Object data;
	}

	private ListNode head;
	private ListNode tail;
}
