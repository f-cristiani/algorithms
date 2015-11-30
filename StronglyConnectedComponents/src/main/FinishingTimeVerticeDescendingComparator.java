package main;

import java.util.Comparator;

public class FinishingTimeVerticeDescendingComparator implements Comparator<Vertice> {
    @Override
    public int compare(Vertice v1, Vertice v2) {
    	return (v2.getFinishingTime() - v1.getFinishingTime());
    }
}