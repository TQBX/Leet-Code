package dfs_bfs_dp;

import java.util.Arrays;

/**
 * @author Summerday
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class Solution2 {
    public int nthUglyNumber(int n) {
        //初始化
        int a = 0,b = 0,c = 0;
        int[]dp = new int[n];
        //初始状态定义
        dp[0] = 1;
        for(int i = 1;i<n;i++){
            int n2 = dp[a]*2;
            int n3 = dp[b]*3;
            int n5 = dp[c]*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            //分别用三个if,过滤重复解的情况
            if(dp[i] == n2) a++;
            if(dp[i] == n3)b++;
            if(dp[i] == n5)c++;
        }

        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int i = s.nthUglyNumber(
                11
        );
        System.out.println(i);
    }
}
