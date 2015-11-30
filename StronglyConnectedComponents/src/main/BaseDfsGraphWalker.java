package main;

import java.util.ArrayList;

abstract public class BaseDfsGraphWalker {

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
	
	abstract protected ArrayList<Edge> getEdges(Vertice v);
}