package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.Edge;
import main.Vertice;

public class VerticeTest {

	@Test
	public void shouldBeConstructedWithAnId() {
		new Vertice(123);
	}
	
	@Test
	public void whenIdIsSettedItShouldBeReturned() {
		Vertice v = new Vertice(123);
		
		assertEquals(123, v.getId());
	}
	
	@Test
	public void whenAnEdgeIsAddedItShouldBeReturnedWithGetEdges() {
		Vertice v = new Vertice(1);
		Edge e1 = new Edge(v, new Vertice(2));
		Edge e2 = new Edge(new Vertice(3), v);
		
		v.addEdge(e1);
		v.addEdge(e2);
		
		ArrayList<Edge> expectedEdges = new ArrayList<Edge>();
		expectedEdges.add(e1);
		expectedEdges.add(e2);
		
		assertEquals(expectedEdges, v.getEdges());
	}

}