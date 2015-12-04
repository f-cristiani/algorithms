package main;

public class Edge {
	private Vertex tail;
	private Vertex head;
	private int id;
	private int pathLength;

	public Edge(Vertex tail, Vertex head, int pathLength) {
		this.tail = tail;
		this.head = head;
		this.pathLength = pathLength;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setTail(Vertex tail) {
		this.tail = tail;
	}
	
	public void setHead(Vertex head) {
		this.head = head;
	}
	
	public Vertex getTail() {
		return this.tail;
	}
	
	public Vertex getHead() {
		return this.head;
	}

	public boolean isSelfLoop() {
		return this.getTail().equals(this.getHead());
	}

	public Integer getLength() {
		return this.pathLength;
	}
}
