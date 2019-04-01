package com.javasuanfa.everyday;

/**
 * @program: yarn
 * @description: Description Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element. You may assume no duplicate exists in the array.
 * @author: liang.man
 * @create: 2019-04-01 22:21
 **/
public class FIndMiniumElement {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(getMiniumEle(arr));


    }


    public static int getMiniumEle(int[] array) {

        if (array == null)
            return -1;
        if (array[0] <= array[array.length - 1]) // 判断是否旋转
            return array[0];
        int low = 0;
        int high = array.length - 1;
        int mid = -1;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (array[mid] > array[high]) { // 这个是最大值
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }

        return array[mid];
    }
}
