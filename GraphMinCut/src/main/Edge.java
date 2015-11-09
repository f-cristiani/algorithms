package main;

public class Edge {
	private Vertice tail;
	private Vertice head;

	public void setTail(Vertice tail) {
		this.tail = tail;
	}

	public void setHead(Vertice head) {
		this.head = head;
	}

	public Vertice getTail() {
		return this.tail;
	}
	
	public Vertice getHead() {
		return this.head;
	}
}
