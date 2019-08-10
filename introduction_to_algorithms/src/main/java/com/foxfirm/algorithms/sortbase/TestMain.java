package com.foxfirm.algorithms.sortbase;

import com.foxfirm.algorithms.divideconquer.MaximumSubarray;

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

        //int[] a = {22, 33, 4, 32, 46, 5, 3, 29, 13};
        //int[] a = {5, 2, 4, 7, 1, 3, 2, 6};
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        //int[] a = {8, -9, 6, 1};
        System.out.println(Arrays.toString(a));
        //System.out.println("Insertion-sort!");
        //(new InsertionSort()).sort(a);
        //System.out.println("Merge-sort!");
        //(new MergeSort()).sort(a);
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        maximumSubarray = maximumSubarray.getMaximumSubarray(a);
        System.out.println(maximumSubarray);

    }
}
