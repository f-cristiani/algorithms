package main;

import java.util.ArrayList;
import java.util.Hashtable;

public class KosarajuStronglyConnectedComponents {
	public Hashtable<Integer, ArrayList<Vertice>> run(Graph graph) {
		DfsLoop reverseDfsLoop = new DfsLoop(
			new ReverseDfsGraphWalker(),
			new IdVerticeDescendingComparator()
			);
		
		DfsLoop directDfsLoop = new DfsLoop(
			new DirectDfsGraphWalker(),
			new FinishingTimeVerticeDescendingComparator()
			);
		
		markAllVerticesAsUnexplored(graph);
		reverseDfsLoop.run(graph);
		
		markAllVerticesAsUnexplored(graph);
		directDfsLoop.run(graph);
		
		Hashtable<Integer, ArrayList<Vertice>> stronglyConnectedComponents = new Hashtable<Integer, ArrayList<Vertice>>();
		for (Vertice vertice : graph.getVertices()) {
			ArrayList<Vertice> verticesForStronglyConnectedComponents = stronglyConnectedComponents.get(vertice.getLeader().getId());
			
			if (verticesForStronglyConnectedComponents == null) {
				ArrayList<Vertice> newVerticeList = new ArrayList<Vertice>();
				newVerticeList.add(vertice);
				stronglyConnectedComponents.put(vertice.getLeader().getId(), newVerticeList);
			} else {
				verticesForStronglyConnectedComponents.add(vertice);
				stronglyConnectedComponents.put(vertice.getLeader().getId(), verticesForStronglyConnectedComponents);   
			}
		}
	   
		return stronglyConnectedComponents;
	}

	private void markAllVerticesAsUnexplored(Graph graph) {
		for (Vertice vertice : graph.getVertices()) {
			vertice.markAsUnexplored();
		}
	}
}