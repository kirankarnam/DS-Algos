package com.btress;

public class BinaryTree {
	
	TreeNode root;
	
	public BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();
	 
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    bt.add(25);
	    bt.add(30);
	 
	    return bt;
	}
	

	public void add(int value) {
	    root = addRecursive(root, value);
	}

	private TreeNode addRecursive(TreeNode current, int value) {
	    if (current == null) {
	        return new TreeNode(value);
	    }
	 
	    if (value < current.data) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.data) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }
	 
	    return current;
	}

}

