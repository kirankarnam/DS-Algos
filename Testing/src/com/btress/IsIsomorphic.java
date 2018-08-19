package com.btress;

public class IsIsomorphic {

	public static void main(String[] args) {
		BinaryTree bst =  new BinaryTree();
		BinaryTree tree1 =  bst.createBinaryTree();
		BinaryTree tree2 =  bst.createBinaryTree();
		System.out.println(isIsomorphic(tree1.root,tree2.root));

	}
	
	public static boolean isIsomorphic(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		if(root1.data !=  root2.data )
			return false;
		
		if((isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
				||
			(isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left))) {
			return true;
		}
		return false;
	}

}
