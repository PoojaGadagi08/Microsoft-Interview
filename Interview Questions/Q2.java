Given a Binary Search Tree (BST), find the second largest element. 
Example:

Input: Root of below BST

    10
   /
5

Output:  5





  class Node {
	int key;
	Node left, right;

	Node(int item) {
		key = item;
		left = right = null;
	}
}

public class Main {
	// A function to find 2nd largest element in a given tree.
	static void secondLargestUtil(Node root, int c) {
		// Base cases, the second condition is important to
		// avoid unnecessary recursive calls
		if (root == null || c >= 2)
			return;

		// Follow reverse inorder traversal so that the
		// largest element is visited first
		secondLargestUtil(root.right, c);

		// Increment count of visited nodes
		c++;

		// If c becomes k now, then this is the 2nd largest
		if (c == 2) {
			System.out.println("2nd largest element is " + root.key);
			return;
		}

		// Recur for left subtree
		secondLargestUtil(root.left, c);
	}

	// Function to find 2nd largest element
	static void secondLargest(Node root) {
		// Initialize count of nodes visited as 0
		int c = 0;

		// Note that c is passed by reference
		secondLargestUtil(root, c);
	}

	// A utility function to insert a new node with given key in BST
	static Node insert(Node node, int key) {
		/* If the tree is empty, return a new node */
		if (node == null)
			return new Node(key);

		/* Otherwise, recur down the tree */
		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);

		/* return the (unchanged) node pointer */
		return node;
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		/* Let us create following BST
			50
		/ \
		30 70
		/ \ / \
		20 40 60 80 */
		Node root = null;
		root = insert(root, 50);
		insert(root, 30);
		insert(root, 20);
		insert(root, 40);
		insert(root, 70);
		insert(root, 60);
		insert(root, 80);

		secondLargest(root);
	}
}
