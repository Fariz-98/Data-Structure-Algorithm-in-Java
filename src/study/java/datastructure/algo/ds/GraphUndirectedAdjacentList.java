package study.java.datastructure.algo.ds;

import java.util.*;

public class GraphUndirectedAdjacentList {

    private Map<Vertex, List<Vertex>> adjacentList;

    public static void main(String[] args) {
        GraphUndirectedAdjacentList graph = new GraphUndirectedAdjacentList();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addVertex("end");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        graph.removeVertex("Bob");
    }

    public GraphUndirectedAdjacentList() {
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(String label) {
        adjacentList.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void addEdge(String vertexLabel, String edgeLabel) {
        Vertex vertex = new Vertex(vertexLabel);
        Vertex edge = new Vertex(edgeLabel);

        adjacentList.get(vertex).add(edge);
        adjacentList.get(edge).add(vertex);
    }

    public void removeVertex(String vertexLabel) {
        Vertex v = new Vertex(vertexLabel);

        // Remove this vertex from all edges of a vertex
        for (Vertex tempVertex : adjacentList.keySet()) {
            List<Vertex> edgesList = adjacentList.get(tempVertex);
            edgesList.remove(v);
        }

        // Remove this vertex from map
        adjacentList.remove(v);
    }

    public List<Vertex> getVertex(String label) {
        return adjacentList.get(new Vertex(label));
    }

}

class Vertex {

    String label;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

}


