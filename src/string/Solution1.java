package string;

/**
 * @author Summerday
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {

    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //定义单词开始的条件:单词前为空格,或者本身为初始字符.
            if((i == 0||s.charAt(i-1) == ' ')&&s.charAt(i)!=' '){
                count++;
            }
        }
        return count;

    }
}