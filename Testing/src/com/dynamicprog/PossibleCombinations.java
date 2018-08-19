package com.dynamicprog;

public class PossibleCombinations {

	public static void main(String[] args) {
		char digits[] = "1212".toCharArray();
		
		System.out.println(new PossibleCombinations().possibleDecodings(digits));
		
		System.out.println(new PossibleCombinations().possibleDecodings("1242".toCharArray()));
		
		System.out.println(new PossibleCombinations().possibleDecodings("12321".toCharArray()));

	}

	
	public int possibleDecodings(char[] input) {
		
		if(input ==null) return 0;
		
		int length = input.length;
		int[] result = new int[length+1];
		result[0] = 1;
		result[1] = 1;
		
		for(int i=1;i<length;i++) {
			int q = input[i]-'0';
			int p = input[i-1] -'0';
			
			if(q<=26 && q>0)
				result[i+1] = result[i];
			
			if((p*10+q) <=26 && (p*10+q) >0) {
				result[i+1]+=result[i-1];
			}
		}
		
		return result[length];
	}
}
