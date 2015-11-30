package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DfsLoop {
	public static  int finishingTime = 0;
	public static Vertice leader = null;
	private BaseDfsGraphWalker dfsGraphWalker = null;
	private Comparator<Vertice> comparator = null;
	
	public DfsLoop(BaseDfsGraphWalker graphWalker, Comparator<Vertice> comparator) {
		this.dfsGraphWalker = graphWalker;
		this.comparator = comparator;
	}
	
	public void run(Graph graph) {
		DfsLoop.finishingTime = 0;
		DfsLoop.leader = null;
		
		for (Vertice vertice : getVertices(graph)) {
			if (!vertice.isExplored()) {
				DfsLoop.leader = vertice;
				dfsGraphWalker.run(graph, vertice);
			}
		}
	}
	
	protected ArrayList<Vertice> getVertices(Graph graph) {
		ArrayList<Vertice> vertices = graph.getVertices();
		
		Collections.sort(vertices, this.comparator);
		
		return vertices;
	}
}