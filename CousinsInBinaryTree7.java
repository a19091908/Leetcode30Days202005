package leetCodeMay2020;

import java.util.Stack;


public class CousinsInBinaryTree7 {
	static Stack<TreeNode7> stack = new Stack<TreeNode7>();
	static int a, b;

	public static void main(String[] args) {
		TreeNode7 root = new TreeNode7(1, new TreeNode7(2), new TreeNode7(3));
		root.left.left = new TreeNode7(4);
		root.left.right = new TreeNode7(5);
		root.right.left = new TreeNode7(6);
		root.right.right = new TreeNode7(7);
		
		int x = 4, y = 3;
		
		boolean ans = isCousins(root, x, y);
		
		System.out.println(ans);

	}

	/**
	 * we check whether there are cousins from depth 0 to deeper depth 
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean isCousins(TreeNode7 root, int x, int y) {
		int returnVal;
		a = x;
		b = y;
		if (root.val == x || root.val == y) 
			return false;
		
		stack.clear();
		stack.push(root);
		
		while(!stack.empty()) {
			returnVal = isCousinsInTheDepth();
			if ( returnVal == 1 ) {
				return true;
			}else if( returnVal == -1 ){
				return false;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @return 
	 * 1. return -1 if the two value have the same parent. <br>
	 * 2. return  0 if the two value do not appear in this depth. <br>
	 * 3. return  1 if the two value are cousins.
	 */
	private static int isCousinsInTheDepth() {
		Stack<TreeNode7> otherStack = new Stack<TreeNode7>();
		TreeNode7 tempNode;
		int theNumberOfFind = 0;
		int theNumberOfFindInChildren = 0;
		
		for(TreeNode7 node: stack) {
			theNumberOfFindInChildren = 0;
			
			tempNode = node.left;
			if (tempNode != null) {
				if (tempNode.val == a || tempNode.val == b) {
					theNumberOfFind++;
					theNumberOfFindInChildren++;
				}
				otherStack.push(tempNode);
			}
			
			tempNode = node.right;
			if (tempNode != null) {
				if (tempNode.val == a || tempNode.val == b) {
					theNumberOfFind++;
					theNumberOfFindInChildren++;
				}
				otherStack.push(tempNode);
			}
			
			if (theNumberOfFindInChildren == 2)
				return -1;
			
			if (theNumberOfFind == 2)
				return 1;
			
		}
		
		stack = otherStack;

		return 0;
	}

}

class TreeNode7 {
    int val;
    TreeNode7 left;
    TreeNode7 right;
    TreeNode7() {}
    TreeNode7(int val) { this.val = val; }
    TreeNode7(int val, TreeNode7 left, TreeNode7 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

