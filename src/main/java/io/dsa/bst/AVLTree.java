package io.dsa.bst;

import io.dsa.Colors;

import static io.dsa.Colors.*;

public class AVLTree extends BinarySearchTreeParent {
    public AVLTree() {
        root = null;
    }

    public static void main(String[] args) {
        AVLTree avlTree = buildAVLTree();
        avlTree.levelOrder();
        avlTree.delete(20);
        avlTree.delete(5);
        avlTree.levelOrder();
    }

    public static AVLTree buildAVLTree() {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(5);

        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(20);
        avlTree.insert(25);
        avlTree.insert(30);
        avlTree.insert(35);

        return avlTree;
    }

    public static void testMethods(AVLTree avlTree) {
        colorPrint("\n=========================================\n", YELLOW);
        System.out.println("================ PreOrder ===============");
        avlTree.preorder(avlTree.root);

        colorPrint("\n=========================================\n", YELLOW);
        System.out.println("================ InOrder ================");
        avlTree.inorder(avlTree.root);

        colorPrint("\n=========================================\n", YELLOW);
        System.out.println("================ PostOrder =============");
        avlTree.postorder(avlTree.root);

        colorPrint("\n=========================================\n", YELLOW);
        System.out.println("============= Level Order ==============");
        avlTree.levelOrder();

        colorPrint("\n=========================================\n", YELLOW);
        System.out.println("=============== Search  ================");
        avlTree.search(avlTree.root, 40);
        avlTree.search(avlTree.root, 101);


        colorPrint("\n=========================================\n", YELLOW);
        System.out.println("=============== Delete  ================");
        avlTree.levelOrder();
        avlTree.delete(avlTree.root, 70);
        avlTree.levelOrder();
        avlTree.delete(avlTree.root, 41);


        colorPrint("\n=========================================\n", YELLOW);
        System.out.println("============= Delete Tree ===============");
        avlTree.deleteTree();
        avlTree.levelOrder();
    }

    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) return root;
        else return minimumNode(root.left);
    }

    public int getHeight(BinaryNode node) {
        if (node == null) return 0;

        return node.height;
    }

    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public int getBalance(BinaryNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    @Override
    public void insert(int value) {
        root = insert(root, value);
    }

    private BinaryNode insert(BinaryNode node, int value) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode(value);
            newNode.height = 1;
            return newNode;
        } else if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && value < node.left.value) {
            // left-left condition
            return rotateRight(node);
        }

        if (balance > 1 && value > node.left.value) {
            // left-right condition
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && value > node.right.value) {
            // right-right condition
            return rotateLeft(node);
        }

        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private BinaryNode delete(BinaryNode node, int value) {
        if (node == null) {
            colorPrintln(value + " does not exist in AVL Tree", Colors.RED);
            return null;
        }

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left != null && node.right != null) {
                BinaryNode minNodeForRight = minimumNode(node.right);
                node.value = minNodeForRight.value;
                node.right = delete(node.right, minNodeForRight.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            // left-left condition
            return rotateRight(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            // left-right condition
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            // right-right condition
            return rotateLeft(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    @Override
    public void delete(int value) {
        root = delete(root, value);
    }
}


