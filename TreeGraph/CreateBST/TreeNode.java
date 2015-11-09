package CreateBST;

class TreeNode {

	TreeNode parent; //the parent
	TreeNode right; // parents right
	TreeNode left; //parents left

	public int data; //keep track of the data inside each leaf/tree node
	private int size; //want to keep track of our tree size

	//Create a tree node with data d in it
	public TreeNode(int d) {
		data = d;
		size = 1; //set size to 1 for creating our initial node
	}

	public void setLeftChild(TreeNode left) {
		this.left = left;
		if(left!=null) {
			left.parent = this;
		}
	}

	public void setRightChild(TreeNode right) {
		this.right = right;
		if(right!=null) {
			right.parent = this;
		}
	}

	public void insertInOrder(int d) {
		if(d < data) {
			if(left == null) {
				setLeftChild(new TreeNode(d));
			}

			else {
				left.insertInOrder(d);
			}
		}

		else {
			if(right == null) {
				setRightChild(new TreeNode(d));
			}
			else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isBST() {
		if(left!=null) {
			if(data < left.data || !left.isBST()) {
				return false;
			}
		}
		if(right!=null) {
			if(data >= right.data || !right.isBST()) {
				return false;
			}
		}
		return true;
	}

	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static TreeNode createMinimalBST(int arr[], int start, int end) {
		if(end < start) {
			return null;
		}

		int mid = (start + end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid+1, end));
		return n;
	}

	public static TreeNode createMinimalBST(int arr[]) {
		return createMinimalBST(arr, 0, arr.length-1);
	}
}