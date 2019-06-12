package redBlack;

public class RedBlackTree {

	private RedBlackTreeNode current;
	private RedBlackTreeNode parent;
	private RedBlackTreeNode grand;
	private RedBlackTreeNode great;
	private RedBlackTreeNode header;
	private static RedBlackTreeNode nullNode;

	static {

		nullNode = new RedBlackTreeNode(0);
		nullNode.left = nullNode;
		nullNode.right = nullNode;

	}

	static final int BLACK = 1;
	static final int RED = 0;

	public RedBlackTree(int x) {

		header = new RedBlackTreeNode(x);
		header.left = nullNode;
		header.right = nullNode;

	}

	public void insert(int item) {

		current = parent = grand = header;
		nullNode.element = item;

		while (current.element != item) {

			great = grand;
			grand = parent;
			parent = current;
			current = item < current.element ? current.left : current.right;

			if (current.left.color == RED && current.right.color == RED)

				handleReorient(item);
		}

		if (current != nullNode)

			return;

		current = new RedBlackTreeNode(item, nullNode, nullNode);

		if (item < parent.element)

			parent.left = current;

		else

			parent.right = current;

		handleReorient(item);
	}

	private void handleReorient(int item) {

		current.color = RED;
		current.left.color = BLACK;
		current.right.color = BLACK;

		if (parent.color == RED) {

			grand.color = RED;

			if (item < grand.element != item < parent.element)

				parent = rotate(item, grand);
			current = rotate(item, great);
			current.color = BLACK;
		}

		header.right.color = BLACK;
	}

	private RedBlackTreeNode rotate(int item, RedBlackTreeNode parent) {

		if (item < parent.element)

			return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left)
					: rotateWithRightChild(parent.left);

		else

			return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right)
					: rotateWithRightChild(parent.right);
	}

	private RedBlackTreeNode rotateWithLeftChild(RedBlackTreeNode k2) {

		RedBlackTreeNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;

	}

	private RedBlackTreeNode rotateWithRightChild(RedBlackTreeNode k1) {

		RedBlackTreeNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		return k2;

	}

	public void inorder() {

		inorder(header.right);

	}

	private void inorder(RedBlackTreeNode r) {

		if (r != nullNode) {

			inorder(r.left);

			char c = 'B';

			if (r.color == 0)

				c = 'R';

			System.out.print(r.element + "" + c + " ");

			inorder(r.right);
		}
	}

	public void preorder() {

		preorder(header.right);

	}

	private void preorder(RedBlackTreeNode r) {

		if (r != nullNode) {

			char c = 'B';

			if (r.color == 0)

				c = 'R';

			System.out.print(r.element + "" + c + " ");

			preorder(r.left);

			preorder(r.right);
		}
	}

	public void postorder() {

		postorder(header.right);

	}

	private void postorder(RedBlackTreeNode r) {

		if (r != nullNode) {

			postorder(r.left);

			postorder(r.right);

			char c = 'B';

			if (r.color == 0)

				c = 'R';

			System.out.print(r.element + "" + c + " ");
		}
	}
}
