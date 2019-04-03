package com.javasuanfa.everyday;

/**
 * @program: yarn
 * @description: sqrt
 * @author: liang.man
 * @create: 2019-04-03 17:36
 **/
public class FindSqrt {
    public static void main(String[] args) {

        System.out.println(getSqrt(9));
    }


    public static int getSqrt(int n) {
        if (n < 0)
            return -1;
        if (n <= 1)
            return n;
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid > n / mid) {
                high = mid - 1;
            } else if (mid < n / mid) {
                low = mid + 1;
            } else {
                return mid;
            }

        }


        return high;
    }
}
