package pac;

public class BinarySearchTree {
	
	public Node Root;
	
	public BinarySearchTree() {
		this.Root = null;
	}
	
	public Node Search(int value) {
		Node node = this.Root;
		while (node != null) {
			if(node.Data == value) {
				return node;
			} else if (node.Data > value) {
				node = node.leftNode;
			} else {
				node = node.rightNode;
			}
		}
		return null;
	}
	
	public void Insert(int value) {
		Node newNode = new Node(value);
		Node node = this.Root;
		while(node != null) {
			if(node.Data == value) {
				if(node.leftNode == null) {
					node.leftNode = newNode;
					newNode.parentNode = node;
					return;
				} else if (node.rightNode == null) {
					node.rightNode = newNode;
					newNode.parentNode = node;
					return;
				} else {
					node = node.leftNode;
				}
			} else if (node.Data > value) {
				if(node.leftNode == null) {
					node.leftNode = newNode;
					newNode.parentNode = node;
					return;
				}
				node = node.leftNode;
			} else {
				if(node.rightNode == null) {
					node.rightNode = newNode;
					newNode.parentNode = node;
					return;
				}
				node = node.rightNode;
			}
		}
		if(node == null) {
			this.Root = newNode;
		}
	}
	
	public Boolean Remove(int data) {
		Node node = this.Search(data);
		if(node == null) {
			return false;
		} else {
			Node parent = node.parentNode;
			if(node.leftNode == null && node.rightNode == null) {
				if(parent.leftNode == node) {
					parent.leftNode = null;
				} else if (parent.rightNode == node) {
					parent.rightNode = null;
				}
				node.parentNode = null;
			} else if (node.leftNode == null && node.rightNode != null) {
				if(parent.leftNode == node) {
					parent.leftNode = node.rightNode;
					node.rightNode.parentNode = parent;
				} else if (parent.rightNode == node) {
					parent.rightNode = node.rightNode;
					node.rightNode.parentNode = parent;
				}
				node.parentNode = null;
				node.rightNode = null;
			} else if (node.leftNode != null && node.rightNode == null) {
				if(parent.leftNode == node) {
					parent.leftNode = node.leftNode;
					node.leftNode.parentNode = parent;
				} else if (parent.rightNode == node) {
					parent.rightNode = node.leftNode;
					node.leftNode.parentNode = parent;
				}
				node.parentNode = null;
				node.leftNode = null;
			} else {
				Node tempNode = node.rightNode;
				while(tempNode.leftNode != null) {
					tempNode = tempNode.leftNode;
				}
				if(tempNode.rightNode != null) {
					tempNode.rightNode.parentNode = tempNode.parentNode;
					tempNode.parentNode.leftNode = tempNode.rightNode;
				} else {
					tempNode.parentNode.leftNode = null;
				}
				tempNode.parentNode = node.parentNode;
				tempNode.rightNode = node.rightNode;
				tempNode.leftNode = node.leftNode;
				node.parentNode = null;
				node.rightNode = null;
				node.leftNode = null;
			}
			return true;
		}
	}
	
	public void printTree(Node n, int space) {
		if(n == null) {
			return;
		} else {
			space++;
			printTree(n.rightNode, space);
			System.out.println();
			for(int i = 0; i < space; i++) {
				System.out.print("      ");
			}
			System.out.println(n.Data);
			printTree(n.leftNode, space);
		}
	}
	
//	void print2DUtil(Node* root, int space)
//	{
//	    // Base case
//	    if (root == NULL)
//	        return;
//	 
//	    // Increase distance between levels
//	    space += COUNT;
//	 
//	    // Process right child first
//	    print2DUtil(root->right, space);
//	 
//	    // Print current node after space
//	    // count
//	    cout << endl;
//	    for (int i = COUNT; i < space; i++)
//	        cout << " ";
//	    cout << root->data << "\n";
//	 
//	    // Process left child
//	    print2DUtil(root->left, space);
//	}

}
