package com.sara.interviews.graphs;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GraphUtilsBiconnectedTest {

    Object v0 = new Object();
    Object v1 = new Object();
    Object v2 = new Object();
    Object v3 = new Object();
    Object v4 = new Object();
    Object v5 = new Object();

    @Test(expected = IllegalArgumentException.class)
    public void testArticulationPointsNullGraph() {
        GraphUtilsBiconnected.articulationPoints(null);
    }

    @Test
    public void testArticulationPointsSingleVertex(){
        Graph<Object> g = new Graph(asList(v0),asList());
        assertTrue(GraphUtilsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsTwoDisconnectedVertices(){
        Graph<Object> g = new Graph(asList(v0,v1),asList());
        assertTrue(GraphUtilsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsTwoConnectedVertices(){
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Graph<Object> g = new Graph(asList(v0,v1),asList(e0));
        assertTrue(GraphUtilsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsPathOfTwoVertices(){
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Graph<Object> g = new Graph(asList(v0,v1,v2),asList(e0,e1));
        assertFalse(GraphUtilsBiconnected.isBiconnected(g));
        assertEquals(Sets.newHashSet(v1), GraphUtilsBiconnected.articulationPoints(g));
    }

    @Test
    public void testArticulationPointsCycleOfThreeVertices(){
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v2,v0);
        Graph<Object> g = new Graph(asList(v0,v1,v2),asList(e0,e1,e2));
        assertTrue(GraphUtilsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsCycleOfThreeVerticesAndPath(){
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v2,v0);
        Edge<Object> e3 = Edge.<Object>of(v0,v3);
        Graph<Object> g = new Graph(asList(v0,v1,v2,v3),asList(e0,e1,e2,e3));
        assertFalse(GraphUtilsBiconnected.isBiconnected(g));
        assertEquals(Sets.newHashSet(v0), GraphUtilsBiconnected.articulationPoints(g));
    }

    @Test
    public void testArticulationPointsCycleOfFourVertices(){
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v2,v3);
        Edge<Object> e3 = Edge.<Object>of(v3,v0);
        Graph<Object> g = new Graph(asList(v0,v1,v2,v3),asList(e0,e1,e2,e3));
        assertTrue(GraphUtilsBiconnected.isBiconnected(g));
    }

    @Test
    public void testArticulationPointsTwoCyclesOfThreeVertices(){
        Edge<Object> e0 = Edge.<Object>of(v0,v1);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v2,v0);
        Edge<Object> e3 = Edge.<Object>of(v0,v3);
        Edge<Object> e4 = Edge.<Object>of(v3,v4);
        Edge<Object> e5 = Edge.<Object>of(v4,v0);
        Graph<Object> g = new Graph(asList(v0,v1,v2,v3,v4),asList(e0,e1,e2,e3,e4,e5));
        assertFalse(GraphUtilsBiconnected.isBiconnected(g));
        assertEquals(Sets.newHashSet(v0), GraphUtilsBiconnected.articulationPoints(g));
    }

    @Test
    public void testArticulationPointsStar(){
        Edge<Object> e0 = Edge.<Object>of(v1,v0);
        Edge<Object> e1 = Edge.<Object>of(v1,v2);
        Edge<Object> e2 = Edge.<Object>of(v1,v3);
        Edge<Object> e3 = Edge.<Object>of(v1,v4);
        Graph<Object> g = new Graph(asList(v0,v1,v2,v3,v4),asList(e0,e1,e2,e3));
        assertFalse(GraphUtilsBiconnected.isBiconnected(g));
        assertEquals(Sets.newHashSet(v1), GraphUtilsBiconnected.articulationPoints(g));
    }

}