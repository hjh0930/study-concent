package com.df.queue;

import java.util.Queue;

/**
 * @author 东风
 */
public class CircularQueue {


    /**
     * 数组底层
     */
    private int n = 0;

    /**
     * 底层是数组
     */
    private String[] items;

    /**
     * 头部
     */
    private int head = 0;

    /**
     * 尾部
     */
    private int tail = 0;

    public CircularQueue(int capacity) {
        // 数组初始化
        items = new String[capacity];
        n = capacity;
    }

    public CircularQueue() {
    }

    /**
     * 入队
     *
     * @param item
     */
    public Boolean enqueue(String item) {
        // 通过这种方式队列需要空一格
        if ((tail + 1) % n == head) {
            System.out.println("false");
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队列
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }

        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(6);
        circularQueue.enqueue("1");
        circularQueue.enqueue("2");
        circularQueue.enqueue("3");
        circularQueue.enqueue("4");
        circularQueue.enqueue("5");


    }
}
