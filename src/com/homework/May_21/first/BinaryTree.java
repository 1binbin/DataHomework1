package com.homework.May_21.first;

/**
 * 二叉树类
 *
 * @Author hongxiaobin
 * @Time 2022/5/15-14:58
 */
public class BinaryTree<T extends Comparable<T>> {
    /**
     * 根节点
     */
    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }


    public BinaryTree(SeqList<T> preList, SeqList<T> inList) {
        this.root = buildBitree(preList, 0, preList.size() - 1, inList, 0, inList.size() - 1);
    }

    /**
     * 根据先序和中序构造二叉树
     *
     * @Param: SeqList<T> preLIst 先序遍历线性表
     * int preStart 先序遍历起点
     * int preEnd 先序遍历终点
     * SeqList<T> inList 中序遍历线性表
     * int inStart 中序遍历起点
     * int inEnd 中序遍历终点
     * @Return: BinaryNode<T> 该二叉树的根节点
     */
    public BinaryNode<T> buildBitree(SeqList<T> preList, int preStart, int preEnd, SeqList<T> inList, int inStart, int inEnd) {
        if (preStart <= preEnd) {
//            获取子树的根节点
            T r = preList.get(preStart);
            BinaryNode<T> node = new BinaryNode<>(r);
//            在中序中找到根节点的位置，划分为左子树和右子树
            int index = inList.search(r);
            int ll = index - inStart;
            int rl = inEnd - index;
            node.setLeft(buildBitree(preList, preStart + 1, preStart + ll, inList, inStart, index - 1));
            node.setRight(buildBitree(preList, preStart + ll + 1, preStart + ll + rl, inList, index + 1, index + rl));
            return node;
        } else {
            return null;
        }
    }

    /**
     * 先序遍历二叉树
     *
     * @Param: BinaryNode<T> node 当前结点，根节点
     * @Return:
     */
    public void preOrder(BinaryNode<T> node) {
        if (node != null) {
            System.out.print(node.getData().toString() + "\t");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * 中序遍历二叉树
     *
     * @Param: BinaryNode<T> node 当前结点，根节点
     * @Return:
     */
    public void inOrder(BinaryNode<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData().toString() + "\t");
            inOrder(node.getRight());
        }
    }

    /**
     * 后序遍历二叉树
     *
     * @Param: BinaryNode<T> node 当前结点，根节点
     * @Return:
     */
    public void postOrder(BinaryNode<T> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData().toString() + "\t");
        }
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }
}

/**
 * 节点类
 *
 * @Author: hongxiaobin
 * @Date: 2022/5/15 15:04
 */
class BinaryNode<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public BinaryNode() {
        this(null, null, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                '}';
    }
}
