package algorithm;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left; // 左下标
        int j = right; // 右下标
        int temp = arr[left]; // 存放基数
        // 从右往左移位，直到小于temp停止
        while(i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            // 从左往右移位，直到大于temp停止
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                // 交换彼此数据
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        // 交换基位数据
        int t1 = arr[i];
        arr[i] = temp;
        arr[left] = t1;

        // 下一次迭代
        quickSort(arr, left, i-1); //左半边
        quickSort(arr, j+1, right); //右半边
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        // int[] arr = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length -1);
        for (int num : arr) {
            System.out.println(num);
        }
    }

}
