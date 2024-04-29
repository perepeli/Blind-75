package problems;

import problems.util.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if(node == null) return 0;

        int maxLeft = dfs(node.left, res);
        int maxRight = dfs(node.right, res);

        int max = node.val + Math.max(Math.max(maxLeft, 0), Math.max(maxRight, 0));

        int currentMax = node.val + (Math.max(maxLeft, 0)) + (Math.max(maxRight, 0));

        res[0] = Math.max(res[0], currentMax);

        return max;
    }
}
