package com.shulga.algorithms.tree.bst.model;

public class BSTTreeNode {
	private Number data;
	private BSTTreeNode left;
	private BSTTreeNode right;

	public Long getData() {
		return data.longValue();
	}

	public void setData(Number data) {
		this.data = data;
	}

	public BSTTreeNode getLeft() {
		return left;
	}

	public void setLeft(BSTTreeNode left) {
		this.left = left;
	}

	public BSTTreeNode getRight() {
		return right;
	}

	public void setRight(BSTTreeNode right) {
		this.right = right;
	}

}
