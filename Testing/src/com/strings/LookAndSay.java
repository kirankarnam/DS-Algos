package com.strings;

public class LookAndSay {

	public static void main(String[] args) {
		LookAndSay ls = new LookAndSay();
		
		System.out.println(ls.lookAndSay(5));
		//1211
		System.out.println(ls.lookAndSay(4));
	}
	
	public String lookAndSay(int n) {
		if(n<=0) return null;
		
		int i=1;
		
		String output="1";
		
		while(i<n) {
			StringBuilder sb = new StringBuilder();
			int count =1;
			
			for(int j=1;j<output.length();j++) {
				
				//check to see if the jth character is same as previous character
				
				if(output.charAt(j) == output.charAt(j-1))
					count++;
				else {
					sb.append(count);
					sb.append(output.charAt(j-1));
					count =1;
				}
			}
			sb.append(count);
			sb.append(output.charAt(output.length()-1));
			output = sb.toString();
			i++;
		}
		return output;
	}

}
