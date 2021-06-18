package com.panda.kotlinpractice.patterns.binary_tree_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RightViewOfBinaryTree  {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int levelSize = queue.size();
                for (int i=0; i < levelSize; i++){
                    TreeNode currentNode = queue.poll();
                    if (i == levelSize - 1) // check if this node is last node.
                        // i == 0 this condition can print left view of the tree
                        result.add(currentNode);
                    if (currentNode.left != null) queue.offer(currentNode.left);
                    if (currentNode.right != null) queue.offer(currentNode.right);
                }


            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewOfBinaryTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}


