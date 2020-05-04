package algorithm;

import java.util.ArrayList;

public class BucketSort {
    /**
     *
     * @param array
     * @param bucketSize 每个桶存放数字的数量
     * @return
     */
    // 时间复杂度：最佳：T(n) = O(n)   最差：T(n) = O(n + nlogn – nlogm) 平均：O(n + nlogn – nlogm)，n个数字，m个桶
    // 空间复杂度：O(N+M)
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        // 创建桶
        int bucketCount = (max - min) / bucketSize + 1; // 桶的数量
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount); // 桶集合
        ArrayList<Integer> resultArr = new ArrayList<>(); // 要返回的数组
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将每个元素放入桶
        for (int i = 0; i < array.size(); i++) {
            // 桶编号：(array.get(i) - min) / bucketSize
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        // 对每个桶进行排序
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) { // 直到bucketCount > 2
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(bucketSort(arr, 5));
    }

}
