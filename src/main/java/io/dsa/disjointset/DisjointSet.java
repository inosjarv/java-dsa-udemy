package io.dsa.disjointset;

import io.dsa.weightedgraph.WeightedNode;

import java.util.ArrayList;
import java.util.List;

import static io.dsa.Colors.*;

public class DisjointSet {
    private final List<WeightedNode> nodeList = new ArrayList<>();

    public static void main(String[] args) {
        List<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A"));
        nodes.add(new WeightedNode("B"));
        nodes.add(new WeightedNode("C"));
        nodes.add(new WeightedNode("D"));

        DisjointSet.makeSet(nodes);
        WeightedNode first = nodes.get(0), second = nodes.get(1);
        DisjointSet output = DisjointSet.findSet(second);
        DisjointSet.union(first, second);
        output.printAllNodes();
    }

    public static void makeSet(List<WeightedNode> nodeList) {
        for (WeightedNode node : nodeList) {
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }

    public static DisjointSet findSet(WeightedNode node) {
        return node.set;
    }

    public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
        if (node1.set.equals(node2.set)) return null;
        else {
            DisjointSet set1 = node1.set;
            DisjointSet set2 = node2.set;

            if (set1.nodeList.size() > set2.nodeList.size()) {
                for (WeightedNode node : set2.nodeList) {
                    node.set = set1;
                    set1.nodeList.add(node);
                }
                return set1;
            } else {
                for (WeightedNode node : set1.nodeList) {
                    node.set = set2;
                    set2.nodeList.add(node);
                }
                return set2;
            }
        }
    }

    public void printAllNodes() {
        colorPrint("Printing all nodes of set: \n", GREEN);
        nodeList.forEach(node -> colorPrint(node + " ", BLUE));
        System.out.println();
    }
}
