package com.sara.interviews.graphs;

import com.google.common.collect.Iterables;

import java.util.*;

import static java.lang.Math.min;

class GraphsBiconnected {

    /*
     * A helper DFS method for articulationPoints()
     */
    private static <T> void dfsAP(Graph<T> g, T vertex, int dfsNo, Map<T,Integer> dfsIds, Set<T> artPoints, Map<T,Integer> low) {
        dfsIds.put(vertex, dfsNo);
        //root is a special case
        if (dfsNo == 0) {
            int noOfChildren = 0;
            for (T adj : g.getAdjacent(vertex)) {
                if (!dfsIds.containsKey(adj)) {
                    dfsAP(g, adj, dfsNo+1, dfsIds, artPoints, low);
                    noOfChildren++;
                }
            }
            if (noOfChildren > 1) {
                artPoints.add(vertex);
            }
        }
        else {
            int minLowOfChildren = Integer.MAX_VALUE;
            int minLow = dfsNo;
            for (T adj : g.getAdjacent(vertex)) {
                //a back non-tree edge
                if (dfsIds.containsKey(adj) && dfsIds.get(adj) < dfsNo-1) {
                    minLow = min(minLow, dfsIds.get(adj));
                } else if (!dfsIds.containsKey(adj)) {
                    dfsAP(g, adj, dfsNo+1, dfsIds, artPoints, low);
                    if (low.get(adj) >= dfsNo) {
                        artPoints.add(vertex);
                    }
                    minLowOfChildren = min(minLowOfChildren, low.get(adj));
                }
            }
            minLow = min(minLow, minLowOfChildren);
            low.put(vertex, minLow);
        }
    }

    /*
     * Returns all articulation points in the undirected, connected graph G<T>
     */
    public static <T> Set<T> articulationPoints(Graph<T> g) {
        HashSet<T> aps = new HashSet<>();
        if (Iterables.isEmpty(g.getVertices())) {
            return aps;
        }
        dfsAP(g, Iterables.getFirst(g.getVertices(), null), 0, new HashMap<>(), aps, new HashMap<>());
        return aps;
    }

    /*
     * Checks if the undirected, connected graph G<T> is biconnected.
     * Graph is biconnected <=> it doesn't have any articulation points.
     */
    public static <T> boolean isBiconnected(Graph<T> g) {
        return Iterables.isEmpty(articulationPoints(g));
    }
}
