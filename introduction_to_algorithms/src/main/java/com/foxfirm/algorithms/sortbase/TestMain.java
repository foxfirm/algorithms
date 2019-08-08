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
        //int[] a = {5, 2, 4, 7, 1, 3, 2, 6};
        System.out.println(Arrays.toString(a));
        //System.out.println("Insertion-sort!");
        //(new InsertionSort()).sort(a);
        System.out.println("Merge-sort!");
        (new MergeSort()).sort(a);
        System.out.println(Arrays.toString(a));

    }
}
