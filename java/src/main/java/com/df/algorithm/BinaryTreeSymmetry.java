package com.df.algorithm;

/**
 * 二叉树对称反转
 * @author dongfeng
 */
public class BinaryTreeSymmetry {

    /**
     * 先把根节点
     * @param root
     * @return
     */
    public static BinaryTreeNode invertTree(BinaryTreeNode root) {
        BinaryTreeNode treeNode = new BinaryTreeNode();
        if (root==null) {
            return null;
        }
        treeNode.setData(root.getData());
        invert(treeNode,root);
        return treeNode;
    }

    /**
     * 对称逻辑
     * @param treeNode
     * @param root
     */
    public static void invert(BinaryTreeNode treeNode,BinaryTreeNode root){
        // 左边的给新树的右边
        if (root.getLeftNode()!=null) {
            treeNode.setRightNode(new BinaryTreeNode(root.getLeftNode().getData()));
            invert(treeNode.getRightNode(),root.getLeftNode());
        }
        // 右边的给新树的左边
        if (root.getRightNode()!=null) {
            treeNode.setLeftNode(new BinaryTreeNode(root.getRightNode().getData()));
            invert(treeNode.getLeftNode(),root.getRightNode());
        }
    }

    public static BinaryTreeNode init(){
        BinaryTreeNode D = new BinaryTreeNode("1",null,null);
        BinaryTreeNode E = new BinaryTreeNode("3",null,null);
        BinaryTreeNode F = new BinaryTreeNode("6",null,null);
        BinaryTreeNode G = new BinaryTreeNode("9",null,null);
        BinaryTreeNode B = new BinaryTreeNode("2",D,E);
        BinaryTreeNode C = new BinaryTreeNode("7",F,G);
        BinaryTreeNode A = new BinaryTreeNode("4",B,C);
        return A;
    }

    public static void main(String[] args) {
        BinaryTreeNode node =  init();

        BinaryTree.prologueNode( invertTree(node));
    }
}
