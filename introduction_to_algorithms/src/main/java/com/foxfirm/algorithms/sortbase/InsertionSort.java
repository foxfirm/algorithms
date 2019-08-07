package com.foxfirm.algorithms.sortbase;

/**
 * InsertionSort
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-06
 */
public class InsertionSort {

    /**
     * 插入排序（升序）
     *
     * @param a
     */
    public void insertionSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
    }
}
