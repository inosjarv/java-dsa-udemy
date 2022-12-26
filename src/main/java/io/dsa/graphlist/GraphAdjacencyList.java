package io.dsa.graphlist;

import java.util.*;

import static io.dsa.Colors.*;

class GraphNode {
    String name;
    int index;
    boolean isVisited;

    List<GraphNode> neighbors = new ArrayList<>();

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
        GraphAdjacencyList graph = graphBuilder();
        System.out.println(graph);
        graph.bfs();

        GraphAdjacencyList graph1 = graphBuilder();
        graph1.dfs();
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

    public static GraphAdjacencyList graphBuilder() {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        GraphAdjacencyList graph = new GraphAdjacencyList(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);

        return graph;
    }
}
