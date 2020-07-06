package two_pointer;

import java.util.ArrayList;
import java.util.List;

/**
 *要用滑动窗口解这道题，我们要回答两个问题：
 *
 * 第一个问题，窗口何时扩大，何时缩小？
 * 第二个问题，滑动窗口能找到全部的解吗？
 * 对于第一个问题，回答非常简单：
 *
 * 当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
 * 当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
 * 当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)[i,j)，那么我们已经找到了一个 ii 开头的序列，也是唯一一个 ii 开头的序列，接下来需要找 i+1i+1 开头的序列，所以窗口的左边界要向右移动
 *
 * 作者：nettee
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 
 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * created by Summer-day
 */
public class Solution1 {
	
	public int[][] findContinuousSequence(int target) {
		int i = 1; //滑动窗口左边界
		int j = 1; //滑动窗口右边界
		int sum = 0;
		List<int[]> res = new ArrayList<>();
		
		while(i<=target/2){
			if(sum<target){
				//有边界右移
				sum+=j;
				j++;
			}else if(sum>target){
				//左边界右移
				sum-=i;
				i++;
			}else {
				//结果
				int[] arr = new int[j-i];
				for(int k = i;k<j;k++){
					arr[k-i] = k;
				}
				res.add(arr);
				sum-=i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}
}
