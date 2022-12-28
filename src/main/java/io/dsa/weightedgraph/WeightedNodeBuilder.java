package io.dsa.weightedgraph;

public class WeightedNodeBuilder {
    private String name;
    private int index;

    public WeightedNodeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WeightedNodeBuilder setIndex(int index) {
        this.index = index;
        return this;
    }

    public WeightedNode createWeightedNode() {
        return new WeightedNode(name);
    }
}