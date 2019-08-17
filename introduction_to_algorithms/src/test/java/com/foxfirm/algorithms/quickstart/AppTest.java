package com.foxfirm.algorithms.quickstart;

import com.foxfirm.algorithms.binarysearchtree.BinarySearchTree;
import com.foxfirm.algorithms.datastructbase.Stack;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testStack() throws Exception {
        System.out.println("welcome to junit test.");
        Stack stack = new Stack(100);
        stack.push(4);
        stack.push(49);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public void testBinarySortTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20, "dog");
        tree.insert(18, "gou");
        tree.insert(66, null);
        tree.insert(9, "wosh222");
        tree.insert(22, 9);
        tree.insert(19, 88);
        tree.insert(15, 88);
        tree.insert(14, 88);
        tree.insert(17, 88);
        tree.insert(12, 9);
        tree.insert(10, 88);
        tree.insert(17, 88);
        tree.insert(16, 88);
        tree.insert(16, 88);
        tree.insert(16, 88);

        BinarySearchTree.Node node = tree.search(15);


        tree.deleteMethod(node);

        tree.print();
    }
}
