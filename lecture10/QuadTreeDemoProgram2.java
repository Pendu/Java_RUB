package lecture10;

import inf.v3d.view.Viewer;

public class QuadTreeDemoProgram2 {

	public static void main(String[] args) {

		QuadTree tree = new QuadTree(
				new Rectangle(-2.0, -2.0, 36.0, 36.0), 8);
				
	 	tree.addPoint(new Point( 0.0, 0.0));
		tree.addPoint(new Point( 0.0, 8.0));
		tree.addPoint(new Point( 4.0, 4.0));
		tree.addPoint(new Point( 8.0, 8.0));
		tree.addPoint(new Point( 8.0, 0.0));
		tree.addPoint(new Point(12.0, 0.0));
		tree.addPoint(new Point(12.0, 4.0));
		tree.addPoint(new Point(16.0, 4.0));
		tree.addPoint(new Point(16.0, 8.0));
		tree.addPoint(new Point(12.0, 8.0));
		tree.addPoint(new Point(12.0, 0.0));
		tree.addPoint(new Point(20.0, 0.0));
		tree.addPoint(new Point(20.0, 8.0));
		tree.addPoint(new Point(24.0, 8.0));
		tree.addPoint(new Point(20.0, 8.0));
		tree.addPoint(new Point(20.0, 0.0));
		tree.addPoint(new Point(32.0, 0.0));
		tree.addPoint(new Point(28.0, 0.0));
		tree.addPoint(new Point(28.0, 4.0));
		tree.addPoint(new Point(32.0, 4.0));
		tree.addPoint(new Point(28.0, 4.0));
		tree.addPoint(new Point(28.0, 8.0));
		tree.addPoint(new Point(32.0, 8.0));
				
		Viewer viewer = new Viewer();
		tree.draw("blue", viewer);

		viewer.setVisible(true);
	}
}

