package test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

import main.Edge;
import main.Graph;
import main.ShortestPathRunner;
import main.Vertex;

public class ShortestPathRunnerTest {

	@Test
	public void testItShouldReturnOneDistanceWithAOneVertexGraph() {
		Graph graph = new Graph();
		Vertex v = new Vertex(1);
		
		graph.addVertice(v);
		
		ShortestPathRunner shortestPathRunner = new ShortestPathRunner();
		
		Hashtable<Vertex, Integer> expectedDistances = new Hashtable<Vertex, Integer>();
		expectedDistances.put(v,  0);
		
		Hashtable<Vertex, Integer> distances = shortestPathRunner.run(graph, v);
		
		assertEquals(1, distances.size());
		assertEquals(expectedDistances.get(v), distances.get(v));
	}
	
	@Test
	public void testItShouldReturnTwoDistancesWithATwoVerticesGraph() {
		Graph graph = new Graph();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(1);
		
		int pathLength = 3;
		
		graph.addEdge(new Edge(v1, v2, pathLength));
		
		ShortestPathRunner shortestPathRunner = new ShortestPathRunner();
		
		Hashtable<Vertex, Integer> expectedDistances = new Hashtable<Vertex, Integer>();
		expectedDistances.put(v1,  0);
		expectedDistances.put(v2,  pathLength);
		
		Hashtable<Vertex, Integer> distances = shortestPathRunner.run(graph, v1);
		
		assertEquals(2, distances.size());
		assertEquals(expectedDistances.get(v1), distances.get(v1));
		assertEquals(expectedDistances.get(v2), distances.get(v2));
	}
}
