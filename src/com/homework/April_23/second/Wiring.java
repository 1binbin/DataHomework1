package com.homework.April_23.second;

import java.util.Stack;

/**
 * @Author hongxiaobin
 * @Time 2022/4/17-20:02
 * @Description 布线最短路径问题
 */
public class Wiring {
    /**
     * @Description: 利用队列，遍历查找起点到终点的路线
     * @Param: int[][] map, int startX, int startY, int endX, int endY
     * @Return: int[][]
     */
    public int[][] findLoad(int[][] map, int startX, int startY, int endX, int endY) {
        if (map[startX][startY] == -1 || map[endX][endY] == -1) {
            throw new RuntimeException("起点或终点为墙，不可通行！");
        }
        //        定义起点为1
        map[startX][startY] = 1;
        //        创建一个循环队列
        Arrayqueuecycle<Position> arrayqueuecycle = new Arrayqueuecycle<>();
        //        定义走的规则走，上右下左
        while (startX != endX || startY != endY) {
            if (startX - 1 >= 0 && map[startX - 1][startY] == 0) {
                arrayqueuecycle.add(new Position(startX - 1, startY));
                map[startX - 1][startY] = map[startX][startY] + 1;
            }
            if (startY + 1 < map.length && map[startX][startY + 1] == 0) {
                arrayqueuecycle.add(new Position(startX, startY + 1));
                map[startX][startY + 1] = map[startX][startY] + 1;
            }
            if (startX + 1 < map.length && map[startX + 1][startY] == 0) {
                arrayqueuecycle.add(new Position(startX + 1, startY));
                map[startX + 1][startY] = map[startX][startY] + 1;
            }
            if (startY - 1 >= 0 && map[startX][startY - 1] == 0) {
                arrayqueuecycle.add(new Position(startX, startY - 1));
                map[startX][startY - 1] = map[startX][startY] + 1;
            }
            //    如果队列为空则进入死胡同，没有路径可走，跳出循环
            if (!arrayqueuecycle.isEmpty()) {
                Position start = arrayqueuecycle.poll();
                startX = start.getRow();
                startY = start.getCol();
            } else {
                throw new RuntimeException("起点到终点没有路径可通行！！");
            }
        }
        return map;
    }

    /**
     * @Description: 路径回溯，打印最短路径
     * @Param: int[][] map, int startX, int startY, int endX, int endY
     * @Return: String
     */
    public String backtrack(int[][] map, int startX, int startY, int endX, int endY) {
        Stack<Position> stack = new Stack<>();
        stack.push(new Position(endX, endY));
        //        回溯算法：找周围比它数值小1的数就压入栈中
        while (startX != endX || startY!= endY) {
            //            规则：上右下左
            if (map[endX - 1][endY] == map[endX][endY] - 1) {
                stack.push(new Position(--endX, endY));
                continue;
            }
            if (map[endX][endY + 1] == map[endX][endY] - 1) {
                stack.push(new Position(endX, ++endY));
                continue;
            }
            if (map[endX + 1][endY] == map[endX][endY] - 1) {
                stack.push(new Position(++endX, endY));
                continue;
            }
            if (map[endX][endY - 1] == map[endX][endY] - 1) {
                stack.push(new Position(endX, --endY));
            }
        }
        //        出栈，拼接字符串
        StringBuilder string = new StringBuilder("最短路径为：");
        if (!stack.isEmpty()){
            string.append(stack.pop().toString());
            while (!stack.isEmpty()) {
                string.append("->").append(stack.pop().toString());
            }
        }
        return string.toString();
    }

    /**
     * @Description: 显示地图
     * @Param: int[][]
     * @Return: void
     */
    public void show(int[][] map) {
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }
}
