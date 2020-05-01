package com.joker;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5),null),new TreeNode(2));
        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode mergeTree = mergeTrees(t1, t2);

    }


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null) {
            t1 = t2;
        }else if(t2 != null){
            traversal(t1, t2);
        }

        return t1;
    }

    //同时遍历两个二叉树，判断一方为空，则直接拿另一方取代即可
    public static void traversal(TreeNode t1, TreeNode t2) {
        t1.val += t2.val;
        if(t1.left == null){
            t1.left = t2.left;
        }else if(t2.left != null){
            traversal(t1.left, t2.left);
        }
        if(t1.right == null){
            t1.right = t2.right;
        }else if(t2.right != null){
            traversal(t1.right, t2.right);
        }
    }


    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
