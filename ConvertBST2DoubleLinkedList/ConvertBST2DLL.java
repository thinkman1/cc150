/**
 * 
 * http://blog.csdn.net/fightforyourdream/article/details/16843303
 * 
 * convert bst to ordered DLL (like inorder)
 *
 */

public class ConvertBST2DLL {
	
	public TreeNode convert(TreeNode root) {
		
		if (root == null) {
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode curr = root, prev = null, head = null;
		
		while (true) {
			
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			if (stack.isEmpty()) {
				break;
			}
			
			curr = stack.pop();
			
			if (prev != null) {
				prev.right = curr;
			}
			
			if (head == null) {
				head = curr;
			}
			
			prev = curr;
			curr = curr.right;
		}
		
		return head;
	}
}