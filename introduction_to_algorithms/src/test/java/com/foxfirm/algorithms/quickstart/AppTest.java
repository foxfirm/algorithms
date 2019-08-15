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
        tree.insert(2);
        tree.insert(23);
        tree.insert(21);
        tree.insert(222);
        tree.insert(12);
        tree.insert(23);

        tree.print();
    }
}
