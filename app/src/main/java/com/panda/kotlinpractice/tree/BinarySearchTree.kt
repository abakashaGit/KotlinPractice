package com.panda.kotlinpractice.tree

import java.util.*

//date class to represent one node.
data class Node(var value: Int, var left: Node?, var right: Node?)

class BinarySearchTree(var root: Node? = null) {

    fun insert(key: Int) {
        root = insertRec(root, key)
    }

    /* A recursive function to
       insert a new key in BST */
    fun insertRec(root: Node?, key: Int): Node {

        /* If the tree is empty,
           return a new node */
        var root = root
        if (root == null) {
            root = Node(key, null, null)
            return root
        }

        /* Otherwise, recur down the tree */
        if (key < root.value)
            root.left = insertRec(root.left, key)
        else if (key > root.value)
            root.right = insertRec(root.right, key)


        /* return the (unchanged) node pointer */
        return root
    }

    fun findMin(root: Node) {
        var current: Node = root
        while (current.left != null) {
            current = current.left!!
        }
        println("the minimum value is ${current.value}")
    }

    fun findMax(root: Node) {
        var current: Node = root
        while (current.right != null) {
            current = current.right!!
        }
        println("max value is ${current.value}")
    }

    fun findHeight(root: Node?): Int {
        if (root == null) return -1;
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1
    }

    //Level order traversal - Breadth first search
    fun traverseLevelOrder(root: Node) {
        var levelQueue: Queue<Node> = LinkedList<Node>()
        levelQueue.offer(root)
        println("Printing level order ")
        while (!levelQueue.isEmpty()) {
            val current: Node = levelQueue.peek()
            print(" ${current.value}")
            levelQueue.let {
                current.left?.let { levelQueue.offer(it) }
                current.right?.let { levelQueue.offer(it) }
            }
//            levelQueue.run {
//                offer(current.left)
//                offer(current.right)
//            }
//            with(levelQueue){
//                offer(current.left)
//                offer(current.right)
//            }
//            levelQueue.apply {
//                offer(current.left)
//                offer(current.right)
//            }
            levelQueue.remove()
        }
    }
    //Depth first traverse
    fun preOrderTraverse(root: Node){
        print(" ${root.value}")
        root.left?.run { preOrderTraverse(this) }
        root.right?.run { preOrderTraverse(this) }
    }
    fun inOrderTraverse(root: Node?){
//        root.left?.run { preOrderTraverse(this) }
//        print(" ${root.value}")
//        root.right?.run { preOrderTraverse(this) }
        
    }
    fun postOrderTraverse(root: Node){
        root.left?.run { preOrderTraverse(this) }
        root.right?.run { preOrderTraverse(this) }
        print(" ${root.value}")
    }

}

fun main() {
    val myTree = BinarySearchTree()

    myTree.insert(50);
    myTree.insert(30);
    myTree.insert(20);
    myTree.insert(40);
    myTree.insert(70);
    myTree.insert(60);
    myTree.insert(80);
    myTree.root?.let { myTree.findMin(it) } ?: println("Tree is empty")
    myTree.root?.let { myTree.findMax(it) } ?: println("Tree is empty")
    //Null check will be done here wiht Elvis operator
    println("Height of the tree is ${myTree.root.let { myTree.findHeight(it) }}") // printing the height of the tree
    myTree.root?.run {
        myTree.traverseLevelOrder(this)
    } ?: println("Tree is empty")

    print(" PreOrderTraversal = ")
    myTree.root?.let { myTree.preOrderTraverse(it) }

    print(" InOrderTraversal = ")
    myTree.root?.let { myTree.inOrderTraverse(it) }

    print(" PostOrderTraversal = ")
    myTree.root?.let { myTree.postOrderTraverse(it) }
}
/*
        50
      30    70
    20  40 60  80
 */