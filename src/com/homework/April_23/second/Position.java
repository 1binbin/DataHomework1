package com.homework.April_23.second;

/**
 * @Author hongxiaobin
 * @Time 2022/4/17-22:12
 * @Description 定义位置结点，row为行，col为列，分别从0开始计数
 */
public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row + " , " + col + ')';
    }
}
