package com.vikas.core.leetcode.tree;

public class GoodNode {
    int count = 0;
    public static void main(String[] args){

    }
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    void dfs(TreeNode node, int max){
        if(node==null){
            return;
        }
        if(node.val>=max){
            count++;
        }
        dfs(node.left, Math.max(max, node.val));
        dfs(node.right, Math.max(max, node.val));
    }
}
