package com.homework.April_2.Second;

/**
 * @author hongxiaobin
 */
public interface SinglyLinearList<T> { //线性表定义的运算，以接口形式描述
    /**
     * 判断是否为空，若为空，则返回true
     */
    boolean isEmpty();

    /**
     * 返回元素个数（长度）
     */
    int size();

    /**
     * 查找并返回首个与key相等元素；若查找不成功，则返回null
     */
    int search(T key);

    /**
     * 查找并删除首个与key相等元素，返回被删除元素的位置
     */
    int remove(T key);

    /**
     * 删除所有元素
     */
    void clear();

    /**
     * 返回所有元素的描述字符串
     */
    @Override
    String toString();

    /**
     * 比较this与obj引用线性表的所有元素是否对应相等
     */
    @Override
    boolean equals(Object obj);

    /**
     * 返回第i个元素
     */
    T get(int i);

    /**
     * 设置第i个元素为x
     */
    void set(int i, T x);

    /**
     * 插入x作为第i个元素
     */
    boolean insert(int i, T x);

    /**
     * 在最后插入x元素
     */
    int insert(T x);

    /**
     * 删除第i个元素，返回被删除元素
     */
    T remove(int i);

    /**
     * 是否包含x元素
     */
    boolean contains(T key);

    /***返回最后一个结点*/
    Node<T> last();

    /**
     * 返回p结点的前驱结点
     */
    Node<T> prev(Node<T> p);

    /**
     * 返回从第i个结点开始，程度为len的子表，深拷贝
     */
    SinglyListSingly<T> subList(int i, int len);

    /**
     * 实现以第一个结点为基准，数据较小的放其前面，大的放后面
     */
    void partition(SinglyListSingly<Integer> list);

    /**
     * 获取某位置的结点
     */
    Node<T> getLocation(int i);

    /**
     * 原地对链表进行反转
     */
    void reverse();
}
