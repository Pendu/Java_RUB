package lecture13;

public class ClassWithInnerClass {

	public double getA() {
		return Math.random();
	}

	public void doSomething() {
		DoSomethingInterface ic = new DoSomethingInterface() {

			public void doSomething() {
				System.out.println("getA() returned: "
						+ getA());
			}
		};
		ic.doSomething();
	}
}
