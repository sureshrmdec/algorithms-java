package com.shulga.algorithms.tree.model;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl implements BinarySearchTree<Integer> {
	private BSTTreeNode rootNode;

	@Override
	public void insertNode(Integer data) {
		if (data != null) {
			BSTTreeNode newBSTTreeNode = new BSTTreeNode();
			newBSTTreeNode.setData(data);
			if (rootNode == null) {
				rootNode = newBSTTreeNode;
			} else {
				BSTTreeNode currentNode = rootNode;
				while (true) {
					if (newBSTTreeNode.getData() < currentNode.getData()) {
						if (currentNode.getLeft() == null) {
							currentNode.setLeft(newBSTTreeNode);
							break;
						}
						currentNode = (BSTTreeNode) currentNode.getLeft();
					} else {
						if (currentNode.getRight() == null) {
							currentNode.setRight(newBSTTreeNode);
							break;
						}
						currentNode = (BSTTreeNode) currentNode.getRight();
					}
				}
			}
		}
	}

	@Override
	public void insertNodeReverseOrder(Integer data) {
		if (data != null) {
			BSTTreeNode newBSTTreeNode = new BSTTreeNode();
			newBSTTreeNode.setData(data);
			if (rootNode == null) {
				rootNode = newBSTTreeNode;
			} else {
				BSTTreeNode currentNode = rootNode;
				while (true) {
					if (newBSTTreeNode.getData() > currentNode.getData()) {
						if (currentNode.getLeft() == null) {
							currentNode.setLeft(newBSTTreeNode);
							break;
						}
						currentNode = (BSTTreeNode) currentNode.getLeft();
					} else {
						if (currentNode.getRight() == null) {
							currentNode.setRight(newBSTTreeNode);
							break;
						}
						currentNode = (BSTTreeNode) currentNode.getRight();
					}
				}
			}
		}
	}

	@Override
	public List traverseTree(TraverseType traverseType) {
		List traversedNodesList = new ArrayList();
		if (traverseType.getOrderType().equalsIgnoreCase(
				TraverseType.INORDER.toString())) {
			traverseInOrder(this.rootNode, traversedNodesList);
		} else if (traverseType.getOrderType().equalsIgnoreCase(
				TraverseType.POSTORDER.toString())) {
			traversePostOrder(this.rootNode, traversedNodesList);
		} else {
			traversePreOrder(this.rootNode, traversedNodesList);
		}
		return traversedNodesList;
	}

	private void traverseInOrder(BSTTreeNode BSTTreeNode, List traversedNodesList) {
		if (BSTTreeNode != null) {
			traverseInOrder((BSTTreeNode) BSTTreeNode.getLeft(),
					traversedNodesList);
			traversedNodesList.add(BSTTreeNode.getData());
			traverseInOrder((BSTTreeNode) BSTTreeNode.getRight(),
					traversedNodesList);
		}
	}

	private void traversePostOrder(BSTTreeNode BSTTreeNode,
			List traversedNodesList) {
		if (BSTTreeNode != null) {
			traversePostOrder((BSTTreeNode) BSTTreeNode.getLeft(),
					traversedNodesList);
			traversePostOrder((BSTTreeNode) BSTTreeNode.getRight(),
					traversedNodesList);
			traversedNodesList.add(BSTTreeNode.getData());
		}
	}

	private void traversePreOrder(BSTTreeNode BSTTreeNode, List traversedNodesList) {
		if (BSTTreeNode != null) {
			traversedNodesList.add(BSTTreeNode.getData());
			traversePreOrder((BSTTreeNode) BSTTreeNode.getLeft(),
					traversedNodesList);
			traversePreOrder((BSTTreeNode) BSTTreeNode.getRight(),
					traversedNodesList);
		}
	}

	@Override
	public StringBuilder traverseTreeInString(TraverseType traverseType) {
		List<Integer> traversedNodesList = traverseTree(traverseType);
		StringBuilder traversedNodesBuilder = new StringBuilder();
		for (Integer integer : traversedNodesList) {
			traversedNodesBuilder.append(integer.toString());
		}
		return traversedNodesBuilder;
	}	

	@Override
	public BSTTreeNode getRootOfTree() {
		return this.rootNode;
	}

}
