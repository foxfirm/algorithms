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

    public Node getRoot() {
        return root;
    }

    public static class Node {
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

        @Override
        public String toString() {
            return key + ":" + data;
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
            System.out.println(node.key + "-" + node.data);
            inorderWalk(node.right);
        }
    }

    /**
     * 从树中查找元素
     *
     * @param k
     * @return
     */
    public Node search(int k) {
        return search(root, k);
    }

    /**
     * 根据k从x为根结点的树查找元素
     *
     * @param x
     * @param k
     * @return
     */
    public Node search(Node x, int k) {
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
     * 最小节点
     *
     * @param x
     * @return
     */
    public Node minimum(Node x) {
        while (x != null && x.left != null) {
            x = x.left;
        }
        return x;
    }

    /**
     * 最大节点
     *
     * @param x
     * @return
     */
    public Node maximum(Node x) {
        while (x != null && x.right != null) {
            x = x.right;
        }
        return x;
    }

    /**
     * 后继
     *
     * @param x
     * @return
     */
    public Node successor(Node x) {
        if (x.right != null) {
            return minimum(x.right);
        }
        Node p = x.parent;
        while (p != null && p.right == x) {
            x = p;
            p = p.parent;
        }
        return p;
    }

    /**
     * 前驱
     *
     * @param x
     * @return
     */
    public Node predecessor(Node x) {
        if (x.left != null) {
            return maximum(x.left);
        }
        Node p = x.parent;
        while (p != null && p.left == x) {
            x = p;
            p = p.parent;
        }
        return p;
    }

    /**
     * 将key和数据插入二叉搜索树
     *
     * @param key
     */
    public void insert(int key, Object data) {
        Node z = new Node(key, data);
        insert(z);
    }

    /**
     * 将节点插入二叉搜索树
     *
     * @param z
     */
    public void insert(Node z) {
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

    /**
     * 将v节点替换u节点
     *
     * @param u
     * @param v
     */
    private void transplant(Node u, Node v) {
        if (u.parent == null) {
            this.root = v;
        } else if (u.parent.left == u) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }

    /**
     * 删除节点，右子节点代替原来节点位置
     *
     * @param z
     */
    public void delete(Node z) {
        if (z.left == null) {
            transplant(z, z.right);
        } else if (z.right == null) {
            transplant(z, z.left);
        } else {
            transplant(z, z.right);
            Node y = minimum(z.right);
            y.left = z.left;
            y.left.parent = y;
        }
        z = null;
    }

    /**
     * 删除节点，后继节点替代原来节点位置
     *
     * @param z
     */
    public void deleteMethod(Node z) {
        if (z.left == null) {
            transplant(z, z.right);
        } else if (z.right == null) {
            transplant(z, z.left);
        } else {
            Node s = minimum(z.right);
            if (s.parent != z) {
                transplant(s, s.right);
                s.right = z.right;
                s.right.parent = s;
            }
            transplant(z, s);
            s.left = z.left;
            s.left.parent = s;
        }
    }
}
