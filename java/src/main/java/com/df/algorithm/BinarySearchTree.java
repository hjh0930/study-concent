package com.df.algorithm;


import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 二叉查找树
 * @author jifeng
 */
public class BinarySearchTree {
    /**
     * 添加节点
     * @param root
     * @param value
     */
    public static void add (BinaryTreeNode root,String value){
        int a = Integer.parseInt(value);
        if (Objects.nonNull(value)) {
            while (Objects.nonNull(root)) {
                // 判断值与根节点比较
                if (a>Integer.parseInt(root.getData())) {
                    // 如果为空就set值
                    if (Objects.isNull(root.getRightNode())) {
                        root.setRightNode(new BinaryTreeNode(value,null,null));
                        return;
                    } else {
                        // 往右遍历
                        root = root.getRightNode();
                    }
                } else {
                    if (Objects.isNull(root.getLeftNode())) {
                        root.setLeftNode(new BinaryTreeNode(value,null,null));
                        return;
                    } else {
                        root = root.getLeftNode();
                    }
                }
            }

        }
    }

    /**
     * 删除操作比较麻烦，需要分4种情况考虑。我们以上面这颗树作为参考：
     *
     * 如果删除节点含有左右子节点：需要用删除节点的后继节点（以中序遍历）取代删除节点的位置。----比如节点删除4，需要用5代替4的位置
     * 如果删除节点只含有单个节点（或左或右）：需要用删除节点的左（右）节点取代删除节点的位置。----比如节点删除8，需要用7代替8的位置
     * 如果删除节点无子节点（是叶子节点）：直接删除。
     *
     * @param node
     */
    public static void delete (BinaryTreeNode node){

    }

    /**
     * 递归获取值
     * @param root
     * @param value
     * @return
     */
    public static String findRecursion (BinaryTreeNode root,String value){
        int a = Integer.parseInt(value);
        if (Objects.isNull(root)) {
            return null;
        }
        if (a >Integer.parseInt(root.getData())) {
            root = root.getRightNode();
            return findRecursion(root,value);
        }
        if (a<Integer.parseInt(root.getData())) {
            root = root.getLeftNode();
            return findRecursion(root,value);
        }
        if (a==Integer.parseInt(root.getData())) {
            System.out.println(true);
           return root.getData();

        }
        return null;
    }

    /**
     * 递归查询
     * @param root
     * @param value
     * @return
     */
    public static String findNonRecursion (BinaryTreeNode root,String value){
        int a = Integer.parseInt(value);

        while (Objects.nonNull(root)) {
            if (a >Integer.parseInt(root.getData())) {
                root = root.getRightNode();

            }
            if (a<Integer.parseInt(root.getData())) {
                root = root.getLeftNode();
            }
            if (a==Integer.parseInt(root.getData())) {
                System.out.println(true);
                break;
            }
        }
        return null;
    }
    /**
     * 获取查找二叉树
     * @param root
     * @return
     */
    public static String getMinNode(BinaryTreeNode root) {
        // 如果树为空直接放回
        if (Objects.isNull(root)) {
            return null;
        }
        if (Objects.nonNull(root.getLeftNode())) {
            root = root.getLeftNode();
            return getMinNode(root);
        }
        return root.getData();
    }

    /**
     * 获取二叉树搜索最大值
     * @param root
     * @return
     */
    public static String getMaxNode(BinaryTreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        if (Objects.nonNull(root.getRightNode())) {
            root = root.getRightNode();
            return getMaxNode(root);
        }
        return root.getData();
    }

    /**
     * 二叉查找树需要左边小于根，右边大于根
     * @return
     */
    public static BinaryTreeNode init(){
        BinaryTreeNode A = new BinaryTreeNode("3",null,null);
        BinaryTreeNode C = new BinaryTreeNode("5",null,null);
        BinaryTreeNode B = new BinaryTreeNode("4",A,C);
        BinaryTreeNode E = new BinaryTreeNode("7",null,null);
        BinaryTreeNode F = new BinaryTreeNode("8",E,null);
        BinaryTreeNode D = new BinaryTreeNode("6",B,F);
        return D;
    }

    /**
     * 层级遍历
     */
    public static List<List<String>>  levelOrder(BinaryTreeNode root) {
        List<List<String>> ret = new ArrayList<>();
        if (root==null) {
            return ret;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        // 将二叉树放入队列中对尾
        queue.offer(root);
        // 判断队列是否为空
        while (!queue.isEmpty()) {
            List<String> level = new ArrayList<String>();
            // 该层级节点个数
            int currentLevelSize = queue.size();
            for (int i =1;i<=currentLevelSize;++i) {
                // 弹出对首节点
                BinaryTreeNode node = queue.poll();
                level.add(node.getData());
                if (node.getLeftNode()!=null){
                    // 获取该节点的左节点
                    queue.offer(node.getLeftNode());
                }
                if (node.getRightNode()!=null){
                    // 获取该节点的右节点
                    queue.offer(node.getRightNode());
                }
            }
           ret.add(level);
        }
        return ret;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = init();
        //BinaryTree.midOrderNode(node);

        //System.out.println(getMinNode(node));
        //System.out.println(getMaxNode(node));
        //System.out.println(findRecursion(node,"4"));
        //System.out.println(findNonRecursion(node,"4"));
        add(node,"2");
        add(node,"9");

        levelOrder(node);
       // BinaryTree.midOrderNode(node);
    }
}
