package com.homework.April_23.first;

import java.util.Stack;

/**
 * @Author hongxiaobin
 * @Time 2022/4/15-8:22
 * @Description 使用一个栈，将十进制装换为二进制或八、十六进制
 */
public class DecStack {
    public static void main(String[] args) {
        int num = 1960;
        System.out.println(decchange(num, 2));
        System.out.println(decchange(num, 8));
        System.out.println(decchange(num, 16));
    }

    /**
     * @Description: 实现将十进制转换为二进制或八、十六进制
     * @Param: [int, int] 前一个int为要转换的数，后一个int为进制选择
     * @Return: String
     */
    public static String decchange(int i, int j) {
        Stack stack = new Stack();
        StringBuilder result = new StringBuilder();
        result.append("将十进制数 ").append(i).append(" 转为 ").append(j).append(" 进制数为 ");
        if (i <= 0 || j <= 0) {
            throw new RuntimeException("参数为非正数");
        }
        while (i > 0) {
            stack.push(i % j);
            i /= j;
        }
        while (!stack.isEmpty()) {
            if ((int) stack.peek() >= 10) {
                result.append((char) (((int) stack.pop()) + 55));
            } else {
                result.append(stack.pop());
            }
        }
        return result.toString();
    }
}

