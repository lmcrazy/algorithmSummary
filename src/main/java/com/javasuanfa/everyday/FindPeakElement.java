package com.javasuanfa.everyday;

/**
 * @program: yarn
 * @description: Find a peak element
 * @author: liang.man
 * @create: 2019-03-27 20:42
 **/
public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 1, 1, 6, 5};
        System.out.println(getAPeakEle(arr));


    }
    /** 给定的数组的元素是按照下面的方式排放的
     * 如果arr[n]<arr[n+1],表示处于上升阶段，low=mid+1,其他条件，则要更新high为mid
     *
     *  *     *
     * *  *  *   *
     *     *       *
     * @param array
     * @return
     */
    public static int getAPeakEle(int[] array) {
        if (array == null)
            return -1;
        if (array.length == 0)
            return -1;
        if (array.length == 1)
            return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low < high) {  //
            mid = low + (high - low) / 2;
            if (array[mid] < array[mid + 1]) {
                low = mid + 1;
            } else {
                //System.out.println("11");
                high = mid;
            }
        }

        return low;
    }
}
