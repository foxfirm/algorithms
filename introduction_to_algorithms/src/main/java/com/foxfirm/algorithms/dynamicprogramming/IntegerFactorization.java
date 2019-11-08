package com.foxfirm.algorithms.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * IntegerFactorization
 *
 * @author huligang
 * @version 1.0
 * @since 2019-11-08
 */
public class IntegerFactorization {

    public static void main(String[] args) {
        Set<String> factor = new HashSet<String>();
        System.out.println(q(4, 4, factor));
        System.out.println(factor);
    }

    public static int q(int n, int m, Set<String> factor) {
        if (n == 1) {
            factor.add("1+");
            return 1;
        } else if (m == 1) {
            String f = "";
            for (int i = 0; i < n; i++) {
                f = f + "1+";
            }
            factor.add(f);
            return 1;
        } else if (m > n) {
            return q(n, n, factor);
        } else if (n == m) {
            return 1 + q(n, n - 1, factor);
        } else {
            return q(n - m, m, factor) + q(n, m - 1, factor);
        }
    }

}
