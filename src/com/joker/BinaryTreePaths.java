package com.joker;

import java.util.ArrayList;
import java.util.List;

/**
 * 257
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {

    List<String> allPaths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return allPaths;

        StringBuilder sb = new StringBuilder();

        findPath(root, sb.append(root.val));
        return allPaths;
    }

    private void findPath(TreeNode node, StringBuilder path) {
        if (node.left == null && node.right == null)
            allPaths.add(path.toString());
        else {
            if (node.left != null)
                findPath(node.left, path.append("->").append(node.left.val));
            if (node.right != null)
                findPath(node.right, path.append("->").append(node.right.val));
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}