package com.foxfirm.algorithms.sortbase;

import java.util.Arrays;

/**
 * MergeSort
 * <p>归并排序，采用分治思想，将原n个元素序列分解成各具n/2个元素的的两个子序列，递归的排序两个子序列，
 * 然后合并已经排序的子序列以产生已排序的目标序列
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-08
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] a = {22, 33, 4, 32, 46, 5, 3, 29, 13};
        System.out.println(Arrays.toString(a));

        System.out.println("Merge-sort!");
        (new MergeSort()).sort(a);
        System.out.println(Arrays.toString(a));

    }

    /**
     * 归并排序
     *
     * @param a
     */
    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * 分治法归并排序
     *
     * @param a
     * @param p
     * @param r
     */
    private void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    /**
     * 合并两个已经排好序的序列
     *
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i = 0, j = 0;
        for (i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = a[q + j + 1];
        }
        i = 0;
        j = 0;
        for (int k = p; k <= r; k++) {
            // 合并完了其中一个子序列，剩下的另一个子序列的元素直接按序放入，然后退出循环排序完成
            if (i >= n1) {
                for (; j < n2; ) {
                    a[k++] = right[j++];
                }
                break;
            }
            if (j >= n2) {
                for (; i < n1; ) {
                    a[k++] = left[i++];
                }
                break;
            }

            // 按顺序合并两个子序列
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
        }
    }

}
