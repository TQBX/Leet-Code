package array;

/**
 * @author Summerday
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {

    public int[] spiralOrder(int[][] matrix) {

        //判断空条件
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;


        boolean[][] visited = new boolean[rows][cols];

        int total = rows * cols;
        int[] arr = new int[total];
        //表示四个方向
        int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        int directionIndex = 0;

        int row = 0,col = 0;
        for (int i = 0; i < total; i++) {
            arr[i] = matrix[row][col];
            visited[row][col] = true;

            int nextRow = row+directions[directionIndex][0];
            int nextCol = col+directions[directionIndex][1];
            //如果走过,或者超出范围,换下一个方向
            if(nextRow<0||nextRow>=rows||nextCol<0||nextCol>=cols||visited[nextRow][nextCol]){
                directionIndex = (directionIndex+1)%4;
            }
            row+=directions[directionIndex][0];
            col+=directions[directionIndex][1];

        }
        return arr;
    }

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10,11,12}
        };
        int[] ints = s.spiralOrder(matrix);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
