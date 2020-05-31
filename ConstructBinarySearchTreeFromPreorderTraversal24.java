package leetCodeMay2020;

public class ConstructBinarySearchTreeFromPreorderTraversal24 {
	static int i;

	public static void main(String[] args) {
		int [] preorder = {8,5,1,7,10,12};
		TreeNode9 treeNode = bstFromPreorder(preorder);
		System.out.println(treeNode.val);

	}

	private static TreeNode9 bstFromPreorder(int[] preorder) {
		i = 0;
		return doBinTree(preorder, Integer.MAX_VALUE);
	}

	private static TreeNode9 doBinTree(int[] preorder, int bound) {
		if (i == preorder.length || preorder[i] > bound ) return null;
		TreeNode9 tempNode = new TreeNode9(preorder[i++]);
		tempNode.left = doBinTree(preorder, tempNode.val);
		tempNode.right = doBinTree(preorder, bound);
	
		return tempNode;
	}

	
	
}

class TreeNode9 {
    int val;
    TreeNode9 left;
    TreeNode9 right;
    TreeNode9(int x) { val = x; }
}
