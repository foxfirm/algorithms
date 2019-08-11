package com.foxfirm.algorithms.quicksort;

import java.util.Arrays;

/**
 * QuickSort
 * <p>快速排序，使用分治思想，将数组a[p..r]分为两个子数组a[p..q-1]，a[q+1..r]以及一个"中间值"a[q]，
 * 使得a[p..q-1]中的每个元素小于等于a[q]，而a[q]也小于a[q+1..r]中的每个元素，然后通过递归调用子数组a[p..q-1]和
 * a[q+1..r]进行排序，由于子数组都是原址排序的，因此无需整合操作，递归完成后直接排序完成
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-11
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] a = {22, 33, 4, 32, 46, 5, 3, 29, 13};
        System.out.println(Arrays.toString(a));

        System.out.println("Quick-sort!");
        (new QuickSort()).sort(a);
        System.out.println(Arrays.toString(a));

    }


    /**
     * 快速排序
     *
     * @param a
     */
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 快速排序
     * <p>首先划分数组，满足左子数组元素全部小于右子数组元素，
     * 然后递归调用左右子数组进行排序
     *
     * @param a
     * @param p
     * @param r
     */
    private void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    /**
     * 将数组a[p..r]分为两个子数组a[p..q-1]，a[q+1..r]以及一个"中间值"a[q]，
     * 使得a[p..q-1]中的每个元素小于等于a[q]，而a[q]也小于a[q+1..r]中的每个元素，
     * 并且返回q值
     *
     * @param a
     * @param p
     * @param r
     * @return
     */
    private int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[r];
        a[r] = temp;
        return i + 1;
    }

}
