package io.dsa.disjointset;

import io.dsa.weightedgraph.WeightedNode;

public class UndirectedEdge {
    public WeightedNode first;
    public WeightedNode second;
    public int weight;

    public UndirectedEdge(WeightedNode first, WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge(" + first + ", " + second + "), weight=" + weight;
    }
}
