package io.dsa.disjointset;

import io.dsa.weightedgraph.WeightedNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static io.dsa.Colors.*;

public class Prims {
    List<WeightedNode> nodeList;

    public Prims(List<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public static void main(String[] args) {
        List<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A"));
        nodes.add(new WeightedNode("B"));
        nodes.add(new WeightedNode("C"));
        nodes.add(new WeightedNode("D"));
        nodes.add(new WeightedNode("E"));

        Prims graph = new Prims(nodes);
        graph.addWeightedUndirectedEdge(0, 1, 5);
        graph.addWeightedUndirectedEdge(0, 2, 13);
        graph.addWeightedUndirectedEdge(0, 4, 15);
        graph.addWeightedUndirectedEdge(1, 2, 10);
        graph.addWeightedUndirectedEdge(1, 3, 8);
        graph.addWeightedUndirectedEdge(2, 3, 6);
        graph.addWeightedUndirectedEdge(2, 4, 20);

        graph.prims(nodes.get(0));

    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        WeightedNode first = nodeList.get(firstIndex);
        WeightedNode second = nodeList.get(secondIndex);
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
    }

    public void prims(WeightedNode node) {
        for (WeightedNode weightedNode : nodeList) {
            weightedNode.distance = Integer.MAX_VALUE;
        }

        node.distance = 0;
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.poll();
            for (WeightedNode neighbor : currentNode.neighbors) {
                if (queue.contains(neighbor)) {
                    if (neighbor.distance > currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        int cost = 0;
        for (WeightedNode nodeToCheck : nodeList) {
            colorPrintln("Node " + nodeToCheck + ", key: " + nodeToCheck.distance + " Parent: " + nodeToCheck.parent, GREEN);
            cost = cost + nodeToCheck.distance;
        }

        colorPrintln("\nTotal Cost of MST: " + cost, CYAN);
    }
}
