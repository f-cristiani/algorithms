package main;

import java.util.ArrayList;

public class Vertice {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private int id;

	public Vertice(int id) {
		this.id = id;
	}

	public void addEdge(Edge e) {
		edges.add(e);
	}

	public ArrayList<Edge> getEdges() {
		return this.edges;
	}
	
	public int getId() {
		return this.id;
	}

}