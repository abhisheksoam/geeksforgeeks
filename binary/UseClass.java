package binary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UseClass {

	public static void main(String[] args) {
		BinarySearchTree bst =  new BinarySearchTree();
		ArrayList<String> input = new ArrayList<String>();
		File file = new File("/Users/abhishek/Desktop/Programming/Coding/CodeJava/bin/binary/text.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
				input.add(sc.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("file gayab");
			e.printStackTrace();
		}

		BinarySearchTreeNode<Integer> root =  bst.takeInput(input);
		
		//System.out.println(root);
//		bst.printTreeLevelWise();
		
		/**
		 *  For getting number of nodes greater than a node in tree.
		 *  
		 */
		
		//System.out.println(bst.greater(35));

		/**
		 * 
		 */
//		System.out.println(bst.greater(35));
//		bst.printNodeAtDistanceK(2);
	}

}
