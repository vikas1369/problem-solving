package com.vikas.core.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args){

    }

    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i)> list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    void inOrderTraversal(TreeNode node){
        if(node == null) return;
        if(node.left!=null) inOrderTraversal(node);
        list.add(node.val);
        if(node.right!=null) inOrderTraversal(node);
    }
}
