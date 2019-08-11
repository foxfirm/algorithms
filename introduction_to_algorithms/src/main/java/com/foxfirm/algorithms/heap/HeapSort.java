package com.foxfirm.algorithms.heap;

import java.util.Arrays;

/**
 * HeapSort
 * <p>堆排序，通过构造最大堆进行排序
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-11
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] a = {22, 33, 4, 32, 46, 5, 3, 29, 13};
        System.out.println(Arrays.toString(a));

        System.out.println("Heap-sort!");
        (new HeapSort()).sort(a);
        System.out.println(Arrays.toString(a));

    }


    /**
     * 堆排序
     *
     * @param a
     */
    public void sort(int[] a) {
        heapSort(a);
    }

    /**
     * 堆排序
     * <p>首先构造一个最大堆，然后每次将堆顶元素与堆尾元素进行交换，堆的大小
     * 减一，再维护最大堆性质，不断重复，直到堆的大小为1
     *
     * @param a
     */
    private void heapSort(int[] a) {
        buildMaxHeap(a);
        int heapSize = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapSize--;
            maxHeapify(a, 0, heapSize);
        }
    }

    /**
     * 构建最大堆
     * <p>采用自底向上的方法，利用维护最大堆性质方法，将数组转换成最大堆</p>
     *
     * @param a
     */
    private void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }

    /**
     * 维护最大堆性质
     * <p>二叉树节点大于或者等于两个子节点,
     * 此方法基于子树都是最大堆的条件下成立
     *
     * @param a
     * @param i
     * @param heapSize
     */
    private void maxHeapify(int[] a, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int largest = i;
        if (left < heapSize && a[i] < a[left]) {
            largest = left;
        }
        if (right < heapSize && a[largest] < a[right]) {
            largest = right;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify(a, largest, heapSize);
        }
    }
}
