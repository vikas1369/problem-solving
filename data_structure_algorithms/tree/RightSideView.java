package com.vikas.core.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args){

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideVisit(list, 0,root);
        return list;
    }

    private void rightSideVisit(List<Integer> list, int depth, TreeNode root) {
        if (root == null){
            return;
        }

        if(depth == list.size()){
            list.add(root.val);
        }

        rightSideVisit(list, depth+1, root.right);
        rightSideVisit(list, depth+1, root.left);
    }
}
