package main;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	
	public void addEdge(Edge edge) {
		this.edges.add(edge);
		
		Vertice tail = edge.getTail();
		if (!this.containsVertice(tail)) {
			this.vertices.add(tail);
		}
		
		Vertice head = edge.getHead();
		if (!this.vertices.contains(head)) {
			this.vertices.add(head);
		}
		
		tail.addEdge(edge);
		head.addEdge(edge);
	}
	
	private boolean containsVertice(Vertice v) {
		boolean containsVertice = false;
		for (Vertice vertice : this.vertices) {
			if (vertice.getId() == v.getId()) {
				containsVertice = true;
				break;
			}
		}
		
		return containsVertice;
	}
	
	public void addVertice(Vertice vertice) {
		this.vertices.add(vertice);
	}

	public ArrayList<Vertice> getVertices() {
		return this.vertices;
	}

	public String print() {
		String printedGraph = "";

		for (Vertice vertice : this.getVertices()) {
			printedGraph += vertice.getId() + "\t";
			
			for (Edge edge : vertice.getEdges()) {
				if (!edge.getTail().equals(vertice)) {
					printedGraph += edge.getTail().getId() + "\t";
				}
				
				if (!edge.getHead().equals(vertice)) {
					printedGraph += edge.getHead().getId() + "\t";
				}
			}
			
			printedGraph += "\n";
		}
		
		return printedGraph;
	}

}
