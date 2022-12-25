package io.dsa.bst;

public class BinaryNode {
    public BinaryNode left;
    public int value;
    public BinaryNode right;
    public int height;

    public BinaryNode(int value) {
        this.value = value;
        this.height = 0;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
