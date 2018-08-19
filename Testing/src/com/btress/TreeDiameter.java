package com.btress;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeDiameter {

	public static void main(String[] args) {
		BinaryTree bst =  new BinaryTree();
		BinaryTree tree1 =  bst.createBinaryTree();
		//System.out.println(diameter(tree1.root));
		TreeDiameter td = new TreeDiameter();
		td.inOrder(tree1.root);
		System.out.println();
		//BinaryTree tree2 =  bst.createBinaryTree();
		//td.postOrderIterative(tree2.root);
	}
	
	/*
	 * left height, rheigth+1 or ldiamter,rightdiameter Max
	 */
	public static int diameter(TreeNode root) {
		if (root == null) return 0;
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		int leftDiamter = diameter(root.left);
		int rightDiamter = diameter(root.right);
		
		int finalDiameter = Math.max(lHeight+rHeight+1, Math.max(leftDiamter, rightDiamter));
		return finalDiameter;
	}
	
	
	public static int height(TreeNode root) {
		if(root == null) return 0;
		
		int left = height(root.left);
		int right = height(root.right);
		if(left > right) {
			return left+1;
		}else {
			return right+1;
		}
	}
	
	public void inOrder(TreeNode root) {
		if(root ==null) return ;
		
		inOrder(root.left);
		System.out.print(root.data);
		inOrder(root.right);
	}
	
	public void preOrder(TreeNode root) {
		if(root ==null) return;
		
		System.out.print(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root ==null) return;
				
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data);
	}
	
	public void inOrderIterative(TreeNode root) {
		if(root == null) return;
		
		// we need a stack
		Stack<TreeNode> s = new Stack<>();
		
		TreeNode curr = root;
		System.out.println();
		while(curr !=null || s.size() >0) {
			while(curr !=null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.print(curr.data);
			curr = curr.right;
		}
	}
	
	public void postOrderIterative(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		 
	    if(root==null) {
	        return ;
	    }
	 
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	 
	    while(!stack.isEmpty()) {
	        TreeNode temp = stack.peek();
	        if(temp.left==null && temp.right==null) {
	            TreeNode pop = stack.pop();
	            res.add(pop.data);
	        }
	        else {
	            if(temp.right!=null) {
	                stack.push(temp.right);
	                temp.right = null;
	            }
	 
	            if(temp.left!=null) {
	                stack.push(temp.left);
	                temp.left = null;
	            }
	        }
	    }
        System.out.print(res);
	}
	
	public TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null)
			return null;
		
		if(root ==node1 || root ==node2)
			return root;
		
		TreeNode left = LCA(root.left,node1,node2);
		
		TreeNode right = LCA(root.right,node1,node2);
		
		if(left !=null && right !=null)
			return root;
		else
			return (left!=null?left:right);
		
	}

}
