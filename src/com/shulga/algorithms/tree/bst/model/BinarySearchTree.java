package com.shulga.algorithms.tree.bst.model;

import java.util.List;

public interface BinarySearchTree<T> {

	void insertNode(T data);

	void insertNodeReverseOrder(T data);

	BSTTreeNode find(T data);

	List traverseTree(TraverseType traverseType);

	BSTTreeNode getRootOfTree();

	boolean delete(T data);

	StringBuilder traverseTreeInString(TraverseType traverseType);
}
