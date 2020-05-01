package algorithm;

import java.util.Arrays;

public class MergeSort {
    // 归并排序
    // 始终都是O(n log n）的时间复杂度
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        int[] leftTemp = mergeSort(left);
        int[] rightTemp = mergeSort(right);
        int[] mergeRes = merge(leftTemp, rightTemp);
        //int[] mergeRes = merge(mergeSort(left), mergeSort(right));
        return mergeRes;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) { // 前两个if判断左右数组是否取完，如left取完，依次把right放入临时数组
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) { // 右小取右，索引+1
                result[index] = right[j++];
            } else { // left[i] <= right[j] 左小取左，索引+1
                result[index] = left[i++];
            }
        }
        return result;
    }

    // 方法2
    public static void mergeSort1(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void sort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        sort(data, left, center);
        // 对右边数组进行递归
        sort(data, center + 1, right);
        // 合并
        merge(data, left, center, right);
    }

    private static void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length]; // 临时数组
        int mid = center + 1; // 右数组第一个元素索引
        int third = left; // third记录临时数组的索引
        int tmp = left; // 缓存左数组的第一个元素的索引
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 4, 5, 7, 1, 3, 6, 2};
        int[] result = mergeSort(arr);
        for (int num : result) {
            System.out.println(num);
        }
    }

}
