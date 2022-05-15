package com.homework.April_23.second;

/**
 * @Author hongxiaobin
 * @Time 2022/4/17-20:06
 * @Description 循环队列
 */
public class Arrayqueuecycle<T> {
    private static final int MIN_SIZE=16;
    private int front;
    private int rear;
    private T[] array;

    public Arrayqueuecycle() {
        this(MIN_SIZE);
    }

    public Arrayqueuecycle(int size) {
        if (size<MIN_SIZE){
            size = MIN_SIZE;
        }
        array = (T[]) new Object[size];
        front = 0;
        rear = 0;
    }

    //    判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //   入队
    public void add(T n) {
        if (n == null){
            throw new RuntimeException("元素为空，不可入队");
        }
//       如果循环队列满了，就扩容
        if (this.front == (this.rear + 1) % array.length) {
            Object[] temp =  this.array;
            this.array = (T[]) new Object[array.length * 2];
            int j = 0;
            for (int i = this.front; i != front; i=(i+1)%temp.length) {
                this.array[j++] = (T) temp[i];
                this.front=0;
                this.rear=j;
            }
        }
        this.array[rear] = n;
        this.rear = (this.rear + 1) % array.length;
    }

    //    出队
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不可取值");
        }
        T value = this.array[front];
        front = (front + 1) % array.length;
        return value;
    }
}
