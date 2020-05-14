package model;

public class ListContainer {

	//atributo
	private long n;
	
	//relation
	private ListContainer next;
	private ListContainer prev;

	public ListContainer(long n) {

		this.n = n;
	}

	public ListContainer getPrev() {
		return prev;
	}

	public void setPrev(ListContainer prev) {
		this.prev = prev;
	}

	public long getN() {
		return n;
	}

	public void setN(long n) {
		this.n = n;
	}

	public ListContainer getNext() {
		return next;
	}

	public void setNext(ListContainer next) {
		this.next = next;
	}
	
}
