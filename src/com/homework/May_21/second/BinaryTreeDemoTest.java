package com.homework.May_21.second;

import com.homework.May_21.SeqList;
import com.homework.May_21.first.BinaryTree;

/**
 * (6-2)测试
 *
 * @Author hongxiaobin
 * @Time 2022/5/16-14:29
 */
public class BinaryTreeDemoTest {
    public static void main(String[] args) {
    //        创建一棵二叉树
        SeqList<String> preList = new SeqList<>();
        SeqList<String> inList1 = new SeqList<>();
        SeqList<String> inList2 = new SeqList<>();
        SeqList<String> inList3 = new SeqList<>();
        String preStr = "abdefgc";
        String inStr = "dbfegac";
        for (int i = 0; i < preStr.length(); i++) {
            preList.insert(String.valueOf(preStr.charAt(i)));
            inList1.insert(String.valueOf(inStr.charAt(i)));
            inList2.insert(String.valueOf(inStr.charAt(i)));
            inList3.insert(String.valueOf(inStr.charAt(i)));
        }
        BinaryTree<String> stringBinaryTree1 = new BinaryTree<>(preList, inList1);
        BinaryTree<String> stringBinaryTree2 = new BinaryTree<>(preList, inList2);
        BinaryTree<String> stringBinaryTree3 = new BinaryTree<>(preList, inList3);
    //        验证性质3
        System.out.println("验证二叉树性质3");
        BinaryTreeDemo.property3(stringBinaryTree1);
    //        交换前遍历
        System.out.println("交换左右子树前的后序遍历");
        stringBinaryTree1.postOrder(stringBinaryTree1.getRoot());
        System.out.println();
    //        交换后遍历
        System.out.println("交换左右子树后的后序遍历------使用前序遍历实现");
        BinaryTreeDemo.swapPre(stringBinaryTree1);
        stringBinaryTree1.postOrder(stringBinaryTree1.getRoot());
        System.out.println();

        System.out.println("交换左右子树后的后序遍历------使用中序遍历实现");
        BinaryTreeDemo.swapIn(stringBinaryTree2);
        stringBinaryTree2.postOrder(stringBinaryTree2.getRoot());
        System.out.println();

        System.out.println("交换左右子树后的后序遍历------使用后序遍历实现");
        BinaryTreeDemo.swapPost(stringBinaryTree3);
        stringBinaryTree3.postOrder(stringBinaryTree3.getRoot());
        System.out.println();
    }
}
