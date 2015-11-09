package main;

import java.util.ArrayList;

public class Vertice {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private int id;

	public void addEdge(Edge e) {
		edges.add(e);
	}

	public ArrayList<Edge> getEdges() {
		return this.edges;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

}