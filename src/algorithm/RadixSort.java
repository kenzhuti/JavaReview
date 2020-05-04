package algorithm;

import java.util.ArrayList;

public class RadixSort {
    // 最佳情况：T(n) = O(n * k)   最差情况：T(n) = O(n * k)   平均情况：T(n) = O(n * k)
    public static int[] radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        // 1. 先算出最大数的位数
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0; // 最大位数
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) { // 共10个数字，0—9
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++) { // 位数
            // 放入桶中
            for (int j = 0; j < array.length; j++) { // 遍历每个数
                int num = (array[j] % (int)Math.pow(10, i + 1)) / (int)Math.pow(10, i); //得到数字的第i+1位数
                bucketList.get(num).add(array[j]);
            }
            // 依次取出
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }

}
