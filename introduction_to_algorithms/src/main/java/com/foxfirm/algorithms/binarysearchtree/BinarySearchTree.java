package com.foxfirm.algorithms.binarysearchtree;

/**
 * BinarySearchTree
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-15
 */
public class BinarySearchTree {

    private Node root;

    static class Node {
        int key;
        Object data;
        Node parent;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    public void print() {
        inorderWalk(root);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private void inorderWalk(Node node) {
        if (node != null) {
            inorderWalk(node.left);
            System.out.println(node.key);
            inorderWalk(node.right);
        }
    }

    /**
     * 从树中查找卫星数据
     *
     * @param k
     * @return
     */
    public Object search(int k) {
        Node node = search(root, k);
        return node == null ? null : node.data;
    }

    /**
     * 根据k从x为根结点的树查找元素
     *
     * @param x
     * @param k
     * @return
     */
    private Node search(Node x, int k) {
        while (x != null && x.key != k) {
            if (k < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    /**
     * 将key插入二叉搜索树
     *
     * @param key
     */
    public void insert(int key) {
        insert(key, null);
    }

    /**
     * 将key和卫星数据插入二叉搜索树
     *
     * @param k
     * @param data
     */
    public void insert(int k, Object data) {
        Node z = new Node(k, data);
        Node y = null;
        Node x = this.root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            this.root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }
}
