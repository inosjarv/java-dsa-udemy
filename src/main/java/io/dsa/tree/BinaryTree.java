package io.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryNode {
    public BinaryNode left;
    public String value;
    public BinaryNode right;
    public int height;

    public BinaryNode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "value='" + value + '\'' +
                '}';
    }
}

public class BinaryTree {
    BinaryNode root;

    public BinaryTree() {
        root = null;
    }

    public static BinaryTree buildBinaryTree(int numberOfNodes) {
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 1; i <= numberOfNodes; i++) {
            binaryTree.insert("N" + i);

        }
        return binaryTree;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = buildBinaryTree(9);
        System.out.println("======== Inserted All Nodes ============");
        System.out.println("\n======================================");
        testMethods(binaryTree);
    }

    public static void testMethods(BinaryTree binaryTree) {
        System.out.println("Preorder Traversal");
        binaryTree.preorder(binaryTree.root);
        System.out.println("\n======================================");

        System.out.println("InOrder Traversal");
        binaryTree.inorder(binaryTree.root);
        System.out.println("\n======================================");

        System.out.println("Postorder Traversal");
        binaryTree.postorder(binaryTree.root);
        System.out.println("\n======================================");

        System.out.println("Level Order Traversal");
        binaryTree.levelOrder();
        System.out.println("\n======================================");

        System.out.println("Searching...");
        binaryTree.search("N5");
        binaryTree.search("N10");
        System.out.println("\n======================================");

        System.out.println("Deepest Node");
        System.out.println(binaryTree.getDeepestNode());
        System.out.println("\n======================================");

        binaryTree.levelOrder();
        System.out.println();
        binaryTree.deleteNode("N3");
        binaryTree.levelOrder();
    }

    public void preorder(BinaryNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(BinaryNode node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public void postorder(BinaryNode node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            System.out.print(node.value + " ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public void search(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            if (node.value.equals(value)) {
                System.out.println(value + " found in BinaryTree");
                return;
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        System.out.println(value + " does not exist in BinaryTree!");
    }

    public void insert(String value) {
        BinaryNode newNode = new BinaryNode(value);
        if (root == null) {
            root = newNode;
            System.out.println("Inserted new node at root!!");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();

            if (currentNode.left == null) {
                currentNode.left = newNode;
                System.out.println("Successfully Inserted!!");
                break;
            } else if (currentNode.right == null) {
                currentNode.right = newNode;
                System.out.println("Successfully Inserted!!");
                break;
            } else {
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
    }

    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();

            if (presentNode.left != null) queue.add(presentNode.left);
            if (presentNode.right != null) queue.add(presentNode.right);
        }
        return presentNode;
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode prev, curr = null;
        while (!queue.isEmpty()) {
            prev = curr;
            curr = queue.poll();

            if (curr.left == null) {
                prev.right = null;
                return;
            } else if (curr.right == null) {
                curr.left = null;
                return;
            }
            queue.add(curr.left);
            queue.add(curr.right);
        }
    }

    public void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode present = queue.poll();
            if (present.value.equals(value)) {
                present.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println(value + " Node is Deleted!!");
                return;
            } else {
                if (present.left != null) queue.add(present.left);
                if (present.right != null) queue.add(present.right);
            }
        }

        System.out.println(value + " node does not exist in BinaryTree!!");
    }

    public void deleteBinaryTree() {
        this.root = null;
        System.out.println("BinaryTree Deleted!!");
    }
}
