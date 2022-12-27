package io.dsa.weightedgraph;

import java.util.List;
import java.util.PriorityQueue;

import static io.dsa.Colors.*;

public class WeightedGraph {
    List<WeightedNode> nodeList;

    public WeightedGraph(List<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public static void main(String[] args) {
        colorPrintln("\nDijkstra\n", YELLOW);
        WeightedGraph weightedGraph = WeightedGraphBuilder.buildWeightedGraph();
        weightedGraph.dijkstra(weightedGraph.nodeList.get(0));

        colorPrintln("\nBellmen-Ford\n", YELLOW);
        WeightedGraph weightedGraph1 = WeightedGraphBuilder.buildWeightedGraph();
        weightedGraph1.bellmanFord(weightedGraph1.nodeList.get(0));
    }

    private static void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        colorPrint(node.name + " ", CYAN);
    }

    public void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);

        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.poll();

            for (WeightedNode neighbor : currentNode.neighbors) {
                if (queue.contains(neighbor)) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            colorPrint("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ", CYAN);
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    public void addWeightedEdge(int i, int j, int distance) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, distance);
    }

    public void bellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0;

        for (int i = 0; i < nodeList.size(); i++) {
            for (WeightedNode currentNode : nodeList) {
                for (WeightedNode neighbor : currentNode.neighbors) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                    }
                }
            }
        }

        System.out.println("Checking for Negative Cycle..");
        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neighbor : currentNode.neighbors) {
                if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                    colorPrintln("Negative Cycle Found...", BLUE);
                    colorPrintln("Vertex Name: " + neighbor, CYAN);
                    colorPrintln("Old Cost: " + neighbor.distance, CYAN);
                    neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                    neighbor.parent = currentNode;
                    colorPrintln("New Cost: " + neighbor.distance, CYAN);
                }
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            colorPrint("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ", CYAN);
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }
}
