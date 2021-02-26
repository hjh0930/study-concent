package com.df.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 节点
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinaryTreeNode {
    /**
     * 数据
     */
    private String data;

    /**
     * 左节点
     */
    private BinaryTreeNode leftNode;
    /**
     * 右节点
     */
    private BinaryTreeNode rightNode;



}
