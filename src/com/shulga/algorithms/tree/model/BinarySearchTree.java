package com.shulga.algorithms.tree.model;

import java.util.List;

public interface BinarySearchTree<T> {

    void insertNode(T data);

    void insertNodeReverseOrder(T data);

    List traverseTree(TraverseType traverseType);

    BSTTreeNode getRootOfTree();

    StringBuilder traverseTreeInString(TraverseType traverseType);
}
