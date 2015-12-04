package test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

import main.Graph;
import main.ShortestPathRunner;
import main.Vertice;

public class ShortestPathRunnerTest {

	@Test
	public void testItShouldReturnOneDistanceWithAOneVerticeGraph() {
		Graph graph = new Graph();
		Vertice v = new Vertice(1);
		
		graph.addVertice(v);
		
		ShortestPathRunner shortestPathRunner = new ShortestPathRunner();
		
		Hashtable<Vertice, Integer> expectedDistances = new Hashtable<Vertice, Integer>();
		expectedDistances.put(v,  0);
		
		Hashtable<Vertice, Integer> distances = shortestPathRunner.run(graph, v);
		
		assertEquals(1, distances.size());
		assertEquals(expectedDistances.get(v), distances.get(v));
	}

}
