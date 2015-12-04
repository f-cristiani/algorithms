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
		Vertex v2 = new Vertex(2);
		
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
	
	@Test
	public void testItShouldReturnTheCorrectDistancesWithFourVerticesGraph() {
		Graph graph = new Graph();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		
		Edge e12 = new Edge(v1, v2, 1);
		Edge e13 = new Edge(v1, v3, 4);
		Edge e24 = new Edge(v2, v4, 6);
		Edge e23 = new Edge(v2, v3, 2);
		Edge e34 = new Edge(v3, v4, 3);
		
		graph.addEdge(e12);
		graph.addEdge(e13);
		graph.addEdge(e24);
		graph.addEdge(e23);
		graph.addEdge(e34);
		
		ShortestPathRunner shortestPathRunner = new ShortestPathRunner();
		
		Hashtable<Vertex, Integer> expectedDistances = new Hashtable<Vertex, Integer>();
		expectedDistances.put(v1,  0);
		expectedDistances.put(v2,  1);
		expectedDistances.put(v3,  3);
		expectedDistances.put(v4,  6);
		
		Hashtable<Vertex, Integer> distances = shortestPathRunner.run(graph, v1);
		
		assertEquals(expectedDistances.size(), distances.size());
		assertEquals(expectedDistances.get(v1), distances.get(v1));
		assertEquals(expectedDistances.get(v2), distances.get(v2));
		assertEquals(expectedDistances.get(v3), distances.get(v3));
		assertEquals(expectedDistances.get(v4), distances.get(v4));
	}
}
