/**
 * case 1: Node n has right child, then get left most of right sub tree
 * case 2: Node n does NOT have right child 
 * 			1. it is the left child of its parent, then its parent is the successor
 * 			2. it is the right child of its parent, then need to go up until the parent is a 'left child'
 * 
 * @author thinkman
 *
 */
public class InorderSuccessor {
	
	public TreeNode getSucc(TreeNode root) {
		
		if (root == null) return null;
		
		if (root.right != null) {
			
			this.findLeftMost(root.right);
		} else {
			TreeNode q = root;
			TreeNode p = q.parent;
			
			while (p != null && p.left != q) {
				q = p;
				p = p.parent;
			}
			
			return p;
		}
	} 
	
	
	private TreeNode findLeftMost(TreeNode node) {
		
		if (node == null) return null;
		
		TreeNode n = node;
		while (n.left != null) {
			n = n.left;
		}
		
		return n;
	}
	
}