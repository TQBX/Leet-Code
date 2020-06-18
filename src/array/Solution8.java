package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Summerday
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution8 {

    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            if(map.containsKey(i)){
                return i;
            }else {
                map.put(i,1);
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums){

        for (int i = 0; i < nums.length ; i++) {
            //nums[i]可能为负(为负是因为这个下标对应的元素出现过了)，所以应该用绝对值表示
            int index = Math.abs(nums[i]);
            if (nums[index]<0)
                return index;
            nums[index] *= (-1) ;
        }
        return 0;
    }

    public int findRepeatNumber3(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution8 s = new Solution8();
        int repeatNumber = s.findRepeatNumber(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4});
        System.out.println(repeatNumber);
    }
}
