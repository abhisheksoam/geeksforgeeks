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

		int [] input = {1,2,3,6,9};
		int [] input1 = {4,6,8,10};
		reverseArray(input);
//		System.out.println(medianSorted(input, input1));

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
	// Brute Force [O(n^2)]
	public static int largestSumContiguousArray(int[] input,int n){
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			int sum =0;
			for(int j=i;j<n;j++){
				sum = sum + input[j];
				if(sum>max){
					max = sum;
				}
			}
		}
		return max;
	}

	// Kadane's Algorithm
	/**
	 * 
	 * @param input array 
	 * @param n size of array
	 * @return maximum sum of the subarray
	 * It works only when there is at least one positive number 
	 */

	public static int largestSumContiguousArray_v2(int[] input,int n){
		int max_ending_here = 0;
		int max_so_far = 0;

		for(int i = 0; i < n; i++){
			max_ending_here += input[i];

			if(max_ending_here > max_so_far){
				max_so_far = max_ending_here;
			}
			if(max_ending_here < 0){
				max_ending_here = 0;
			}
		}
		return max_so_far;
	}
	
	/**
	 * Search an element in a sorted and rotated array 
	 */
	
	// Brute Force  [O(n)] 
	/**
	 * 
	 * @param input:- Array
	 * @param key:- Element to search
	 * @return Boolean
	 */
	public static boolean searchElement(int[] input,int key){
		for(int i:input){
			if(i==key){
				return true;
			}
		}
		return false;
	}

	// TODO: Binary Search Approach
	
	/**
	 * Merge an array of size n into another array of size m+n.
	 * There are two sorted arrays. First one is of size m+n containing only m elements. 
	 * Another one is of size n and contains n elements.
	 * Merge these two arrays into the first array of size m+n such that the output is sorted.
	 */
	
	public static void mergeArray(int[] inputN, int[] inputMandN){
		int[] inputM = new int[inputMandN.length-inputN.length];
		int k =0;
		int j =0;
		int m =0;
		// Moving elements from M+N to new Array inputM
		for(int i=0;i<inputMandN.length;i++){
			if(inputMandN[i]!=0){
				inputM[k] = inputMandN[i];
				inputMandN[i] = 0;
				k++;
			}
		}
		k =0;
		
		//Comparing and placing into inputMandN
		while(k<inputM.length && j<inputN.length){
			if(inputM[k]>inputN[j]){
				inputMandN[m] = inputN[j];
				j++;
			}else{
				inputMandN[m] = inputM[k];
				k++;				
			}
			m++;
			
		}

		while(k<inputM.length){
			inputMandN[m] = inputM[k];
			k++;	
			m++;
		}
		
		while(j<inputN.length){
			inputMandN[m] = inputN[j];
			j++;
			m++;
		}
		
		
		// Printing inputMandN array
		for(int i:inputMandN){
			System.out.print(i+" ");
		}
		
	}

	/**
	 *  Median of two sorted array
	 *  There are 2 sorted arrays A and B of size n each. 
	 *  Write an algorithm to find the median of the array obtained
	 *  after merging the above 2 arrays
	 */
	// Complexity O[(2n)] = O[n]
	public static int medianSorted(int[] input, int[] input1){
		int i =0;
		int j =0;
		int k =0;
		int[] proc =  new int[2*input.length];
		while(i<input.length && j<input1.length){
			if(input[i]>input1[j]){
				proc[k] = input1[j];
				j++;
				k++;
			}else{
				proc[k] = input[i];
				i++;
				k++;
			}
		}
		
		while(i<input.length){
			proc[k] = input[i];
			i++;
			k++;
		}
		
		while(j<input1.length){
			proc[k] = input1[j];
			j++;
			k++;
		}
		
		return (proc[input.length-1]+proc[input.length])/2;
	}
	
	//TODO: Log(n) version
	
	/**
	 *   Program to reverse an array
	 *   Number of swaps will be half of the size of input
	 */
	
	public static void reverseArray(int[] input){
		int startIndex = 0;
		int endIndex = input.length-1;
		int swaps = input.length/2;
		int k = 0;
		while(k<swaps){
			int m = input[startIndex];
			input[startIndex] = input[endIndex];
			input[endIndex] = m;
			k++;
			startIndex++;
			endIndex--;
		}
		
		for(int i:input){
			System.out.print(i+" ");
		}
	}
	
	

}
