package com.sara.interviews.graphs;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.*;


public class GraphsBipartiteTest {

    private final Object v0 = new Object();
    private final Object v1 = new Object();
    private final Object v2 = new Object();
    private final Object v3 = new Object();
    private final Object v4 = new Object();

    @Test(expected = IllegalArgumentException.class)
    public void testIsBipartiteNullGraph() {
        GraphsBipartite.isBipartite(null);
    }

    @Test
    public void testIsBipartiteEmptyGraph() throws Exception {
        Graph<Object> g = new Graph<>(asList(),asList());
        assertTrue(GraphsBipartite.isBipartite(g));
    }

    @Test
    public void testIsBipartiteIncorrectGraph() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Graph<Object> g = new Graph<>(asList(),asList(e0));
        assertTrue(GraphsBipartite.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfTwo() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Graph<Object> g = new Graph<>(asList(v0,v1),asList(e0));
        assertTrue(GraphsBipartite.isBipartite(g));
    }

    @Test
    public void testIsBipartiteTwoDisconnectedVertices() throws Exception {
        Graph<Object> g = new Graph<>(asList(v0,v1),asList());
        assertTrue(GraphsBipartite.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfThree() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v0);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2),asList(e0,e1,e2));
        assertFalse(GraphsBipartite.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfThreePlusSomething() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v0);
        Edge<Object> e3 = Edge.of(v0, v3);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2,v3),asList(e0,e1,e2,e3));
        assertFalse(GraphsBipartite.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfFour() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v3);
        Edge<Object> e3 = Edge.of(v3, v0);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2,v3),asList(e0,e1,e2,e3));
        assertTrue(GraphsBipartite.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfFourWithSomething() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v3);
        Edge<Object> e3 = Edge.of(v3, v0);
        Edge<Object> e4 = Edge.of(v0, v4);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2,v3,v4),asList(e0,e1,e2,e3,e4));
        assertTrue(GraphsBipartite.isBipartite(g));
    }

}