package com.shulga.algorithms.tree.model;

public class BSTTreeNode<T> {
	private int data;
	private T value;
	private BSTTreeNode left;
	private BSTTreeNode right;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
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
