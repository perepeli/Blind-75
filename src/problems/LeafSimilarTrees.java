package problems;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);

        if(l1.size() != l2.size()) return false;
        for(int i = 0; i < l1.size(); i++) {
            if(!(l1.get(i).equals(l2.get(i)))) return false;
        }
        return true;
    }

    private void dfs(TreeNode node, List<Integer> temp) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            temp.add(node.val);
            return;
        }
        dfs(node.left, temp);
        dfs(node.right, temp);
    }
}
