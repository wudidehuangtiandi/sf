package easy;

import structure.binarytree.BinaryTree;


/**
 * 二叉树遍历
 *        7
 *    4       9
 *  1   6   8  10
 */

public class BinaryTreeTraversal {
    public static void main(String[] args) {

        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(10);

        //遍历
        //binaryTree.PreorderTraversal(); //7 4 1 6 9 8 10
        //binaryTree.MidTraversal(); //1 4 6 7 8 9 10
        //binaryTree.PostTraversal(); //1 6 4 8 10 9 7

    }



}
