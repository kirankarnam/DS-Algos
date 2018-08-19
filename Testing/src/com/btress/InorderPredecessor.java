package com.btress;

public class InorderPredecessor {

	public static void main(String[] args) {
		BinaryTree bst =  new BinaryTree();
		BinaryTree tree1 =  bst.createBinaryTree();
		InorderPredecessor inp = new InorderPredecessor();
		inp.inorder(tree1.root);
		System.out.println(tree1.root.right.right.data);
		System.out.println("-------------------");
		inp.inorderPred(tree1.root, tree1.root.right.right);

		System.out.println();

	}
	
	public void inorderPred(TreeNode root,TreeNode node) {
		if(node == null) throw new IllegalArgumentException();
		
		if(node.left != null) {
			TreeNode temp = node.left;
			while(temp.right !=null) {
				temp = temp.right;
			}
			System.out.println(temp.data);
		}
		
		//search for the node from root keeping track of parent and the node from where we take last right turn in the answer
		
		
		TreeNode temp = root;
		TreeNode result = null;

		
		while(temp !=null) {
			if(temp.data < node.data) {
				result = temp;
				temp = temp.right;
			}else if(temp.data > node.data) {
				temp = temp.left;
			}else {
				break;
			}
		}
		
		if(result!=null)
			System.out.println(result.data);
		else
			System.out.println("inorder predecessor not found");
	}
	
	public void inorder(TreeNode root) {
		if(root == null) return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		
	}

}
