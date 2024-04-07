package data_structure.tree;/*
https://leetcode.com/problems/same-tree/
*/


import data_structure.tree.model.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q== null){
            return true;
        }else if(p == null && q!= null){
            return false;
        }else if(q == null && p!= null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else{
            boolean leftFlag = isSameTree(p.left, q.left);
            boolean rightFlag = isSameTree(p.right, q.right);
            return leftFlag && rightFlag;
        }
    }
}