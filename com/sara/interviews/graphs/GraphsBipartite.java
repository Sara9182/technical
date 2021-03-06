package com.sara.interviews.graphs;

import java.util.*;

class GraphsBipartite {

    /*
     * Checks if the whole graph G<T> (possibly unconnected) is bipartite.
     */
    public static <T> boolean isBipartite(UndirectedGraph<T> g) {

        class BipartiteGraphChecker {
            boolean isOddLayer = false;
            Set<T> visited = new HashSet<>();
            Map<T,Boolean> verticesLayers = new HashMap<>();

            /*
             * Check if the connected component that contains vertex at index i is bipartite.
             * A connected graph is bipartite <=> it doesn't contain a cycle of odd length.
             * This can be checked by running DFS search, marking the layers of visited vertices as odd and even
             * and checking if an edge exists between an even and an odd vertices.
             */
            private boolean isBipartiteConnectedComponent(T vertex) {
                visited.add(vertex);
                verticesLayers.put(vertex,isOddLayer);
                isOddLayer = !isOddLayer;
                if (g.getAdjacent(vertex) != null) {
                    for (T adj:g.getAdjacent(vertex)) {
                        if (visited.contains(adj) && verticesLayers.get(vertex) == verticesLayers.get(adj)) {
                            return false;
                        }
                        if (!visited.contains(adj)) {
                            isBipartiteConnectedComponent(adj);
                        }
                    }
                }
                return true;
            }
        }

        if (g == null) {
            throw new IllegalArgumentException();
        }
        BipartiteGraphChecker checker = new BipartiteGraphChecker();
        for (T vertex:g.getVertices()) {
            // the whole graph is bipartite <=> each of its connected components is bipartite
            if (!checker.visited.contains(vertex) && !checker.isBipartiteConnectedComponent(vertex)) {
                return false;
            }
        }
        return true;
    }


}
