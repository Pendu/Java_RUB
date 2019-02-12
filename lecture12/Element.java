package lecture12;

public class Element {

	private int id;
	private Node n1;
	private Node n2;

	public Element(int id, Node n1, Node n2) {
		this.id = id;
		this.n1 = n1;
		this.n2 = n2;
		this.n1.addElement(this);
		this.n2.addElement(this);
	}

	public int getId() { return this.id; }

	public String toString() {
		return "Element " + this.id + ". Nodes: "
				+ this.n1.getId() + ", " + this.n2.getId();
	}
}
