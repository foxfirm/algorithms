package com.foxfirm.algorithms.binarysearchtree;

import java.util.Arrays;
import java.util.LinkedList;

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
            //return key + ":" + data;
            return "" + key;
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

    public String display() {
        LinkedList<LinkedList<Node>> rowList = new LinkedList<>();
        LinkedList<Node> row = new LinkedList<>();
        row.add(root);
        rowList.add(row);
        boolean hasMore = true;
        while (hasMore) {
            hasMore = false;
            LinkedList<Node> newRow = new LinkedList<>();
            for (int i = 0; i < row.size(); i++) {
                if (row.get(i) != null) {
                    newRow.add(row.get(i).left);
                    newRow.add(row.get(i).right);
                    if (row.get(i).left != null || row.get(i).right != null) {
                        hasMore = true;
                    }
                }
            }
            if (hasMore) {
                rowList.add(newRow);
                row = newRow;
            }
        }

        int high = rowList.size();
        //int maxColumnNum = (int) Math.pow(2, high - 1);

        LinkedList<LinkedList<Character>> image = new LinkedList<>();
        for (int i = 0; i < high; i++) {
            LinkedList<Character> chars = new LinkedList<>();

            LinkedList<Node> perRow = rowList.get(i);
            String testStr = "";
            for (int j = 0; j < perRow.size(); j++) {

                //testStr = "";
                if (perRow.get(j) != null) {
                    // 坐标
                    int firstLength = (int) Math.pow(2, high - i - 1) - 1;
                    int interval = (int) Math.pow(2, high - i);
                    int x = firstLength + j * interval;

                    testStr = appendCoord(testStr, x, perRow.get(j));
                }

            }
            System.out.println(testStr);
        }

        // test


        return Arrays.toString(rowList.toArray());
    }

    public String appendCoord(String s, int x, Node node) {
        //System.out.println("s:" + s + ",x:" + x + ",key:" + node);

        char[] keys = String.valueOf(node.key).toCharArray();
        char[] olds = s.toCharArray();
        char[] news = new char[x + keys.length];
        for (int i = 0; i < news.length; i++) {
            news[i] = '_';
        }

        if (olds.length <= news.length) {
            for (int i = 0; i < olds.length; i++) {
                news[i] = olds[i];
            }
            for (int j = x, k = 0; j < x + keys.length; j++, k++) {
                news[j] = keys[k];
            }
            StringBuilder sb = new StringBuilder();
            for (char c : news) {
                sb.append(c);
            }
            String ret = sb.toString();
            return ret;
        } else {
            for (int j = x - 1, k = 0; j < x - 1 + keys.length; j++) {
                olds[j] = keys[k++];
            }
            StringBuilder sb = new StringBuilder();
            sb.append(olds);
            return sb.toString();
        }
    }


    /**
     * 树的高度
     *
     * @param root
     * @return
     */
    public int getHigh(Node root) {
        return (root == null) ? 0 : Math.max(getHigh(root.left), getHigh(root.right)) + 1;
    }

    private void writeArray(Node curNode, int rowIndex, int columnIndex, String[][] res, int high) {
        if (curNode == null) {
            return;
        }
        res[rowIndex][columnIndex] = String.valueOf(curNode.key);
        int curLevel = (rowIndex + 1) / 2;
        if (curLevel == high) {
            return;
        }
        int gap = high - curLevel - 1;

        if (curNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(curNode.left, rowIndex + 2, columnIndex - gap * 2, res, high);
        }

        if (curNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(curNode.right, rowIndex + 2, columnIndex + gap * 2, res, high);
        }
    }

    public void displayTree(Node root) {
        if (root == null) {
            System.out.println("Empty!");
            return;
        }
        int high = getHigh(root);

        int arrayHigh = high * 2 - 1;
        int arrayWidth = (2 << (high - 2)) * 3 + 1;

        String[][] res = new String[arrayHigh][arrayWidth];
        for (int i = 0; i < arrayHigh; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        writeArray(root, 0, arrayWidth / 2, res, high);

        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i < line.length) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }


}
