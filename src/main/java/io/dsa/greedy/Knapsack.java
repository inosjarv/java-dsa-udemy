package io.dsa.greedy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
class KnapsackItem {
    private int index;
    private int value;
    private int weight;
    private double ratio;

    KnapsackItem(int index, int value, int weight) {
        this.index = index;
        this.value = value;
        this.weight = weight;
        this.ratio = value * 1.0 / weight;
    }
}

public class Knapsack {
    public static void main(String[] args) {
        List<KnapsackItem> items = new ArrayList<>();
        int[] values = {100, 120, 60}, weights = {20, 30, 10};
        int capacity = 50;
        for (int i = 0; i < values.length; i++) {
            items.add(new KnapsackItem(i, values[i], weights[i]));
        }
        knapsack(items, capacity);
    }

    static void knapsack(List<KnapsackItem> items, int capacity) {
        Comparator<KnapsackItem> comparator = (a, b) -> b.getRatio() > a.getRatio() ? 1 : -1;
        items.sort(comparator);

        int usedCapacity = 0;
        double totalValue = 0;

        for (KnapsackItem item : items) {
            if (usedCapacity + item.getWeight() <= capacity) {
                usedCapacity += item.getWeight();
                System.out.println("Taken: " + item);
            } else {
                int usedWeight = capacity - usedCapacity;
                double value = item.getRatio() * usedWeight;
                System.out.println("Taken: item index = " + item.getIndex() + ", obtained value = " + value + ", used weight = " + usedWeight + ", ratio = " + item.getRatio());
                usedCapacity += usedWeight;
            }
            totalValue += item.getValue();
            if (usedCapacity == capacity) break;
        }

        System.out.println("Total Value = " + totalValue);
    }
}
