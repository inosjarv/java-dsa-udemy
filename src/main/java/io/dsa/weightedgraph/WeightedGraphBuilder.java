package io.dsa.weightedgraph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraphBuilder {
    public static WeightedGraph buildWeightedGraph() {
        List<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));


        WeightedGraph graph = new WeightedGraph(nodeList);
        graph.addWeightedEdge(0, 1, 2); // A -> 2 -> B
        graph.addWeightedEdge(0, 2, 5); // A -> 5 -> C
        graph.addWeightedEdge(1, 2, 6); // B -> 6 -> C
        graph.addWeightedEdge(1, 3, 1); // B -> 1 -> D
        graph.addWeightedEdge(1, 4, 3); // B -> 3 -> E
        graph.addWeightedEdge(2, 5, 8); // C -> 8 -> F
        graph.addWeightedEdge(3, 4, 4); // D -> 4 -> E
        graph.addWeightedEdge(4, 6, 9); // E -> 9 -> G
        graph.addWeightedEdge(5, 6, 7); // F -> 7 -> G
        return graph;
    }
}
