package main;

import java.util.ArrayList;

public class ReverseDfsGraphWalker {

	public void run(Graph graph, Vertice vertice) {
		vertice.markAsExplored();
		vertice.setLeader(DfsLoop.leader);
		
		for (Edge edge: getEdges(vertice)) {
			Vertice endPoint = null;
			
			if (edge.getTail().equals(vertice)) {
				endPoint = edge.getHead();
			} else {
				endPoint = edge.getTail();
			}
			
			if (!endPoint.isExplored()) {
				this.run(graph, endPoint);	
			}
		}
		
		DfsLoop.finishingTime++;
		vertice.setFinishingTime(DfsLoop.finishingTime);
	}
	
	private ArrayList<Edge> getEdges(Vertice v) {
		return v.getIncomingEdges();
	}
}
