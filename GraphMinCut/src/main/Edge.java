package main;

public class Edge {
	private Vertice tail;
	private Vertice head;

	public Edge(Vertice tail, Vertice head) {
		this.tail = tail;
		this.head = head;
	}
	
	public Vertice getTail() {
		return this.tail;
	}
	
	public Vertice getHead() {
		return this.head;
	}
}
