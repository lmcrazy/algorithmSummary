package com.javasuanfa.everyday;

/**
 * @program: yarn
 * @description: Find first target,
 * 在排序的数组中，有可能是升序排序，找到对应的目标之后，前面还可能是目标值，因此要向前遍历
 * @author: liang.man
 * @create: 2019-03-28 22:36
 **/
public class FindFirstTarget {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 5, 6, 7};
        System.out.println(findFirstTarget(arr, 2));
    }

    public static int findFirstTarget(int[] arr, int target) {
        if (arr == null)
            return -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1); // 一定要加上括号，+号的优先级高于 >>
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {

                while ((mid - 1) >= 0 && arr[mid - 1] == target) {
                    --mid;
                }
                return mid;
            }
        }


        return -1;
    }
}
