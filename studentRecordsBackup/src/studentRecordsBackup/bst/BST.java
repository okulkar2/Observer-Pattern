package src.studentRecordsBackup.bst;

/**
*
*Class BST is used to create a Binary 
*Search Tree. It includes methods to 
*perform different operations on BST like
*insert, update, print Tree and calculate
*the sum of all nodes.
*
*/
public class BST {
	private Node root;
	private Node node1;
	
	public BST(){
		root = null;
		node1 = null;
	}

	/**
	 *
	 *insert(int)- It is used to create a new node for
	 *given value and call insertNode() to insert this 
	 *Node in appropriate position in BST.
	 *
	 *@param value- Integer variable containing value to be
	 *              inserted in the BST.
	 *
	*/
	public void insert(int value){
		//System.out.println("Code Here1");
		Node tempNode = new Node(value);
		root = insertNode(root,tempNode);
		//System.out.println("rootNode Value "+ rootNode.getbNumber());
	}
	
	/**
	 *
	 *insertNode(Node ,Node) is used to find appropriate
	 *position for node in the BST and insert 
	 *the node at that position 
	 *
	 *@param currentNode,newNode- 2 Node variable containing the root and
	 *             new Node to be inserted.
	 *@return Node. current Node, ideally, it returns root node
	 *
	*/
	private Node insertNode(Node currentNode, Node newNode){
		
		if(currentNode == null){
			node1 = newNode;
			return newNode;
		}
		else if(newNode.getbNumber() < currentNode.getbNumber()){
			Node Left = insertNode(currentNode.getLeft(),newNode);
			currentNode.setLeft(Left);
			//System.out.println("currentNode left Value "+ currentNode.getbNumber());
		}
		else{
			Node Right = insertNode(currentNode.getRight(),newNode);
			currentNode.setRight(Right);
			//System.out.println("currentNode left Value "+ currentNode.getbNumber());
		}
		
		return currentNode;
	}
	
	/**
	 *
	 *printInorder(Node)- It is used to print the values of
	 *the BST in Inorder.
	 *
	 *@param rootNode- Node variable of the root of the tree.
	 *
	*/
	public void printInorder(Node rootNode){
		
		if(rootNode != null){
			printInorder(rootNode.getLeft());
			System.out.print(rootNode.getbNumber()+" ");
			printInorder(rootNode.getRight());
		}
	}
	
	/**
	 *
	 *printBSum()- It is used to print the sum of all 
	 *Node values in BST using calculateSum() method.
	 *
	*/
	public void printBSum(){
		int sum = 0;
		sum = calculateSum(root,sum);
		System.out.println("The sum of all the B-Numbers is: "+sum);
	}

	/**
	 *
	 *calculateSum(Node ,int ) is used to calculate the
	 *sum of all Node values in BST.
	 *
	 *@param root1- Node variable containing the node 
	 *       sum- Integer variable for storing the sum
	 *             
	 *@return the sum of the tree
	 *
	*/
	private int calculateSum(Node root1,int sum1){
		
		if(root1 != null){
			sum1 = calculateSum(root1.getLeft(),sum1);
			sum1 = sum1 + root1.getbNumber();
			sum1 = calculateSum(root1.getRight(),sum1);
		}
		return sum1;
	}
	
	/**
	 *
	 *updateTree(int ) is used to update(increment) every Node value
	 *of BST with the update_value passed as parameter.
	 *
	 *@param updateValue- Integer variable containing the update_value
	 *                    which is used update every Node.
	 *
	*/
	public void updateTree(int updateValue){
		updateTree(root,updateValue);
		Node maxNode = findMax(root);
		maxNode.setFlag(true);
		maxNode.updatebNumber(maxNode, updateValue);
	}
	
	/**
	 *
	 *updateTree(Node ,int ) is used to increment every Node value
	 *of BST with the value passed as parameter.
	 *
	 *@param node1- Node variable of the tree whoes every Node value
	 *              is to be updated.Typically, root is passed over here
	 *		updateValue- Integer variable containing the update_value
	 *             		 which is used to increment every Node value.
	 *
	*/
	private void updateTree(Node node1, int value){
		
		if(node1 != null){
			updateTree(node1.getLeft(),value);
			node1.updatebNumber(node1, value);
			updateTree(node1.getRight(),value);
		}
	}
	
	/**
	 *
	 *findMax(Node) is used to find the maximum valued Node
	 *in the BST.
	 *
	 *@param tempNode- Node variable containing the root
	 *                 node of BST 
	 *             
	 *@return the Node conataining maximum value in BST
	 *
	*/
	private Node findMax(Node tempNode){
		
		while(tempNode.getRight() != null){
			tempNode = tempNode.getRight();
		}
		
		return tempNode;
	}
	
	/**
	 *
	 *getRoot() is used to return the root Node
	 *of the BST.
	 *
	 *@return root Node of the BST
	 *
	*/
	public Node getRoot() {
		return root;
	}

	/**
	 *
	 *setRoot() is used to set the root Node
	 *of the BST to the passed rootIn Node.
	 *
	 *@param rootIn- Node variable which is used to set root Node. 
	 *
	*/
	public void setRoot(Node rootIn) {
		root = rootIn;
	}
	
	/**
	 *
	 *getNode() is used to return the node1 contaning current 
	 *Node of the BST.
	 *
	 *@return node1 Node of the BST
	 *
	*/
	public Node getNode() {
		return node1;
	}

	/**
	 *
	 *setNode() is used to set the node1 Node
	 *of the BST to the passed node1In Node.
	 *
	 *@param node1In- Node variable which is used to set node1 Node. 
	 *
	*/
	public void setNode(Node node1In) {
		node1 = node1In;
	}

}