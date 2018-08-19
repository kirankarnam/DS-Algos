package com.btress;

public class InorderPred {
	
	public TreeNode inorderPredecessor(TreeNode root, TreeNode node) {
		if(root == null) return null;
		if(node == null) return null;
		
		TreeNode pred = null;
		TreeNode curr = root;
		
		if(node.left != null) {
			return max(node.left);
		}
		while (curr != null) {
			if (curr.data > node.data) {
				curr = curr.left;
			} else if (curr.data < node.data) {
				pred = curr;
				curr = curr.right;
			}else
				break;
		}
		
		return pred;
	}

	private TreeNode max(TreeNode left) {
		TreeNode curr = left;
		
		while(curr.right !=null) {
			curr = curr.right;
		}
		return curr;
	}

	public void inorder(TreeNode root) {
		if(root == null) return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		
	}
	
	public static void main(String[] args) {
		BinaryTree bst =  new BinaryTree();
		BinaryTree tree1 =  bst.createBinaryTree();
		InorderPred inp = new InorderPred();
		TreeNode succ = inp.inorderPredecessor(tree1.root, tree1.root.right.right);
		
		inp.inorder(tree1.root);
		System.out.println();
		System.out.println(succ.data);

	}

}
