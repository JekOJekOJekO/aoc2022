package aoc2022.d07;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import aoc2022.AocBase;

public class D07 extends AocBase {

	List<Node> nodeList = new LinkedList<>();
	
	public D07() {
		super("/D07-Input.txt");
		//super("/D07-Input-demo.txt");
	}

	public void doit() throws IOException {
		
		// Baum erstellen
		Node root = new Node("/");
		nodeList.add(root);
		
		Node current = root;
		
		String line = null;
		
		int linecounter = 0;
		
		// Zeile 1 überspringen
		reader.readLine();
		
		while ((line = reader.readLine()) != null) {
			System.out.println(++linecounter);
			
			if (line.startsWith("$ cd ")) {
				if (line.endsWith("..")) {
					// command: $ cd ..
					current = current.parent;
				} else {
					// command: $ cd ncfcchsz
					String dirName = line.substring(5);
					current = getChildNodeDirNyName(current, dirName);
				}
				
			} else if (line.startsWith("$ ls")){
				// command ls
				// nichts zu tun
				continue;
			} else if (line.startsWith("dir")){
				// directory: dir rfb
				String dirName = line.substring(4);
				addDir(current, dirName);
			} else {
				// file
				addFile(current, line);
			}
		}
		
		int sum = 0;
		
		for (Node node : nodeList) {
			
			if (node.nodeType != NodeType.DIR) {
				continue;
			}
		
			if (node.size <= 100000) {
				sum += node.size;
			}
		}
		
		System.out.println("Summe: " + sum);
		// korrekt: 1315285
		
		long available = 70000000;
		long neededForUpdate = 30000000;
		long free = available - root.size;
		long needed = neededForUpdate - free;
		
		long currentSize = Long.MAX_VALUE; 
		
		for (Node node : nodeList) {
			if (node.nodeType != NodeType.DIR) {
				continue;
			}

			if (node.size >= needed && node.size < currentSize) {
				currentSize = node.size;
			}
		}
		
		System.out.println("Size: " + currentSize);
		
	}
	
	private void addFile(Node current, String line) {
		String[] fileInfo = line.split(" ");
		for (Node node : current.childFiles) {
			// already a child
			if (node.name.equals(fileInfo[1])) {
				return;
			}
		}
		
		// add new child
		Node newNode = new Node(fileInfo[1], fileInfo[0]);
		newNode.parent = current;
		nodeList.add(newNode);
		current.childFiles.add(newNode);
		recalcSize(newNode);
	}

	private void recalcSize(Node currentNode) {
		Node tmp = currentNode;
		while (tmp.parent != null) {
			tmp = tmp.parent;
			tmp.size += currentNode.size;
		}
	}

	private Node getChildNodeDirNyName(Node currentNode, String dirName) {
		for (Node node : currentNode.childDirs) {
			if (node.name.equals(dirName)) {
				return node;
			}
		}
		return null;
	}
	
	private void addDir(Node parent, String dirname) {
		for (Node node : parent.childDirs) {
			if (node.name.equals(dirname)) {
				return;
			}
		}
		Node newNode = new Node(dirname);
		newNode.parent = parent;
		nodeList.add(newNode);
		parent.childDirs.add(newNode);
	}

}
