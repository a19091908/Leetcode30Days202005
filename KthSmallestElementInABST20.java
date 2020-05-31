package leetCodeMay2020;

import java.util.Stack;

public class KthSmallestElementInABST20 {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		
		int k = 5;
		int ans = kthSmallest(root, k);
		System.out.println(ans);
	}

	private static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		int kthSmall = 0;
		
		if (node == null) return 0;
		stack.push(node);
		while ( !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			}else {
				TreeNode tempNode = stack.pop(); 
				if (k == ++kthSmall) {
					return tempNode.val;
				}
				node = tempNode.right;
			}
		}
		
		
		return 0;
	}


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
