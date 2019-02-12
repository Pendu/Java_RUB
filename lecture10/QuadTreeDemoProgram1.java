package lecture10;

import inf.v3d.view.Viewer;

public class QuadTreeDemoProgram1 {

	public static void main(String[] args) {

		QuadTree tree = new QuadTree(
				new Rectangle(0.0, 0.0, 10.0, 10.0), 8);
				
	 	tree.addPoint(new Point(2.3, 2.7));
		tree.addPoint(new Point(7.2, 4.1));
		tree.addPoint(new Point(5.1, 9.3));
		tree.addPoint(new Point(9.3, 5.7));
				
		Viewer viewer = new Viewer();
		tree.draw("blue", viewer);

		viewer.setVisible(true);
	}
}

