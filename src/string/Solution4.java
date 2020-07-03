package string;

/**
 * 转化未小写
 * created by Summer-day
 */
public class Solution4 {

  public String toLowerCase(String str) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) < 65 || str.charAt(i) > 90) {
        result.append(str.charAt(i));
      } else {
        result.append((char) ((int) (str.charAt(i)) + 32));
      }
    }
    return result.toString();
  }
}
