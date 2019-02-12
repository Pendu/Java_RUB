package lecture10;

public class ListOfDoublesDemoProgram {
	
	public static void main(String[] args) {
		
		ListOfDoubles l1 = new ArrayListOfDoubles();
		ListOfDoubles l2 = new LinkedListOfDoubles();

		l1.addFirst(1.1);
		l1.addFirst(6.2);
		l1.addFirst(9.4);
		l2.addFirst(1.1);
		l2.addFirst(6.2);
		l2.addFirst(9.4);
		l1.print("l1=");
		l2.print("l2=");
	}
}
