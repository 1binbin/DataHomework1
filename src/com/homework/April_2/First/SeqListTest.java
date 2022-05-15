package com.homework.April_2.First;

/**
 * @Author hongxiaobin
 * @Time 2022/3/29-21:51
 * @Description 作为SeqList类的测试
 */
public class SeqListTest {
    public static void main(String[] args) {
        SeqLinearList<Integer> seqList = new SeqList<>(8);
        seqList.insert(21);
        seqList.insert(20);
        seqList.insert(90);
        seqList.insert(20);
        seqList.insert(21);
        seqList.insert(90);
        System.out.println("初始线性表为");
        System.out.println(seqList);
        System.out.println("判断非空");
        System.out.println(seqList.isEmpty());
        System.out.println("线性表长度");
        System.out.println(seqList.size());
        System.out.println("读取下标为 3 的元素");
        System.out.println(seqList.get(3));
        System.out.println("将下标为 3 的元素修改为 20");
        seqList.set(3,20);
        System.out.println(seqList);
        System.out.println("在 9 的位置插入元素 20");
        seqList.insert(9,20);
        System.out.println(seqList);
        System.out.println("删除下标为 5 的元素");
        seqList.remove(5);
        System.out.println(seqList);
        System.out.println("以第一个元素为基准，小的放左边，大的放右边");
        seqList.seqPartition();
        System.out.println(seqList);
        System.out.println("查找元素 20 的位置");
        System.out.println(seqList.search(20));
        System.out.println("线性表是否包含元素 20");
        System.out.println(seqList.contains(20));
        System.out.println("删除第一个值为 21 的元素");
        seqList.remove((Integer) 21);
        System.out.println(seqList);
        System.out.println("删除所有值为 20 的元素");
        seqList.removeAll(20);
        System.out.println(seqList);
        System.out.println("将第一个元素 90 替换为 80");
        seqList.replaceFirst(90,80);
        System.out.println(seqList);
        System.out.println("查找最后一个元素 21");
        System.out.println(seqList.searchLast(21));
        System.out.println("清除所有元素");
        seqList.clear();
        System.out.println(seqList);
    }
}
