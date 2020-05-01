package algorithm;

/**
 * 二分查找
 * 又叫折半查找，要求待查找的序列有序。每次取中间位置的值与待查关键字比较，如果中间位置
 * 的值比待查关键字大，则在前半部分循环这个查找的过程，如果中间位置的值比待查关键字小，
 * 则在后半部分循环这个查找的过程。直到查找到了为止，否则序列中没有待查的关键字。
 */
public class BinarySearch {
    public static int biSearch(int[] array, int a) {
        int lo = 0; //lo
        int hi = array.length - 1; //high
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) /2; //中间位置
            if (a == array[mid]) {
                return mid + 1;
            } else if(a > array[mid]) { //向右查找
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] array = new int[10];
        int [] array = new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println(biSearch(array, 5));
    }
}
