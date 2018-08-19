package com.btress;

import java.util.Stack;

public class SpiralOrder {

	public static void main(String[] args) {
		SpiralOrder so = new SpiralOrder();
		BinaryTree bst =  new BinaryTree();
		BinaryTree tree1 =  bst.createBinaryTree();
		so.printSpiral(tree1.root);

	}
	
	
	public void printSpiral(TreeNode root) {
		if(root ==null) return;
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		s1.push(root);
		boolean left_to_right = false;
		
		while(!s1.isEmpty()) {
			TreeNode curr = s1.pop();
			System.out.print(curr.data);
			
			if(left_to_right) {
				if(curr.left !=null) {
					s2.push(curr.left);
				}
				if(curr.right !=null) {
					s2.push(curr.right);
				}
			}else {
				if(curr.right !=null)
					s2.push(curr.right);
				
				if(curr.left !=null)
					s2.push(curr.left);
			}
			
			if(s1.isEmpty()) {
				left_to_right=!left_to_right;
				Stack<TreeNode> temp = s1;
				s1=s2;
				s2=temp;
			}
		}
	}

}
