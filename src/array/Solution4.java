package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Summerday
 * <p>
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4 {

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        if (k < 0) return count;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        for (int i : map.keySet()) {
            if (k == 0) {
                if (map.get(i) > 1)
                    count++;
            } else if (map.containsKey(i + k)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int pairs = s.findPairs(new int[]{1, 2, 3, 4, 5}, 1);
        System.out.println(pairs);
    }
}
