package com.sara.interviews.graphs;

import java.util.List;

/*
 * An undirected graph is a directed graph in which every edge is a represented by two edges in both directions
 */
class UndirectedGraph<T> extends DirectedGraph<T>{
    public UndirectedGraph(List<T> vertices, List<Edge<T>> edges) {
        super(vertices,edges);
        edges.forEach((Edge<T> edge) -> adjacent.put(edge.getTo(), edge.getFrom()));
    }
}
