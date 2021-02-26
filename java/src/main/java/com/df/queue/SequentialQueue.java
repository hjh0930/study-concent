package com.df.queue;

import java.util.Arrays;

/**
 * @author dongfeng
 */

public class SequentialQueue {

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

    public SequentialQueue(int capacity) {
        // 数组初始化
        items = new String[capacity];
        n = capacity;
    }

    public SequentialQueue() {
    }

    /**
     * 入队
     *
     * @param item
     */
    public Boolean enqueue(String item) {
        if (tail == n) {
            System.out.println("false");
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    /***
     * 如果
     * @param item
     * @return
     */
    public Boolean resetEnqueue(String item) {
        if (tail == n) {
            if (head == 0) {
                //空间已经满了
                return false;
            }
            int count = 0;
            for (int i = head; i < tail; i++) {
                items[count] = items[i];
                count++;
                items[i] = null;
            }
            items[count] = item;
            return true;
        }
        items[tail] = item;
        tail++;
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
        items[head] = null;
        head++;
        return item;
    }

    @Override
    public String toString() {
        return "SequentialQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    public static void main(String[] args) {
        SequentialQueue queueIMp = new SequentialQueue(5);
        queueIMp.enqueue("1");
        queueIMp.enqueue("2");
        queueIMp.enqueue("3");
        queueIMp.enqueue("4");
        queueIMp.enqueue("5");
        System.out.println(queueIMp.items.toString());
        System.out.println(queueIMp.dequeue());
        System.out.println(queueIMp.dequeue());
        queueIMp.resetEnqueue("6");
        System.out.println(queueIMp.items.toString());
    }
}
