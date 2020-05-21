package array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Summerday
 *
 * 找到第三大的数,如果没有,则输出最大的数
 */
public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.thirdMax(new int[]{1,2});
        System.out.println(i);
    }
    public int thirdMax(int[] nums){

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] newArr = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            newArr[i++] = integer;
        }
        Arrays.sort(newArr);
        System.out.println(Arrays.toString(newArr));
        int len = newArr.length;
        return len<3?newArr[len-1]:newArr[len-3];
    }

}
