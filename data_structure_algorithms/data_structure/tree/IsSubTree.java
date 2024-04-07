package data_structure.tree;

import data_structure.tree.model.TreeNode;

public class IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(dfs(root, subRoot) == true) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean dfs(TreeNode root, TreeNode subroot){
        if(root== null && subroot == null) return true;
        if(root ==null || subroot == null) return false;
        if(root.val != subroot.val) return false;
        return dfs(root.left, subroot.left) && dfs(root.right, root.left);
    }
}
