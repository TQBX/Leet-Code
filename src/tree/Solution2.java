package tree;

/**
 * created by Summer-day
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Solution2 {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        //中序遍历倒叙  右-->根-->左  --> 递减
        //每经过一个节点 K-1 ,k==0时,直接返回
        this.k = k;
        dfs(root);
        return res;

    }
    //逆向中序遍历 : 右 根 左  输出递增
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k<0) res = root.val;
        dfs(root.left);
    }
}
