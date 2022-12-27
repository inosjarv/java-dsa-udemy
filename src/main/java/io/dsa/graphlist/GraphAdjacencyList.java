package io.dsa.graphlist;

import java.util.*;

import static io.dsa.Colors.*;
import static io.dsa.graphlist.GraphAdjacencyListBuilder.*;

class GraphNode {
    String name;
    int index;
    boolean isVisited;
    List<GraphNode> neighbors = new ArrayList<>();
    GraphNode parent;

    GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

public class GraphAdjacencyList {
    List<GraphNode> nodeList;

    public GraphAdjacencyList(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public static void main(String[] args) {
        GraphAdjacencyList graph = undirectedGraphBuilder();
        System.out.println(graph);
        graph.bfs();

        GraphAdjacencyList graph1 = undirectedGraphBuilder();
        graph1.dfs();

        GraphAdjacencyList graph2 = directedGraphBuilder();
        graph2.topologicalSort();

        GraphAdjacencyList graph3 = undirectedGraphBuilder2();
        graph3.bfsForSSSPPP(graph3.nodeList.get(0));
    }

    private static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        colorPrint(node.name + " ", CYAN);
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);

        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public void bfs() {
        for (GraphNode node : nodeList)
            if (!node.isVisited) bfs(node);

        System.out.println();
    }

    private void bfs(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            currentNode.isVisited = true;
            colorPrint(currentNode.name + " ", GREEN);

            for (GraphNode neighbor : currentNode.neighbors) {
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

            List<GraphNode> neighbors = currentNode.neighbors;

            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }

    }

    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList) {
            if (!node.isVisited) topologicalVisit(node, stack);
        }

        while (!stack.isEmpty()) colorPrint(stack.pop().name + " ", RED);

        System.out.println();
    }

    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : node.neighbors) {
            if (!neighbor.isVisited) topologicalVisit(neighbor, stack);
        }

        node.isVisited = true;
        stack.push(node);
    }

    public void bfsForSSSPPP(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            currentNode.isVisited = true;

            colorPrint("Printing path for node " + currentNode.name + ": ", YELLOW);
            pathPrint(currentNode);

            for (GraphNode neighbor : currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (GraphNode node : nodeList) {
            s.append(node.name).append(": ");
            for (int j = 0; j < node.neighbors.size(); j++) {
                if (j == node.neighbors.size() - 1) {
                    s.append((node.neighbors.get(j).name));
                } else {
                    s.append(node.neighbors.get(j).name).append(" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
