package main;

import java.util.Iterator;
import java.util.Random;

public class KargerGraphMinimumCut {
	public int getMinimumCut(Graph graph) {
		while (graph.getVertices().size() > 2) {
			mergeTwoVertices(graph);	
		}
		
		return graph.getEdges().size();
	}
	
	private void mergeTwoVertices(Graph graph) {
		Edge e = pickEdgeRandmolyFromGraph(graph);
		Vertice verticeToMaintain = e.getTail();
		Vertice verticeToMerge = e.getHead();
		
		for (Edge verticeEdge : verticeToMerge.getEdges()) {
			if (verticeEdge.getTail().equals(verticeToMerge)) {
				verticeEdge.setTail(verticeToMaintain);
			}
			
			if (verticeEdge.getHead().equals(verticeToMerge)) {
				verticeEdge.setHead(verticeToMaintain);
			}
			
			verticeToMaintain.addEdge(verticeEdge);
		}
		
		graph.getVertices().remove(verticeToMerge);
		removeSelfLoops(graph);
	}
	
	private Edge pickEdgeRandmolyFromGraph(Graph graph) {
		Random r = new Random(System.currentTimeMillis());
		return graph.getEdges().get(r.nextInt(graph.getEdges().size()));
	}
	
	private void removeSelfLoops(Graph graph) {
		for (Iterator<Edge> iterator = graph.getEdges().iterator(); iterator.hasNext();) {
		    Edge edge = iterator.next();
		    if (edge.isSelfLoop()) {
		        iterator.remove();
		        for (Vertice vertice : graph.getVertices()) {
					vertice.getEdges().remove(edge);
				}
		    }
		}
	}
}
