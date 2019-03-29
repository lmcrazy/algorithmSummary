package com.javasuanfa.everyday;

/**
 * @program: yarn
 * @description: 代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，因此造成自身及之后版本的代码在单元测试中均出错。请找出第一个错误的版本号。
 * @author: liang.man
 * @create: 2019-03-29 21:48
 **/
public class FirstBadVersion {

    public static void main(String[] args) {


        System.out.println(findBadVersion(11));

    }

    public static int findBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (!isBadVersion(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static boolean isBadVersion(int var) {

        if (var >= 9)
            return true;
        return false;

    }
    // 下面是提交测试的内容
    public int findFirstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (!FirstBadVersion.isBadVersion(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }


}
