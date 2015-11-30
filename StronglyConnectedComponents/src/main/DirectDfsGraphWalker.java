package main;

import java.util.ArrayList;

public class DirectDfsGraphWalker extends BaseDfsGraphWalker {

	@Override
	protected ArrayList<Edge> getEdges(Vertice v) {
		return v.getOutgoingEdges();
	}
}
