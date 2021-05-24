package com.panda.kotlinpractice.patterns.binary_st;

import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
};

public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root, boolean isReverseLevel) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }
                if(isReverseLevel){
                    result.add(0,currentLevel);
                }else{
                    result.add(currentLevel);
                }

            }

        }

        return result;
    }


    public static List<List<Integer>> traverseZigzag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
            boolean isLeftToRight = true; // for  zigzag
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    if (isLeftToRight){
                        currentLevel.add(currentNode.val);
                    }else{
                        currentLevel.add(0,currentNode.val);
                    }

                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }
                isLeftToRight = !isLeftToRight;
                result.add(currentLevel);

            }

        }

        return result;
    }

    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if(root != null){
            Queue<TreeNode> levelQueue = new LinkedList<>();
            levelQueue.offer(root);
            while(!levelQueue.isEmpty()){
                int numberOfElement = levelQueue.size();
                int levelSum = 0;
                TreeNode currentNode = levelQueue.poll();
                for(int i = 0; i < numberOfElement; i++){
                    levelSum += currentNode.val;
                }
                result.add(Double.valueOf(levelSum/numberOfElement));
                if(currentNode.left != null) levelQueue.offer(currentNode.left);
                if(currentNode.right != null) levelQueue.offer(currentNode.right);
            }
        }
        return result;
    }

    private static int findMinDepth(TreeNode root){
        if (root == null) return -1;
        int minDepth =-1; // depth of root node is 0
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            minDepth++;
            int levelsize = queue.size();
            for (int i=0; i<levelsize; i++){
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null || currentNode.right == null)
                    return minDepth;
                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(12);
//        root.left = new TreeNode(7);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(9);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(5);
//        List<List<Integer>> result = LevelOrderTraversal.traverse(root,true);
//        System.out.println("Level order traversal: " + result);

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);

        List<List<Integer>> result = LevelOrderTraversal.traverseZigzag(root);
        System.out.println("zigzag traversal: " + result);
    }
}
