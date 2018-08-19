package com.lists;

public class Add2Lists {
	
	public LinkedList addLists(LinkedList l1, LinkedList l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		LinkedList result = new LinkedList();
		int carry = 0;
		
		ListNode p = l1.head;
		ListNode q = l2.head;
		ListNode curr =  result.head;
		
		while(p!= null || q != null) {
			int x = (p!=null) ? p.data :0;
			int y = (q!=null) ? q.data :0;
			
			int sum = carry + x+y;
			carry = sum/10;
			
			result.insertFront(sum % 10);
			
			if(p != null) p = p.next;
			if(q != null) q = q.next;
			
		}
		
		if(carry > 0) {
			result.insertFront(carry);
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.push(2);
		list1.push(4);
		list1.push(3);
		
		LinkedList list2 = new LinkedList();
		list2.push(5);
		list2.push(6);
		list2.push(4);
		
		Add2Lists a2l = new Add2Lists();
		LinkedList result = a2l.addLists(list1, list2);
		
		ListNode curr = result.head;
		
		while(curr !=null) {
			System.out.println(curr.data);
			curr = curr.next;
		}

	}

}
