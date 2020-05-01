package algorithm;

import java.util.Arrays;

public class SortMethods {
    // 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    // 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) { //找到最小的数
                    minIndex = j; //将最小数的索引保存
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    // 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i]; //插入的数
            int index = i - 1; //被插入的位置（准备和前一个数比较）
            while (index >= 0 && insertVal < arr[index]) {
                arr[index + 1] = arr[index]; //将把arr[index]向后移动
                index--; //让index向前移动
            }
            arr[index + 1] = insertVal;
        }
        return arr;
    }

    // 希尔排序
    // 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
    public static int[] shellSort(int[] array) {
        int len = array.length;
        int insertVal, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                insertVal = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && insertVal < array[preIndex] ) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = insertVal;
            }
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 6, 72, 35, 23, 78, 61, 90, 32, 109};
        int[] arr1 = new int[] {49, 28, 65, 97, 76, 13, 27, 49};
        int[] arr2 = new int[] {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr3 = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] result = insertionSort(arr3);
        for (int num : result) {
            System.out.println(num);
        }
    }
}