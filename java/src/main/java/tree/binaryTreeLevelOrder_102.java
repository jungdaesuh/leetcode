package tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class binaryTreeLevelOrder_102 {


}

class iterative {

}

class recursion {
    List<List<Integer>> levels = new ArrayList<>();

    public void helper(TreeNode node, int level) {

        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        levels.get(level).add(node.val);

        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}