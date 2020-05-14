package model;

public class AbbContainer {

	//atributo
	private long n;
	
	//relation
	private AbbContainer right;
	private AbbContainer left;
	
	public AbbContainer(long n) {
		this.n = n;
	}

	public long getN() {
		return n;
	}

	public void setN(long n) {
		this.n = n;
	}

	public AbbContainer getRight() {
		return right;
	}

	public void setRight(AbbContainer right) {
		this.right = right;
	}

	public AbbContainer getLeft() {
		return left;
	}

	public void setLeft(AbbContainer left) {
		this.left = left;
	}
		
}
