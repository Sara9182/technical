package com.sara.interviews.graphs;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.*;


public class GraphUtilsTest {

    Object v0 = new Object();
    Object v1 = new Object();
    Object v2 = new Object();
    Object v3 = new Object();
    Object v4 = new Object();

    @Test
    public void testIsBipartiteCycleOfTwo() throws Exception {
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Graph<Object> g = new Graph(asList(v0,v1),asList(e0));
        assertTrue(GraphUtils.isBipartite(g));
    }

    @Test
    public void testIsBipartiteTwoDisconnectedVertices() throws Exception {
        Graph<Object> g = new Graph(asList(v0,v1),asList());
        assertTrue(GraphUtils.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfThree() throws Exception {
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v2,v0);
        Graph<Object> g = new Graph(asList(v0,v1,v2),asList(e0,e1,e2));
        assertFalse(GraphUtils.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfThreePlusSomething() throws Exception {
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v2,v0);
        Edge<Object> e3 = Edge.<Object>of(v0,v3);
        Graph<Object> g = new Graph(asList(v0,v1,v2,v3),asList(e0,e1,e2,e3));
        assertFalse(GraphUtils.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfFour() throws Exception {
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v2,v3);
        Edge<Object> e3 = Edge.<Object>of(v3,v0);
        Graph<Object> g = new Graph(asList(v0,v1,v2,v3),asList(e0,e1,e2,e3));
        assertTrue(GraphUtils.isBipartite(g));
    }

    @Test
    public void testIsBipartiteCycleOfFourWithSomething() throws Exception {
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v2,v3);
        Edge<Object> e3 = Edge.<Object>of(v3,v0);
        Edge<Object> e4 = Edge.<Object>of(v0,v4);
        Graph<Object> g = new Graph(asList(v0,v1,v2,v3,v4),asList(e0,e1,e2,e3,e4));
        assertTrue(GraphUtils.isBipartite(g));
    }
}