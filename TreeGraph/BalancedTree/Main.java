package BalancedTree;

public class Main {

	public static int checkHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int leftheight = checkHeight(root.left);
		if(leftheight == -1) {
			return -1;
		}

		int rightheight = checkHeight(root.right);
		if(rightheight == -1) {
			return -1;
		}

		int heightdiff = leftheight - rightheight;

		if(Math.abs(heightdiff) > 1) {
			return -1;
		}
		else {
			return Math.max(leftheight, rightheight) + 1;
		}
	}

	public static boolean isBalanced(TreeNode root) {
		if(checkHeight(root) == -1) {
			return false;
		}

		else {
			return true;
		}
	}


	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + isBalanced(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}
}