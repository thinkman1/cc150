public class SymmetricTree {

	/**
	 * return symmetric tree, recursion, break given tree
	 */
	public boolean getSymmetricTreeRec(TreeNode node) {
		if (root == null) return null;
		
		TreeNode left = getSymmetricTree(node.left);
		TreeNode right = getSymmetricTree(node.right);
		
		node.left = right;
		node.right = left;
		
		return node;
	}
	

	/**
	 * return symmetric tree, recursion, do not break given tree
	 */
	public boolean getSymmetricTree(TreeNode node) {
		if (root == null) return null;
		
		TreeNode newNode = new TreeNode(node.val);
		newNode.left = getSymmetricTree(node.right);
		newNode.right = getSymmetricTree(node.left);
				
		return newNode;
	}
	
    // return mirror, break given
    public static void mirror(TreeNode root) {  
        if(root == null){  
            return;  
        }  
          
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        stack.push(root);  
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();  
              
            TreeNode tmp = cur.right;  
            cur.right = cur.left;  
            cur.left = tmp;  
              
            if(cur.right != null){  
                stack.push(cur.right);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
            }  
        }  
    }  
      
    // return mirror, do not break given
    public static TreeNode mirrorCopy(TreeNode root){  
        if(root == null){  
            return null;  
        }  
          
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        Stack<TreeNode> newStack = new Stack<TreeNode>();  
        stack.push(root);  
        TreeNode newRoot = new TreeNode(root.val);  
        newStack.push(newRoot);  
          
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();  
            TreeNode newCur = newStack.pop();  
              
            if(cur.right != null){  
                stack.push(cur.right);  
                newCur.left = new TreeNode(cur.right.val);  
                newStack.push(newCur.left);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
                newCur.right = new TreeNode(cur.left.val);  
                newStack.push(newCur.right);  
            }  
        }  
          
        return newRoot;  
    }
    
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2){  
        if(r1==null && r2==null){  
            return true;  
        }  
          
        if(r1==null || r2==null){  
            return false;  
        }  
          
        if(r1.val != r2.val){  
            return false;  
        }  
          
        return isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);  
    }      
}