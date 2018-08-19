package com.strings;

public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.println(new RemoveDuplicates().removeDup("kiiiiran"));

	}
	
	public String removeDup(String s) {
		if(s==null) return null;
		
		int length = s.length();
		
		char[] chars = s.toCharArray();
		
		/*int i=1;
		int res_ind=1;
		
		while(i<length) {
			if(chars[i]!=chars[i-1]) {
				chars[res_ind] = chars[i];
				res_ind++;
			}
			i++;
		}
		
		String str = new String(chars);
		return str.substring(0, res_ind);*/
		
		int i=0;
		int res_ind=0;
		int[] char_array = new int[256];
		while(i<length) {
			if(char_array[chars[i]] == 0) {
				char_array[chars[i]] = 1;
				chars[res_ind] = chars[i];
				res_ind++;
			}
				
			i++;
		}
		
		
		return new String(chars).substring(0, res_ind);
		
		
	}

}
