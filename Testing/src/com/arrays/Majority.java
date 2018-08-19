package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Majority {

	public static void main(String[] args) {
		Majority major = new Majority();
		
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(1);
		System.out.println(major.majorityElement(input));
		
	}
	

		public int majorityElement(final List<Integer> a) {
		    
		    if(a ==null) return 0;
		    
		    
		    int length = a.size();
		    
		    if(length ==0) return 0;
		    
		    if(length <2) return a.get(0);
		    
		    int majority = a.size()/2;
		    
		    Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
		    
		    for(int i=0 ;i<length;i++){
		        if(countMap.containsKey(a.get(i))){
		            int count = countMap.get(a.get(i));
		            if(count+1 >= majority)
		                return a.get(i);
		            else
		                countMap.put(a.get(i) , countMap.get(a.get(i)+1));
		        }else{
		            countMap.put(a.get(i),1);
		            
		        }
		    }
		    return 0;
		}


}
