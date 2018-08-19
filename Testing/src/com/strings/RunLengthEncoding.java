package com.strings;

public class RunLengthEncoding {

	public static void main(String[] args) {
		System.out.println(new RunLengthEncoding().encoding("aabbbccc"));

	}
	
	public String encoding (String s) {
		if(s==null || s.length()==0) return "";
		
		StringBuilder sb = new StringBuilder();
		
		int length = s.length();
		int count=1;
		
		for(int i=0;i<length;i++) {
			while(i<length-1 && s.charAt(i) ==s.charAt(i+1)) {
				count++;
				i++;
			}
			sb.append(s.charAt(i)).append(count);
			count =1;
		}
		
		return sb.toString();
	}
	

}
