package com.lists;

public class SwapPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	ListNode swapPairs(ListNode head) {
		if(head ==null || head.next ==null)
			return head;
		
		ListNode curr = head;
		ListNode newStart = curr.next;
		ListNode next,temp;
		while(true) {
			next = curr.next;
			temp = next.next;
			next.next=curr;
			//breaking condition
			if(temp ==null) {
				curr.next = null;
				break;
			}
			if(temp.next ==null) {
				curr.next = temp;
				break;
			}
			curr.next = temp.next;
			curr = temp;
			
		}
		
		return newStart;

	}
}
