package main;

import java.util.ArrayList;

public class Vertex {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private int id;

	public Vertex(int id) {
		this.id = id;
	}

	public void addEdge(Edge e) {
		if (!this.getEdges().contains(e)) {
			this.getEdges().add(e);
		}
	}

	public ArrayList<Edge> getEdges() {
		return this.edges;
	}
	
	public int getId() {
		return this.id;
	}

}