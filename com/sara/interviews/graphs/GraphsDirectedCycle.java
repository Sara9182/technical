package com.sara.interviews.graphs;

import com.google.common.collect.Iterables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GraphsDirectedCycle {

    private static <T> boolean dfsCheckForCycle(
            DirectedGraph<T> g,
            T vertex,
            int dfsNo,
            Map<T,Integer> dfsIds,
            Set<T> currentSubtree) {

        dfsIds.put(vertex,dfsNo);
        currentSubtree.add(vertex);
        if (g.getAdjacent(vertex) == null) {
            return false;
        }
        for (T adj : g.getAdjacent(vertex)) {
            // a directed graph has got a cycle if it contains a non-tree back edge
            if (dfsIds.containsKey(adj) && currentSubtree.contains(adj)) {
                return true;
            }
            boolean subtreeHasCycle = dfsCheckForCycle(g, adj, dfsNo+1, dfsIds, currentSubtree);
            currentSubtree.remove(adj);
            if (subtreeHasCycle) {
                return true;
            }
        }
        return false;
    }

    /*
     * Checks if a directed graph has got a directed cycle
     */
    public static <T> boolean hasCycle(DirectedGraph<T> g) {
        Iterable<T> vertices = g.getVertices();
        Map<T,Integer> dfsIds = new HashMap<>();
        //unless the graph is strongly connected, we need to call DFS traversal for each unvisited vertex
        for (T vertex : vertices) {
            if (!dfsIds.containsKey(vertex)) {
                //a graph contains a cycle if any of its strongly connected components contains a cycle
                if (dfsCheckForCycle(g, Iterables.getFirst(g.getVertices(),null), 0, dfsIds, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }
}
