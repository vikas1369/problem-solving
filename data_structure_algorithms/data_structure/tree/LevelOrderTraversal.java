package com.vikas.core.leetcode.tree;

import data_structure.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    public static void main(String[] args){

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        pre(list,0, root);
        return list;
    }

    void pre(List<List<Integer>> list, int level, TreeNode root){
        if(root == null){
            return;
        }

        if(list.size() == level){
            List<Integer> levelList = new ArrayList<>();
            levelList.add(root.val);
            list.add(levelList);
        }else{
            list.get(level).add(root.val);
        }
        pre(list, level+1, root.left);
        pre(list, level+1, root.right);
    }
}
