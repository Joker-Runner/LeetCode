package com.joker;

import java.util.Arrays;
import java.util.HashSet;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        int[] inorder = new int[]{2,3,1};
        int[] postorder = new int[]{3,2,1};

        TreeNode tree = buildTree(inorder, postorder);
    }

    static HashSet<Integer> set = new HashSet<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        TreeNode tree = new TreeNode(postorder[postorder.length - 1]);
        set.add(tree.val);
        findSubNode(tree, inorder, postorder);
        return tree;
    }

    private static void findSubNode(TreeNode node, int[] inorder, int[] postorder) {
        int leftValueIndex = indexOf(node.val, inorder);
        if (leftValueIndex > 0 && !set.contains(inorder[leftValueIndex - 1])) {
            node.left = new TreeNode(inorder[leftValueIndex - 1]);
            set.add(node.left.val);
            findSubNode(node.left, inorder, postorder);
        }

        int rightValueIndex = indexOf(node.val, postorder);
        if (rightValueIndex > 0 && !set.contains(postorder[rightValueIndex - 1])) {
            node.right = new TreeNode(postorder[rightValueIndex - 1]);
            set.add(node.right.val);
            findSubNode(node.right, inorder, postorder);
        }
    }

    private static int indexOf(int value, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
