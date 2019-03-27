package com.javasuanfa;

/**
 * @program: yarn
 * @description:
 * @author: liang.man
 * @create: 2019-02-25 11:00
 **/
public class Lcs {

    public static void main(String[] args) {


    }

    public static int findLcs(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int ab[][] = new int[lena + 1][lenb + 1];

        for (int i = 0; i <= lena; i++) {
            for (int j = 0; j <= lenb; j++) {
                ab[i][j] = 0;
            }
        }


        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    ab[i][j] = ab[i - 1][j - 1] + 1;

                } else {
                    ab[i][j] = ab[i - 1][j] >= ab[i][j - 1] ? ab[i - 1][j] : ab[i][j - 1];
                }
            }
        }
        int max = ab[lena][lenb];


        return max;

    }
}
