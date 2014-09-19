package com.sara.interviews.graphs;

public class Graph {
    private final Vertex[] vertices;

    public Graph(Vertex[] vertices) {
        this.vertices = vertices;
        //we save the information in each vertex about its index in the graph
        for (int i=0; i<vertices.length; i++) {
            vertices[i].id = i;
        }
    }

    /*
     * Checks if the whole graph (possibly unconnected) is bipartite.
     */
    public boolean isBipartite() {

        class BipartiteGraphChecker {
            boolean isOddLayer = false;
            boolean[] visited = new boolean[vertices.length];
            boolean[] verticesLayers = new boolean[vertices.length];

            /*
             * Check if the connected component that contains vertex at index i is bipartite.
             * A connected graph is bipartite <=> it doesn't contain a cycle of odd length.
             * This can be checked by running DFS search, marking the layers of visited vertices as odd and even
             * and checking if an edge exists between an even and an odd vertices.
             */
            private boolean isBipartiteConnectedComponent(int i) {
                visited[i] = true;
                verticesLayers[i] = isOddLayer;
                isOddLayer = !isOddLayer;
                for (Vertex adj:vertices[i].getAdjacents()) {
                    if (visited[i] && verticesLayers[i] == verticesLayers[adj.id]) {
                        return false;
                    }
                    isBipartiteConnectedComponent(adj.id);
                }
                return true;
            }
        }

        BipartiteGraphChecker checker = new BipartiteGraphChecker();
        for (int i=0; i<checker.visited.length; i++) {
            // the whole graph is bipartite <=> each of its connected components is bipartite
            if (!checker.visited[i] && !checker.isBipartiteConnectedComponent(i)) {
                return false;
            }
        }
        return true;
    }
}
