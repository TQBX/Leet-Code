package tree;

import java.util.*;

/**
 * created by Summer-day
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * <p>
 * Root
 * / \
 * l   r
 * / \ / \
 */
public class Solution4 {

    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);

    }

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化,加入非空的root节点
        queue.add(root);
        //如果没有协议层就跳出循环
        while (!queue.isEmpty()) {
            //存放该层节点的值
            List<Integer> oneLevel = new ArrayList();
            //记录下一层的节点数
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                //取出节点queue中节点,分别加入该节点的非空左右子节点
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //头插
            res.addFirst(oneLevel);
        }
        return res;
    }
}
