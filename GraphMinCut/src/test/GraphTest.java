package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Edge;
import main.Graph;
import main.Vertice;

public class GraphTest {

	@Test
	public void shouldNotThrowAnyExceptionWhenConstructedWithoutArguments() {
		new Graph();
	}

	@Test
	public void whenAnEdgeIsAddedItsTailAndHeadVerticesAreAlsoAddedToTheGraph() {
		Graph graph = new Graph();
		
		Vertice tail1 = new Vertice(1);
		Vertice head1 = new Vertice(2);
		
		Vertice tail2 = new Vertice(3);
		Vertice head2 = new Vertice(4);
		
		Edge e1 = new Edge(tail1, head1);
		Edge e2 = new Edge(tail2, head2);
		
		graph.addEdge(e1);
		graph.addEdge(e2);
		
		assertEquals(4, graph.getVertices().size());
	}
	
	@Test
	public void whenAVerticeAlreadyExistsItIsNotAddedToTheGraph() {
		Graph graph = new Graph();
		
		Vertice tail1 = new Vertice(1);
		Vertice head1 = new Vertice(2);
		
		Vertice head2 = new Vertice(3);
		
		Edge e1 = new Edge(tail1, head1);
		Edge e2 = new Edge(tail1, head2);
		
		graph.addEdge(e1);
		graph.addEdge(e2);
		
		assertEquals(3, graph.getVertices().size());
	}	
	
	@Test
	public void whenAnEdgeIsAddedToTheGraphTheEdgeItselfIsAddedToTheTailAndHead() {
		Graph graph = new Graph();
		
		Vertice tail = new Vertice(1);
		Vertice head = new Vertice(2);
		
		Edge e = new Edge(tail, head);
		
		graph.addEdge(e);
		
		for (Vertice v : graph.getVertices()) {
			assertTrue(v.getEdges().contains(e));
		}
	}
	
	@Test
	public void shouldPrintItselfCorrectly() {
		Graph graph = new Graph();
		
		Vertice tail1 = new Vertice(1);
		Vertice head1 = new Vertice(2);
		
		Vertice head2 = new Vertice(3);
		
		Edge e1 = new Edge(tail1, head1);
		e1.setId(1);
		Edge e2 = new Edge(tail1, head2);
		e2.setId(2);
		Edge e3 = new Edge(tail1, tail1);
		e2.setId(3);
		
		graph.addEdge(e1);
		graph.addEdge(e2);
		graph.addEdge(e3);
		
		String expectedPrintedGraph = "1\t2\t3\t1\t\n2\t1\t\n3\t1\t\n";
		assertEquals(expectedPrintedGraph, graph.print());
	}
}
