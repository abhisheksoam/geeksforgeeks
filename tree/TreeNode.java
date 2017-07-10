package tree;

import java.util.ArrayList;

public class TreeNode<T> {
	
	ArrayList<T> listOfChildren;
	T data;
	
	public TreeNode(T data) {
		listOfChildren =  new ArrayList<T>();
		this.data = data;
	}

}
