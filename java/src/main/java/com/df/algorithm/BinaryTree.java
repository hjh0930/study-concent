package com.df.algorithm;
import java.util.Objects;

/**
 * @author jifeng
 * 二叉查找树
 */
public class BinaryTree {

    /**
     * 前序遍历 根->左->右
     * @param root
     */
    public static void prologueNode (BinaryTreeNode root){
        // 根节点
        System.out.println(root.getData());
        if (Objects.nonNull(root.getLeftNode())) {
            prologueNode(root.getLeftNode());
        }
        if (Objects.nonNull(root.getRightNode())) {
            prologueNode(root.getRightNode());
        }
    }

    /**
     * 中序遍历 左->根->右
     * @param root
     */
    public static void midOrderNode(BinaryTreeNode root) {
        if (Objects.nonNull(root.getLeftNode())) {
            midOrderNode(root.getLeftNode());
        }
        System.out.println(root.getData());
        if (Objects.nonNull(root.getRightNode())) {
            midOrderNode(root.getRightNode());
        }
    }

    /**
     * 后序遍历 左->右->根
     * @param root
     */
    public static void rightOrderNode(BinaryTreeNode root) {
        if (Objects.nonNull(root.getLeftNode())) {
            rightOrderNode(root.getLeftNode());
        }
        if (Objects.nonNull(root.getRightNode())) {
            rightOrderNode(root.getRightNode());
        }
        System.out.println(root.getData());
    }

    public static BinaryTreeNode init() {
        BinaryTreeNode J = new BinaryTreeNode("J", null, null);
        BinaryTreeNode H = new BinaryTreeNode("H", null, null);
        BinaryTreeNode G = new BinaryTreeNode("G", null, null);
        BinaryTreeNode F = new BinaryTreeNode("F", null, J);
        BinaryTreeNode E = new BinaryTreeNode("E", H, null);
        BinaryTreeNode D = new BinaryTreeNode("D", null, G);
        BinaryTreeNode C = new BinaryTreeNode("C", F, null);
        BinaryTreeNode B = new BinaryTreeNode("B", D, E);
        BinaryTreeNode A = new BinaryTreeNode("A", B, C);
        return A;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = init();
        prologueNode(root);
        System.out.println("---------------");
        midOrderNode(root);
        System.out.println("---------------");
        rightOrderNode(root);
    }
}
