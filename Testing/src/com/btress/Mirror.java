package com.btress;

public class Mirror {

	public static void main(String[] args) {
		BinaryTree bst =  new BinaryTree();
		BinaryTree tree1 =  bst.createBinaryTree();
		BinaryTree tree2 =  bst.createBinaryTree();
		System.out.println(isSame(tree1.root,tree2.root));
		

	}

	public static boolean isMirror(TreeNode n1,TreeNode n2) {
		if(n1 == null && n2 == null) return true;
		
		if(n1 ==null || n2 == null) return false;
		
		if(n1.data == n2.data) {
			if(isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left)){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isSame(TreeNode n1,TreeNode n2) {
		if(n1 == null && n2 == null) return true;
		
		if(n1 ==null || n2 == null) return false;
		
		if(n1.data == n2.data) {
			if(isSame(n1.left, n2.left) && isSame(n1.right, n2.right)){
				return true;
			}
		}
		
		return false;
	}

}
