package lecture06;

import gnu.jel.CompilationException;
import gnu.jel.CompiledExpression;
import gnu.jel.DVMap;
import gnu.jel.Evaluator;
import gnu.jel.Library;

import java.util.HashMap;
import java.util.Map;

/**
 * The <code>UserFunction</code> class that is used to evaluate functions
 * defined by a string. It is just a simple wrapper around classes from the
 * gnu-jel package.
 * <p>
 * Example:
 * 
 * <pre>
 * UserFunction f = new UserFunction(&quot;sin(PI * x) + pow(y, 3)&quot;, &quot;x&quot;, &quot;y&quot;);
 * System.out.println(f.valueAt(0.5, 2));
 * </pre>
 * 
 * The first line constructs a function f(x,y) = sin(PI * x) + y^3 while the
 * second line computes the function value f(0.5, 2) and prints it out. Note
 * that you can use all methods and constants defined in the
 * {@link java.lang.Math} class.
 * 
 * @author Matthias Baitsch
 */
public class UserFunction {

	/**
	 * For internal use only.
	 */
	public static class ValueProvider extends DVMap {

		private double[] values_;
		private Map<String, Integer> variableNames_ = new HashMap<String, Integer>();

		public void addVariable(int idx, String name) {
			variableNames_.put(name, idx);
		}

		public double getDoubleProperty(String name) {
			return values_[variableNames_.get(name)];
		}

		@Override
		public String getTypeName(String name) {
			if (variableNames_.containsKey(name)) {
				return "Double";
			}
			return null;
		}

		public void setValue(int idx, double value) {
			if (values_ == null) {
				values_ = new double[variableNames_.size()];
			}
			values_[idx] = value;
		}

		public int countVariables() {
			return variableNames_.size();
		}
	}

	private CompiledExpression expression_;
	private ValueProvider valueProvider_ = new ValueProvider();
	private String expressions_;

	/**
	 * Constructs a user defined function.
	 * 
	 * @param expression
	 *            A mathematical expression involving zero or more variables.
	 *            The expression has to conform to Java syntax; all methods and
	 *            constants defined in the <code>java.lang.Math</code> class are
	 *            available.
	 * @param variables
	 *            An array of variable names used in the expression. Each
	 *            variable that appears in the expression must be listed here.
	 * @throws CompilationException
	 *             if the expression contains errors or unknown variables.
	 */
	@SuppressWarnings("rawtypes")
	public UserFunction(String expression, String... variables) {
		try {
		Class[] staticLib = new Class[] { java.lang.Math.class };
		Class[] dynlib = new Class[] { ValueProvider.class };
		Library lib = new Library(staticLib, dynlib, null, valueProvider_, null);

		for (int i = 0; i < variables.length; i++) {
			valueProvider_.addVariable(i, variables[i]);
		}
		expressions_ = expression;
		expression_ = Evaluator.compile("(double)(" + expression + ")", lib);
		} catch(CompilationException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * Evaluates the expression for the specified set of variables.
	 * 
	 * @param x
	 *            the variable list. Vales are assigned in the sequence given in
	 *            the constructor. Esample: If in the constructor, the variables
	 *            where x and y and the arguments are [9,1] then the expression
	 *            is evaluated for x=9 and y=1;
	 * @return the function value
	 */
	public double valueAt(double... x) {
		if (x.length != valueProvider_.countVariables()) {
			throw new IllegalArgumentException("Illegal number of arguments: "
					+ x.length);
		}
		try {
			for (int i = 0; i < x.length; i++) {
				valueProvider_.setValue(i, x[i]);
			}
			return expression_.evaluate_double(new Object[] { valueProvider_ });
		} catch (Throwable e) {
			throw new Error(e);
		}
	}

	public String getExpression() {
		return expressions_;
	}
}
