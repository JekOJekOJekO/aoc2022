package aoc2022.d07;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
	NodeType nodeType;
	String name;
	int size = 0;
	
	Node parent = null;
	List<Node> childDirs = new LinkedList<>();
	List<Node> childFiles = new LinkedList<>();

	public Node(String name, String size) {
		this.nodeType = NodeType.FILE;
		this.name = name;
		this.size = Integer.valueOf(size);
	}
	
	public Node(String name) {
		this.nodeType = NodeType.DIR;
		this.name = name;
	}
	
	
}
