package main;

import java.util.ArrayList;

public class Vertice {
	ArrayList<Edge> edges = new ArrayList<Edge>();

	public void addEdge(Edge e) {
		edges.add(e);
	}

	public ArrayList<Edge> getEdges() {
		return this.edges;
	}

}
