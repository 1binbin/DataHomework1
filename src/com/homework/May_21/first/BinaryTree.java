package com.homework.May_21.first;

import com.homework.May_21.BinaryNode;
import com.homework.May_21.SeqList;

import java.util.Stack;

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
    private int leafs;

    public BinaryTree() {
        this.root = null;
        leafs = 0;
    }


    public BinaryTree(SeqList<T> preList, SeqList<T> inList) {
        this.root = buildBitree(preList, 0, preList.size() - 1, inList, 0, inList.size() - 1);
    }

    /**
     * 计算叶子结点的个数
     *
     * @Param: BinaryNode<T> node 当前树的根节点
     * @Return:
     */
    public void leafCount(BinaryNode<T> node) {
        if (node != null) {
//            判断是否为叶子结点
            if (node.getLeft() == null && node.getRight() == null) {
                leafs++;
            }
            leafCount(node.getLeft());
            leafCount(node.getRight());
        }
    }

    /**
     * 求二叉树的高度
     *
     * @Param: BinaryNode<T> node 当前树的根结点
     * @Return: 二叉树的高度
     */
    public int getHeight(BinaryNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 依次打印从根节点到指定结点node路径上所有结点，并求路径长度
     *
     * @Param: BinaryNode<T> node 目的结点
     * @Return: 路径长度
     */
    public int printPath(BinaryNode<T> node) {
        if (root != null) {
            printPath(root, node);
            System.out.println(stack);
            return stack.size();
        }
        return 0;
    }

    Stack<BinaryNode<T>> stack = new Stack<>();

    private boolean printPath(BinaryNode<T> root, BinaryNode<T> node) {
        if (root == null) {
            return false;
        }
//        遍历到的入栈
        stack.push(root);
//        找到目标结点就停止
        if (root == node) {
            return true;
        }
        if (printPath(root.getLeft(), node)) {
//            左子树找不到，因为root == null  return false
            return true;
        }
        if (printPath(root.getRight(), node)) {
//            右子树找不到
            return true;
        }
//        如果其左右子节点都找不到就出栈，表示找到尽头了找不到，故此结点不会是路径中的一点
//        往回走的时候，其左右结点都是false，故将其出栈
        stack.pop();
        return false;
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
//            这个元素找完之后设置为空，防止后续在中序中查找到与它相同的元素，导致index出错
            inList.set(index,null);
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
     * （6-1）1
     * 查找并删除首个以与key相等元素为结点为根的子树
     *
     * @Param: T key 要删除结点的值
     * @Return: BinaryNode<T> 需要删除的结点
     */
    public BinaryNode<T> remove(T key) {
        if (this.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        return remove(this.getRoot(), key);
    }

    public BinaryNode<T> remove(BinaryNode<T> node, T key) {
        BinaryNode<T> temp;
        if (node != null) {
            if (node.getLeft() != null && node.getLeft().getData().equals(key)) {
                temp = node.getLeft();
                node.setLeft(null);
                return temp;
            }
            if (node.getRight() != null && node.getRight().getData().equals(key)) {
                temp = node.getRight();
                node.setRight(null);
                return temp;
            }
            remove(node.getLeft(), key);
            remove(node.getRight(), key);
        }
        return null;
    }

    /**
     * （6-1）2
     * 判断是否为二叉排序树
     *
     * @Param:
     * @Return: true 是二叉排序树 反之不是
     */
    public boolean isSorted() {
        if (this.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        return isSorted(this.getRoot());
    }

    public boolean isSorted(BinaryNode<T> root) {
        boolean s = true;
        if (root == null) {
            return true;
        }
        if (root.getLeft() != null) {
            if (root.getLeft().getData().compareTo(root.getData()) >= 0) {
                s = false;
            }
        }
        if (root.getRight() != null) {
            if (root.getRight().getData().compareTo(root.getData()) <= 0) {
                s = false;
            }
        }
        isSorted(root.getLeft());
        isSorted(root.getRight());
        return s;
    }

    /**
     * （6-1）3
     * 返回某结点的父母结点
     *
     * @Param: BinaryNode<T> p 需要找到其父母结点的子节点
     * @Return: BinaryNode<T> 其父母结点
     */
    public BinaryNode<T> parent(BinaryNode<T> p) {
        if (this.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        return parent(this.getRoot(), p);
    }

    public BinaryNode<T> parent(BinaryNode<T> root, BinaryNode<T> p) {
        if (root == null || root.getLeft() == p || root.getRight() == p) {
            return root;
        }
        BinaryNode<T> left = parent(root.getLeft(), p);
        if (left != null) {
            return left;
        }
        BinaryNode<T> right = parent(root.getRight(), p);
        if (right != null) {
            return right;
        }
        return null;
    }

    /**
     * 查找指定结点，便于测试
     *
     * @Param: T data 指定值
     * @Return: 指定结点
     */
    public BinaryNode<T> getNode(T data) {
        if (this.getRoot() == null) {
            throw new RuntimeException("该二叉树为空");
        }
        return getNode(this.getRoot(), data);
    }

    public BinaryNode<T> getNode(BinaryNode<T> root, T data) {
        BinaryNode<T> temp = null;
        if (root.getData().equals(data)) {
            return root;
        }
        if (root.getLeft() != null) {
            temp = getNode(root.getLeft(), data);
        }
        if (temp != null) {
            return temp;
        }
        if (root.getRight() != null) {
            temp = getNode(root.getRight(), data);
        }
        return temp;
    }

    /**
     * 先序遍历二叉树
     *
     * @Param: BinaryNode<T> node 当前结点
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

    public int getLeafs() {
        return leafs;
    }

    public void setLeafs(int leafs) {
        this.leafs = leafs;
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }


}

