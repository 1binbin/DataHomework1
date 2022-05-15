package com.homework.April_23.second;

/**
 * @Author hongxiaobin
 * @Time 2022/4/17-22:15
 * @Description
 */
public class Wiringtest {
    public static void main(String[] args) {
        Wiring wiring = new Wiring();
        //        使用-1为障碍，0为可通行
        int[][] map = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1,  0,  0, -1,  0,  0,  0,  0, -1},
                {-1,  0,  0, -1, -1,  0,  0,  0, -1},
                {-1,  0,  0,  0,  0, -1,  0,  0, -1},
                {-1,  0,  0,  0, -1, -1,  0,  0, -1},
                {-1, -1,  0,  0,  0, -1,  0,  0, -1},
                {-1, -1, -1, -1,  0,  0,  0,  0, -1},
                {-1, -1, -1, -1,  0,  0,  0,  0, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
        //        输出原来的map
        System.out.println("原本地图的情况");
        wiring.show(map);
        System.out.printf("起点为 (%d,%d) 终点为 (%d,%d)\n", 3, 2, 4, 6);
        System.out.println("遍历查找后地图的情况");
        wiring.show(wiring.findLoad(map, 3, 2, 4, 6));
        System.out.println(wiring.backtrack(map, 3, 2, 4, 6));
    }
}
