package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphMinCutMain {
	public static void main(String[] args) throws IOException {
		int minimumCut = -1;
		KargerGraphMinimumCut graphMinCut = new KargerGraphMinimumCut();

		for (int i = 0; i < 100; i++) {
			System.out.println("Try " + i + ": ");
			Graph graph = getGraphFromFile();
			int iterationMinCut = graphMinCut.getMinimumCut(graph);	
			
			if (iterationMinCut < minimumCut || minimumCut == -1) {
				minimumCut = iterationMinCut;
			}
			
			System.out.println("MinCut: " + minimumCut + " | Size: " + iterationMinCut + "\n");
		}
		
	    System.out.println(minimumCut);
	}
	
	private static Graph getGraphFromFile() throws IOException {
		ArrayList<Vertice> verticesInFile = new ArrayList<Vertice>();
		BufferedReader br = new BufferedReader(new FileReader("src/graph.txt"));
	    String line = br.readLine();
	    String[] splittedLine;
	    
	    Graph graph = new Graph();
	    
	    while (line != null) {
	    	splittedLine = line.split("\t");
			Vertice tail = getNewOrExistentVertice(verticesInFile, Integer.parseInt(splittedLine[0]));
			
	        for (int i = 1; i < splittedLine.length; i++) {
				Vertice head = getNewOrExistentVertice(verticesInFile, Integer.parseInt(splittedLine[i]));
				
				Edge e = new Edge(tail, head);
				graph.addEdge(e);
			}
	        
	        line = br.readLine();
	    }
	    
	    br.close();
	    
	    return graph;
	}
	
	private static Vertice getNewOrExistentVertice(ArrayList<Vertice> verticesInFile, int id) {
		for (Vertice vertice : verticesInFile) {
			if (vertice.getId() == id) {
				return vertice;
			}
		}
		
		Vertice v = new Vertice(id);
		verticesInFile.add(v);
		return v;
	}
}
