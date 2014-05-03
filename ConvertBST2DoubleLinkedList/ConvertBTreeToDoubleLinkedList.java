class BiNode {
	public BiNode n1;
	public BiNode n2;
}

class NodePair {
	BiNode head;
	BiNode tail;
	
	public NodePair(BiNode head, BiNode tail) {
		this.head = head;
		this.tail = tail;
	}
}

public class ConvertBTreeToDoubleLinkedList {

	public NodePair convert(BiNode root) {
		if (root == null) return null;
		
		NodePair left = convert(root.n1);
		NodePair right = convert(root.n2);
		
		if (left != null) {
			concate(left.tail, root);
		}
		
		if (right != null) {
			concate(root, right.head);
		}
		
		return new NodePair(left != null ? left.head : root,
							right != null ? right.tail : root);
	}
	
	public void concate(BiNode head, BiNode tail) {
		head.n2 = tail;
		tail.n1 = head;
	}
}
