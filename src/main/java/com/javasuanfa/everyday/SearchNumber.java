package com.javasuanfa.everyday;

/**
 * @program: yarn
 * @description: Find any position of a target number in a sorted array. Return -1 if target does not exist.
 * @author: man.liang
 * @create: 2019-03-27 14:02
 **/
public class SearchNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4};
        int n = 3;
        System.out.println(binarySearch(arr, 1));

    }

    public static int binarySearch(int[] array, int number) {
        if (array == null)
            return -1;
        int low = 0;
        int high = array.length - 1;
        while (low <= high) { // 考虑到两个相等的时候
            int mid = low + (high - low) / 2;
            if (array[mid] == number) {
                return mid;
            } else if (array[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }
}
