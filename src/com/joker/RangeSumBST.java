package com.joker;

public class RangeSumBST {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(18);
        treeNode.right.right = new TreeNode(0);

        int sum = rangeSumBST(treeNode, 7, 15);
        System.out.println(sum);
    }

    private static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root != null) {
            if (root.val >= L && root.val <= R) {
                sum += root.val;
            }
            sum += rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
        return sum;
    }
}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

