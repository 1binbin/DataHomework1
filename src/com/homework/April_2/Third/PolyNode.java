package com.homework.April_2.Third;

/**
 * @Author hongxiaobin
 * @Time 2022/3/30-9:08
 * @Description
 */
public class PolyNode {
    /**
     * 系数
     */
    private double coef;
    /**
     * 指数
     */
    private int index;
    public PolyNode next;

    public PolyNode(double coef, int index) {
        this.coef = coef;
        this.index = index;
        this.next = null;
    }

    public PolyNode() {
        this(0, 0);
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
