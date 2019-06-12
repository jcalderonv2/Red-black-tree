package redBlack;

public class RedBlackTreeNode {

	RedBlackTreeNode left, right;
	int element;
	int color;

	public RedBlackTreeNode(int theElement) {

		this(theElement, null, null);

	}

	public RedBlackTreeNode(int theElement, RedBlackTreeNode lt, RedBlackTreeNode rt) {

		left = lt;
		right = rt;
		element = theElement;
		color = 1;

	}

}
