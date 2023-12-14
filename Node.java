package pac;

public class Node {
	public int Data;
	public Node leftNode;
	public Node rightNode;
	public Node parentNode;
	
	public Node(int data) {
		this.Data = data;
		this.leftNode = null;
		this.rightNode = null;
		this.parentNode = null;
	}

}
