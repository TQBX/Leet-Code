package array;

/**
 * @author Summerday
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution9 {


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null||matrix.length ==0||matrix[0].length ==0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0,j = col-1;
        while(i<=row-1&&j>=0){

            int curr = matrix[i][j];
            if( curr== target){
                return true;
            }else if(curr > target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Solution9 s = new Solution9();
        boolean numberIn2DArray = s.findNumberIn2DArray(matrix, 16);
        System.out.println(numberIn2DArray);
    }



}
