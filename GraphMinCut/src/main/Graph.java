package main;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	
	public void addEdge(Edge edge) {
		this.edges.add(edge);
		
		Vertice tail = edge.getTail();
		tail.addEdge(edge);
		
		Vertice head = edge.getTail();
		head.addEdge(edge);

		this.vertices.add(tail);
		this.vertices.add(head);
	}
	
	public void addVertice(Vertice vertice) {
		this.vertices.add(vertice);
	}

	public ArrayList<Vertice> getVertices() {
		return this.vertices;
	}

}
