package com.sara.interviews.graphs;

public class Edge<T> {
    private final T from;
    private final T to;

    private Edge(T from,T to) {
        this.from = from;
        this.to = to;
    }

    public static <T> Edge<T> of(T from, T to) {
        return new Edge<T>(from, to);
    }

    public T getFrom() {
        return from;
    }

    public T getTo() {
        return to;
    }
}
