package array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author abhishek
 *	Uncompleted Question: 
 *
 *	
 */

public class Solution {

	public static void main(String[] args) {
	
		int [] a = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(largestSumContiguousArray(a, a.length));
		//		int n = a.length;
//		majorityElement_2(input);
	
//		findOdd(input);
//		int i;
//	    int x1 = a[0]; /* For xor of all the elements in array */
//	    int x2 = 1; /* For xor of all the elements from 1 to n+1 */
//	     
//	    for (i = 1; i< n; i++)
//	        x1 = x1^a[i];
//	            
//	    for ( i = 2; i <= n+1; i++)
//	        x2 = x2^i;         
//	    
//	    System.out.println(x1^x2);
	}
	
	/**
	 *  Sum of the elements in the given array
	 */
	
	public static int sumElements(int[] input){
		int sum = 0;
		for(int i: input){
			sum += i;
		}
		return sum;
	}
	
	/**
	 *  Find the largest number in array
	 */
	
	public static int maxElement(int[] input){
		int max = Integer.MIN_VALUE;
		for(int i=0;i<input.length;i++){
			if(input[i]>max){
				max = input[i];
			}
			
		}
		return max;
	}
	
	
	/**
	 * To find whether there exists two number in array for number x
	 * Given an array A[] and a number x, check for pair in A[] with sum as x
	 */
	
	public static boolean numberSum(int[] input,int x){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i=0;i<input.length; i++){
			map.put(input[i], true);
		}
		for(int i=0;i<input.length;i++){
			int firstNumber = input[i];
			int secondNumber = x- input[i];
			if(map.containsKey(firstNumber)){
				map.remove(firstNumber);
				if(map.containsKey(secondNumber)){
					System.out.println("First number : "+firstNumber+"second number : "+secondNumber);
					return true;	
				}
			}
		}
		return false;	
	}

	/**
	 * Majority Element
	 * 1. Simple Version(Using hashmap)
	 * 2. BST approach 
	 */
	
	// 1. S
	public static int majorityElement(int [] input){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<input.length;i++){
			if(map.containsKey(input[i])){
				map.put(input[i],map.get(input[i])+1);
			}else{
				map.put(input[i], 1);
			}
		}
		
		int size = input.length/2;
		for(int i=0;i<input.length;i++){
			if(map.containsKey(input[i])){
				if(map.get(input[i])>size){
					System.out.println("Element: "+input[i]+"Size: "+ map.get(input[i]));
					return 0;
				}
			}
		}
	
		return 0;
	}

	// 2. BST 
	public static class BSTNode{
		int data;
		int count;
		BSTNode left;
		BSTNode right;
		
		public BSTNode(){
			
		}
	} 
	
	public static int majorityElement_2(int[] input){
		int size = input.length/2;
		BSTNode root = new BSTNode();
		for(int i=0;i<input.length;i++){
			root = insertBST(input[i],root,size);
		}
		return 0;
	}

	private static BSTNode insertBST(int number,BSTNode root,int size) {
		
		if(root == null){
			BSTNode node = new BSTNode();
			node.data = number;
			node.count += 1;
			node.left = null;
			node.right = null;
			return node;
		}
		else if(number == root.data){
			if(root.count > size){
				System.out.println("Number is:" + number);
			}
			root.count++;
		}
		else if(number > root.data){
			root.right = insertBST(number, root.right, size);
		}else{
			root.left = insertBST(number, root.left, size);
		}
		return root;
		
	}

	/**
	 *  Find the Number Occurring Odd Number of Times
	 *  Given an array of positive integers.
	 *  All numbers occur even number of times 
	 *  except one number which occurs odd number of times. 
	 *  Find the number in O(n) time & constant space.
	 *  
	 *  Can use 
	 *  1) Hashmap
	 *  2) XOR
	 */
	
	
	// Used Sorting and just traversing and using few variables to calculate result [ O(nlogn + n) = O(nlogn)] 
	public static void findOdd(int[] input){
		Arrays.sort(input);
		int previousNumber = input[0];
		int previousNumberCount = 1;
		for(int i=1;i<input.length;i++){
			if(input[i] == previousNumber ){
				previousNumberCount++;
			}else{
				if(previousNumberCount%2==1){
					System.out.println("Number is: "+ previousNumber);
				}
				previousNumber = input[i];
				previousNumberCount = 1;
			}
		}
		if(previousNumberCount%2==1){
			System.out.println("Number is: "+ previousNumber);
		}
		else{
			System.out.println("Number is: "+ "None");
		}
		
		
	}
	
	/**
	 * Find the Missing Number
	 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
	 */
	
	// Use sum formula
	public static int findMissingNumber(int[] input,int n){
		int sum = (n * (n+1))/2;
		for(int i=0;i<input.length;i++){
			sum = sum - input[i];
		}
		return sum;
	}
	
	
	/**
	 *  Largest Sum Contiguous array 
	 */
	
	public static int largestSumContiguousArray(int[] input,int n){
//		int[][] process = new int[n+1][n+1];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			int sum =0;
			for(int j=i;j<n;j++){
				sum = sum + input[j];
//				process[i][j] = sum;
				if(sum>max){
					max = sum;
				}
			}
		}
		return max;
	}
	
	
		



}
