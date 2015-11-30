package main;

import java.util.ArrayList;

public class Vertice {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private int id;
	private boolean explored;
	private Vertice leader;
	private int finishingTime; 

	public Vertice(int id) {
		this.id = id;
		this.explored = false;
		this.leader = null;
		this.finishingTime = 0;
	}

	public void addEdge(Edge e) {
		if (!this.getEdges().contains(e)) {
			this.getEdges().add(e);
		}
	}

	public ArrayList<Edge> getEdges() {
		return this.edges;
	}
	
	public ArrayList<Edge> getIncomingEdges() {
		ArrayList<Edge> incomingEdges = new ArrayList<Edge>();
		for (Edge edge : this.getEdges()) {
			if (edge.getHead().equals(this)) {
				incomingEdges.add(edge);
			}
		}
		
		return incomingEdges;
	}
	
	public ArrayList<Edge> getOutgoingEdges() {
		ArrayList<Edge> outoingEdges = new ArrayList<Edge>();
		for (Edge edge : this.getEdges()) {
			if (edge.getTail().equals(this)) {
				outoingEdges.add(edge);
			}
		}
		
		return outoingEdges;
	}
	
	public void setFinishingTime(int t) {
		this.finishingTime = t;
	}
	
	public int getFinishingTime() {
		return this.finishingTime;
	}
	
	public int getId() {
		return this.id;
	}

	public void markAsExplored() {
		this.explored = true;
	}
	
	public boolean isExplored() {
		return this.explored;
	}
	
	public void setLeader(Vertice v) {
		this.leader = v;
	}
	
	public Vertice getLeader() {
		return this.leader;
	}

	public void markAsUnexplored() {
		this.explored = false;
	}
}