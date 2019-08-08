package com.foxfirm.algorithms.sortbase;

/**
 * InsertionSort
 * <p>插入排序，其思想如同玩扑克抓牌时，
 * 在手中对扑克进行排序，左手的牌都是排好的，右手中的那张是即将插入的，
 * 桌子上盖住的牌是未排序的
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
    public void sort(int[] a) {
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
