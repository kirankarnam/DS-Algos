package com.lists;

public class ClonewithRandom {
	
	
	public ListNode cloneRandom(ListNode node) {
		if(node == null) return null;
		
		//copy the list to a new list
		ListNode curr = node;
		
		while(curr != null) {
			ListNode newNode = new ListNode(curr.data);
			newNode.next = curr.next;
			curr.next = newNode;
			curr = newNode.next;
		}
		
		curr = node;
		
		//copy random pointer at each node
		
		while(curr != null) {
			if(curr.random != null)
				curr.next.random = curr.random.next;
			curr = curr.next.next;
		}
		
		curr = node;
		
		ListNode newHead = curr.next;
		
		//split the list
		while(curr !=null) {
			ListNode next = curr.next;
			curr.next = next.next;
			if(next.next !=null)
				next.next = next.next.next;
			
			curr = curr.next;
		}
		return newHead;
	}
	
	public static void main(String args[]) {
		LinkedList list1 = new LinkedList();
		list1.push(2);
		list1.push(4);
		list1.push(3);
		
		list1.head.random = list1.head.next.next;
		list1.head.next.random = list1.head;
		list1.head.next.next.random = list1.head.next;
		
		ListNode curr = list1.head;
		
		while(curr != null) {
			System.out.print(curr.data+" -"+curr.random.data+"---->");
			curr = curr.next;
		}
		
		ClonewithRandom clr = new ClonewithRandom();
		ListNode newNode = clr.cloneRandom(list1.head);
		
		ListNode curr2 = newNode;
		
		System.out.println();
		while(curr2 != null) {
			System.out.print(curr2.data+" -"+curr2.random.data+"---->");
			curr2 = curr2.next;
		}
		
	}

}
