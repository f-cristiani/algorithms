package test;

import org.junit.Test;

import main.Edge;
import main.Vertice;

public class EdgeTest {

	@Test
	public void shouldBeConstructedWithTailAndHead() {
		new Edge(new Vertice(), new Vertice());
	}
}