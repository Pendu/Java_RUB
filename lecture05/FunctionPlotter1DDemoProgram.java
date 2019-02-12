package lecture05;

import inf.v3d.view.Viewer;

public class FunctionPlotter1DDemoProgram {	
	
	public static void main(String[] args) {		

		UserFunction f = new UserFunction("sin(1/(2*x+0.01))", "x");	
		Viewer v = new Viewer();		

		FunctionPlotter1D fp = new FunctionPlotter1D(0, 5, f);
		
		fp.plot(v);		
		v.setVisible(true);	
	}
}
