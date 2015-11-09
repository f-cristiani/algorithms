package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		
		Vertice tail1 = new Vertice();
		Vertice head1 = new Vertice();
		
		Vertice tail2 = new Vertice();
		Vertice head2 = new Vertice();
		
		Edge e1 = new Edge(tail1, head1);
		Edge e2 = new Edge(tail2, head2);
		
		graph.addEdge(e1);
		graph.addEdge(e2);
		
		assertEquals(4, graph.getVertices().size());
	}
	
	@Test
	public void whenAVerticeAlreadyExistsItIsNotAddedToTheGraph() {
		Graph graph = new Graph();
		
		Vertice tail1 = new Vertice();
		Vertice head1 = new Vertice();
		
		Vertice head2 = new Vertice();
		
		Edge e1 = new Edge(tail1, head1);
		Edge e2 = new Edge(tail1, head2);
		
		graph.addEdge(e1);
		graph.addEdge(e2);
		
		assertEquals(3, graph.getVertices().size());
	}	
	
	@Test
	public void whenAnEdgeIsAddedToTheGraphTheEdgeItselfIsAddedToTheTailAndHead() {
		Graph graph = new Graph();
		
		Vertice tail = new Vertice();
		Vertice head = new Vertice();
		
		Edge e = new Edge(tail, head);
		
		graph.addEdge(e);
		
		for (Vertice v : graph.getVertices()) {
			assertTrue(v.getEdges().contains(e));
		}
	}
	
	@Test
	public void shouldPrintItselfCorrectly() {
		Graph graph = new Graph();
		
		Vertice tail1 = new Vertice();
		tail1.setId(1);
		Vertice head1 = new Vertice();
		head1.setId(2);
		
		Vertice head2 = new Vertice();
		head2.setId(3);
		
		Edge e1 = new Edge(tail1, head1);
		e1.setId(1);
		Edge e2 = new Edge(tail1, head2);
		e2.setId(2);

		graph.addEdge(e1);
		graph.addEdge(e2);
		
		String expectedPrintedGraph = "1\t2\t3\t\n2\t1\t\n3\t1\t\n";
		assertEquals(expectedPrintedGraph, graph.print());
	}
}
