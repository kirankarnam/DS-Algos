package com.lists;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size() ==0 )
			return null;
		return mergeKLists(lists,0,lists.size()-1);
		
	}

	private ListNode mergeKLists(List<ListNode> lists, int start, int end) {
		
		
		if(start < end) {
			int mid = (start+end)/2;
			return merge(mergeKLists(lists, start, mid),mergeKLists(lists, mid+1, end));
		}
		return lists.get(start);
	}

	private ListNode merge(ListNode m, ListNode n) {
		
		ListNode head = new ListNode(0);
		
		ListNode p = head;
		
		while(m!=null && n != null) {
			if(m.data < n.data) {
				p.next = m;
				p = p.next;
				m=m.next;
			}else {
				p.next = n;
				p = p.next;
				n = n.next;
			}
		}
		
		if(m  != null) {
			p.next = m;
		}else
			p.next = n;
		
		return head.next;
	}
	
	public static void main(String args[]) {
		MergeKLists list =  new MergeKLists();
		ListNode a = new ListNode(1);
		a=list.push(3,a);
		a=list.push(5,a);
		a=list.push(7,a);
		
		ListNode b = new ListNode(2);
		b=list.push(4,b);
		b=list.push(6,b);
		b=list.push(8,b);
		
		ListNode c = new ListNode(0);
		c=list.push(9,c);
		c=list.push(10,c);
		c=list.push(11,c);
		
		List<ListNode> input = new ArrayList<ListNode>();
		input.add(a);
		input.add(b);
		input.add(c);
		ListNode result = list.mergeKLists(input);
		
		
		/*a.next.next = new ListNode(3);
		list1 = 1->3->5->7->NULL
				list2 = 2->4->6->8->NULL
				list3 = 0->9->10->11*/
		
		list.printList(result);
	}
	
	public ListNode push(int new_data,ListNode a)
	{
		   /* 1. Allocate the Node &
	       2. Put in the data
	       3. Set next as null */
		ListNode new_node = new ListNode(new_data);
	 
	    /* 4. If the Linked List is empty, then make the
	           new node as head */
	    if (a == null)
	    {
	        a = new ListNode(new_data);
	        return a;
	    }
	 
	    /* 4. This new node is going to be the last node, so
	         make next of it as null */
	    new_node.next = null;
	 
	    /* 5. Else traverse till the last node */
	    ListNode last = a; 
	    while (last.next != null)
	        last = last.next;
	 
	    /* 6. Change the next of last node */
	    last.next = new_node;
	    return a;
	}
	
	  public void printList(ListNode input)
	    {
	        ListNode tnode = input;
	        while (tnode != null)
	        {
	            System.out.print(tnode.data+" ");
	            tnode = tnode.next;
	        }
	    }

}
