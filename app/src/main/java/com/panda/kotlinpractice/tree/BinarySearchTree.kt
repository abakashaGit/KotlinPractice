package com.panda.kotlinpractice.tree

import java.util.*


class Node(
    var key: Int,
    var left: Node? = null,
    var right: Node? = null
)

class BinarySearchTree(var root: Node? = null) {

    fun insert(key: Int) {
        root = insertRec(root, key)
    }

    /* A recursive function to
       insert a new key in BST */
    private fun insertRec(root: Node?, key: Int): Node {

        /* If the tree is empty,
           return a new node */
        var root = root
        if (root == null) {
            root = Node(key, null, null)
            return root
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key)
        else if (key > root.key)
            root.right = insertRec(root.right, key)


        /* return the (unchanged) node pointer */
        return root
    }

    fun findMin(root: Node) {
        var current: Node = root
        while (current.left != null) {
            current = current.left!!
        }
        println("the minimum value is ${current.key}")
    }

    fun findMax(root: Node) {
        var current: Node = root
        while (current.right != null) {
            current = current.right!!
        }
        println("max value is ${current.key}")
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
            print(" ${current.key}")
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
        print(" ${root.key}")
        root.left?.run { preOrderTraverse(this) }
        root.right?.run { preOrderTraverse(this) }
    }
    fun inOrderTraverse(root: Node?){
//        root.left?.run { preOrderTraverse(this) }
//        print(" ${root.value}")
//        root.right?.run { preOrderTraverse(this) }

        root?.left?.let { preOrderTraverse(it) }
        print(" ${root?.key}")
        root?.right?.let { preOrderTraverse(it) }

    }
    fun postOrderTraverse(root: Node){
        root.left?.run { preOrderTraverse(this) }
        root.right?.run { preOrderTraverse(this) }
        print(" ${root.key}")
    }

}

fun main() {
    val myTree = BinarySearchTree()

//    myTree.apply {
//
//        insert(50)
//
//        insert(30)
//        insert(70)
//
//        insert(20)
//        insert(40)
//        insert(60)
//        insert(80)
//
//        insert(10)
//
//    }

    val root = Node(12)
    root.left = Node(7)
    root.right = Node(1)
    root.left!!.left = Node(9)
    root.right!!.left = Node(10)
    root.right!!.right = Node(5)
    /*
        50
      30    70
    20  40 60  80
  10
 */

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
