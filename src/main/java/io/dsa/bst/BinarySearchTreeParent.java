package io.dsa.bst;

import io.dsa.Colors;

import java.util.LinkedList;
import java.util.Queue;

import static io.dsa.Colors.*;

public abstract class BinarySearchTreeParent {
    public BinaryNode root;

    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) return root;
        else return minimumNode(root.left);
    }

    public void preorder(BinaryNode node) {
        if (node == null) return;

        colorPrint(node.value + " ", Colors.GREEN);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(BinaryNode node) {
        if (node == null) return;

        inorder(node.left);
        colorPrint(node.value + " ", Colors.GREEN);
        inorder(node.right);
    }

    public void postorder(BinaryNode node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        colorPrint(node.value + " ", Colors.GREEN);
    }

    public void levelOrder() {
        if (root == null) {
            colorPrintln("Tree is Empty!!", RED);
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            colorPrint(node.value + " ", Colors.GREEN);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        System.out.println();
    }

    public BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            colorPrint(value + " not found in BST!!\n", Colors.RED);
            return null;
        } else if (node.value == value) {
            colorPrint(value + " found in BST\n", Colors.GREEN);
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public void deleteTree() {
        root = null;
        colorPrintln("Tree Deleted!!", RED);
    }

    abstract void insert(int value);

    abstract void delete(int value);
}
