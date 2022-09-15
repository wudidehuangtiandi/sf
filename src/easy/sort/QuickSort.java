package easy.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 */
public class QuickSort {

    public static void main(String[] args) {

        int len = 12;
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("排序前的数组");
        System.out.println(Arrays.toString(arr));

        //排序
        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后的数组");
        System.out.println(Arrays.toString(arr));
    }

    //头尾指针相等时停止
    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(arr, low, high);
        //递归左右分支
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        //把最左边的元素当作基准值
        int key = arr[low];
        int left = low; //
        int right = high + 1;
        while (true) {
            //左指针遇到>=key的值，才停下
            while (arr[++left] < key) {
                if (left == high) {break;}
            }

            //右指针遇到<=key的值，才停下
            while (key < arr[--right]) {
                if (right == low) {break;}
            }


            if (left >= right) {
                //扫描了所有元素，结束循环
                break;
            } else {
                //交换左右指针
                swap(arr, left, right);
            }
        }
        //right指向的值一定是小于或等于key值，所以交换key和右指针的值
        swap(arr, low, right);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
