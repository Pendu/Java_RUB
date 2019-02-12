package lecture12;

public class ElementDemoProgram {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Element e1 = new Element(10, n1, n2);
		Element e2 = new Element(11, n1, n3);
		
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(e1);
		System.out.println(e2);
	}
}
