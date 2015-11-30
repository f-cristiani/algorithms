package main;

import java.util.ArrayList;

public class ReverseDfsGraphWalker extends BaseDfsGraphWalker {

	@Override
	protected ArrayList<Edge> getEdges(Vertice v) {
		return v.getIncomingEdges();
	}
}
