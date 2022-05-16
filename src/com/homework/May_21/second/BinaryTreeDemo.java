package com.homework.May_21.second;

import com.homework.May_21.BinaryNode;
import com.homework.May_21.first.BinaryTree;

/**
 * (6-2)
 *
 * @Author hongxiaobin
 * @Time 2022/5/16-14:29
 */
public class BinaryTreeDemo {
    /**
     * （6-2）1验证二叉树的性质3
     *
     * @Param:
     * @Return:
     */
    public static <T extends Comparable<T>> void property3(BinaryTree<T> bitree) {

    }

    /**
     * （6-2）2交换结点的左右子树，使用前序遍历
     *
     * @Param:
     * @Return:
     */
    public static <T extends Comparable<T>> void swapPre(BinaryTree<T> bitree) {
        if (bitree.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        swapTreePre(bitree.getRoot());
    }

    private static <T extends Comparable<T>> void swapTreePre(BinaryNode<T> node) {
        if (node != null) {
//            交换左右子树
            BinaryNode<T> temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
//            遍历左子树
            swapTreePre(node.getLeft());
//            遍历右子树
            swapTreePre(node.getRight());
        }
    }

    /**
     * （6-2）2交换结点的左右子树，使用中序遍历
     * 由于左子树交换后，经过根节点时，再交换一遍，原来的左变为右，原来的右子树变为左子树，而新的左子树没有进行交换过
     * 也就是左边的交换完之后换到右边时，又被交换一遍
     * @Param:
     * @Return:
     */
    public static <T extends Comparable<T>> void swapIn(BinaryTree<T> bitree) {
        if (bitree.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        swapTreeIn(bitree.getRoot());
    }

    private static <T extends Comparable<T>> void swapTreeIn(BinaryNode<T> node) {
        if (node != null) {
            swapTreeIn(node.getLeft());
            BinaryNode<T> temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
//            当左子树交换完之后，再让根节点交换，原来交换完的左子树变到右边
//            如果此时再进行右子树交换，相当与把原来交换完的左子树再交换一遍，而原来没有交换的右子树到左边后没有进行交换
//            故再进行一次左子树交换，实现让原来的右子树交换且原来的左子树不会再交换一次
            swapTreeIn(node.getLeft());
        }
    }

    /**
     * （6-2）2交换结点的左右子树，使用后序遍历
     *
     * @Param:
     * @Return:
     */
    public static <T extends Comparable<T>> void swapPost(BinaryTree<T> bitree) {
        if (bitree.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        swapTreePost(bitree.getRoot());
    }

    private static <T extends Comparable<T>> void swapTreePost(BinaryNode<T> node) {
        if (node != null) {
            swapTreePost(node.getLeft());
            swapTreePost(node.getRight());
            BinaryNode<T> temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
        }
    }
}
