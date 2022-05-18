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
     * （6-2）1验证二叉树的性质3 O(n)
     *
     * @Param: BinaryTree<T> bitree 二叉树
     * @Return:
     */
    private static int leafsCount;
    private static int twoChildCount;

    public static <T extends Comparable<T>> void property3(BinaryTree<T> bitree) {
        if (bitree.getRoot()==null){
            throw new RuntimeException("该二叉树为空");
        }
        property3(bitree.getRoot());
        System.out.println("no的个数为 "+leafsCount);
        System.out.println("n2的个数为 "+twoChildCount);
        if (leafsCount == twoChildCount +1){
            System.out.println("满足二叉树的性质3");
        }else {
            System.out.println("不满足二叉树性质3");
        }
    }

    public static <T extends Comparable<T>> void property3(BinaryNode<T> node) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                leafsCount++;
            }
            if (node.getLeft() != null && node.getRight() != null) {
                twoChildCount++;
            }
            property3(node.getLeft());
            property3(node.getRight());
        }
    }

    /**
     * （6-2）2交换结点的左右子树，使用前序遍历 O(n)
     *
     * @Param: BinaryTree<T> bitree 二叉树
     * @Return:
     */
    public static <T extends Comparable<T>> void swapPre(BinaryTree<T> bitree) {
        if (bitree.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        swapPre(bitree.getRoot());
    }

    private static <T extends Comparable<T>> void swapPre(BinaryNode<T> node) {
        if (node != null) {
//            交换左右子树
            BinaryNode<T> temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
//            遍历左子树
            swapPre(node.getLeft());
//            遍历右子树
            swapPre(node.getRight());
        }
    }

    /**
     * （6-2）2交换结点的左右子树，使用中序遍历 O(n)
     * 由于左子树交换后，经过根节点时，再交换一遍，原来的左变为右，原来的右子树变为左子树，而新的左子树没有进行交换过
     * 也就是左边的交换完之后换到右边时，又被交换一遍
     *
     * @Param: BinaryTree<T> bitree 二叉树
     * @Return:
     */
    public static <T extends Comparable<T>> void swapIn(BinaryTree<T> bitree) {
        if (bitree.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        swapIn(bitree.getRoot());
    }

    private static <T extends Comparable<T>> void swapIn(BinaryNode<T> node) {
        if (node != null) {
            swapIn(node.getLeft());
            BinaryNode<T> temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
//            当左子树交换完之后，再让根节点交换，原来交换完的左子树变到右边
//            如果此时再进行右子树交换，相当与把原来交换完的左子树再交换一遍，而原来没有交换的右子树到左边后没有进行交换
//            故再进行一次左子树交换，实现让原来的右子树交换且原来的左子树不会再交换一次
            swapIn(node.getLeft());
        }
    }

    /**
     * （6-2）2交换结点的左右子树，使用后序遍历 O(n)
     *
     * @Param: BinaryTree<T> bitree 二叉树
     * @Return:
     */
    public static <T extends Comparable<T>> void swapPost(BinaryTree<T> bitree) {
        if (bitree.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        swapPost(bitree.getRoot());
    }

    private static <T extends Comparable<T>> void swapPost(BinaryNode<T> node) {
        if (node != null) {
            swapPost(node.getLeft());
            swapPost(node.getRight());
            BinaryNode<T> temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
        }
    }
}
