package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.offer(root);

        int max = Integer.MIN_VALUE;
        int resLevel = 0;
        int currLevel = 0;

        while(!queue.isEmpty()) {
            List<TreeNode> levelNodes = new ArrayList<>();
            int levelSum = 0;
            while (!queue.isEmpty()) {

                TreeNode levelNode = queue.poll();
                levelSum += levelNode.val;
                levelNodes.add(levelNode);
            }
            currLevel++;
            if(levelSum > max) {
                max = levelSum;
                resLevel = currLevel;
            }

            for(TreeNode child : levelNodes) {
                if(child.left != null) queue.offer(child.left);
                if(child.right != null) queue.offer(child.right);
            }
        }

        return resLevel;
    }
}
