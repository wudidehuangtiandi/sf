package easy.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 原理，从头开始依次对比两个数，如果后一个比前一个大则交换位置。
 * 时间复杂度O(n^2) 空间复杂度O(1)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int m;
        int[] a = {1, 2, 88, 99, 55, 45, 66, 18, 35, 62, 84, 82, 25, 62, 33, 64, 9, 85, 24, 52, 56};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    m = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = m;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }


}
