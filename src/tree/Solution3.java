package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * created by Summer-day
 *
 *
 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution3 {

    //此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1+1 。

    /**
     *
     * DFS算法:
     * 终止条件： 当 root​ 为空，说明已越过叶节点，因此返回 深度 00 。
     * 递推工作： 本质上是对树做后序遍历。
     * 计算节点 root​ 的 左子树的深度 ，即调用 maxDepth(root.left)；
     * 计算节点 root​ 的 右子树的深度 ，即调用 maxDepth(root.right)；
     * 返回值： 返回 此树的深度 ，即 max(maxDepth(root.left), maxDepth(root.right)) + 1。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * BFS 算法 层序遍历
     * 树的层序遍历 / 广度优先搜索往往利用 队列 实现。
     * 关键点： 每遍历一层，则计数器 +1+1 ，直到遍历完成，则可得到树的深度。
     * 算法解析：
     * 特例处理： 当 root​ 为空，直接返回 深度 00 。
     * 初始化： 队列 queue （加入根节点 root ），计数器 res = 0。
     * 循环遍历： 当 queue 为空时跳出。
     * 初始化一个空列表 tmp ，用于临时存储下一层节点；
     * 遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp；
     * 更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue；
     * 统计层数： 执行 res += 1 ，代表层数加 11；
     * 返回值： 返回 res 即可。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */

    public int maxDepthBFS(TreeNode root){
        if(root == null) return 0;
        List<TreeNode>  queue = new LinkedList<TreeNode>(),tmp;
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
            res++;
            tmp = new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if(treeNode.left!=null) tmp.add(treeNode.left);
                if(treeNode.right!=null) tmp.add(treeNode.right);
            }
            /**
             * int n = queue.size();
             * for(int i = 0;i<n;i++){
             *      TreeNode node = queue.poll();
             *      if(node.left!=null) queue.add(node.left);
             *      if(node.right!=null) queue.add(node.right);
             *     }
             */
            queue = tmp;
        }
        return res;
    }

    /**
     * 判断是否为平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }
}
