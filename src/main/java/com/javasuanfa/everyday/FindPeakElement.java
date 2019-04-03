package com.javasuanfa.everyday;

/**
 * @program: yarn
 * @description: Find a peak element
 * @author: liang.man
 * @create: 2019-03-27 20:42
 **/
public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 3,4 , 6, 5};
        System.out.println(getAPeakEle(arr));
        System.out.println(findPeakElement(arr));

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

    public static int findPeakElement(int[] nums){
        int length = nums.length;
        if(length==0){
            return 0;
        }
        int left=0;
        int right=length-1;
        int mid;
        while(left<right){
            mid=left+((right-left)>>1);
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return right;
    }
}
