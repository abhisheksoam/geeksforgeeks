package binary;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTree {
	int size;
	BinarySearchTreeNode<Integer> root;

	public BinarySearchTree(){
		root = new BinarySearchTreeNode<Integer>();
		size = 0;
	}

	public BinarySearchTree(int data){
		root = new BinarySearchTreeNode<Integer>(data);
		size = 0;
	}
	
	
	/**
	 *  Foldable Binary Tree
	 *  Given a binary tree, find out if the tree can be folded or not.
	 */
	
	
	
	
	/**
	 * Print all nodes at distance k from root
	 */
	// Root version
	public void printNodeAtDistanceK(int k){
		printNodeAtDistanceK(k,root);
	}
	
	private void printNodeAtDistanceK(int k, BinarySearchTreeNode<Integer> root) {
		if(root == null){
			return;
		}
		if(k==0 ){
			System.out.print(root.data+" ");
			return;
		} 
		printNodeAtDistanceK(k-1, root.leftChild);
		printNodeAtDistanceK(k-1, root.rightChild);
	}
	
	/**
	 *  Take Input function which builds a tree
	 * @return
	 */
	public BinarySearchTreeNode<Integer> takeInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root value");
		int rootData = sc.nextInt();
		if(rootData==-1){
			return null;
		}
		root = new BinarySearchTreeNode<Integer>(rootData);
		size++;
		Queue<BinarySearchTreeNode<Integer>> pendingNode = new Queue<BinarySearchTreeNode<Integer>>();
		pendingNode.addElement(root);
		while(pendingNode.getSize()!=0){

			BinarySearchTreeNode<Integer> present = pendingNode.popElement();
			System.out.println("Enter the left child for" + present.data);
			int leftData = sc.nextInt();
			if(leftData!=-1){
				size++;
				BinarySearchTreeNode<Integer> leftNode = new BinarySearchTreeNode<Integer>(leftData);
				present.leftChild =  leftNode;
				pendingNode.addElement(leftNode);
			}

			System.out.println("Enter the right child for" + present.data);
			int rightData = sc.nextInt();
			if(rightData!=-1){
				size++;
				BinarySearchTreeNode<Integer> rightNode = new BinarySearchTreeNode<Integer>(rightData);
				present.rightChild =  rightNode;
				pendingNode.addElement(rightNode);
			}

		}
		return root;

	}
	/**
	 * Take input method which uses list to build the tree
	 * @param input
	 * @return
	 */
	public BinarySearchTreeNode<Integer> takeInput(ArrayList<String> input) {
		if(input.size() == 0){
			System.out.println("No tree can be formed");
			return null;
		}
		int index = 0;
		root = new BinarySearchTreeNode<Integer>(Integer.parseInt(input.get(index)));
		index++;
		size++;

		Queue<BinarySearchTreeNode<Integer>> pendingNode = new Queue<BinarySearchTreeNode<Integer>>();
		pendingNode.addElement(root);
		while(pendingNode.getSize()!=0){

			BinarySearchTreeNode<Integer> present = pendingNode.popElement();
//			System.out.println("Enter the left child for" + present.data);
			int leftData = Integer.parseInt(input.get(index));
			index++;
			if(leftData!=-1){
				size++;
				BinarySearchTreeNode<Integer> leftNode = new BinarySearchTreeNode<Integer>(leftData);
				present.leftChild =  leftNode;
				pendingNode.addElement(leftNode);
			}

//			System.out.println("Enter the right child for" + present.data);
			int rightData = Integer.parseInt(input.get(index));
			index++;
			if(rightData!=-1){
				size++;
				BinarySearchTreeNode<Integer> rightNode = new BinarySearchTreeNode<Integer>(rightData);
				present.rightChild =  rightNode;
				pendingNode.addElement(rightNode);
			}

		}
		return root;

	}


	public int getSize(){
		return size;
	}

	public int countElement(){
		return countElement(root);
	}

	private int countElement(BinarySearchTreeNode<Integer> node) {
		if(node == null){
			return 0;
		}else{
			return 1+countElement(node.leftChild)+countElement(node.rightChild);
		}
	}
	
	/**
	 * Inorder Traversal: In this tree we visit all the nodes in a sequence Left Tree,Root,Right Tree
	 */

	public void inorderTraverse(){
		inorderTraverse(root);
	}

	private void inorderTraverse(BinarySearchTreeNode<Integer> node) {
		if(node==null){
			return;
		}
		inorderTraverse(node.leftChild);
		System.out.print(node.data+" ");
		inorderTraverse(node.rightChild);

	}

	public boolean isBST(){
		return isBST(root);
	}

	private boolean isBST(BinarySearchTreeNode<Integer> node) {
		if(node == null){
			return true;
		}if(node.leftChild!=null && node.leftChild.data>node.data){
			return false;
		}else if (node.rightChild!=null && node.rightChild.data<node.data){
			return false;
		}

		boolean left = isBST(node.leftChild);
		boolean right = isBST(node.rightChild);
		if (left&&right){
			return true;
		}else{
			return false;

		}
	}

	public boolean sameTree(BinarySearchTreeNode<Integer> root1, BinarySearchTreeNode<Integer> root2){
		if(root1==null&&root2==null){
			return true;
		}
		if(root1!=null&&root2!=null){
			if(root1.data==root2.data){
				boolean left = sameTree(root1.leftChild, root2.leftChild);
				boolean right = sameTree(root1.rightChild, root2.rightChild);
				if(left==true&&right==true){
					return true;
				}else{
					return false;
				}

			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public int maxDepth(){
		return maxDepth(root);
	}

	private int maxDepth(BinarySearchTreeNode<Integer> node) {
		if(node==null){
			return 0;
		}
		//System.out.println("Current node traversed "+node.data+" ");
		int left = 1 + maxDepth(node.leftChild);
		//System.out.println("Current node traversed - "+node.data+" ");
		int right = 1 + maxDepth(node.rightChild);
		return Math.max(left, right);
	}

	public void makeMirror(){
		makeMirror(root);
	}

	private void makeMirror(BinarySearchTreeNode<Integer> node) {
		if(node==null){
			return;
		}

		makeMirror(node.leftChild);
		makeMirror(node.rightChild);
		System.out.println("Current node "+node.data);
		if(node.leftChild!=null&&node.rightChild!=null){
			BinarySearchTreeNode<Integer> temp = node.leftChild;
			node.leftChild = node.rightChild;
			node.rightChild = temp;
		}
		if(node.leftChild==null&&node.rightChild!=null){
			node.leftChild = node.rightChild;
			node.rightChild =null;
		}
		if(node.rightChild==null&&node.leftChild!=null){
			node.rightChild = node.leftChild;
			node.leftChild = null;
		}

	}

	public void printTreeLevelWise(){
		printTreeLevelwise(root);
	}

	private void printTreeLevelwise(BinarySearchTreeNode<Integer> root) {
		if(root==null){ 
			System.out.println("No Tree to print");
			return;
		}
		Queue<BinarySearchTreeNode<Integer>> pendingNode = new Queue<BinarySearchTreeNode<Integer>>();
		pendingNode.addElement(root);
		pendingNode.addElement(null);
		while(pendingNode.getSize()!=0){
			BinarySearchTreeNode<Integer> node = (BinarySearchTreeNode<Integer>) pendingNode.popElement();
			if(node==null){
				System.out.println();
				if(pendingNode.getSize()==0){
					return;
				}
				pendingNode.addElement(null);

			}else{
				System.out.print(node.data+" ");
				if(node.leftChild!=null){
					pendingNode.addElement(node.leftChild);
				}
				if(node.rightChild!=null){
					pendingNode.addElement(node.rightChild);
				}

			}
		}

	}

	public void printTreeLevelWise(BinarySearchTreeNode<Integer> root){
		if(root==null){ 
			System.out.println("No Tree to print");
			return;
		}
		Queue<BinarySearchTreeNode<Integer>> pendingNode = new Queue<BinarySearchTreeNode<Integer>>();
		pendingNode.addElement(root);
		pendingNode.addElement(null);
		while(pendingNode.getSize()!=0){
			BinarySearchTreeNode<Integer> node = pendingNode.popElement();
			if(node!=null){
				System.out.print(node.data+" ");
				if(node.leftChild!=null){
					pendingNode.addElement(node.leftChild);
				}
				if(node.rightChild!=null){
					pendingNode.addElement(node.rightChild);
				}
			}else{
				System.out.println();
				if(pendingNode.getSize()==0){
					return;
				}
				pendingNode.addElement(null);
			}
		}

	}

	//print root to leaf each line

	public void printRootToLeaf(){
		printRootToLeaf(root,new ArrayList<Integer>());
	}

	private void printRootToLeaf(BinarySearchTreeNode<Integer> node,ArrayList<Integer> list) {
		if(node==null){
			return;
		}

		list.add(node.data);
		printRootToLeaf(node.leftChild,list);
		printRootToLeaf(node.rightChild, list);
		if(node.leftChild==null&&node.rightChild==null){
			System.out.println("");
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i)+" ");
			}
			list.remove(list.size()-1);
		}else{
			list.remove(list.size()-1);
		}
	}

	// Count leaf node in a tree 
	public int countLeaf(){
		return countLeaf(root);
	}

	private int countLeaf(BinarySearchTreeNode<Integer> node) {
		if(node == null){
			return 0;
		}
		if(node.leftChild == null && node.rightChild == null){
			return 1;
		}
		int left = countLeaf(node.leftChild);
		int right = countLeaf(node.rightChild);
		return left + right;

	}


	// Minimum value in BST
	public int minimumValue(){
		return minimumValue(root);
	}

	private int minimumValue(BinarySearchTreeNode<Integer> node) {
		if(node== null){
			return 0;
		}
		if(node.leftChild == null && node.rightChild ==null){
			return node.data;
		}

		return minimumValue(node.leftChild);

	}


	
	// Sum of all the nodes
	public int sumNode(){
		return sumNode(root);
	}

	private int sumNode(BinarySearchTreeNode<Integer> node) {
		if(node==null){
			return 0;
		}
		int sum =node.data +  sumNode(node.leftChild) + sumNode(node.rightChild);
		return sum;

	}

	// Print the nodes that dont have sibling 

	public void withoutSiblingsNode(){
		withoutSiblingsNode(root);
	}

	private void withoutSiblingsNode(BinarySearchTreeNode<Integer> node) {
		if(node==null){
			return;
		}
		if(node.leftChild==null&&node.rightChild!=null || node.rightChild==null && node.leftChild!=null){
			System.out.println(node.data);
		}

		withoutSiblingsNode(node.leftChild);
		withoutSiblingsNode(node.rightChild);
	}

	// Remove the leaves of the tree

	public void removeLeaves(){
		removeLeaves(root);
	}

	private void removeLeaves(BinarySearchTreeNode<Integer> node) {
		if(node==null){
			return;
		}
		if(node.leftChild==null&&node.rightChild==null){
			System.out.println(node.data);
			node = null;
			return;
		}
		removeLeaves(node.leftChild);
		removeLeaves(node.rightChild);
	}

	
	// find the element in the given tree 
	public boolean containsElement(int element){
		return containsElement(element,root);
	}

	private boolean containsElement(int element,BinarySearchTreeNode<Integer> node) {
		if(node==null){
			return false;
		}
		if(node.data == element){
			return true;
		}
		boolean left = containsElement(element,node.leftChild);
		boolean right = containsElement(element, node.rightChild);
		if(left==true||right==true){
			return true;
		}else{
			return false;
		}
		
	}
	
	//an arbitrary Binary Tree to a tree that holds Children Sum Property
	
//	public boolean childrenSum(){
//		return childrenSum(root);
//	}
	
//	private boolean childrenSum(BinarySearchTreeNode<Integer> node) {
//		if(node == null||node.leftChild == null && node.rightChild == null){
//			return true;
//		}
//		
//		
//		
//	}
	
	// number of nodes greater than x 

	/**
	 * 
	 * @param x Integer value of the node 
	 * @return  integer which gives the nodes greater than the input value x 
	 */
	public int greater(int x){
		return greater(x,root);
	}

	/**
	 * 
	 * @param x  integer value for a node in the tree 
	 * @param node Root of the node 
	 * @return integer which gives the nodes greater than the input value x
	 */
	private int greater(int x, BinarySearchTreeNode<Integer> node) {
		if(node==null){
			return 0;
		}
		if(node.data > x){
			return 1+greater(x,node.leftChild) + greater(x,node.rightChild);
		}else{
					return greater(x,node.leftChild) + greater(x,node.rightChild);
		}
	}
	
	

	


}
