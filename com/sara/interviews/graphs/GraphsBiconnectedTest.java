package com.sara.interviews.graphs;

import com.google.common.collect.Sets;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GraphsBiconnectedTest {

    private final Object v0 = new Object();
    private final Object v1 = new Object();
    private final Object v2 = new Object();
    private final Object v3 = new Object();
    private final Object v4 = new Object();

    @Test
    public void testArticulationPointsSingleVertex(){
        Graph<Object> g = new Graph<>(asList(v0),asList());
        assertTrue(GraphsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsTwoDisconnectedVertices(){
        Graph<Object> g = new Graph<>(asList(v0,v1),asList());
        assertTrue(GraphsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsTwoConnectedVertices(){
        Edge<Object> e0 = Edge.of(v0, v1);
        Graph<Object> g = new Graph<>(asList(v0,v1),asList(e0));
        assertTrue(GraphsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsPathOfTwoVertices(){
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2),asList(e0,e1));
        assertFalse(GraphsBiconnected.isBiconnected(g));
        assertEquals(Sets.newHashSet(v1), GraphsBiconnected.articulationPoints(g));
    }

    @Test
    public void testArticulationPointsCycleOfThreeVertices(){
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v0);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2),asList(e0,e1,e2));
        assertTrue(GraphsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsCycleOfThreeVerticesAndPath(){
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v0);
        Edge<Object> e3 = Edge.of(v0, v3);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2,v3),asList(e0,e1,e2,e3));
        assertFalse(GraphsBiconnected.isBiconnected(g));
        assertEquals(Sets.newHashSet(v0), GraphsBiconnected.articulationPoints(g));
    }

    @Test
    public void testArticulationPointsCycleOfFourVertices(){
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v3);
        Edge<Object> e3 = Edge.of(v3, v0);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2,v3),asList(e0,e1,e2,e3));
        assertTrue(GraphsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsTwoCyclesOfThreeVertices(){
        Edge<Object> e0 = Edge.of(v0, v1);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v2, v0);
        Edge<Object> e3 = Edge.of(v0, v3);
        Edge<Object> e4 = Edge.of(v3, v4);
        Edge<Object> e5 = Edge.of(v4, v0);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2,v3,v4),asList(e0,e1,e2,e3,e4,e5));
        assertFalse(GraphsBiconnected.isBiconnected(g));
        assertEquals(Sets.newHashSet(v0), GraphsBiconnected.articulationPoints(g));
    }

    @Test
    public void testArticulationPointsStar(){
        Edge<Object> e0 = Edge.of(v1, v0);
        Edge<Object> e1 = Edge.of(v1, v2);
        Edge<Object> e2 = Edge.of(v1, v3);
        Edge<Object> e3 = Edge.of(v1, v4);
        Graph<Object> g = new Graph<>(asList(v0,v1,v2,v3,v4),asList(e0,e1,e2,e3));
        assertFalse(GraphsBiconnected.isBiconnected(g));
        assertEquals(Sets.newHashSet(v1), GraphsBiconnected.articulationPoints(g));
    }

}