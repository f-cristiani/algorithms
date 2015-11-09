package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Edge;
import main.Vertice;

public class EdgeTest {

	@Test
	public void shouldBeConstructedWithTailAndHead() {
		new Edge(new Vertice(), new Vertice());
	}
	
	@Test
	public void whenIdIsSettedItShouldBeReturned() {
		Edge e = new Edge(new Vertice(), new Vertice());
		e.setId(123);
		
		assertEquals(123, e.getId());
	}
}