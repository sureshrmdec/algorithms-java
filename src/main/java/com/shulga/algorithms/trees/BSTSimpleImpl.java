package com.shulga.algorithms.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTSimpleImpl {
    private BSTTreeNode rootNode = null;

    private class BSTTreeNode {
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

    private void traversePreOrderNonRec(BSTTreeNode root, List<BSTTreeNode> traversedNodesList) {
        Stack<BSTTreeNode> callStack = new Stack<BSTTreeNode>();
        callStack.add(root);
        while (true) {
            BSTTreeNode node = callStack.pop();
            if (node == null) {
                break;
            }
            traversedNodesList.add(node);
            BSTTreeNode right = root.getRight();
            if (right != null) {
                callStack.add(right);
            }
            BSTTreeNode left = root.getLeft();
            if (left != null) {
                callStack.add(left);
            }
        }
    }

    private BSTTreeNode findCommonAncestor(BSTTreeNode one, BSTTreeNode two) {
        BSTTreeNode current = one;
        while (rootNode != null) {
            if (rootNode.getData() > one.getData() && rootNode.getData() > two.getData()) {
                rootNode = rootNode.getLeft();
            } else if (rootNode.getData() < one.getData() && rootNode.getData() < two.getData()) {
                rootNode.getRight();
            } else if (rootNode.getData() == one.getData() || rootNode.getData() == one.getData()) {
                return rootNode;
            } else {
                return rootNode;
            }
        }
        return null;
    }

    private void traversePreOrder(BSTTreeNode node, List<Number> traversedNodesList) {
        if (node != null) {
            traversedNodesList.add(node.getData());
            traversePreOrder(node.getLeft(), traversedNodesList);
            traversePreOrder(node.getRight(), traversedNodesList);
        }
    }

    public StringBuilder traverseTreeInString(TraverseType traverseType) {
        List<Number> traversedNodesList = traverseTree(traverseType);
        StringBuilder traversedNodesBuilder = new StringBuilder();
        for (Number integer : traversedNodesList) {
//            traversedNodesBuilder.append(integer.toString());
            System.out.println(integer.toString());
        }
        return traversedNodesBuilder;
    }

    public BSTTreeNode getRootOfTree() {
        return this.rootNode;
    }

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

    public BSTTreeNode findRec(Number data, BSTTreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.getData().longValue() == data.longValue()) {
            return root;
        } else if (root.getData().longValue() < data.longValue()) {
            return findRec(data, root.getRight());
        } else {
            return findRec(data, root.getLeft());
        }
    }

    public static void main(String[] args) {
        BSTSimpleImpl bst = new BSTSimpleImpl();
        bst.insertNode(10);
        bst.insertNode(5);
        bst.insertNode(20);
        bst.insertNode(3);
        bst.insertNode(7);
        bst.insertNode(6);
        bst.insertNode(15);
        bst.insertNode(25);
        bst.insertNode(23);
        bst.insertNode(27);
        System.out.println(bst.traverseTreeInString(TraverseType.POSTORDER));


    }

    public void printList(List<Integer> list) {
        for (Integer item : list) {
            System.out.println(item);
        }
    }

}