package lecture10;

import inf.v3d.view.Viewer;
import java.util.LinkedList;

public class QuadTree {

	private QuadTreeNode root;
	private LinkedList<Point> polygon;
	private int maxLevel;
	
	public QuadTree(Rectangle r, int level) {	
		this.root = new QuadTreeNode(r, 0);
		this.polygon = new LinkedList<Point>();
		this.maxLevel = level;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	public void addPoint(Point p) {
		Point s = p;
		if (this.polygon.size() != 0) {
			s = this.polygon.getLast();
		}
		polygon.add(p);		
		partition(root, s, p);
	}
	
	private void partition(QuadTreeNode root, Point p1, Point p2) {
		
		boolean intersects = root.getR().intersects(p1.getX(), 
				p1.getY(), p2.getX(), p2.getY());
		
		if (!intersects) {
			return;
		}
		if (root.getLevel() == this.maxLevel) {
			root.setIntersects(intersects);
			return;
		}
		if (root.isLeaf()) {
			root.createSubNode();
		}
		
		partition(root.getLB(), p1, p2);
		partition(root.getLT(), p1, p2);
		partition(root.getRB(), p1, p2);
		partition(root.getRT(), p1, p2);
	}
	
	public void draw(String color, Viewer v) {
		this.draw(root, color, v);
	}
	
	private void draw(QuadTreeNode root, String color, Viewer v) {
		
		if (root.isLeaf()) {
			if (!root.intersects()) {
				color = "white";
			}
			root.getR().draw(color, v);
		} else {
			this.draw(root.getLT(), color, v);
			this.draw(root.getLB(), color, v);
			this.draw(root.getRB(), color, v);
			this.draw(root.getRT(), color, v);
		}
	}	
}
