package com.sara.interviews.graphs;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.List;

public class Graph<T> {
    private final List<T> vertices;
    private MultiMap<T,T> adjacent = new MultiValueMap<>();

    public Graph(List<T> vertices, List<Edge<T>> edges) {
        this.vertices = vertices;
        edges.forEach(
                (Edge<T> edge) -> {
                    adjacent.put(edge.getFrom(), edge.getTo());
                    adjacent.put(edge.getTo(), edge.getFrom());
                });
    }

    public List<T> getVertices() {
        return vertices;
    }

    public List<T> getAdjacent(T vertex) {
        return (List<T>) adjacent.get(vertex);
    }
}
