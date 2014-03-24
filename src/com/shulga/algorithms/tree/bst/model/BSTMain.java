package com.shulga.algorithms.tree.bst.model;

import java.util.List;

public class BSTMain {
	public static void main(String[] args) {
		BinarySearchTree<Number> bst = new BSTImpl();
		bst.insertNode(5);
		bst.insertNode(4);
		bst.insertNode(3);
		bst.insertNode(7);
		bst.insertNode(8);
		bst.insertNode(6);
		System.out.println(bst.traverseTreeInString(TraverseType.INORDER));
		bst.delete(5);
		System.out.println(bst.traverseTreeInString(TraverseType.INORDER));
		
		System.out.println(bst.find(5));
		System.out.println(bst.find(8).getData());
		
	}
	
	public void printList(List<Integer> list){
		for (Integer item : list) {
			System.out.println(item);
		}
	}
}
