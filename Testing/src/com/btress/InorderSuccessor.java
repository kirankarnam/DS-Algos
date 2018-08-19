package com.btress;

public class InorderSuccessor {

	public static void main(String[] args) {
		BinaryTree bst =  new BinaryTree();
		BinaryTree tree1 =  bst.createBinaryTree();
		InorderSuccessor ins = new InorderSuccessor();
		TreeNode node = new TreeNode(2);
		TreeNode succ = ins.inordersucc(tree1.root, node);
		
		ins.inorder(tree1.root);
		System.out.println();
		System.out.println(succ.data);

	}
	
	public void inorder(TreeNode root) {
		if(root == null) return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		
	}
	
	
	/**
	 * case 1 : if right tree is present inorder succ is the least value of the right subtree
	 * case 2: if the node has no right subtree. search the node from the root and find where we take the last left
	 * 
	 * 
	 */
	
	public TreeNode inordersucc(TreeNode root, TreeNode node) {
		if(root ==null) return null;
		if(node == null) return null;
		
		TreeNode curr = root;
		TreeNode next = null;
		
		while(curr !=null && curr.data != node.data) {
			if(curr.data > node.data) {
				next = curr;
				curr = curr.left;
			}else {
				curr = curr.right;
			}
		}
		
		if(curr == null) return null;
		
		if(curr.right == null) return next;
		
		curr = curr.right;
		
		while(curr.left!=null)
			curr = curr.left;
		
		return curr;
		
		
	}

}
