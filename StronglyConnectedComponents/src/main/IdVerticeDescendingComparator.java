package main;

import java.util.Comparator;

public class IdVerticeDescendingComparator implements Comparator<Vertice> {
    @Override
    public int compare(Vertice v1, Vertice v2) {
    	return (v1.getId() - v2.getId());
    }
}