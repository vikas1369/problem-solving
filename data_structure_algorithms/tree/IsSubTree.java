package com.vikas.core.leetcode.tree;

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
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }