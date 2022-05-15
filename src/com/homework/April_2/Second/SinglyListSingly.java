package com.homework.April_2.Second;

/**
 * @author hongxiaobin
 */
public class SinglyListSingly<T> implements SinglyLinearList<T> {
    public Node<T> head;
    public int size;


    public SinglyListSingly() {
        head = new Node<>();
        size = 0;
    }

    public SinglyListSingly(T[] values) {
        this();
        Node<T> last = head;
        for (T value : values) {
            last.next = new Node<>(value, null);
            last = last.next;
        }
        size = values.length;
    }


    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:10
     * @Description: 获取单链表的长度
     * @Param: []
     * @Return: int
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:10
     * @Description: 获取某位置的元素
     * @Param: [i]
     * @Return: T
     */
    @Override
    public T get(int i) {
        return getLocation(i).getData();
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:09
     * @Description: 将某位置的元素修改为x
     * @Param: [i, x]
     * @Return: void
     */
    @Override
    public void set(int i, T x) {
        if (x == null) {
            throw new NullPointerException();
        }
        if (i >= 0 && i < this.size) {
            Node<T> p = head.next;
            for (int j = 0; j < i; j++) {
                p = p.next;
            }
            if (p != null) {
                p.setData(x);
            } else {
                throw new NullPointerException();
            }
        } else {
            throw new IndexOutOfBoundsException(i);
        }
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:05
     * @Description: 判断单链表是否为空
     * @Param: []
     * @Return: boolean
     */
    @Override
    public boolean isEmpty() {
        return head.next == null;
    }


    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:06
     * @Description: 在指定位置插入元素x
     * @Param: [i, x]
     * @Return: boolean
     */
    @Override
    public boolean insert(int i, T x) {
        if (x == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        Node pre = head;
        Node newNode = new Node(x, null);
        if (i == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            for (int j = 1; j <= i; j++) {
                pre = pre.next;
            }
            newNode.next = pre.next;
            pre.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:06
     * @Description: 在尾部插入某元素
     * @Param: [x]
     * @Return: int
     */
    @Override
    public int insert(T x) {
        insert(size, x);
        return size;
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:06
     * @Description: 删除指定位置的元素
     * @Param: [i]
     * @Return: T
     */
    @Override
    public T remove(int i) {
        Node<T> temp = head;
        for (int j = 0; temp.next != null && j < i; j++) {
            temp = temp.next;
        }
        if (i >= 0 && temp.next != null) {
            T x = temp.next.getData();
            temp.next = temp.next.next;
            size--;
            return x;
        } else {
            throw new NullPointerException();
        }
    }


    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:06
     * @Description: 清空单链表
     * @Param: []
     * @Return: void
     */
    @Override
    public void clear() {
        head.next = null;
    }


    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:06
     * @Description: 查找某元素第一次出现的位置
     * @Param: [key]
     * @Return: int
     */
    @Override
    public int search(T key) {
        if (key != null) {
            Node temp = head.next;
            for (int i = 0; temp.next != null; i++) {
                if (temp.getData().equals(key)) {
                    return i;
                }
                temp = temp.next;
            }
            return -1;
        } else {
            throw new NullPointerException();
        }
    }


    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:07
     * @Description: 判断是否包含某元素
     * @Param: [key]
     * @Return: boolean
     */
    @Override
    public boolean contains(T key) {
        int i = search(key);
        return i != -1;
    }


    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:07
     * @Description: 返回单链表中的最后一个结点
     * @Param: []
     * @Return: com.homework.April_2.Second.Node<T>
     */
    @Override
    public Node<T> last() {
        if (this.isEmpty()) {
            throw new RuntimeException("当前链表为空");
        }
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:07
     * @Description: 返回某结点的前驱结点
     * @Param: [p]
     * @Return: com.homework.April_2.Second.Node<T>
     */
    @Override
    public Node<T> prev(Node<T> p) {
        Node temp = this.head.next;
        if (p.getData() == null) {
            throw new NullPointerException("p is null");
        }
        if (p == this.head.next) {
            return null;
        }
        while (!p.equals(temp.next)) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:07
     * @Description: 返回从第i个结点开始，长度为len的子表
     * @Param: [i, len]
     * @Return: com.homework.April_2.Second.SinglyListSingly<T>
     */
    @Override
    public SinglyListSingly<T> subList(int i, int len) {
        if (i < 0 || len + i > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = this.head;
//        得到第i个的前驱结点
        for (int j = 0; j <= i; j++) {
            temp = temp.next;
        }
        T[] source = (T[]) new Object[len];
        for (int z = 0; z < len; z++) {
            source[z] = temp.getData();
            temp = temp.next;
        }
        return new SinglyListSingly<>(source);
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/4/1 11:10
     * @Description: 实现以第一个结点为基准，数据较小的放其前面，大的放后面
     * @Param: [list]
     * @Return: void
     */
    @Override
    public void partition(SinglyListSingly<Integer> list) {
        Node<Integer> start = list.head.next;
        Node<Integer> end = list.last();
        int benchmark = start.getData();
        while (start != end) {
            while (start != end && end.getData() >= benchmark) {
                end = list.prev(end);
            }
            start.setData(end.getData());
            while (start != end && start.getData() <= benchmark) {
                start = start.next;
            }
            end.setData(start.getData());
        }
        start.setData(benchmark);
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:07
     * @Description: 删除单链表中第一次出现的某元素
     * @Param: [key]
     * @Return: int
     */
    @Override
    public int remove(T key) {
        int i = search(key);
        remove(i);
        return i;
    }



    /**
     * @Author: hongxiaobin
     * @Date: 2022/4/1 16:40
     * @Description: 获取指定位置的结点
     * @Param: [i]
     * @Return: com.homework.April_2.Second.Node<T>
     */
    @Override
    public Node<T> getLocation(int i) {
        if (i < 0 || i > size) {
            throw new NullPointerException();
        }
        Node node = head;
        if (node == null) {
            throw new NullPointerException();
        }
        for (int index = 0; index <= i; index++) {
            node = node.next;
        }
        return node;
    }

    /**
     * @Author: hongxiaobin
     * @Description: 单链表就地反转
     * @Date: 2022/3/18 9:13
     * @Param:
     * @Return:
     */
    @Override
    public void reverse() {
        Node<T> p = head.next;
        Node<T> q;
        head.next = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = head.next;
            head.next = q;
        }
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 21:07
     * @Description: 遍历输出单链表
     * @Param: []
     * @Return: java.lang.String
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node<T> p = head.next;
        if (!isEmpty()) {
            str.append(p.getData().toString());
            Node<T> q = p.next;
            for (int i = 1; i < size; i++) {
                str.append(",").append(q.getData().toString());
                q = q.next;
            }
        }
        return str + "]";
    }
}
