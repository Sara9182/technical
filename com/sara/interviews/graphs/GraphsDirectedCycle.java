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
     * Checks if a directed connected graph has got a directed cycle
     */
    public static <T> boolean hasCycle(DirectedGraph<T> g) {
        if (Iterables.isEmpty(g.getVertices())) {
            return false;
        }
        return dfsCheckForCycle(g, Iterables.getFirst(g.getVertices(),null),0,new HashMap<>(), new HashSet<>());
    }
}
