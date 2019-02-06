//  REMEMBER TO SAVE A BACKUP OF YOUR FILES!!!

/**
 * 
 * @author JJ Bernsdorff, Western Governors University, Student ID 000291957, BHP1 Task 1 Binary Search Tree
 * 
 *  The Binary Tree class contains the necessary methods to create and modify the Binary Search Tree (BST)
 * 
 * 
 *  
 */
public class BinaryTree {


	static BSTNode root;										// instance variable root

	static BSTNode nodeFound;									// for holding the found node

	static BSTNode deleteIt;									// for holding the node to delete
	
	static BSTNode container;									// for shifting nodes around

	/* Inputs supplied data into node for insertion into the BST.
	 * 
	 * @insert(String entry) Takes the supplied data as 'entry' and inserts it into 'newNode'.
	 * If the tree is empty, containing no root node, it is created with the supplied data and marked as 'root'.
	 * If the tree is NOT empty, already containing a node, the insertNode method is run to look for an appropriate location. 
	 */
	public void insert(String entry) {							// insert method

		BSTNode newNode = new BSTNode(entry);					// creates newNode to be inserted into the tree

		if(root == null) {										// checks to see if a root exists (usually used once)

			root = newNode;										// if no root, create one

//			System.out.println("The root is now " + root.key + "\n");	// prints out the name of the root

		} else {

			insertNode(root, newNode);

		}

	}

	/* Uses recursion to insert the supplied data.
	 * 
	 * @insertNode(BSTNode root, BSTNode newNode) Takes the value of newNode, using the root
	 * as a starting point, and looks for an appropriate location to insert it.  Looks through
	 * the BST for children on which to base insertion decisions.
	 */
	public void insertNode(BSTNode root, BSTNode newNode) {		// holds the recursion called in the insert method		

		if(newNode.key.compareToIgnoreCase(root.key) < 0) {		// checks to see if the key is less than the root

			if(!root.hasLeftChild()) {							// if it is, and the root has no left child...

				root.leftChild = newNode;						// make newNode the leftChild of root
				newNode.parent = root;							// and set root as its parent

				System.out.println("Added: " + newNode.key + " and it is a left child of " + newNode.parent.key + ".");

			} else {											// otherwise if there is a leftChild

				root = root.leftChild;							// make root the leftChild				

				insertNode(root, newNode);							// and keep searching...

			}

		} else {												// otherwise if the key is greater than the root

			if(!root.hasRightChild()) {							// and if the root has no right child...

				root.rightChild = newNode;						// make newNode the rightChild of root
				newNode.parent = root;							// and set root as its parent

				System.out.println("Added: " + newNode.key + " and it is a right child of " + newNode.parent.key + ".");

			} else {											// otherwise if there is a rightChild

				root = root.rightChild;							// make root the rightChild

				insertNode(root, newNode);							// and keep searching...

			}

		}

	}

	/* Looks for the requested key.
	 * 
	 * @lookup(String key) Takes the value of 'key' and searches the BST for it.
	 * If the entry cannot be found, the user is notified.
	 * If the entry is found, the user is notified.
	 * Then the node 'nodeFound' is set to null, to empty it for the next use. 
	 */
	public BSTNode lookup(String key) {							// looks up the requested node

		if(root == null) {										// checks to see if the root is empty

			System.out.println("There is nothing to evaluate." + "\n");	// if so, it lets you know

		} else {												// otherwise...

			lookupNode(root, key);								// go find the requested node...

			if(nodeFound == null) {

				System.out.println("Not Found: The entry " + "'" + key.toUpperCase() + "'" + " does not exist in the tree.");

			} else {

				System.out.print("Found: " + "\'" + nodeFound.key.toUpperCase() + nodeFound.value + "\'" + "\n");

			}

			nodeFound = null;									// clears the value of nodeFound after printing nodeFound

		}

		return nodeFound;										// returns an empty nodeFound for next use

	}

	/* Uses recursion to find the requested key.
	 * 
	 * @lookupNode(BSTNode root, String key) Takes the value of 'newNode', using the root
	 * as a starting point, and searches the BST for a node with the matching key.
	 */
	public BSTNode lookupNode(BSTNode root, String key) {

		if(root.leftChild != null)							// if leftChild is NOT null, continues searching
			lookupNode(root.leftChild, key);

		if(root.key.equalsIgnoreCase(key))					// if match IS made, returns match in nodeFound
			nodeFound = root;


		if(root.rightChild != null)							// if rightChild is NOT null, continues searching
			lookupNode(root.rightChild, key);

		return nodeFound;										// returns match in root

	}

	/* Deletes the requested node.
	 * 
	 * @delete(String key) Takes the supplied key and looks for the node to delete.
	 * If the BST is empty, not having a root from which to begin searching, the user is notified.
	 * If the node to be deleted cannot be found in the BST, the user is notified.
	 */
	public void delete(String key) {						// the node to remove				

		BSTNode parent;					// holds the parent value of found node deleteIt

		if(root == null) {			

			System.out.println("The tree does not have a root from which to begin searching..." + "\n");

		} else {	

			deleteIt = lookupNode(root, key);			// finds the node and stores it in deleteIt

			if(deleteIt == null) {

				System.out.println("Not Found: The entry " + "'" + key.toUpperCase() + "'" + " does not exist in the tree.");
				return;

			} else {

				parent = deleteIt.parent;					// sets the value of parent to the parent of deleteIt

			}

			System.out.println("\n" + "The node " + "'" + deleteIt.key.toUpperCase() + "'" + " is targeted for deletion.");

			//	Case 1: delNode has no children (is a leaf)
			if(deleteIt.isLeaf()) {				// checks to see if the node is a leaf (has no children)

//				System.out.println("Node: " + deleteIt.key.toUpperCase() + " " + deleteIt.value + " is a leaf.");

				if(deleteIt.isLeftChild()) {		// checks to see if the node is left child

					parent.leftChild = deleteIt.rightChild;	// also delNode.leftChild.parent = null; may work, but check to see for sure
					nodeFound = null;

				} else {						// if node is not a left child

					parent.rightChild = deleteIt.leftChild;	// also delNode.rightChild.parent = null; may work, but check to see for sure
					//					deleteIt = null;
					nodeFound = null;
				}

				System.out.println("Deleted: " + deleteIt.key.toUpperCase() + " has been deleted from the tree." + "\n");
				deleteIt = null;								

				// Case 2:  nodeToRemove has one child
			} else if(deleteIt.leftChild == null){ 				// only child is right child

				if(deleteIt.isLeftChild()) {	

//					System.out.println(deleteIt.key.toUpperCase() + " is the left child of " + deleteIt.parent.key);
					parent.leftChild = deleteIt.rightChild;
					nodeFound = null;

				} else {

//					System.out.println(deleteIt.key.toUpperCase() + " is the right child of " + deleteIt.parent.key);
					parent.rightChild = deleteIt.leftChild;
					nodeFound = null;

				}
				
				System.out.println("Deleted: " + deleteIt.key.toUpperCase() + " has been deleted from the tree." + "\n");
				deleteIt = null;

				// Case 3:  deleteIt has two children (has sub-cases)
			} else if(deleteIt.hasTwoChildren()){
				
				container = null;
				BSTNode replacementNode = minNode(deleteIt.rightChild);// holds the minValue of rightChild's subtree
				
//				System.out.println(deleteIt.key + " Here I am. My left child is " + deleteIt.leftChild.key + 
//						" and my right child is " + deleteIt.rightChild.key + "\n" + "My parent is " + parent.key +
//						" My replacement node is " + replacementNode.key + "\n");
//				System.out.println(deleteIt.rightChild.key);

//				parent = replacementNode.parent;					// removes the node by changing the link to parent
				
				System.out.println("Deleted: " + deleteIt.key.toUpperCase() + " has been deleted from the tree." + "\n");
				
				parent.rightChild = replacementNode;				// links parent's rightChild to replacementNode
				replacementNode.leftChild = parent.leftChild;
				replacementNode.parent = replacementNode.rightChild;
				
//				container = deleteIt;				
//				deleteIt = replacementNode;
//				parent = null;
//				replacementNode = null;
				
			}

			nodeFound = null;

		}

	}

	
	/* Used in a scenario where the node to be deleted has two children in the BST, and a node
	 * with the minimum acceptable value for replacement needs to be found automatically.
	 * 
	 * @minNode(BSTNode focusNode) Takes the node being deleted as a starting point,
	 * then searches the BST for, the minimum node, the next best replacement for
	 * the node being deleted. 
	 */
	public BSTNode minNode(BSTNode focusNode) {

		if(focusNode.leftChild == null)
			return focusNode;	
		else
			return minNode(focusNode.leftChild);

	}

	/* Used in a scenario where the node to be deleted has two children in the BST, and a node
	 * with the maximum acceptable value for replacement needs to be found automatically.
	 * 
	 * @maxNode(BSTNode focusNode) Takes the node being deleted as a starting point,
	 * then searches the BST for, the maximum node, the next best replacement for
	 * the node being deleted. 
	 */
	public BSTNode maxNode(BSTNode focusNode) {
		if(focusNode.rightChild == null)
			return focusNode;
		else
			return maxNode(focusNode.rightChild);
	}

	/* Used to print the BST to visually confirm nodes that are being deleted, left in
	 * place but being reported as deleted, to confirm insertion locations are correct,
	 * to look at the data being input, or just simply to look at your work.
	 * 
	 *  @printTree(BSTNode focusNode) Uses 'focusNode' as a starting point in the BST (root)
	 *  and recursively the left and right sides of the tree for nodes to print.
	 *  When nodes are found, they are printed.
	 */
	public void printTree(BSTNode focusNode) { // Pre-Order traversal (alphabetical order)

		if(focusNode != null) {								// if the supplied starting point is not empty

			printTree(focusNode.leftChild);
			System.out.println(focusNode.key + " " + focusNode.value);
			printTree(focusNode.rightChild);

		}

	}


	/* Used to implement the methods above to insert, lookup, and remove entries in the BST.
	 * 
	 */
	public static void main(String[] args) {

		BinaryTree myTree = new BinaryTree();
		
		System.out.println("JJ Bernsdorff (000291957) BHP1: Binary Search Tree (BST)" + "\n" + "--------------------------------------------------------" + "\n");

		// First set of insert test cases (Test Case 1 - 10):
		myTree.insert("Bob Smith 555-235-1111 bsmith@somewhere.com");
		myTree.insert("Jane Williams 555-235-1112 jw@something.com");
		myTree.insert("Mohammed al-Salam 555-235-1113 mas@someplace.com");
		myTree.insert("Pat Jones 555-235-1114 pjones@homesweethome.com");
		myTree.insert("Billy Kidd 555-235-1115 billy_the_kid@nowhere.com");
		myTree.insert("H. Houdini 555-235-1116 houdini@noplace.com");
		myTree.insert("Jack Jones 555-235-1117 jjones@hill.com");
		myTree.insert("Jill Jones 555-235-1118 jillj@hill.com");
		myTree.insert("John Doe 555-235-1119 jdoe@somedomain.com");
		myTree.insert("Jane Doe 555-235-1120 jdoe@somedomain.com");

		// First set of lookup test cases (Test Case 11 - 12):
		myTree.lookup("Pat Jones");
		myTree.lookup("Billy Kidd");

		// First set delete test cases (Test Case 13):
		myTree.delete("John Doe");

		//		myTree.printTree(root);

		// Second set of insert test cases (Test Case 14 - 19):
		myTree.insert("Test Case 555-235-1121 Test_Case@testcase.com");
		myTree.insert("Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		myTree.insert("Jo Wu 555-235-1123 wu@h.com");
		myTree.insert("Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us");
		myTree.insert("Bob vanDyke 555-235-1125 vandyke@nodomain.com");
		myTree.insert("Upside Down 555-235-1126 upsidedown@rightsideup.com");

		// Second set of lookup test cases (Test Case 20 - 21):
		myTree.lookup("Jack Jones");
		myTree.lookup("Nadezhda Kanachekhovskaya");

		// Second set delete test cases (Test Case 22 - 23):
		myTree.delete("Jill Jones");		
		myTree.delete("John Doe");			

		// Third set lookup test cases (Test Case 24 - 25):
		myTree.lookup("Jill Jones");
		myTree.lookup("John Doe");

//		myTree.printTree(root);						// prints out the final, remaining tree entries so you can
													// inspect the tree for failures...

	}
}
