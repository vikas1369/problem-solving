/*
https://leetcode.com/problems/diameter-of-binary-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        maxDepth(root, diameter);
        return diameter[0];
    }
    public int maxDepth(TreeNode root, int[] diameter) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left, diameter);
        int right = maxDepth(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left+ right);
        System.out.println("Diameter "+ diameter);
        return Math.max(left, right) +1;
    }
}