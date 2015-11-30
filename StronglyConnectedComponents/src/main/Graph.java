package main;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	
	public void addEdge(Edge edge) {
		this.edges.add(edge);
		
		Vertice tail = edge.getTail();
		if (!this.vertices.contains(tail)) {
			this.vertices.add(tail);
		}
		
		Vertice head = edge.getHead();
		if (!this.vertices.contains(head)) {
			this.vertices.add(head);
		}
		
		tail.addEdge(edge);
		head.addEdge(edge);
	}
	
	public void addVertice(Vertice vertice) {
		this.vertices.add(vertice);
	}

	public ArrayList<Vertice> getVertices() {
		return this.vertices;
	}
	
	public ArrayList<Edge> getEdges() {
		return this.edges;
	}
}
