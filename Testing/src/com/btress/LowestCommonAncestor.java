package com.btress;

public class LowestCommonAncestor {
	
	public static void main(String args[]) {
		
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
