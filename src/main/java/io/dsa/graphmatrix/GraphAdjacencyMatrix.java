package io.dsa.graphmatrix;

import java.util.*;

import static io.dsa.Colors.*;
import static io.dsa.graphmatrix.GraphAdjacencyMatrixBuilder.*;

class GraphNode {
    String name;
    int index;
    boolean isVisited;
    GraphNode parent;

    GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "GraphNode[" + "name='" + name + '\'' + ", index=" + index + ", isVisited=" + isVisited + ']';
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
        GraphAdjacencyMatrix graph = undirectedGraphBuilder();
        System.out.println(graph);
        graph.bfs();

        GraphAdjacencyMatrix graph1 = undirectedGraphBuilder();
        graph1.dfs();

        GraphAdjacencyMatrix graph2 = directedGraphBuilder();
        graph2.topologicalSort();

        GraphAdjacencyMatrix graph3 = undirectedGraphBuilder2();
        graph3.bfsForSSSPPP(graph3.nodeList.get(3));
    }

    private static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        colorPrint(node.name + " ", CYAN);
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = 1;
    }

    public void addDirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
    }

    public void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) bfs(node);
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

            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void dfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) dfs(node);
        }
        System.out.println();
    }

    private void dfs(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            colorPrint(currentNode.name + " ", BLUE);

            List<GraphNode> neighbors = getNeighbors(currentNode);

            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    private List<GraphNode> getNeighbors(GraphNode node) {
        List<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) neighbors.add(nodeList.get(i));
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

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList) {
            if (!node.isVisited) topologicalVisit(node, stack);
        }

        while (!stack.isEmpty()) colorPrint(stack.pop().name + " ", RED);
        System.out.println();
    }

    public void bfsForSSSPPP(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            currentNode.isVisited = true;

            colorPrint("Printing path for node " + currentNode.name + ": ", YELLOW);
            pathPrint(currentNode);

            for (GraphNode neighbor : getNeighbors(currentNode)) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            }
            System.out.println();
        }
    }

    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : getNeighbors(node)) {
            if (!neighbor.isVisited) topologicalVisit(neighbor, stack);
        }

        node.isVisited = true;
        stack.push(node);
    }
}
