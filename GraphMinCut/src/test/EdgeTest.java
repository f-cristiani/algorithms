package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Edge;
import main.Vertice;

public class EdgeTest {

	@Test
	public void shouldThrowNoExceptionWhenConstructedWithoutArguments() {
		new Edge();
	}
	
	@Test
	public void whenTailIsSettedWithAVerticeItShouldBeReturned() {
		Vertice tailVertice = new Vertice();
		
		Edge e = new Edge();
		e.setTail(tailVertice);
		
		assertEquals(tailVertice, e.getTail());
	}
	
	@Test
	public void whenHeadIsSettedWithAVerticeItShouldAddItselfToTheEdgesListOfTheVertice() {
		Vertice headVertice = new Vertice();
		
		Edge e = new Edge();
		e.setHead(headVertice);
		
		assertEquals(headVertice, e.getHead());
	}
}