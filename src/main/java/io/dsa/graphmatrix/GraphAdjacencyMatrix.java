package io.dsa.graphmatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static io.dsa.Colors.GREEN;
import static io.dsa.Colors.colorPrint;

class GraphNode {
    String name;
    int index;
    boolean isVisited;

    GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

public class GraphAdjacencyMatrix {
    List<GraphNode> nodeList;
    int[][] adjacencyMatrix;

    public GraphAdjacencyMatrix(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public static void main(String[] args) {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);

        System.out.println(graph);

        graph.bfs();
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = 1;
    }

    public void bfs() {
        for (GraphNode node: nodeList) {
            if (!node.isVisited)
                bfs(node);
        }
        System.out.println();
    }

    private void bfs(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            colorPrint(currentNode.name + " ", GREEN);

            List<GraphNode> neighbors = getNeighbors(currentNode);

            for (GraphNode neighbor: neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    private List<GraphNode> getNeighbors(GraphNode node) {
        List<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1)
                neighbors.add(nodeList.get(i));
        }

        return neighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (GraphNode graphNode : nodeList) {
            sb.append(graphNode.name).append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).name).append(": ");
            for (int j : adjacencyMatrix[i]) {
                sb.append((j)).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
