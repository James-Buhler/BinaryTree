package pac;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] arr = {5,3,8,9,6,1,0,7,2,4};
		BinarySearchTree tree = new BinarySearchTree();
		for(int i = 0; i < 10; i ++) {
			tree.Insert(arr[i]);
		}
		tree.printTree(tree.Root, 0);
		System.out.println("===========================");
		tree.Remove(9);
		tree.Remove(8);
		tree.Remove(7);
		tree.printTree(tree.Root, 0);
		System.out.println("===========================");
		System.out.println(tree.Search(0));
		System.out.println(tree.Search(3));
		System.out.println(tree.Search(2));
		
	}

}
