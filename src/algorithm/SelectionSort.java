package algorithm;

public class SelectionSort {
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

    public static void main(String[] args) {
        int[] arr = new int[] {1, 6, 72, 35, 23, 78, 61, 90, 32, 109};
        selectionSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }

    }
}
