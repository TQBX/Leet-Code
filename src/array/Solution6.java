package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Summerday
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Solution6 {

    /**
     * 自己完成
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        //只要k次遍历即可
        for (int i = 0; i < k; i++) {
            //每次将相对首个作为最小值,遍历后面的,如果有更小的就交换
            int min = arr[i];
            int j;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    arr[j] = arr[j] + min;
                    min = arr[j] - min;
                    arr[j] = arr[j] - min;
                }
                res[i] = min;
            }
            //如果k = len,处理
            res[i] = min;
        }
        return res;
    }

    public int[] getLeastNumsWithQueue(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }


    public int[] getLeastNumsWithQuickSort(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        // 原地不断划分数组
        partitionArray(arr, 0, arr.length - 1, k);

        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        if (k >= 0) System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    void partitionArray(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作
        int m = partition(arr, lo, hi);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < m) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            partitionArray(arr, lo, m - 1, k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数
            partitionArray(arr, m + 1, hi, k);
        }
    }

    // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
// 代码参考 Sedgewick 的《算法4》
    int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Solution6 s = new Solution6();
        int[] leastNumbers = s.getLeastNumbers(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4
        }, 10);
        int[] leastNumbers2 = s.getLeastNumsWithQueue(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4
        }, 10);
        int[] leastNumbers3 = s.getLeastNumsWithQuickSort(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4
        }, 10);
        System.out.println(Arrays.toString(leastNumbers3));

    }
}
