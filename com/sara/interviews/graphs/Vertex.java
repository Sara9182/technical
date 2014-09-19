package com.sara.interviews.graphs;

import java.util.LinkedList;

public class Vertex {
    public int id = -1;     //this field is used to store the index of this vertex in a graph
    private final LinkedList<Vertex> adjacents;

    public Vertex(LinkedList<Vertex> adjacents) {
        this.adjacents = adjacents;
    }

    public LinkedList<Vertex> getAdjacents() {
        return adjacents;
    }
}
