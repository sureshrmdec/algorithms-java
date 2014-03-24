package com.shulga.algorithms.tree.bst.model;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl implements BinarySearchTree<Number> {
	private BSTTreeNode rootNode = null;

	@Override
	public void insertNode(Number data) {
		if (data == null) {
			return;
		}
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

	@Override
	public void insertNodeReverseOrder(Number data) {
		if (data == null) {
			return;
		}
		BSTTreeNode newNode = new BSTTreeNode();
		newNode.setData(data);
		if (rootNode == null) {
			rootNode = newNode;
		} else {
			BSTTreeNode currentNode = rootNode;
			while (true) {
				if (newNode.getData() > currentNode.getData()) {
					if (currentNode.getLeft() == null) {
						currentNode.setLeft(newNode);
						break;
					}
					currentNode = currentNode.getLeft();
				} else {
					if (currentNode.getRight() == null) {
						currentNode.setRight(newNode);
						break;
					}
					currentNode = currentNode.getRight();
				}
			}
		}
	}

	@Override
	public List<Number> traverseTree(TraverseType traverseType) {
		List<Number> traversedNodesList = new ArrayList<Number>();

		if (traverseType == TraverseType.INORDER) {
			traverseInOrder(rootNode, traversedNodesList);
		} else if (traverseType == TraverseType.POSTORDER) {
			traversePostOrder(rootNode, traversedNodesList);
		} else {
			traversePreOrder(rootNode, traversedNodesList);
		}
		return traversedNodesList;
	}

	private void traverseInOrder(BSTTreeNode node, List<Number> traversedNodesList) {
		if (node != null) {
			traverseInOrder(node.getLeft(), traversedNodesList);
			traversedNodesList.add(node.getData());
			traverseInOrder(node.getRight(), traversedNodesList);
		}
	}

	private void traversePostOrder(BSTTreeNode node, List<Number> traversedNodesList) {
		if (node != null) {
			traversePostOrder(node.getLeft(), traversedNodesList);
			traversePostOrder(node.getRight(), traversedNodesList);
			traversedNodesList.add(node.getData());
		}
	}

	private void traversePreOrder(BSTTreeNode node, List<Number> traversedNodesList) {
		if (node != null) {
			traversedNodesList.add(node.getData());
			traversePreOrder(node.getLeft(), traversedNodesList);
			traversePreOrder(node.getRight(), traversedNodesList);
		}
	}

	@Override
	public StringBuilder traverseTreeInString(TraverseType traverseType) {
		List<Number> traversedNodesList = traverseTree(traverseType);
		StringBuilder traversedNodesBuilder = new StringBuilder();
		for (Number integer : traversedNodesList) {
			traversedNodesBuilder.append(integer.toString());
		}
		return traversedNodesBuilder;
	}

	@Override
	public BSTTreeNode getRootOfTree() {
		return this.rootNode;
	}

	@Override
	public boolean delete(Number data) {
		BSTTreeNode current = rootNode;
		BSTTreeNode parent = rootNode;
		boolean isLeft = false;
		while (current.getData() != data.longValue()) {
			parent = current;
			if (current.getData() < data.longValue()) {
				current = current.getRight();
				isLeft = false;
			} else {
				current = current.getLeft();
				isLeft = true;
			}
			if (current == null) {
				return false;
			}
		}

		// delNode does not have children
		if (current.getRight() == null && current.getLeft() == null) {
			if (current == rootNode) {
				rootNode = null;
			} else if (isLeft) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}

		// delNode does not have left child, so node is replaced by right
		// subtree
		else if (current.getLeft() == null) {
			if (current == rootNode) {
				rootNode = current.getRight();
			} else if (isLeft) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		}

		// delNode does not have right child, so node is replaced by left
		// subtree
		else if (current.getRight() == null) {
			if (current == rootNode) {
				rootNode = current.getLeft();
			} else if (isLeft) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		}

		// delNode has 2 children, node is replaced by successor
		else {
			BSTTreeNode successor = getSuccessor(current);
			if (current == rootNode) {
				rootNode = successor;
			} else if (isLeft) {
				parent.setLeft(successor);
			} else {
				parent.setRight(successor);
			}
		}
		return true;
	}

	private BSTTreeNode getSuccessor(BSTTreeNode delNode) {
		BSTTreeNode successorParent = delNode;
		BSTTreeNode successor = delNode;
		BSTTreeNode current = delNode.getRight();

		// while it has left child
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if (successor != delNode.getRight()) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(delNode.getRight());
		}
		successor.setLeft(delNode.getLeft());
		return successor;
	}

	@Override
	public BSTTreeNode find(Number data) {
		BSTTreeNode current = rootNode;
		while (current.getData() != data.longValue()) {
			if (current.getData() < data.longValue()) {
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

}