package algorithm;

import java.util.Arrays;
// 最佳情况：T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
public class CountingSort {
    public static int[] CountingSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int bias, min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        bias = 0 - min; // 偏差，最小的数，使Counting数组bucket从0开始
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] + bias]++;
        }
        int index = 0, i = 0; // index：原数组索引，i：排序数组索引
        while (index < arr.length) {
            if (bucket[i] != 0) {
                arr[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 9, 7, 2, 3, 5, 4, 6};
        CountingSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
