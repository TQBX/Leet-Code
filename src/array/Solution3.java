package array;

/**
 * @author Summerday
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 */
public class Solution3 {

    public int fib(int N) {

        if(N == 0||N == 1){
            return N;
        }else {
            return fib(N-1)+fib(N-2);
        }
    }

    public int fib_2(int N) {
        int[] fibArray = new int[N + 1];
        fibArray[0] = 0;
        if(N > 0) fibArray[1] = 1;
        for(int i = 2; i <= N; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray[N];
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.fib(4));
    }
}
