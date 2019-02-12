package lecture12;

import java.util.List;
import java.util.ArrayList;

public class Node {

	private int id;
	private List<Element> elements = new ArrayList<Element>();

	public Node(int id) {
		this.id = id;
	}

	public void addElement(Element e) {
		this.elements.add(e);
	}

	public int getId() { return this.id; }

	public String toString() {
		String s = "Node " + this.id + ". Elements: ";
		for (Element e : this.elements) {
			s += e.getId() + ", ";
		}
		return s.substring(0, s.length() - 2);
	}
}
