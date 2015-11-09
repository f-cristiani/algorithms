package main;

public class Edge {
	private Vertice tail;
	private Vertice head;
	private int id;

	public Edge(Vertice tail, Vertice head) {
		this.tail = tail;
		this.head = head;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Vertice getTail() {
		return this.tail;
	}
	
	public Vertice getHead() {
		return this.head;
	}
}
