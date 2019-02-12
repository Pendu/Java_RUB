package lecture10;

public class QuadTreeNode {
	
	private Rectangle r;
	private boolean intersects;
	
	private int level;
	
	private QuadTreeNode lT;
	private QuadTreeNode rT;
	private QuadTreeNode lB;
	private QuadTreeNode rB;
	
	public QuadTreeNode(Rectangle r, int level) {
		this.r = r;
		this.level = level;
	}
	
	public boolean isLeaf() {
		if (lT == null) {
			return true;
		}
		return false;
	}
	
	public void createSubNode() {
		this.lT = new QuadTreeNode(new Rectangle(
				r.getX(), r.getY()+r.getH()/2, 
				r.getW()/2, r.getH()/2), this.level+1);	
		
		this.rT = new QuadTreeNode(new Rectangle(
					r.getX()+r.getW()/2, r.getY()+r.getH()/2, 
					r.getW()/2, r.getH()/2), this.level+1);
		
		this.lB = new QuadTreeNode(new Rectangle(
				r.getX(), r.getY(), 
				r.getW()/2, r.getH()/2), this.level+1);
		
		this.rB = new QuadTreeNode(new Rectangle(
				r.getX()+r.getW()/2, r.getY(), 
				r.getW()/2, r.getH()/2), this.level+1);
	}
	
	public boolean intersects() {
		return intersects;
	}

	public void setIntersects(boolean intersects) {
		this.intersects = intersects;
	}

	public QuadTreeNode getLT() {
		return lT;
	}

	public void setLT(QuadTreeNode lT) {
		this.lT = lT;
	}

	public QuadTreeNode getRT() {
		return rT;
	}

	public void setRT(QuadTreeNode rT) {
		this.rT = rT;
	}

	public QuadTreeNode getLB() {
		return lB;
	}

	public void setLB(QuadTreeNode lB) {
		this.lB = lB;
	}

	public QuadTreeNode getRB() {
		return rB;
	}

	public void setRB(QuadTreeNode rB) {
		this.rB = rB;
	}

	public int getLevel() {
		return level;
	}

	public Rectangle getR() {
		return r;
	}
}
