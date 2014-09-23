package com.sara.interviews.graphs;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GraphsDirectedCycleTest {

    private final Object v0 = new Object();
    private final Object v1 = new Object();
    private final Object v2 = new Object();
    private final Object v3 = new Object();
    private final Object v4 = new Object();

    @Test
    public void testEmptyGraph() throws Exception {
        DirectedGraph<Object> g = new DirectedGraph<>(Arrays.<Object>asList(),Arrays.<Edge<Object>>asList());
        assertFalse(GraphsDirectedCycle.hasCycle(g));
    }

    @Test
    public void testOneVertex() throws Exception {
        DirectedGraph<Object> g = new DirectedGraph<>(asList(v0),asList());
        assertFalse(GraphsDirectedCycle.hasCycle(g));
    }

    @Test
    public void testOneVertexWithCycle() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v0);
        DirectedGraph<Object> g = new DirectedGraph<>(asList(v0),asList(e0));
        assertTrue(GraphsDirectedCycle.hasCycle(g));
    }

    @Test
    public void testPathOfTwoVertices() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        DirectedGraph<Object> g = new DirectedGraph<>(asList(v0),asList(e0));
        assertFalse(GraphsDirectedCycle.hasCycle(g));
    }

    @Test
    public void testCycleOfTwoVertices() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v0);
        DirectedGraph<Object> g = new DirectedGraph<>(asList(v0,v1),asList(e0,e1));
        assertTrue(GraphsDirectedCycle.hasCycle(g));
    }

    @Test
    public void testCycleOfThreeVertices() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v0);
        DirectedGraph<Object> g = new DirectedGraph<>(asList(v0,v1,v2),asList(e0,e1,e2));
        assertTrue(GraphsDirectedCycle.hasCycle(g));
    }

    @Test
    public void testCycleOfThreeVerticesAndSomething() throws Exception {
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v0);
        Edge<Object> e3 = Edge.of(v1, v3);
        Edge<Object> e4 = Edge.of(v1, v4);
        DirectedGraph<Object> g = new DirectedGraph<>(asList(v0,v1,v2,v3,v4),asList(e0,e1,e2,e3,e4));
        assertTrue(GraphsDirectedCycle.hasCycle(g));
    }
}