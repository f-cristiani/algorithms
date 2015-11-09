package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.Edge;
import main.Vertice;

public class VerticeTest {

	@Test
	public void shouldThrowNoExceptionWhenConstructedWithoutArguments() {
		new Vertice();
	}
	
	@Test
	public void whenAnEdgeIsAddedItShouldBeReturnedWithGetEdges() {
		Vertice v = new Vertice();
		Edge e1 = new Edge();
		Edge e2 = new Edge();
		
		v.addEdge(e1);
		v.addEdge(e2);
		
		ArrayList<Edge> expectedEdges = new ArrayList<Edge>();
		expectedEdges.add(e1);
		expectedEdges.add(e2);
		
		assertEquals(expectedEdges, v.getEdges());
	}

}
