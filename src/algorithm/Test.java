package algorithm;
public class Test {
    //声明全局变量，用于记录数组array的长度；
    static int len;
    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    public static void HeapSort(int[] array) {
        len = array.length;
        // 1.构建一个最大堆
        buildMaxHeap(array);
        // 2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            adjustHeap(array, 0);
        }
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = len / 2 - 1; i >= 0 ; i--) {
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (2 * i < len && array[2 * i] > array[i]) {
            maxIndex = 2 * i;
        }
        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (2 * i + 1 < len && array[2 * i + 1] > array[i]) {
            maxIndex = 2 * i + 1;
        }
        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, i, maxIndex);
            adjustHeap(array, maxIndex);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[i] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {90, 80, 70, 60, 50, 40, 30, 20 ,10, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
