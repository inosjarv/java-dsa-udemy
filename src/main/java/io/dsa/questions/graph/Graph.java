package io.dsa.questions.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum State {
    Unvisited, Visited, Visiting;
}

class GraphNode {
    String name;
    int index;
    boolean isVisited;
    GraphNode parent;
    State state;
    List<GraphNode> neighbors;

    GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.state = State.Unvisited;
        neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  this.name;
    }
}

public class Graph {
    List<GraphNode> nodes;

    public Graph(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public static void main(String[] args) {
        List<GraphNode> nodeList = new ArrayList<>();
        for (char c = 'A'; c <= 'J'; c++)
            nodeList.add(new GraphNode(Character.toString(c), c - 65)); // ASCII of A = 65

        Graph graph = new Graph(nodeList);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(0, 3);
        graph.addDirectedEdge(1, 9);
        graph.addDirectedEdge(2, 6);
        graph.addDirectedEdge(4, 0);
        graph.addDirectedEdge(4, 5);
        graph.addDirectedEdge(5, 8);
        graph.addDirectedEdge(6, 7);
        graph.addDirectedEdge(6, 3);

        System.out.println(graph.search(nodeList.get(4), nodeList.get(0)));
    }

    public void addDirectedEdge(int first, int second) {
        nodes.get(first).neighbors.add(nodes.get(second));
    }

    // Route Between Nodes
    public boolean search(GraphNode start, GraphNode end) {
        Queue<GraphNode> queue = new LinkedList<>();
        start.state = State.Visiting;

        queue.add(start);
        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();

            if (current != null) {
                for (GraphNode neighbor: current.neighbors) {
                    if (neighbor.state == State.Unvisited) {
                        if (neighbor == end) return true;
                        else {
                            neighbor.state = State.Visiting;
                            queue.add(neighbor);
                        }
                    }
                }
                current.state = State.Visited;
            }
        }
        return false;
    }
}
