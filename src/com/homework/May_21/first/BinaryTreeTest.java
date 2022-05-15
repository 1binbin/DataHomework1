package com.homework.May_21.first;

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

    }
    private static void extracted(SeqList<String> preList, String preStr) {
        for (int i = 0; i < preStr.length(); i++) {
            preList.insert(String.valueOf(preStr.charAt(i)));
        }
    }
}
