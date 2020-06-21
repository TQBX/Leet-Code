package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Summerday
 *
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class Solution11 {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        for(int num:nums){

            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                temp = map.get(num);
                if(temp+1>len/2){
                    return num;
                }
                map.put(num,temp+1);
            }
        }
        return -1;
    }

    public int majorityElementByVotes(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        Solution11 s = new Solution11();
        System.out.println(s.majorityElement(arr));
    }

}
