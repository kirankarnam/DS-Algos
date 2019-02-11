package com.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	
	public static void main(String[] args) {
		GenerateParanthesis gp = new GenerateParanthesis();
		System.out.println(gp.generateParenthesis(3));
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		generateOneByOne("",res,n,n);
		return res;
	}
	
	public void generateOneByOne(String subList,List<String> res, int left,int right) {
		if(left > right)
			return;
		
		if(left >0)
			generateOneByOne(subList+"(",res,left-1,right);
		
		if(right >0)
			generateOneByOne(subList+")",res,left,right-1);
		
		if(left ==0 && right ==0) {
			res.add(subList);
			return;
		}
	}

}
