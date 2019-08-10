package com.foxfirm.algorithms.divideconquer;

import java.util.Arrays;

/**
 * MaximumSubarray
 * <p>最大子数组问题，多个连续的数组元素值之和达到最大值，
 * 采用分治策略求解
 *
 * @author huligang
 * @version 1.0
 * @since 2019-08-10
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(Arrays.toString(a));

        System.out.println((new MaximumSubarray()).getMaximumSubarray(a));
    }

    private int low = 0;

    private int high = 0;

    private int maxSum = 0;

    public MaximumSubarray() {
    }

    public MaximumSubarray(int low, int high, int maxSum) {
        this.low = low;
        this.high = high;
        this.maxSum = maxSum;
    }


    /**
     * 获取最大的一个子数组
     *
     * @param a
     * @return
     */
    public MaximumSubarray getMaximumSubarray(int[] a) {
        if (null == a || a.length == 0) {
            return null;
        }
        return findMaximumSubarray(a, 0, a.length - 1);
    }

    /**
     * 获取最大的一个子数组
     * <p>可能存在多个子数组达到最大和</p>
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private MaximumSubarray findMaximumSubarray(int[] a, int low, int high) {
        MaximumSubarray result = null;
        if (low == high) {
            result = new MaximumSubarray(low, high, a[low]);
            return result;
        }

        int mid = (low + high) / 2;
        MaximumSubarray leftMax = findMaximumSubarray(a, low, mid);
        MaximumSubarray rightMax = findMaximumSubarray(a, mid + 1, high);
        MaximumSubarray crossingMax = findMaxCrossingSubarray(a, low, mid, high);

        if (leftMax.getMaxSum() > rightMax.getMaxSum()) {
            if (leftMax.getMaxSum() > crossingMax.getMaxSum()) {
                result = leftMax;
            } else {
                result = crossingMax;
            }
        } else {
            if (rightMax.getMaxSum() > crossingMax.getMaxSum()) {
                result = rightMax;
            } else {
                result = crossingMax;
            }
        }
        return result;
    }

    /**
     * 计算分布在中点两端的最大数组
     *
     * @param a
     * @param low
     * @param mid
     * @param high
     * @return
     */
    private MaximumSubarray findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
        int leftMaxSum = a[mid];
        int leftMaxIndex = mid;
        int leftSum = 0;
        for (int i = mid; i >= low; i--) {
            leftSum = leftSum + a[i];
            if (leftSum > leftMaxSum) {
                leftMaxIndex = i;
                leftMaxSum = leftSum;
            }
        }

        int rightMaxSum = a[mid + 1];
        int rightMaxIndex = mid + 1;
        int rightSum = 0;
        for (int i = mid + 1; i <= high; i++) {
            rightSum = rightSum + a[i];
            if (rightSum > rightMaxSum) {
                rightMaxIndex = i;
                rightMaxSum = rightSum;
            }
        }

        MaximumSubarray result = new MaximumSubarray(leftMaxIndex, rightMaxIndex, leftMaxSum + rightMaxSum);
        return result;
    }


    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(int maxSum) {
        this.maxSum = maxSum;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("maxSubarray\n");
        sb.append("begin index: ").append(low).append("\n");
        sb.append("end index: ").append(high).append("\n");
        sb.append("max sum: ").append(maxSum).append("\n");
        return sb.toString();
    }
}
