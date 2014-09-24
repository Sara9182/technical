package com.sara.interviews.graphs;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.List;

class DirectedGraph<T>  {
    protected final Iterable<T> vertices;
    protected final Multimap<T,T> adjacent = ArrayListMultimap.create();

    public DirectedGraph(List<T> vertices, List<Edge<T>> edges) {
        this.vertices = vertices;
        edges.forEach((Edge<T> edge) -> adjacent.put(edge.getFrom(), edge.getTo()));
    }

    public Iterable<T> getVertices() {
        return vertices;
    }

    public List<T> getAdjacent(T vertex) {
        return (List<T>) adjacent.get(vertex);
    }
}
