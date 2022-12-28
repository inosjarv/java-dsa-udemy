package io.dsa.weightedgraph;

import io.dsa.disjointset.DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedNode implements Comparable<WeightedNode> {
    public String name;
    public List<WeightedNode> neighbors = new ArrayList<>();
    public Map<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited;
    public WeightedNode parent;
    public int distance;
    public int index;
    public DisjointSet set;

    public WeightedNode(String name) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
    }

    public WeightedNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.distance = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(WeightedNode other) {
        return this.distance - other.distance;
    }
}
