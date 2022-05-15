package com.homework.April_23.third;

/**
 * @Author hongxiaobin
 * @Time 2022/4/14-14:58
 * @Description
 */
public class Hanoitower {
    private static int count;

    public static void main(String[] args) {
        move(50, 'A', 'B', 'C');
        System.out.println("一共移动 " + count + " 次");
    }

    public static void move(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.printf("第 %d 次将第 1 个盘子移动：%s -> %s\n", ++count, a, c);
        } else {
            move(n - 1, a, c, b);
            System.out.printf("第 %d 次将第 %d 个盘子移动：%s -> %s\n", ++count, n, a, c);
            move(n - 1, b, a, c);
        }
    }
}
