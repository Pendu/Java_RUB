package lecture10;

import lecture09.Node;

public class LinkedListOfDoubles implements ListOfDoubles {

	private Node head = new Node(0, null);

	public void addFirst(double x) {
		Node n = new Node(x, this.head.getNext());
		this.head.setNext(n);
	}

	public void print(String l) {
		Node n = this.head.getNext();

		System.out.print(l + "<");
		while (n != null) {
			System.out.print(n.getValue() + " ");
			n = n.getNext();
		}
		System.out.println(">");
	}
}
