package com.arrays;

import java.util.Stack;

public class MaxStack {
	Stack<Integer> stack;
	Stack<Integer> maxStack;
	
	public MaxStack() {
		stack = new Stack();
		maxStack = new Stack();
	}
	
	public void push(int x) {
		int top = stack.isEmpty()?x:stack.peek();
		int max = top>x?top:x;
		maxStack.push(max);
		stack.push(x);
		
		
	}
	
	
	public int pop() {
		maxStack.pop();
		return stack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	 public int peekMax() {
		 return maxStack.peek();
	 }
	 
	 public int popMax() {
		 int max = peekMax();
		 Stack<Integer> buffer = new Stack();
		 while(top()!=max) buffer.push(pop());
		 pop();
		 while(!buffer.isEmpty())push(buffer.pop());
		 return max;
	 }
}
