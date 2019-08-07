package com.foxfirm.algorithms.sortbase;

import java.util.Arrays;

/**
 * TestMain
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-07
 */
public class TestMain {

    public static void main(String[] args) {

        int[] a = {22, 33, 4, 32, 46, 5, 3, 29, 13};
        System.out.println(Arrays.toString(a));
        System.out.println("Insertion-sort!");
        (new InsertionSort()).insertionSort(a);
        System.out.println(Arrays.toString(a));

    }
}
