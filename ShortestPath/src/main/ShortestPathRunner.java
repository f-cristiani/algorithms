package main;

import java.util.Hashtable;

public class ShortestPathRunner {

	public Hashtable<Vertice, Integer> run(Graph graph, Vertice v) {
		Hashtable<Vertice, Integer> distances = new Hashtable<Vertice, Integer>();
		
		distances.put(graph.getVertices().get(0), 0);
		
		return distances;
	}

}
