package main;

import java.util.ArrayList;
import java.util.Hashtable;

public class ShortestPathRunner {

	public Hashtable<Vertex, Integer> run(Graph graph, Vertex source) {
		Hashtable<Vertex, Integer> distances = new Hashtable<Vertex, Integer>();
		ArrayList<Vertex> verticesProcessedSoFar = new ArrayList<Vertex>();

		verticesProcessedSoFar.add(source);
		distances.put(source, 0);
		
		while (verticesProcessedSoFar.size() != graph.getVertices().size()) {
			int minimumScore = Integer.MAX_VALUE;
			Vertex vertexThatMinimizesMinimumScore = null;
			
			for (Edge edge : graph.getEdges()) {
				if (graph.getVertices().contains(edge.getTail()) && !verticesProcessedSoFar.contains(edge.getHead())) {
					int tempMinimumScore = distances.get(edge.getTail()) + edge.getLength(); 
					if (tempMinimumScore < minimumScore) {
						vertexThatMinimizesMinimumScore = edge.getHead();
						minimumScore = tempMinimumScore;
					}
				}
			}
			
			if (vertexThatMinimizesMinimumScore != null) {
				verticesProcessedSoFar.add(vertexThatMinimizesMinimumScore);
				distances.put(vertexThatMinimizesMinimumScore, minimumScore);
			}
		}
		
		return distances;
	}

}
