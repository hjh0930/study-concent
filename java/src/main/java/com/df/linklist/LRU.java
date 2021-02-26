package com.df.linklist;

import lombok.Data;

import java.util.Objects;

@Data
public class LRU {

    private Node head = null;
    @Data
    class Node{
        // 数据
        private String data;
        // 下一个node
        private Node next = null;

        public Node(String data) {
            this.data = data;
        }

    }

    /**
     * 插入node 的数据 lru
     * @param data
     */
    private void addNodeEcludeHead(String data){
        Node node = new Node(data);
        if (Objects.isNull(head)) {
            head = node;
            return;
        }
        int count = 1;
        Node tmp = head;
        // 不管什么节点都插入到头节点
        while (Objects.nonNull(tmp.next)) {
            if (count==1) {
                node.next = tmp.next;
                tmp.next = node;
                break;
            }
            count++;
            tmp = tmp.next;
        }
    }


    /**
     * 最早淘汰
     * @param data
     */
    private void addLruNode(String data){
        // 把所有的值放入新值的后面
        // 在把后面的值赋值给head
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    /**
     *
     * @param data
     */
    private void addNode(String data){
        Node node = new Node(data);
        if (Objects.isNull(head)) {
            head = node;
            return;
        }
        Node tmp = head;
        // 不管什么节点都插入到头节点
        while (Objects.nonNull(tmp.next)) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    /**
     **/
    private int length(){
        int length = 1;
        Node tmp = head;
        while (Objects.nonNull(tmp.next)) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 反转
     */
    private void print(){
        Node tmp = head;
        while (Objects.nonNull(tmp.next)) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println(tmp.data);
    }

    /**
     * 反转
     * @param node
     */
    public void reverseNode(Node node) {
        Node reverseNode = null;
        Node pNode = node;
        Node pPrev = null;
        while (Objects.nonNull(pNode)) {
            Node pNext = pNode.next;
            if (Objects.isNull(pNext)) {
                reverseNode = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = reverseNode;
        print();
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.addNode("1");
        lru.addNode("2");
        lru.addNode("3");
        lru.addNode("4");
        /*lru.addLruNode("6");
        lru.addLruNode("7");
        lru.addLruNode("8");*/
        //lru.addNodeEcludeHead("5");
        lru.reverseNode(lru.head);
    }
}
