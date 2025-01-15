package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    int maxStreak = 0;
    int currStreak = 0;
    int currNum = 0;
    List<Integer> ans = new ArrayList();

    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        int num = node.val;
        if (num == currNum) {
            currStreak++;
        } else {
            currStreak = 1;
            currNum = num;
        }

        if (currStreak > maxStreak) {
            ans = new ArrayList();
            maxStreak = currStreak;
        }

        if (currStreak == maxStreak) {
            ans.add(num);
        }

        dfs(node.right);
    }
}
