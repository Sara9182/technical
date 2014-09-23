package com.sara.interviews.graphs;



import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.List;

class Graph<T> {
    private final Iterable<T> vertices;
    private final Multimap<T,T> adjacent = ArrayListMultimap.create();

    public Graph(List<T> vertices, List<Edge<T>> edges) {
        this.vertices = vertices;
        edges.forEach(
                (Edge<T> edge) -> {
                    adjacent.put(edge.getFrom(), edge.getTo());
                    adjacent.put(edge.getTo(), edge.getFrom());
                });
    }

    public Iterable<T> getVertices() {
        return vertices;
    }

    public List<T> getAdjacent(T vertex) {
        return (List<T>) adjacent.get(vertex);
    }
}
