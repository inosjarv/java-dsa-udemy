package io.dsa.bst;

import io.dsa.Colors;

import static io.dsa.Colors.colorPrint;
import static io.dsa.Colors.colorPrintln;


public class BinarySearchTree extends BinarySearchTreeParent {
    public BinarySearchTree() {
        root = null;
    }

    public static BinarySearchTree buildBST() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);

        return bst;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = buildBST();
        testMethods(bst);
    }

    public static void testMethods(BinarySearchTree bst) {
        colorPrint("\n=========================================\n", Colors.YELLOW);
        System.out.println("================ PreOrder ===============");
        bst.preorder(bst.root);

        colorPrint("\n=========================================\n", Colors.YELLOW);
        System.out.println("================ InOrder ================");
        bst.inorder(bst.root);

        colorPrint("\n=========================================\n", Colors.YELLOW);
        System.out.println("================ PostOrder =============");
        bst.postorder(bst.root);

        colorPrint("\n=========================================\n", Colors.YELLOW);
        System.out.println("============= Level Order ==============");
        bst.levelOrder();

        colorPrint("\n=========================================\n", Colors.YELLOW);
        System.out.println("=============== Search  ================");
        bst.search(bst.root, 40);
        bst.search(bst.root, 101);


        colorPrint("\n=========================================\n", Colors.YELLOW);
        System.out.println("=============== Delete  ================");
        bst.levelOrder();
        bst.delete(bst.root, 70);
        bst.levelOrder();
        bst.delete(bst.root, 41);


        colorPrint("\n=========================================\n", Colors.YELLOW);
        System.out.println("============= Delete Tree ===============");
        bst.deleteTree();
        bst.levelOrder();
    }

    private BinaryNode insert(BinaryNode current, int value) {
        if (current == null) {
            return new BinaryNode(value);
        } else if (value <= current.value) {
            current.left = insert(current.left, value);
            return current;
        } else {
            current.right = insert(current.right, value);
            return current;
        }
    }

    @Override
    public void insert(int value) {
        root = insert(root, value);
    }

    public BinaryNode delete(BinaryNode root, int value) {
        if (root == null) {
            colorPrintln(value + " does not exist in BST", Colors.RED);
            return null;
        }

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode minNodeRight = minimumNode(root.right);
                root.value = minNodeRight.value;
                root.right = delete(root.right, minNodeRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    @Override
    public void delete(int value) {
        root = delete(root, value);
    }
}

