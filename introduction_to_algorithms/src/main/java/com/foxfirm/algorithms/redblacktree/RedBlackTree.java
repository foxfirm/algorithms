package com.foxfirm.algorithms.redblacktree;

/**
 * RedBlackTree
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-17
 */
public class RedBlackTree {

    Node root;
    Node nil = null;

    enum Color {
        RED, BLACK
    }

    public static class Node {
        int key;
        Node p;
        Node left;
        Node right;
        Color color;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key + ":" + color;
        }
    }

    /**
     * 向左旋转
     *
     * @param x
     */
    private void leftRotate(Node x) {
        Node y = x.right;

        // 将y的左子节点移到x的右子节点
        x.right = y.left;
        if (y.left != null) {
            y.left.p = x;
        }

        // 将y节点移到x节点
        y.p = x.p;
        if (x.p == null) {
            this.root = y;
        } else if (x.p.left == x) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }

        // 将x节点移到y的左子节点
        y.left = x;
        x.p = y;
    }

    /**
     * 向右旋转，假设x.left！=null
     *
     * @param x
     */
    private void rightRotate(Node x) {
        Node y = x.left;

        // 将y的右子节点移到x的左子节点
        x.left = y.right;
        if (y.right != null) {
            y.right.p = x;
        }

        // 将y节点移到x节点
        y.p = x.p;
        if (x.p == null) {
            this.root = y;
        } else if (x.p.left == x) {
            x.left.p = y;
        } else {
            x.p.right = y;
        }

        // 将x节点移到y的右子节点
        y.right = x;
        x.p = y;
    }

    public void rbInsert(RedBlackTree tree, Node z) {
        Node y = tree.nil;
        Node x = tree.root;
        while (x != tree.nil) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == tree.nil) {
            tree.root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = tree.nil;
        z.right = tree.nil;
        z.color = Color.RED;
        rbInsertFixup(tree, z);
    }


    public void rbInsertFixup(RedBlackTree tree, Node z) {

    }
}
