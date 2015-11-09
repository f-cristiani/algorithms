package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Edge;
import main.Vertice;

public class EdgeTest {

	@Test
	public void shouldBeConstructedWithTailAndHead() {
		new Edge(new Vertice(1), new Vertice(2));
	}
	
	@Test
	public void whenIdIsSettedItShouldBeReturned() {
		Edge e = new Edge(new Vertice(1), new Vertice(2));
		e.setId(123);
		
		assertEquals(123, e.getId());
	}
}