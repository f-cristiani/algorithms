package main;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	
	public void addEdge(Edge edge) {
		this.edges.add(edge);
		
		Vertex tail = edge.getTail();
		if (!this.vertices.contains(tail)) {
			this.vertices.add(tail);
		}
		
		Vertex head = edge.getHead();
		if (!this.vertices.contains(head)) {
			this.vertices.add(head);
		}
		
		tail.addEdge(edge);
		head.addEdge(edge);
	}
	
	public void addVertice(Vertex vertice) {
		this.vertices.add(vertice);
	}

	public ArrayList<Vertex> getVertices() {
		return this.vertices;
	}
	
	public ArrayList<Edge> getEdges() {
		return this.edges;
	}

	public String print() {
		String printedGraph = "";

		for (Vertex vertice : this.getVertices()) {
			printedGraph += vertice.getId() + "\t";
			
			for (Edge edge : vertice.getEdges()) {
				if (!edge.getTail().equals(vertice)) {
					printedGraph += edge.getTail().getId() + "\t";
				}
				
				if (!edge.getHead().equals(vertice)) {
					printedGraph += edge.getHead().getId() + "\t";
				}
				
				if (edge.getHead().equals(vertice) && edge.getTail().equals(vertice)) {
					printedGraph += vertice.getId() + "\t";
				}
			}
			
			printedGraph += "\n";
		}
		
		return printedGraph;
	}

}
