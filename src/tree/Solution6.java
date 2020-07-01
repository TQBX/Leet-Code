package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * offer27 二叉树镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * created by Summer-day
 */
public class Solution6 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {

            int count = queue.size();
            TreeNode node = queue.poll();

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

        }
        return root;
    }
}
