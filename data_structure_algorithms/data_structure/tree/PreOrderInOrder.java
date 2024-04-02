package com.vikas.core.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class PreOrderInOrder {
    public static void main(String[] args){
        PreOrderInOrder preOrderInOrder = new PreOrderInOrder();
        preOrderInOrder.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelper(preorder, 0, inorder.length-1);
    }
    TreeNode buildTreeHelper(int[] preOrder, int start, int end){
        if(start>end || preIndex >= preOrder.length){
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preIndex++]);
        int inIndex = map.get(node.val);
        node.left = buildTreeHelper(preOrder, 0, inIndex-1);
        node.right = buildTreeHelper(preOrder, inIndex+1, end);
        return node;
    }
}
