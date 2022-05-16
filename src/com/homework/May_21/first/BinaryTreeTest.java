package com.homework.May_21.first;

import com.homework.May_21.BinaryNode;
import com.homework.May_21.SeqList;

/**
 * 二叉树测试类
 *
 * @Author hongxiaobin
 * @Time 2022/5/15-14:56
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
//        根据先序和中序构造二叉树
        SeqList<String> preList = new SeqList<>();
        SeqList<String> inList = new SeqList<>();
        String preStr = "abdefgc";
        String inStr = "dbfegac";
        extracted(preList, preStr);
        extracted(inList, inStr);
        BinaryTree<String> stringBinaryTree =new BinaryTree<>(preList,inList);
//        遍历
        System.out.println("先序遍历");
        stringBinaryTree.preOrder(stringBinaryTree.getRoot());
        System.out.println();
        System.out.println("中序遍历");
        stringBinaryTree.inOrder(stringBinaryTree.getRoot());
        System.out.println();
        System.out.println("后序遍历");
        stringBinaryTree.postOrder(stringBinaryTree.getRoot());
        System.out.println();
//        统计叶子结点数
        System.out.println("该二叉树的叶子结点数为");
        stringBinaryTree.leafCount(stringBinaryTree.getRoot());
        System.out.println(stringBinaryTree.getLeafs());
//        计算二叉树的高度
        System.out.println("该二叉树的高度为");
        System.out.println(stringBinaryTree.getHeight(stringBinaryTree.getRoot()));
//        求根节点到指定结点的路径
        System.out.println("根节点到结点 g 的路径");
        BinaryNode<String> temp = stringBinaryTree.getNode("g");
        System.out.println("路径长度为"+stringBinaryTree.printPath(temp));
//        返回某结点的父母结点
        System.out.println("结点 g 的父母结点为");
        BinaryNode<String> g = stringBinaryTree.getNode("g");
        System.out.println(stringBinaryTree.parent(g));
//        删除某个结点为根节点的子树
        System.out.println("删除以值为 e 结点为根节点的子树");
        stringBinaryTree.remove("e");
        stringBinaryTree.preOrder(stringBinaryTree.getRoot());
        System.out.println();
//        判断是否为二叉排序树
        SeqList<Integer> preList1 = new SeqList<>();
        SeqList<Integer> inList1 = new SeqList<>();
        int[] pre = {7,3,1,2,5,10,9,12};
        int[] in = {1,2,3,5,7,9,10,12};
        for (int i = 0; i < pre.length; i++) {
            preList1.insert(pre[i]);
            inList1.insert(in[i]);
        }
        BinaryTree<Integer> integerBinaryTree =new BinaryTree<>(preList1,inList1);
        System.out.println("该二叉树是否为二叉排序树");
        System.out.println(integerBinaryTree.isSorted());
    }
    private static void extracted(SeqList<String> preList, String preStr) {
        for (int i = 0; i < preStr.length(); i++) {
            preList.insert(String.valueOf(preStr.charAt(i)));
        }
    }
}
