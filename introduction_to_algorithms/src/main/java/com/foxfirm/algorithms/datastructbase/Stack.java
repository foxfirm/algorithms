package com.foxfirm.algorithms.datastructbase;

/**
 * Stack
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-11
 */
public class Stack {

    private int[] a;

    private static final int DEFAULT_INIT_SIZE = 11;

    private int top = 0;

    public Stack(int initialSize) {
        a = new int[initialSize];
    }

    public Stack() {
        a = new int[DEFAULT_INIT_SIZE];
    }


    public boolean isEmpty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int element) {
        a[++top] = element;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("underflow");
        } else {
            return a[top--];
        }
    }
}
