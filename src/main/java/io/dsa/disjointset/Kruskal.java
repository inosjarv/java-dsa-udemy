package io.dsa.disjointset;

import io.dsa.weightedgraph.WeightedNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static io.dsa.Colors.*;

public class Kruskal {
    List<WeightedNode> nodeList;
    List<UndirectedEdge> edgeList;

    public Kruskal(List<WeightedNode> nodeList) {
        this.nodeList = nodeList;
        this.edgeList = new ArrayList<>();
    }

    public static void main(String[] args) {
        List<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A"));
        nodes.add(new WeightedNode("B"));
        nodes.add(new WeightedNode("C"));
        nodes.add(new WeightedNode("D"));
        nodes.add(new WeightedNode("E"));

        Kruskal graph = new Kruskal(nodes);
        graph.addWeightedUndirectedEdge(0, 1, 5);
        graph.addWeightedUndirectedEdge(0, 2, 13);
        graph.addWeightedUndirectedEdge(0, 4, 15);
        graph.addWeightedUndirectedEdge(1, 2, 10);
        graph.addWeightedUndirectedEdge(1, 3, 8);
        graph.addWeightedUndirectedEdge(2, 3, 6);
        graph.addWeightedUndirectedEdge(2, 4, 20);

        graph.kruskal();

    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex),
                nodeList.get(secondIndex), weight);

        WeightedNode first = edge.first;
        WeightedNode second = edge.second;
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    public void kruskal() {
        DisjointSet.makeSet(nodeList);
        edgeList.sort(Comparator.comparingInt(edge -> edge.weight));

        int cost = 0;
        for (UndirectedEdge edge : edgeList) {
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;

            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
                DisjointSet.union(first, second);
                cost += edge.weight;
                colorPrintln("Taken " + edge, CYAN);
            }
        }

        colorPrintln("\nTotal Cost of MST: " + cost, GREEN);
    }
}
