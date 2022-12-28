package io.dsa.weightedgraph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraphBuilder {
    public static WeightedGraph buildWeightedGraph() {
        List<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNodeBuilder().setName("A").setIndex(0).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("B").setIndex(1).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("C").setIndex(2).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("D").setIndex(3).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("E").setIndex(4).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("F").setIndex(5).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("G").setIndex(6).createWeightedNode());


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

    public static WeightedGraph buildWeightedGraph2() {
        List<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNodeBuilder().setName("A").setIndex(0).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("B").setIndex(1).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("C").setIndex(2).createWeightedNode());
        nodeList.add(new WeightedNodeBuilder().setName("D").setIndex(3).createWeightedNode());

        WeightedGraph graph = new WeightedGraph(nodeList);
        graph.addWeightedEdge(0, 1, 8);
        graph.addWeightedEdge(0, 3, 1);
        graph.addWeightedEdge(1, 2, 1);
        graph.addWeightedEdge(2, 0, 4);
        graph.addWeightedEdge(3, 1, 2);
        graph.addWeightedEdge(3, 2, 9);

        return graph;
    }
}
