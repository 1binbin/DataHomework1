package com.homework.April_2.Third;

/**
 * @Author hongxiaobin
 * @Time 2022/3/30-8:55
 * @Description 基于单链表存储结构的一元多项式的求和运算
 */
public class SinglyListPolynomial {
    public static void main(String[] args) {
//        多项式p1
        Polynomial p1 = new Polynomial();
        p1.insert(new PolyNode(7, 0));
        p1.insert(new PolyNode(3, 1));
        p1.insert(new PolyNode(9, 2));
        p1.insert(new PolyNode(5, 17));
        System.out.println("p1 = " + p1);
//        多项式p2
        Polynomial p2 = new Polynomial();
        p2.insert(new PolyNode(8, 1));
        p2.insert(new PolyNode(22, 7));
        p2.insert(new PolyNode(-9, 8));
        System.out.println("p2 = " + p2);
//        求和
        System.out.println("p1 + p2 = " + p2.addPolyn(p1));
    }
}

class Polynomial {
    PolyNode head;
    PolyNode current;

    public Polynomial() {
        head = new PolyNode();
        current = head;
        head.next = null;
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 9:17
     * @Description: 判断单链表是否为空
     * @Param: null
     * @Return: boolean
     */
    public boolean isEmpty() {
        return current.next == null;
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 9:18
     * @Description: 按照指数从小到大的顺序插入结点，便于后续进行求和运算
     * @Param: PolyNode
     * @Return: void
     */
    public void insert(PolyNode node) {
//        如果系数为0则不插入
        if (node.getCoef() != 0) {
//            如果为空链表就直接插入
            if (head.next == null) {
                head.next = node;
            } else {
//                辅助指针temp
                PolyNode temp = head;
                //        用来判断要添加的结点的指数是否已存在，已存即系数相加
                boolean flag = false;
                while (true) {
                    if (temp.next == null) {
                        break;
                    }
                    //            找到位置
                    if (temp.next.getIndex() > node.getIndex()) {
                        break;
//                        指数相同时，系数相加，不插入
                    } else if (temp.next.getIndex() == node.getIndex()) {
                        temp.next.setCoef(temp.next.getCoef() + node.getCoef());
                        flag = true;
                        break;
                    }
                    //            后继结点后移
                    temp = temp.next;
                }
                if (!flag) {
                    node.next = temp.next;
                    temp.next = node;
                }
            }
        }
    }

    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 18:02
     * @Description: 实现两个一元多项式相加
     * @Param: Polynomial
     * @Return: Polynomial
     */
    public Polynomial addPolyn(Polynomial list) {
        PolyNode pre = this.head;
        PolyNode p = this.head.next;
        PolyNode q = list.head.next;

        while (p != null && q != null) {
            if (p.getIndex() < q.getIndex()) {
                pre.next = p;
                pre = p;
                p = p.next;
            } else if (p.getIndex() == q.getIndex()) {
                double sum = p.getCoef() + q.getCoef();
                if (sum != 0.0) {
                    p.setCoef(sum);
                    pre.next = p;
                    pre = p;
                }
                p = p.next;
                q = q.next;
            } else {
                pre.next = q;
                pre = q;
                q = q.next;
            }
        }
        pre.next = (p == null) ? q : p;
        return this;
    }


    /**
     * @Author: hongxiaobin
     * @Date: 2022/3/30 9:19
     * @Description: 打印多项式
     * @Param: null
     * @Return: String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
//        表示系数
        StringBuilder coef = new StringBuilder();
//        表示指数
        StringBuilder index = new StringBuilder();
//        表示每一项
        StringBuilder theOne = new StringBuilder();
        current = head.next;

        while (current != null) {
            coef.delete(0, coef.length());
            index.delete(0, index.length());
            theOne.delete(0, theOne.length());
//            系数为1的时候省略不写
            if (current.getCoef() != 1) {
                coef.append(current.getCoef());
            }
//            指数不同情况的输出格式
            if (current.getIndex() == 1) {
                index.append("x");
                theOne.append(coef).append(index);
            } else if (current.getIndex() == 0) {
                index.append(current.getCoef());
                theOne.append(coef);
            } else {
                index.append(current.getIndex());
                theOne.append(coef).append("x^").append(index);
            }
//            将每一项组合成s输出
            if (current == head.next) {
                s.append(theOne);
            } else {
                s.append(" + ").append(theOne);
            }
//            指针后移
            current = current.next;
        }
        return s.toString();
    }
}