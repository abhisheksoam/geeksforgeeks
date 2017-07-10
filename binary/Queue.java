package binary;

import java.util.ArrayList;

public class Queue<T> {
	ArrayList<T> list;
	int postionTop;
	int endTop;
	
	public Queue(){
		list = new ArrayList<T>();
	}
	
	public int getSize(){
		return list.size();
	}
	
	public void addElement(T data){
		list.add(data);
	}
	
	public T popElement(){
		T value = list.get(0);
		list.remove(0);
		return value;
	}
	
	public T top(){
		return list.get(0);
	}
	
	public T last(){
		return list.get(list.size()-1);
	}

}
