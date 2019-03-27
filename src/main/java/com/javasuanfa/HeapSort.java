package com.javasuanfa;

/**
 * @program: yarn
 * @description:
 * @author: liang.man
 * @create: 2019-02-27 10:58
 **/
// https://blog.csdn.net/u010452388/article/details/81283998
public class HeapSort {
    public static void main(String[] args) {
        // 在创建大根堆的时候，元素要上浮
        int[] a = {1, 11, 2, 4, 57, 3};
        int len = a.length;
        buildheap(a);
        for (int b : a) {
            System.out.println(b);
        }

        System.out.println("--------");
        // 在排序的时候，元素要下沉
        while (len > 0) {
            swap(a, 0, len - 1);
            len--;
            heapify(a, 0, len);
        }
        for (int b : a) {
            System.out.println(b);
        }

    }


    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        // 判断孩子中，较大值的索引
        while (left < size) {
            int largest;
            if (right < size && arr[left] < arr[right]) {
                largest = right;
            } else {
                largest = left;
            }
            if (arr[index] > arr[largest]) {
                largest = index;
            }
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
            right = 2 * index + 2;

        }


    }

    public static void buildheap(int[] array) {

        int len = array.length;

        for (int i = 0; i < len; i++) {
            int currentIndex = i;
            int fatherIndex = (i - 1) / 2;
            while (array[currentIndex] > array[fatherIndex]) {
                swap(array, currentIndex, fatherIndex);
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex - 1) / 2;

            }


        }


    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
