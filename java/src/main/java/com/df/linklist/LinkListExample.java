package com.df.linklist;

import lombok.Data;

import java.util.Objects;

/**
 * @author dongfeng
 */
@Data
public class LinkListExample {
    public Node head = null;

    @Data
    class Node {

        /**
         * 数据
         */
        public String data;

        public Node next = null;

        public Node(String data) {
            this.data = data;
        }

    }

    /**
     * 添加结点
     *
     * @param data
     */
    public void addNode(String data) {
        Node node = new Node(data);
        // 如果是头结点为空，则添加头结点
        if (head == null) {
            head = node;
            return;
        }
        // 如果头结点找出尾结点复制，后尾结点的指针指向新添加的结点
        Node tmp = head;
        while (Objects.nonNull(tmp.next)) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    /**
     * 遍历结点
     */
    public void traverse(Node node) {
        //临时节点，从首节点开始
        Node tmp = node;
        while (tmp != null) {
            System.out.println("节点：" + tmp.data);
            // 继续下一个
            tmp = tmp.next;
        }

    }

    /**
     * 计算链长
     *
     * @return
     */
    public int linkListLength() {
        int length = 0;
        // 从临时结点，从首节点开始
        Node tmp = head;
        // 找到尾节点
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 插入结点
     *
     * @param index
     * @param data
     */
    public void insertNode(int index, String data) {
        // 校验，防止选中插入的下标越界
        if (index <= 0 || index > linkListLength() + 1) {
            System.out.println("插入位置不合法。");
            return;
        }
        int count = 1;
        Node insertNode = new Node(data);
        // 临时节点
        Node tmp = head;
        while (Objects.nonNull(tmp.next)) {
            if (count == index - 1) {
                insertNode.next = tmp.next;
                tmp.next = insertNode;
                break;
            }
            count++;
            tmp = tmp.next;
        }
    }

    /**
     * 根据位置删除节点
     *
     * @param index
     */
    public void deleteNode(int index) {
        // 校验，防止选中插入的下标越界
        if (index <= 0 || index > linkListLength() + 1) {
            System.out.println("插入位置不合法。");
            return;
        }
        int count = 1;
        // 临时节点，从头节点开始
        Node tmp = head;
        //Node node = new Node(null);
        while (Objects.nonNull(tmp.next)) {
                /*if (count == index-1) {
                    node = tmp;
                }
                if (count== index+1) {
                    node.next = tmp;
                }*/
            // 上一个节点
            if (index - 1 == count) {
                Node deleteNode = tmp.next;
                // 删除的地址赋值给上一个节点地址
                tmp.next = deleteNode.next;

            }
            count++;
            tmp = tmp.next;
        }
    }

    /**
     * 打印
     */
    public void print() {
        Node tmp = head;
        while (tmp.next != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println(tmp.data);
    }

    /**
     * 反转
     *
     * @param node
     */
    private void ReverseIteratively(Node node) {

        Node ReverseNode = null;
        Node pNode = node;
        Node prev = null;
        int length = 0;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                // 只赋值最后一个值
                ReverseNode = pNode;
            }
            // 把除最后一个node 的值挂在pNode上
            pNode.next = prev;
            System.out.println(prev);
            // prev 除最后一个node
            prev = pNode;
            pNode = pNext;
            length++;
        }
        this.head = ReverseNode;
        System.out.println(length);
        System.out.println(this.head);
    }

    /**
     * 查找单平台的中间数据（适用指针快慢指针）
     *
     * @param node
     */
    public void searchMid(Node node) {
        Node q = this.head;
        Node p = this.head;
        while (q.next != null && q.next.next != null) {
            q = q.next.next;
            p = p.next;
        }
        // 用快慢指针，需要判断node的总长度来判断中间节点有几个
        int length = linkListLength();
        if (length % 2 == 0) {
            System.out.println(p.data + "-" + p.next.data);
            return;
        }
        System.out.println(p.data);
    }


    /**
     * 查询倒数第k个值
     */
    private Node findElem(Node node, int k) {
        if (k < 1 || k > linkListLength()) {
            return null;
        }
        Node p = this.head;
        Node q = this.head;
        for (int i = 0; i < k - 1; i++) {
            p = p.next;
        }
        // 由于p.next!=null 会导致p 的最后一次循环没有走，顾在for循环中-1 使p在for减一次循环
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        System.out.println(q);
        return q;
    }

    /**
     * 删除重复节点
     */
    public void deleteDuplecate(Node head) {
        Node q = this.head;
        // q的数据是逐渐的减少的
        while (q.next != null) {
            Node p = q;
            while (p.next != null) {
                // 去除自己node节点所有用q当前节点和p的下一个节点比较，如果相同的话就直接跳过下个节点，下下节点在比较
                if (q.data.equals(p.next.data)) {
                    p.next = p.next.next;
                    System.out.println(p.data);
                } else {
                    p = p.next;
                }
            }
            q = q.next;
        }
    }

    public static void main(String[] args) {
        LinkListExample listExample = new LinkListExample();
        listExample.addNode("1");
        listExample.addNode("2");
        listExample.addNode("3");
        listExample.addNode("4");
        listExample.addNode("5");
        listExample.addNode("6");
        //System.out.println(listExample.linkListLength());
       // listExample.insertNode(2,"4");
       // System.out.println(listExample.head.data);
        //listExample.print();
        // 中间节点查
        //listExample.searchMid(listExample.head);
        // 反转
        listExample.ReverseIteratively(listExample.head);
        //查询
        /*Node node = listExample.findElem(listExample.head,4);
        if (Objects.nonNull(node)) {
            System.out.println(node.data);
        }*/

       // listExample.deleteDuplecate(listExample.head);
    }

}
