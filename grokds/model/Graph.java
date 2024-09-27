package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Graph {
    private HashMap<Integer, ArrayList<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyList.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
        adjacencyList.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1);
    }

    public void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.get(vertex).stream().forEach(vert -> adjacencyList.computeIfPresent(vert, (k, v) -> (ArrayList) v.stream().filter(a -> !a.equals(vertex)).collect(Collectors.toList())));
            adjacencyList.remove(vertex);
        }
    }

    public void removeVertexDirectional(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.remove(vertex);
            adjacencyList.values().stream().forEach(l -> l.removeIf(v -> v == vertex));

        }
    }

    /*

    public void removeVertex(int vertex);
    // Remove a vertex from the graph.

    public void addEdge(int vertex1, int vertex2);
    // Add an edge between two vertices.

    public void removeEdge(int vertex1, int vertex2);
    // Remove an edge between two vertices.

    public ArrayList<Integer> getVertices();
    // Get a list of all vertices.

    public boolean isAdjacent(int vertex1, int vertex2);
    // Check if two vertices are adjacent.

    public int getVertexCount();
    // Get the total number of vertices.

    public int getEdgeCount();
    // Get the total number of edges.

    public ArrayList<Pair<Integer, Integer>> getEdges();
    // Get a list of all edges.

    public ArrayList<Integer> getNeighbors(int vertex);
    // Get a list of neighbors of a given vertex.

    */
}