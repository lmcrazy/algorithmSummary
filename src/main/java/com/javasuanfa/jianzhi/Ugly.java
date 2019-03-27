package com.javasuanfa.jianzhi;

import java.util.ArrayList;

/**
 * @program: yarn
 * @description:
 * @author: liang.man
 * @create: 2019-03-11 18:10
 **/
public class Ugly {

    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index) {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int temp = Math.min(m2, Math.min(m3, m5));
            list.add(temp);
            if (temp == m2) ++i2;
            if (temp == m3) ++i3;
            if (temp == m5) ++i5;
        }
        return list.get(index - 1);
    }

}
