package com.other;

import java.util.HashMap;

/**
 * THis can be solved using hashmap and doubly linked list
 * 
 * When a page is referenced, the required page may be in the memory. 
 * 	If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
	If the required page is not in the memory, we bring that in memory. 
		In simple words, we add a new node to the front of the 
		queue and update the corresponding node address in the hash. 
		If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, 
		and add the new node to the front of queue.
 * @author kkarnam
 *
 */
class Node {
int key;
int value;
Node pre;
Node next;

public Node(int key, int value) {
	this.key = key;
	this.value = value;
}
}
public class LRUCache {
	HashMap<Integer, Node> map;
	int capacity, count;
	Node head, tail;
	
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}
	
	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
	
	public void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}
	
	/**
	 * check to see if the map contains the key if it is present delete the node from rear and add to the front of the list
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			return result;
		}
		return -1;
	}
	
	
	public void set(int key, int value) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
		}else {
			Node node = new Node(key,value);
			map.put(key, node);
			if(count < capacity) {
				count++;
				addToHead(node);
			}else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
			
		}
	}
}

