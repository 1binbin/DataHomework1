package com.homework.April_2.Second;

/**
 * @author hongxiaobin
 */
public class SinglyListTest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{555, 123, 123, 111, 653, 651, 122};
        SinglyLinearList<Integer> linearlist = new SinglyListSingly<>(arr);
        System.out.println("原链表为");
        System.out.println(linearlist);
        System.out.println("链表是否为空");
        System.out.println(linearlist.isEmpty());
        System.out.println("链表的长度");
        System.out.println(linearlist.size());
        System.out.println("获取第 3 个元素");
        System.out.println(linearlist.get(3));
        System.out.println("将第 4 个元素设置为 999");
        linearlist.set(4, 999);
        System.out.println(linearlist);
        System.out.println("在第 6 个位置插入 555");
        linearlist.insert(6, 555);
        System.out.println(linearlist);
        System.out.println("尾部插入元素 666");
        linearlist.insert(666);
        System.out.println(linearlist);
        System.out.println("查找元素 123 的位置");
        System.out.println(linearlist.search(123));
        System.out.println("判断是否包含元素 111");
        System.out.println(linearlist.contains(111));
        System.out.println("删除元素 111");
        linearlist.remove((Integer) 111);
        System.out.println(linearlist);
        System.out.println("删除第 5 个元素");
        linearlist.remove(5);
        System.out.println(linearlist);
        System.out.println("返回最后一个结点");
        System.out.println(linearlist.last());
        System.out.println("返回第三个元素的前驱结点");
        System.out.println(linearlist.prev(linearlist.getLocation(3)));
        System.out.println("返回从 4 开始长度为 3 的子表");
        System.out.println(linearlist.subList(4,3));
        System.out.println("以第一个结点为基准，数据较小的放其前面，大的放后面");
        linearlist.partition((SinglyListSingly<Integer>) linearlist);
        System.out.println(linearlist);
        System.out.println("反转链表");
        linearlist.reverse();
        System.out.println(linearlist);
        System.out.println("清空链表");
        linearlist.clear();
        System.out.println(linearlist);
    }
}
