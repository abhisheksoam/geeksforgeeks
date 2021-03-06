package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;



/**
 * 
 * @author abhishek
 *	Uncompleted Function: 
 *  sortElementByFrequency_v3
 *	
 */

public class Solution {

	public static void main(String[] args) {

		int [] input = {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
		//		int [] input1 = {2, 3, 5, 6};
		//		leadersInArray(input);
		//		System.out.println(medianSorted(input, input1));
		//		sortElementByFrequency_v2(input);
		//		System.out.println(countInversion(input));
		//		sumClosetToZero(input);
		//		twoSmallestElement(input);
		//		majortiyElementInSortedArray(input);
		//		segrate0and1(input);
		//		kLargest_v1(input, 3);
		//		kLargest_v2(input, 3);
		//		maximumDifference(input);
		//		maximumDifference_v2(input);
		//		unionAndIntersection(input, input1, "intersection");
		//		unionAndIntersection(input, input1, "union");
		//		segregateEvenAndOdd(input);
		//		findTwoRepeating(input);
		//		ceilAndFloor(input, 5);
		//		sort012(input);
		//		findDuplicates(input);
		//		nextGreaterElement(input);
		//		areElementsConsecutive(input);
		//		smallestMissingNumber(input, 10);
		//		findMinimumDistanceBetweenTwoNumbers(input, 3, 2);
		//		System.out.println(binarySearch(input, 0, input.length-1, 7));
		//		System.out.println(binarySearch(input, 23));
		//		selectionSort(input);
		//		countSmallerElementsOnRight(input);
		//		findSubarrayWithSum_v1(33, input);
		//		findSubarrayWithSum(33, input);
		//		findTriplets_v1(input, 24);
		//		findSmallPositiveNumberFromUnsorted(input);
//			findTwoNumberWithOddOcc(input);
	}
	
	/**
	 *  Maximum product subarray
	 */
	public static int maxmumProductSubarray(int[] input){
		
	}
	
	
	/**
	 * Find the two numbers with odd occurrences in an unsorted array
	 */
	// O(n) time complexity and O(n) space complexity
	public static void findTwoNumberWithOddOcc(int[] input){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<input.length;i++){
			if(map.containsKey(input[i])){
				map.put(input[i], map.get(input[i])+1);
			}else{
				map.put(input[i],1);
			}
		}
		
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry p = it.next();
			if((int)p.getValue()%2!=0){
				System.out.println(p.getKey());
			}
		}
	}

	// O(n) time complexity and O(1) space complexity
	public static void findTwoNumberWithOddOcc_v1(int[] input){
		
	}
	
	/**
	 * Find the smallest positive number missing from an unsorted array
	 */
	// O(n) time complexity and O(n) space complexity
	public static void findSmallPositiveNumberFromUnsorted(int[] input){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int maximumElement = Integer.MIN_VALUE;
		for(int i=0;i<input.length;i++){
			if(input[i]>0){
				map.put(input[i],true);
			}
			if(input[i]>maximumElement){
				maximumElement = input[i];
			}
		}

		for(int i=1;i<maximumElement;i++){
			if(!map.containsKey(i)){
				System.out.println("Min value "+i);
				return;
			}
		}
	}

	// O(n) time complexity and O(1) space complexity
	public static void findSmallPositiveNumberFromUnsorted_v1(int[] input){

				
	}



	/**
	 *  Find a Triplet equal to the given sum
	 */

	// Brute Force
	public static void findTriplets(int[] input,int sum){
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input.length;j++){
				for(int k=0;k<input.length;k++){
					if(input[i]+input[j]+input[k] == sum){
						System.out.println(input[i]+" "+input[j]+" "+input[k]);
						return;
					}
				}
			}
		}
	}
	// Optimized version, This method assumes All elements in array are unique
	public static void findTriplets_v1(int[] input, int sum){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i=0;i<input.length;i++){
			map.put(input[i],true);
		}

		for(int i=0;i<input.length;i++){
			for(int j=0;j<input.length;j++){
				int value = input[i]+input[j];
				if (map.containsKey(sum-value)){
					System.out.println(input[i]+" "+input[j]+" "+(sum-value));
					return;
				}
			}
		}
	}


	/**
	 * Find subarray with given sum
	 */
	public static void findSubarrayWithSum(int sum,int[] input){
		for(int i=0;i<input.length;i++){
			int value = 0;
			for(int j=i;j<input.length;j++){
				value = value + input[j];
				if(value == sum){
					System.out.println("Index are "+ i +" "+ j);
				}
			}

		}
	}

	public static void findSubarrayWithSum_v1(int sum,int[] input){
		int currentSum = input[0];
		int lastIndex = 0;
		for(int i=1;i<input.length;i++){
			if(currentSum==sum){
				System.out.println("Index are "+ lastIndex +" "+ i);
				return;
			}else if(currentSum>sum){
				while(currentSum>sum){
					currentSum = currentSum - input[lastIndex];
					lastIndex++;
				}

				if(currentSum==sum){
					System.out.println("Index are "+ lastIndex +" "+ i);
					return;
				}

			}
			currentSum = currentSum + input[i];

		}
		System.out.println("Doesn't contain");
	}


	/**
	 *  Implement two stacks in an array for Fixed Size
	 */
	public class TwoStacksInArray<T>{
		private static final int INITIAL_ELEMENT = 10;
		private ArrayList<T> list;
		private int stackSize_1;
		private int stackSize_2;
		private int lastInsertedElement_1;
		private int lastInsertedElement_2;

		public TwoStacksInArray(){
			list = new ArrayList<T>(INITIAL_ELEMENT);
			lastInsertedElement_1 = 0;
			lastInsertedElement_2 = INITIAL_ELEMENT-1;
			stackSize_1 = 0;
			stackSize_2 = 0;
		}

		public int getStack2Size(){
			return stackSize_2;
		}

		public int getStack1Size(){
			return stackSize_1;
		}

		public void pushElementToStack_1(T element){
			list.add(element);
			lastInsertedElement_1++;
			stackSize_1++;
		}

		public void pushElementToStack_2(T element){
			list.add(element);
			lastInsertedElement_2--;
			stackSize_1++;
		}

		public void popElementFromStack_1(){
			list.remove(--lastInsertedElement_1);
			stackSize_1--;
		}

		public void popElementFromStack_2(){
			list.remove(++lastInsertedElement_2);
			stackSize_1--;
		}

	}


	/**
	 *  Minimum number of jumps to reach end
	 */

	//	public static int minimumJumps(int[] input,int pos,int steps){
	//		if(pos>=input.length-1){
	//			return steps;
	//		}
	//		int canSkip = input[pos];
	//		int min = Integer.MAX_VALUE;
	//		for(int i=pos+1;i<=pos+canSkip;i++){
	//			int steps = minimumJumps(input, pos, steps)
	//		}
	//		
	//		
	//		
	//	}

	/**
	 *  Count smaller elements on right side
	 */
	// Brute Force
	public static void countSmallerElementsOnRight(int[] input){
		for(int i=0;i<input.length;i++){
			int element = input[i];
			int count = 0;
			for(int j=i+1;j<input.length;j++){
				if(input[j]<element){
					count++;
				}
			}
			System.out.println(count);
		}
	}

	// Optimized Approach
	public static void countSmallerElementsOnRight_v2(int[] input){

	}

	/**
	 * Selection Sort
	 */
	public static void selectionSort(int[] input){
		for(int i=0;i<input.length-1;i++){
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for(int j =i+1;j<input.length;j++ ){
				if(input[j]<min){
					min = input[j];
					minIndex = j;
				}
			}
			if(min!=Integer.MAX_VALUE && minIndex != -1){
				int temp = input[i];
				input[i] = input[minIndex];
				input[minIndex] = temp;
			}
		}

		for(int i:input){
			System.out.println(i);
		}

	}


	/**
	 * Binary Search
	 */

	// Recursive Version
	public static int binarySearch(int[] input, int low, int high,int x){
		if(low>high){
			return -1;
		}
		int mid = low + (high-low)/2;
		if(input[mid]==x){
			return mid;
		}else if(x > input[mid]){
			return binarySearch(input, mid+1, high, x);
		}else{
			return binarySearch(input, low, mid-1, x);
		}
	}

	// Iterative Version
	private static int binarySearch(int[] input, int x){
		int l = 0;
		int r = input.length-1;
		while(l<=r){
			int mid = l + (r-l)/2;
			if(input[mid]==x){
				return mid;
			}else if(x>input[mid]){
				l = mid +1;
			}else{
				r = mid -1;
			}

		}
		return -1;
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

	/**
	 * Reversal algorithm for array rotation
	 */

	public static void reversalRotation(int[] input, int d){
		d = d % input.length;
		int k,m;
		k = m = 0;
		int[] proc =  new int[input.length];
		for(int i=d;i<input.length;i++){
			proc[k] = input[i];
			k++;
		}

		while(m<d){
			proc[k] = input[m];
			k++;
			m++;
		}

		for(int i: proc){
			System.out.print(i+ " ");
		}

	}


	/**
	 * Leaders in an array
	 * An element is leader if it is greater than all the elements to its right side.
	 */

	public static void leadersInArray(int[] input){
		ArrayList<Integer> leadersList = new ArrayList<Integer>();
		int maxElementTillNow = Integer.MIN_VALUE;
		for(int i=input.length-1;i>=0;i--){
			if(input[i]>maxElementTillNow){
				maxElementTillNow = input[i];
				leadersList.add(input[i]);
			}
		}

		for(int i:leadersList){
			System.out.print(i+" ");
		}

	}

	/**
	 *  Sort elements by frequency
	 *  Print the elements of an array in the decreasing frequency 
	 *  if 2 numbers have same frequency then print the one which came first.
	 */


	static class SortbyCount implements Comparator<Pair<Integer,Integer>>
	{
		// Used for sorting in ascending order of
		public int compare(Pair<Integer,Integer> a, Pair<Integer,Integer> b)
		{
			return  b.count-a.count;
		}
	}


	static class Pair<T,V> {
		public T index;
		public V count;

		public Pair(T first, V second) {
			this.index = first;
			this.count = second;
		}
	}

	public static void sortElementByFrequency(int[] input){
		Arrays.sort(input);
		for(int i:input){
			System.out.print(i+" ");
		}
		System.out.println();
		ArrayList<Pair<Integer, Integer>> list = new ArrayList<Solution.Pair<Integer,Integer>>();
		int previous_element = input[0];
		int previous_element_count = 1;
		int previous_element_first_index = 0;
		int k = 0;
		for(int i=1;i<input.length;i++){
			if(previous_element==input[i]){
				previous_element_count++;
			}else{
				Pair<Integer, Integer> pair = new Pair<Integer, Integer>(previous_element_first_index, previous_element_count);
				list.add(pair);
				previous_element_first_index = i;
				previous_element_count = 1;
				previous_element = input[i];
			}
		}

		for(Pair p:list){
			System.out.print(p.count+" ");
		}
		// Sort list on the basis of index 1
		Collections.sort(list, new SortbyCount());
		System.out.println();
		for(Pair p:list){
			System.out.print(p.count+" ");
		}



	}

	// Using HashMap
	public static void sortElementByFrequency_v2(int[] input){

		HashMap<Integer,Pair<Integer, Integer>> map = new HashMap<Integer, Pair<Integer,Integer>>();
		for(int i=0;i<input.length;i++){
			if(map.containsKey(input[i])){
				Pair<Integer, Integer> pair = map.get(input[i]);
				pair.count++;
				map.put(input[i], pair);
			}else{
				Pair<Integer, Integer> pair = new Solution.Pair<Integer, Integer>(i,1);
				pair.index = i;
				pair.count = 1;
				map.put(input[i], pair);
			}
		}
		ArrayList<Pair<Integer, Integer>> list = new ArrayList<Solution.Pair<Integer,Integer>>();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			list.add((Pair<Integer, Integer>) pair.getValue());
			it.remove();
		}
		Collections.sort(list, new SortbyCount());
		Integer previous_count = 0;
		for(Pair p:list){
			int x = (int)p.count;
			while(x>0){
				System.out.print(input[(int)p.index]+" ");
				x--;
			}


		}

	}


	// Using BST 
	public static void sortElementByFrequency_v3(int[] input){

	}


	/**
	 * Count Inversions in an array
	 * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
	 * If array is already sorted then inversion count is 0. If array is sorted in reverse order 
	 * that inversion count is the maximum. Formally speaking, two elements a[i] and a[j] 
	 * form an inversion if a[i] > a[j] and i < j
	 */

	// Brute Force O[n*2] 

	public static int countInversion(int[] input){
		int swaps_needed = 0;
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length;j++){
				if(input[i]>input[j]){
					swaps_needed++;
				}
			}
		}
		return swaps_needed;
	}

	public static int countInversion_v2(int[] input){
		int swaps_needed = 0;
		// Just implement any less complexity sorting algorithm but make
		// sure you count each swap
		return swaps_needed;
	}


	/**
	 * Two elements whose sum is closest to zero
	 */
	// Brute Force [O(n*n)]
	public static void sumClosetToZero(int[] input){
		int sum = Integer.MAX_VALUE;
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length;j++){
				int value = input[i]+input[j];
				value = Math.abs(0-value);
				if(value<sum){
					sum = value;
				}
			}
		}
		System.out.println(sum);
	}	

	/**
	 * Find the smallest and second smallest elements in an array 
	 */
	public static void twoSmallestElement(int[] input){
		int smallestElement = Integer.MAX_VALUE;
		int secondSmallestElement = Integer.MAX_VALUE;
		for(int i=0;i<input.length;i++){
			if(input[i]<smallestElement){
				smallestElement = input[i];
			}
		}

		for(int i=0;i<input.length;i++){
			if(input[i]<secondSmallestElement&& input[i]>smallestElement){
				secondSmallestElement = input[i];
			}
		}

		System.out.println(smallestElement+" "+secondSmallestElement);

	}

	// in one traversal 
	public static void twoSmallestElement_v2(int[] input){

	}

	/**
	 * Check for Majority Element in a sorted array
	 */

	// Linear Approach O[n]
	public static void majortiyElementInSortedArray(int[] input){
		int n = input.length/2;
		int previousElement = input[0];
		int previousElementIndex = 0;
		for(int i=1;i<input.length;i++){
			if(previousElementIndex+n<input.length){
				if(input[previousElement+n-1]==previousElement){
					System.out.println("Element Found"+" "+input[i]);
					return;
				}
			}
			if(input[i]!=previousElement){
				previousElement = input[i];
				previousElementIndex = i;
			}
		}
	}

	//Binary Search
	public static void majortiyElementInSortedArray_v2(int[] input){

	}

	/**
	 * Maximum and minimum of an array using minimum number of comparisons
	 */

	public static void maximumAndMinimum(int[] input){
		int minimum = Integer.MAX_VALUE;
		int maximum = Integer.MIN_VALUE;
		for(int i=0;i<input.length;i++){
			if(input[i]>maximum){
				maximum = input[i];
			}else if(input[i]<minimum){
				minimum = input[i];
			}
		}
		System.out.println("minimum :"+" "+minimum+"And maximum:"+" "+maximum);
	}

	/**
	 * Segregate 0s and 1s in an array
	 */

	public static void segrate0and1(int[] input){
		int l =0;
		int r = input.length-1;
		while(l<r){
			if(input[l]==1){
				input[l] = 0;
			} 
			if(input[r]==0){
				input[r] = 1;
			}
			l++;
			r--;
		}

		for(int i:input){
			System.out.print(i+" ");
		}

	}

	/**
	 * Write an efficient program for printing k largest elements in an array.
	 * Elements in array can be in any order.
	 */

	// Sorting Algorithm
	public static void kLargest_v1(int[] input, int k){
		Arrays.sort(input);
		int i = input.length-1;
		while(k>0){
			System.out.println(input[i]);
			k--;
			i--;
		}
	}

	// Using Heap Algorithm
	public static void kLargest_v2(int[] input, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<>(input.length, Collections.reverseOrder());
		for(int i=0;i<input.length;i++){
			queue.offer(input[i]);
		}
		while(k>0){
			System.out.println(queue.poll());
			k--;
		}
	}

	//Using Order Statistics
	public static void kLargest_v3(int[] input, int k){

	}


	/**
	 * Maximum difference between two elements such that larger element appears after the smaller number
	 * Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[].
	 */

	// Brute Force
	public static void maximumDifference(int[] input){
		int maximumDifference = Integer.MIN_VALUE;
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length;j++){
				if(input[j]>input[i]){
					int diff = input[j] - input[i];
					if(diff>maximumDifference){
						maximumDifference = diff;
					}
				}
			}
		}

		System.out.println(maximumDifference);

	}

	// Efficient Solution 
	public static void maximumDifference_v2(int[] input){
		int maximumDifference = Integer.MIN_VALUE;
		int minElement = input[0];
		for(int i=1;i<input.length;i++){
			if(input[i]>minElement){
				if(input[i]-minElement>maximumDifference){
					maximumDifference = input[i]-minElement;
				}
			}else{
				minElement = input[i];
			}
		}

		System.out.println(maximumDifference);
	}

	/**
	 * Union and Intersection of two sorted arrays
	 */

	public static void unionAndIntersection(int[] input,int[] input1, String keyword){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i=0;i<input.length;i++){
			map.put(input[i],true);
		}
		switch (keyword) {
		case "union":
			for(int i=0;i<input1.length;i++){
				map.put(input1[i], true);
			}
			Iterator<Entry<Integer, Boolean>> it = map.entrySet().iterator();
			while(it.hasNext()){
				Entry<Integer,Boolean> pair = it.next();
				System.out.print(pair.getKey()+" ");
			}
			break;
		case "intersection":
			for(int i=0;i<input1.length;i++){
				if(map.containsKey(input1[i])){
					System.out.print(input1[i]+" ");
				}
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Ceiling and floor in a sorted array 
	 */

	public static void ceilAndFloor(int[] input, int x){

	}

	/**
	 * Segregate Even and Odd numbers
	 */

	public static void segregateEvenAndOdd(int[] input){
		int l = 0;
		int r = input.length-1;
		while(l<r){
			if(input[l]%2!=0){
				if(input[r]%2==0){
					int swapValue = input[l];
					input[l] = input[r];
					input[r] = swapValue;
					l++;
					r--;
				}else{
					r--;
				}
			}else{
				if(input[r]%2==0){
					l++;
				}else{
					l++;
					r--;
				}
			}
		}

		for(int i:input){
			System.out.print(i+" ");
		}
	}


	/**
	 *  Find the two repeating elements in a given array
	 */

	public static void findTwoRepeating(int[] input){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i:input){
			if(map.containsKey(i)){
				System.out.print(i+" ");
			}else{
				map.put(i,1);
			}
		}
	}

	/**
	 * A Product Array Puzzle
	 */

	public static void productArrayPuzzle(int[] input){

	}

	/**
	 * Sort an array of 0s, 1s and 2s 
	 */
	// Brute Force O[2n] = O[n]
	public static void sort012(int[] input){
		int zero_count = 0;
		int one_count = 0;
		int two_count = 0;
		for(int i:input){
			if(i==0){
				zero_count++;
			}else if(i==1){
				one_count++;
			}else{
				two_count++;
			}
		}
		int k =0;
		while(zero_count-->0){
			input[k] = 0;
			k++;
		}
		while(one_count-->0){
			input[k] = 1;
			k++;
		}
		while(two_count-->0){
			input[k] = 2;
			k++;
		}
		for(int i:input){
			System.out.print(i+" ");
		}
	}

	//In one loop
	public static void sort012_v1(int[] input){

	}

	/**
	 *  Find the Minimum length Unsorted Subarray,
	 *  sorting which makes the complete array sorted
	 */

	public static void minimumLengthUnsortedSubarray(int[] input){

	}

	/**
	 * Find duplicates in O(n) time and O(1) extra space
	 */
	public static void findDuplicates(int[] input){
		for(int i=0;i<input.length;i++){
			int value = input[Math.abs(input[i])];
			if(value > 0){
				input[Math.abs(input[i])] = -input[Math.abs(input[i])];
			}else{
				System.out.print(Math.abs(input[i])+" ");
			}
		}
	} 


	/**
	 *  Equilibrium index of an array
	 */

	public static void equilibriumIndex(int[] input){
		int l = 0;
		int r = input.length-1;
		while(l<r){

		}
	}

	/**
	 * Search in a row wise and column wise sorted matrix
	 */

	public void searchInDoubleMatrix(int[][] input, int x){

	}

	/**
	 * Next Greater Element 
	 */
	// Brute Force
	public static void nextGreaterElement(int[] input){
		Boolean out = false;
		for(int i=0;i<input.length;i++){
			int value = input[i];
			for(int j = i+1 ;j<input.length;j++){
				if(input[j]>value){
					out = true;
					System.out.println(input[j]);
					break;
				}
			}
			if(out!=true){
				System.out.println(-1);
			}
			out = false;

		}
	}

	/**
	 * Check if array elements are consecutive 
	 */
	public static void areElementsConsecutive(int[] input){



	}

	/**
	 * Find the smallest missing number
	 */
	// T Complexity O[n] and S Complexity O[n]
	public static void smallestMissingNumber(int[] input,int m){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i:input){
			map.put(i, true);
		}
		for(int i=0;i<m;i++){
			if(!map.containsKey(i)){
				System.out.println(i);
				return;
			}
		}

	}

	/**
	 * Count number of occurrences (or frequency) in a sorted array
	 */

	public static void countNumberOfOccurences(int[] input,int x){

	}

	/**
	 * Find the minimum distance between two numbers
	 */

	public static void findMinimumDistanceBetweenTwoNumbers(int[] input, int first, int second){
		Boolean firstNumberPresence = false;
		Boolean secondNumberPresence = false;
		int firstNumberIndex = -1;
		int secondNumberIndex =-1;
		int min = Integer.MAX_VALUE;

		for(int i=0;i<input.length;i++){
			if(input[i] == first){
				firstNumberPresence = true;
				firstNumberIndex = i;

			}else if(input[i]==second){
				secondNumberPresence = true;
				secondNumberIndex = i;
			}

			if(firstNumberPresence&&secondNumberPresence){
				int value = Math.abs(secondNumberIndex-firstNumberIndex);
				if(value<min){
					min = value; 
				}
				firstNumberPresence = false;
				secondNumberPresence = false;
			}
		}

		System.out.println(min);
	}

	/**
	 * Find a Fixed Point (Value equal to index) in a given array
	 */

	// Simple Traversal
	private static void fixPoint(int[] input){
		for(int i = 0;i<input.length;i++){
			if(i==input[i]){
				System.out.println("found an fixed point "+i);
				return;
			}
		}
	}






}
