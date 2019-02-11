package com.arrays;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		AsteroidCollision as = new AsteroidCollision();
		int [] input= {5,10,-5};
		int[] res = as.asteroidCollision(input);
		for(int i:res)
			System.out.print(i);

	}
	
	//use a stack
    
    /*
        for the length of the asteroids
        
        check if the stack is empty or asteroids[i] is >0  then push to stack
        
        while(true){
            prev = stack.peek()
            
            if(prev <0)
                stack.push(new element)
            if(prev == asteroid[i])
                stack.pop();break;
            if(prev > -asteroid[i])
                break;
            
            stack.pop();
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                break;
            }
        }
create new array of size of stack and push elements into it and return
        
    */
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<asteroids.length;i++) {
			if(stack.isEmpty() || asteroids[i] > 0) {
				stack.push(asteroids[i]);
				continue;
			}
			
			while(true) {
				int prev = stack.peek();
				
				if(prev <0) {
					stack.push(asteroids[i]);
					break;
				}
				
				if(prev == -asteroids[i]) {
					stack.pop();
					break;
				}
				
				if(prev > -asteroids[i])
					break;
				
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(asteroids[i]);
					break;
				}
			}
		}
		
		int [] res = new int[stack.size()];
		for(int i=stack.size()-1;i>=0;i--) {
			res[i] = stack.pop();
		}
		
		return res;
	}

}
