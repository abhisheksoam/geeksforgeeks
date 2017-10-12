package linked_list;

import java.util.Scanner;

public class LinkedList<T> {
	private Node<T> rootNode;
	private int size;
	
	public LinkedList(){
		rootNode = null;
		size = 0;
	}
	
	public void takeInput(){
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> previous = null;
		while(data!=-1){
			Node<Integer> node = new Node<Integer>(data);
			if(size==0){
				rootNode = (Node<T>) node;
				previous = node;
				size++;
			}else{
				previous.next = node;
				previous = node;
				size++;
			}
		
			data = sc.nextInt();
		}	
	}
	
	
	public void printLinkList(){
		Node<Integer> current = (Node<Integer>) rootNode;
		while(current!=null){
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
		return;
	}
	
	public void getSize(){
		System.out.println(size);
	}
	
	// Insert Element at the last position
	public void insertElementAtLast(int data){
		Node<Integer> node = new Node<Integer>(data);
		Node<Integer> current = (Node<Integer>) rootNode;
		size++;
		Node<Integer> previous = null;
		while(true){
			if(current.next==null){
				previous.next.next = node;
				break;
			}
			previous = current;
			current = current.next;
		}
		
	}
	
	// Insert Element at specific position
	
	
	
}	
