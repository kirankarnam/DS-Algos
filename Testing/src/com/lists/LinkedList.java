package com.lists;

public class LinkedList {
	
	ListNode head ;
	
	
	public ListNode reverse(ListNode node,int k) {
		if(node == null) return null;
		if(k==0) return node;
		
		ListNode curr = node;
		ListNode next=null,prev = null;
		int count = 0;
		
		while(curr != null && count <k) {
			next =  curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count ++;
		}
		
		if(next !=null)
			node.next = reverse(next,k);
			
		return prev;
		
	}
	
	public void push(int new_data)
	{
		   /* 1. Allocate the Node &
	       2. Put in the data
	       3. Set next as null */
	    ListNode new_node = new ListNode(new_data);
	 
	    /* 4. If the Linked List is empty, then make the
	           new node as head */
	    if (head == null)
	    {
	        head = new ListNode(new_data);
	        return;
	    }
	 
	    /* 4. This new node is going to be the last node, so
	         make next of it as null */
	    new_node.next = null;
	 
	    /* 5. Else traverse till the last node */
	    ListNode last = head; 
	    while (last.next != null)
	        last = last.next;
	 
	    /* 6. Change the next of last node */
	    last.next = new_node;
	    return;
	}
	
	
	ListNode interweave(ListNode node) {
		if(node == null) return null;
		
		ListNode mid = findMid( node);
		mid = reverse(mid);
		

		ListNode curr = node;
		ListNode next;
		ListNode nextMid;
		while(curr !=null && mid !=null) {
			next = curr.next;
			nextMid = mid.next;
			curr.next = mid;
			curr.next.next = next;
			curr = next;
			mid = nextMid;
		}
		//curr.next = null;
		return node;
	}
	
	
	ListNode findMid(ListNode node) {
		ListNode slow = node;
		ListNode fast = slow.next;
		
		while(fast!=null && fast.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	ListNode reverse(ListNode node) {
		
		if(node ==null) return null;
		
		ListNode prev = null,next = null;
		
		ListNode curr = node;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		return prev;
	}
	
    void printList()
    {
        ListNode temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	  
	    public void insertFront(int new_data)
	    {
	        /* 1 & 2: Allocate the Node &
	                  Put in the data*/
	        ListNode new_node = new ListNode(new_data);
	 
	        /* 3. Make next of new Node as head */
	        new_node.next = head;
	 
	        /* 4. Move the head to point to new Node */
	        head = new_node;
	    }
	    
	    public static void main(String args[]) {
	    	LinkedList list1 = new LinkedList();
			list1.push(1);
			list1.push(2);
			list1.push(3);
			list1.push(4);
			list1.push(5);
			list1.push(6);
			list1.push(7);
			list1.push(8);
			list1.push(9);
			
			list1.head = list1.interweave(list1.head);
			
			list1.printList();
	    }
}
