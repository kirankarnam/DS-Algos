package com.strings;

public class ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println(new ReverseWordsInString().reverseWords("Today is Sunday"));
	}
	
	public String reverseWords(String s) {
		if(s == null) return null;
		
		char[] chars = s.toCharArray();
		int i=0;
		int word_begin = -1;
		int length = chars.length;
		
		while(i<length) {
			if(word_begin==-1 && chars[i]!=' ') {
				word_begin = i;
			}

			if(i+1==length || chars[i+1] ==' ' ) {
				chars = reverse(chars,word_begin,i);
				word_begin=-1;
			}
			i++;
		};
		
		chars= reverse(chars,0,i-1);
		return new String(chars);
	}
	

	public char[] reverse(char[] input,int startIndex,int endIndex) {
		if(input ==null) throw new IllegalArgumentException();
		


		while(startIndex<endIndex) {
			char temp = input[startIndex];
			input[startIndex] = input[endIndex];
			input[endIndex] = temp;

			startIndex++;
			endIndex--;
		}
		return input;
	}

}
