package lecture08;

import gnu.jel.CompilationException;
import inf.math.UserFunction;

public class Exceptions2DemoProgram {

	public static void main(String[] args) {
		try {
			UserFunction f = new UserFunction("sos(x)", "x");
			System.out.println("f(1.0) = "+f.valueAt(1.0));
		
		} catch (CompilationException e) {
			System.out.println("Expression failed to compile");
		}
	}
}
